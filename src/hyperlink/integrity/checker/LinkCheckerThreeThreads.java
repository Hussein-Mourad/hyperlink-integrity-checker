/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class LinkCheckerThreeThreads {

    private String rootUrl;
    private int threshold;
    private ArrayList<Link> links = new ArrayList<>();

    public LinkCheckerThreeThreads(String url, int threshold) {
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
            String linkText = anchorTag.text();
            Link link = new Link(relHref, absHref, linkText);

            // if the extracted link is the same as the domain or it starts with # skip them
            if (!relHref.startsWith("#") && !absHref.equals(url)) {
                int code = Utils.getResCode(absHref);
                System.out.println("Code " + code + " " + "Depth in. " + depth + " " + absHref);
                link.setStatusCode(code);

                if (link.isValid() && threshold != 0) {
                    checkSubLinks(absHref, depth);
                }
            }
            links.add(link);
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
            String relHref = anchorTag.attr("href"); // == "/"
            String absHref = anchorTag.absUrl("href"); // == "http://jsoup.org/"
            String linkText = anchorTag.text();
            Link link = new Link(relHref, absHref, linkText);

            // if the extracted link is the same as the domain or it starts # skip them
            if (!relHref.startsWith("#") && !absHref.equals(rootUrl) && !absHref.equals(url)) {
                int code = Utils.getResCode(absHref);
                link.setStatusCode(code);
                System.out.println("Code " + code + " " + "Depth in. " + depth + " " + absHref);
                if (link.isValid()) {
                    checkSubLinks(absHref, depth + 1);
                }
            }
            links.add(link);
        }

    }

    public String[][] getLinksData() {
        return Utils.linksToArray(links);
    }

}
