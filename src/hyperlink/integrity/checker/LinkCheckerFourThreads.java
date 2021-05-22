/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class LinkCheckerFourThreads {

    private String rootUrl;
    private int threshold;

    public LinkCheckerFourThreads(String url, int threshold) {
        this.rootUrl = url;
        this.threshold = threshold;
    }

    public String start() {
        long start = System.nanoTime();
        checkRootUrl(rootUrl);
        return Utils.getDuration(System.nanoTime() - start);
    }

    private void checkRootUrl(String url) {

        Elements anchorTags = Utils.getAnchorTags(url);
        if (anchorTags == null) {
            return;
        }
        if (anchorTags.size() < 4) {
            String start = new LinkCheckerThreeThreads(url, threshold).start();
            System.out.println(start);
            return;
        }
        for (int i = 0; i <= anchorTags.size() / 4; i += 4) {
            Element anchorTag1 = anchorTags.get(i);
            Element anchorTag2 = anchorTags.get(i + 1);
            Element anchorTag3 = anchorTags.get(i + 2);
            Element anchorTag4 = anchorTags.get(i + 3);
            int depth = 0;
            String relHref1 = anchorTag1.attr("href");
            String absHref1 = anchorTag1.absUrl("href");
            String relHref2 = anchorTag2.attr("href");
            String absHref2 = anchorTag2.absUrl("href");
            String relHref3 = anchorTag3.attr("href");
            String absHref3 = anchorTag3.absUrl("href");
            String relHref4 = anchorTag4.attr("href");
            String absHref4 = anchorTag4.absUrl("href");

            Threading thread1 = new Threading(absHref1);
            thread1.start();
            Threading thread2 = new Threading(absHref2);
            thread2.start();
            Threading thread3 = new Threading(absHref3);
            thread3.start();
            Threading thread4 = new Threading(absHref4);
            thread4.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
                thread4.join();
                if (!relHref1.startsWith("#") && !absHref1.equals(url)) {
                    if (thread1.isValid() && threshold != 0) {
                        checkSubLinks(absHref1, depth);
                    }
                }

                if (!relHref2.startsWith("#") && !absHref2.equals(url)) {
                    if (thread2.isValid() && threshold != 1) {
                        checkSubLinks(absHref2, depth);
                    }
                }

                if (!relHref3.startsWith("#") && !absHref3.equals(url)) {
                    if (thread3.isValid() && threshold != 1) {
                        checkSubLinks(absHref3, depth);
                    }
                }

                if (!relHref4.startsWith("#") && !absHref4.equals(url)) {
                    if (thread3.isValid() && threshold != 1) {
                        checkSubLinks(absHref4, depth);
                    }
                }
                System.out.println("four" + absHref1);
                System.out.println(absHref2);
                System.out.println(absHref3);
                System.out.println(absHref4);

            } catch (InterruptedException ex) {

            }

        }
    }
    //    if (!relHref.startsWith ( "#") && !absHref.equals(rootUrl) && !absHref.equals(url)) {

    private void checkSubLinks(String url, int depth) {
        if (depth == threshold) {
            return;
        }

        Elements anchorTags = Utils.getAnchorTags(url);
        if (anchorTags == null) {
            return;
        }
        if (anchorTags.size() < 4) {
            new LinkCheckerThreeThreads(url, threshold).start();
            return;
        }
        for (int i = 0; i <= anchorTags.size() / 4; i += 4) {
            Element anchorTag1 = anchorTags.get(i);
            Element anchorTag2 = anchorTags.get(i + 1);
            Element anchorTag3 = anchorTags.get(i + 2);
            Element anchorTag4 = anchorTags.get(i + 3);

            String relHref1 = anchorTag1.attr("href");
            String absHref1 = anchorTag1.absUrl("href");
            String relHref2 = anchorTag2.attr("href");
            String absHref2 = anchorTag2.absUrl("href");
            String relHref3 = anchorTag3.attr("href");
            String absHref3 = anchorTag3.absUrl("href");
            String relHref4 = anchorTag4.attr("href");
            String absHref4 = anchorTag4.absUrl("href");

            Threading thread1 = new Threading(absHref1);
            thread1.start();
            Threading thread2 = new Threading(absHref2);
            thread2.start();
            Threading thread3 = new Threading(absHref3);
            thread3.start();
            Threading thread4 = new Threading(absHref4);
            thread4.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
                thread4.join();
                if (!relHref1.startsWith("#") && !absHref1.equals(url)) {
                    if (thread1.isValid() && threshold != 0) {
                        checkSubLinks(absHref1, depth + 1);
                    }
                }
                if (!relHref2.startsWith("#") && !absHref2.equals(url)) {
                    if (thread2.isValid() && threshold != 1) {
                        checkSubLinks(absHref2, depth + 1);
                    }
                }
                if (!relHref3.startsWith("#") && !absHref3.equals(url)) {
                    if (thread3.isValid() && threshold != 1) {
                        checkSubLinks(absHref3, depth + 1);
                    }
                }
                if (!relHref4.startsWith("#") && !absHref4.equals(url)) {
                    if (thread3.isValid() && threshold != 1) {
                        checkSubLinks(absHref4, depth + 1);
                    }
                }
                System.out.println(absHref1);
                System.out.println(absHref2);
                System.out.println(absHref3);
                System.out.println(absHref4);
            } catch (InterruptedException ex) {
            }
        }
    }
}
