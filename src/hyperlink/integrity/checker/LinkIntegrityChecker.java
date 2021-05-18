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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class LinkIntegrityChecker {

    private String url;
    private int threshold;
    private int depth = 0;
    private ArrayList<String> urls = new ArrayList<>();

    public LinkIntegrityChecker(String url, int threshold) {
        this.url = url;
        this.threshold = threshold;

//        try {
//            URL u = new URL(url);
//            System.out.println("Valid url");
//        } catch (MalformedURLException ex) {
//            System.out.println("Invalid url");
//            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
        checkLink(url);
    }

    private void checkLink(String url) {
        try {
//            // if it is not a valid url appends the domain to the url as it can be a subdomain;
//            if (!Helpers.isValidUrl(url)) {
//                url = this.url + url;
//            }

            if (Helpers.isValidUrl(url)) {

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

                    try {
                        URL urlTest = new URL(link);
                        HttpURLConnection connection = (HttpURLConnection) urlTest.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();

                        int code = connection.getResponseCode();
                        System.out.println("Code " + code + " " + link);

                    } catch (IOException ex) {
                        System.out.println("Invalid Link " + link);
                    }
                    if (depth++ == threshold) {
                        checkLinks2(link);
                    }

                }

//                anchorTags.stream().map((anchorTag) -> anchorTag.attributes().get("href")).forEachOrdered((String newUrl) -> {
//                    if (!newUrl.equals("#")) {
//                        if (!Helpers.isValidUrl(newUrl) && !newUrl.equals("#")) {
//                            newUrl = this.url + newUrl;
//                        }
//                        System.out.println(newUrls);
////                    if (depth++ != threshold) {
////                        checkLink(newUrl);
////                    } else {
////                        depth = 0;
////                    }
//                    }
//                });
            }
        } catch (IOException ex) {
            System.out.println("Invalid Link");
            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void checkLinks2(String url) {
        try {
//            // if it is not a valid url appends the domain to the url as it can be a subdomain;
//            if (!Helpers.isValidUrl(url)) {
//                url = this.url + url;
//            }

            if (Helpers.isValidUrl(url)) {

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

                    try {
                        URL urlTest = new URL(link);
                        HttpURLConnection connection = (HttpURLConnection) urlTest.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();

                        int code = connection.getResponseCode();
                        System.out.println("Code " + code + " " + link);

                    } catch (IOException ex) {
                        System.out.println("Invalid Link " + link);
                    }

                }

//                anchorTags.stream().map((anchorTag) -> anchorTag.attributes().get("href")).forEachOrdered((String newUrl) -> {
//                    if (!newUrl.equals("#")) {
//                        if (!Helpers.isValidUrl(newUrl) && !newUrl.equals("#")) {
//                            newUrl = this.url + newUrl;
//                        }
//                        System.out.println(newUrls);
////                    if (depth++ != threshold) {
////                        checkLink(newUrl);
////                    } else {
////                        depth = 0;
////                    }
//                    }
//                });
            }
        } catch (IOException ex) {
            System.out.println("Invalid Link");
            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//
//    private Elements getLinks(String url) {
//        Elements anchorTags = null;
//        try {
//            Document doc = Jsoup.connect(url).get();
//            anchorTags = doc.select("a[href]");
//        } catch (IOException ex) {
//
//        }
//        return anchorTags;
//    }
//    public static void main(String[] args) {
//        LinkIntegrityChecker obj = new LinkIntegrityChecker(this.url);
//        Thread thread = new Thread(obj);
//        thread.start();
//        System.out.println("This code is outside of the thread");
//    }
//
//    public void run() {
//        System.out.println("This code is running in a thread");
//    }
}
