/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hussein
 */
public class LinkCheckerOneThread {

    private String rootUrl;
    private int threshold;
    private ArrayList<Link> links = new ArrayList<>();

    public LinkCheckerOneThread(String url, int threshold) {
        this.rootUrl = url;
        this.threshold = threshold;

    }

    public String start() {
        String time;
        long start = System.nanoTime();
        checkRootUrl(rootUrl);
        long elapsedTime = System.nanoTime() - start;
        long duration = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        time = duration + " s";
        if (duration >= 60) {
            duration /= 60;
            time =
        }
        System.out.println("One Thread elapsed time: " + duration + " s");
        return elapsedTime;
    }

    private void checkRootUrl(String url) {

        Link[] urls = Utils.getLinks(url);

        for (Link link : urls) {
            links.add(link);
            int depth = 0;
            if (!link.getRelHref().startsWith("#") && !link.getAbsHref().equals(url)) {
                int code = Utils.getResCode(link.getAbsHref());
                System.out.println("Code " + code + " " + "Depth in. " + depth + " " + link.getAbsHref());
                link.setStatusCode(code);
                if (link.isValid()) {
                    if (threshold != 0) {
                        checkSubLinks(link.getAbsHref(), depth);
                    }
                }
            }
        }
    }

    private void checkSubLinks(String url, int depth) {
        if (depth == threshold) {
            return;
        }

        Link[] urls = Utils.getLinks(url);

        for (Link link : urls) {
            links.add(link);
            if (!link.getRelHref().startsWith("#") && !link.getAbsHref().equals(url)) {
                int code = Utils.getResCode(link.getAbsHref());
                System.out.println("Code " + code + " " + "Depth in. " + depth + " " + link.getAbsHref());
                link.setStatusCode(code);
                if (link.isValid()) {
                    checkSubLinks(link.getAbsHref(), depth + 1);
                }
            }
        }
    }

    public String[][] getLinksData() {
        return Utils.linksToArray(links);
    }

}
