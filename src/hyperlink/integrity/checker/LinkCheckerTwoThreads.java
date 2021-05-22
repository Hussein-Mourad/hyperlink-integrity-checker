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
        for (Element anchorTag : anchorTags) {
            int depth = 0;
            String relHref = anchorTag.attr("href"); // == "/"
            String absHref = anchorTag.absUrl("href"); // == "http://jsoup.org/"

            // if the extracted link is the same as the domain or it starts with # skip them
            if (!relHref.startsWith("#") && !absHref.equals(url)) {
                Threading threading = new Threading(absHref);
                threading.start();
                try {
                    threading.join();
                    if (threading.isValid() && threshold != 0) {
                        checkSubLinks(absHref, depth);
                    }
                } catch (InterruptedException ex) {

                }
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
        for (Element anchorTag : anchorTags) {
            String relHref = anchorTag.attr("href");
            String absHref = anchorTag.absUrl("href"); // == "http://jsoup.org/"

            // if the extracted link is the same as the domain or it starts # skip them
            if (!relHref.startsWith("#") && !absHref.equals(rootUrl) && !absHref.equals(url)) {
                Threading threading = new Threading(absHref);
                threading.start();
                try {
                    threading.join();

                    if (threading.isValid()) {
                        checkSubLinks(absHref, depth + 1);
                    }
                } catch (InterruptedException ex) {

                }

            }
        }

    }
}
