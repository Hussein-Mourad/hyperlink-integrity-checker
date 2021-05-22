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
public class LinkCheckerTwoThreads {

    private String rootUrl;
    private int threshold;

    public LinkCheckerTwoThreads(String url, int threshold) {
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
        if (anchorTags.size() == 1) {
            Element anchorTag = anchorTags.get(0);
            int depth = 0;
            String relHref = anchorTag.attr("href");
            String absHref = anchorTag.absUrl("href");

            if (!relHref.startsWith("#") && !absHref.equals(url)) {
                int code = Utils.getResCode(absHref);

                if (code == 200 && threshold != 0) {
                    checkSubLinks(absHref, depth);
                }
            }
        }

        for (int i = 0; i <= anchorTags.size() / 2 && anchorTags.size() >= 2; i += 2) {
            Element anchorTag1 = anchorTags.get(i);
            Element anchorTag2 = anchorTags.get(i + 1);
            int depth = 0;
            String relHref1 = anchorTag1.attr("href"); // == "/"
            String absHref1 = anchorTag1.absUrl("href");
            String relHref2 = anchorTag2.attr("href"); // == "/"
            String absHref2 = anchorTag2.absUrl("href");

            Threading thread1 = new Threading(absHref1);
            thread1.start();
            Threading thread2 = new Threading(absHref2);
            thread2.start();
            try {
                thread1.join();
                if (!relHref1.startsWith("#") && !absHref1.equals(url)) {
                    if (thread1.isValid() && threshold != 0) {
                        checkSubLinks(absHref1, depth);
                    }
                }
                thread2.join();
                if (!relHref2.startsWith("#") && !absHref2.equals(url)) {
                    if (thread2.isValid() && threshold != 1) {
                        checkSubLinks(absHref2, depth);
                    }
                }
                System.out.println(absHref1);
                System.out.println(absHref2);
            } catch (InterruptedException ex) {
            }

        }

    }

    private void checkSubLinks(String url, int depth) {
        if (depth == threshold) {
            return;
        }
        Elements anchorTags = Utils.getAnchorTags(url);
        if (anchorTags == null) {
            return;
        }

        if (anchorTags.size() == 1) {
            Element anchorTag = anchorTags.get(0);
            String relHref = anchorTag.attr("href");
            String absHref = anchorTag.absUrl("href");

            if (!relHref.startsWith("#") && !absHref.equals(url)) {
                int code = Utils.getResCode(absHref);

                if (code == 200 && threshold != 0) {
                    checkSubLinks(absHref, depth + 1);
                }
            }
        }

        for (int i = 0; i <= anchorTags.size() / 2 && anchorTags.size() >= 2; i += 2) {
            Element anchorTag1 = anchorTags.get(i);
            Element anchorTag2 = anchorTags.get(i + 1);

            String relHref1 = anchorTag1.attr("href"); // == "/"
            String absHref1 = anchorTag1.absUrl("href");
            String relHref2 = anchorTag2.attr("href"); // == "/"
            String absHref2 = anchorTag2.absUrl("href");

            Threading thread1 = new Threading(absHref1);
            thread1.start();
            Threading thread2 = new Threading(absHref2);
            thread1.start();
            try {
                thread1.join();
                if (!relHref1.startsWith("#") && !absHref1.equals(rootUrl) && !absHref1.equals(url)) {
                    if (thread1.isValid() && threshold != 0) {
                        checkSubLinks(absHref1, depth + 1);
                    }
                }
                thread2.join();
                if (!relHref2.startsWith("#") && !absHref2.equals(rootUrl) && !absHref2.equals(url)) {
                    if (thread2.isValid() && threshold != 1) {
                        checkSubLinks(absHref2, depth + 1);
                    }
                }
                System.out.println(absHref1);
                System.out.println(absHref2);
            } catch (InterruptedException ex) {
            }
        }
    }
}
