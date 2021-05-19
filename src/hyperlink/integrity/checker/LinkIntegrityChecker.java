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
    private ArrayList<String[]> urls = new ArrayList<>();

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

    private void checkRootUrl(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.select("a[href]");
            for (Element anchorTag : anchorTags) {
                String link = anchorTag.attributes().get("href");
                if (link.equals("#") || link.equals(url)) { // if the extracted link is the same as the domain or it is # skip them
                    continue;
                }
                if (!Helpers.isValidUrl(link)) {
                    link = url + link;
                }
                int depth = 0;
                try {
                    URL urlTest = new URL(link);
                    HttpURLConnection connection = (HttpURLConnection) urlTest.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int code = connection.getResponseCode();
                    System.out.println("Code " + code + " " + "Depth " + depth + " " + link);
                    if (threshold != 0) {
                        checkLinks(link, depth);
                    }

                } catch (IOException ex) {
                    System.out.println("Invalid Link " + link);
                }
//                    String[] item = {"Valid", link};
//                    urls.add(item);
            }
        } catch (IOException ex) {
            System.out.println("Invalid Link " + url);
        }

    }

    private void checkLinks(String url, int depth) {
        if (depth == threshold) {
            System.out.println("\n Returned at depth: " + depth + "\n");
            return;
        }
        try {
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.select("a[href]");
            for (Element anchorTag : anchorTags) {
                String link = anchorTag.attributes().get("href");

                if (link.equals("#") || link.equals(rootUrl) || link.equals(url)) { // if the extracted link is the same as the domain or it is # skip them
                    continue;
                }

//                if (!Helpers.isValidUrl(link)) {
//                    link = url + link;
//                }
                int code = getResCode(link);
                System.out.println("Code " + code + " " + "Depth " + depth + " " + link);
                checkLinks(link, depth + 1);
            }
        } catch (IOException ex) {
            System.out.println("Invalid Link " + url);
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

    private Elements getLinks(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            return links;
        } catch (IOException ex) {
            return null;
        }
    }

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
}
