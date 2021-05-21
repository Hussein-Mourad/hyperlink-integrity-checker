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
public class LinkCheckerThreeThreads {

    private String rootUrl;
    private int threshold;
    private ArrayList<Link> links = new ArrayList<>();

    public LinkCheckerThreeThreads(String url, int threshold) {
        this.rootUrl = url;
        this.threshold = threshold;
        checkRootUrl(rootUrl);
    }

    public static void main(String[] args) {
        LinkCheckerThreeThreads linkIntegrityChecker = new LinkCheckerThreeThreads("https://74mazen74.github.io/74Mazen.github.io/", 1);
//        LinkCheckerOneThread linkIntegrityChecker = new LinkCheckerOneThread("https://google.com", 0);
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

    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
