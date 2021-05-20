/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class LinkIntegrityChecker {

    private String rootUrl;
    private int threshold;
    private ArrayList<Link> links = new ArrayList<>();

    public LinkIntegrityChecker(String url, int threshold) {
        this.rootUrl = url;
        this.threshold = threshold;

//        try {
//            URL u = new URL(rootUrl);
//            System.out.println("Valid rootUrl");
//        } catch (MalformedURLException ex) {
//            System.out.println("Invalid rootUrl");
//            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());
        checkRootUrl(rootUrl);
    }

    public static void main(String[] args) {
        LinkIntegrityChecker linkIntegrityChecker = new LinkIntegrityChecker("https://74mazen74.github.io/74Mazen.github.io/", 1);
//        LinkIntegrityChecker linkIntegrityChecker = new LinkIntegrityChecker("https://google.com", 0);
//
    }

    private void checkRootUrl(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.select("a[href]");

            for (Element anchorTag : anchorTags) {
                int depth = 0;

                String relHref = anchorTag.attr("href"); // == "/"
                String absHref = anchorTag.absUrl("href"); // == "http://jsoup.org/"
                String linkText = anchorTag.text();

                // if the extracted link is the same as the domain or it starts with # skip them
                Link link = new Link(relHref, absHref, linkText);
                if (!relHref.startsWith("#") && !absHref.equals(url)) {
                    int code = getResCode(absHref);
                    System.out.println("Code " + code + " " + "Depth in. " + depth + " " + absHref);
                    link.setStatusCode(code);
                    if (link.isValid()) {
                        if (threshold != 0) {
                            checkSubLinks(absHref, depth);
                        }
                    }
                }
                links.add(link);
            }
        } catch (IllegalArgumentException | IOException ex) {
            System.out.println("Not a link " + url);
        }
    }

    private void checkSubLinks(String url, int depth) {
        if (depth == threshold) {
            return;
        }
        try {
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.select("a[href]");
            for (Element anchorTag : anchorTags) {
                String relHref = anchorTag.attr("href"); // == "/"
                String absHref = anchorTag.absUrl("href"); // == "http://jsoup.org/"
                String linkText = anchorTag.text();

                Link link = new Link(relHref, absHref, linkText);
                // if the extracted link is the same as the domain or it starts # skip them
                if (!relHref.startsWith("#") && !absHref.equals(rootUrl) && !absHref.equals(url)) {
                    int code = getResCode(absHref);
                    link.setStatusCode(code);
                    System.out.println("Code " + code + " " + "Depth in. " + depth + " " + absHref);
                    if (link.isValid()) {
                        checkSubLinks(absHref, depth + 1);
                    }
                }
                links.add(link);
            }
        } catch (IllegalArgumentException | IOException ex) {
            System.out.println("Not a link" + url);
        }
    }

    private int getResCode(String url) {
        try {
            URL urlTest = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlTest.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException | ClassCastException ex) {
            return HttpURLConnection.HTTP_FORBIDDEN;
        }
    }

    public String[][] getResults() {
        Link[] tmpLinks = new Link[links.size()];
        tmpLinks = links.toArray(tmpLinks);
        String[][] arr = new String[links.size()][Link.ArraySize()];
        for (int i = 0; i < tmpLinks.length; i++) {
            arr[i] = tmpLinks[i].toArray();
        }
        return arr;
    }

//    private String[] getLinkData(String url) {
//        Document doc = Jsoup.connect(url).get();
//
//    }
//    private String[] getLinks(String url) {
//        ArrayList<String> links = new ArrayList<>();
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Elements anchorTags = doc.select("a[href]");
//            anchorTags.stream()
//                    .map((anchorTag) -> anchorTag.attributes()
//                    .get("href")).filter((link) -> !(link.equals("#") || link.equals(url)))
//                    .forEachOrdered((link) -> {
//                        links.add(link);
//                    });
//            return (String[]) links.toArray();
//        } catch (IOException ex) {
//            return null;
//        }
//    }
//
//    private Elements getLinks(String rootUrl) {
//        Elements anchorTags = null;
//        try {
//            Document doc = Jsoup.connect(rootUrl).get();
//            anchorTags = doc.select("a[href]");
//        } catch (IOException ex) {
//
//        }
//        return anchorTags;
//    }
//    public static void main(String[] args) {
//        LinkIntegrityChecker obj = new LinkIntegrityChecker(this.rootUrl);
//        Thread thread = new Thread(obj);
//        thread.start();
//        System.out.println("This code is outside of the thread");
//    }
//
//    public void run() {
//        System.out.println("This code is running in a thread");
//    }
    //    private static void test() {
//        for (int i = 0; i < 2; i++) {
//            int depth = 0;
//            System.out.println("Outerloop loop Depth: " + depth + " " + "i: " + i);
//            test2(depth);
//        }
//    }
//
//    private static void test2(int depth) {
//        if (depth == 2) {
//            return;
//        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println("Depth: " + depth + " " + "j: " + i);
//            test2(depth + 1);
//        }
//    }
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
