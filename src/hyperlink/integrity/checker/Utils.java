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
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class Utils {

    public static boolean isValidUrlFrontend(String url) {
        return url.startsWith("http://") || url.startsWith("https://") && !url.contains(" ");
    }

    public static int getResCode(String url) {
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

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            int value = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static Elements getAnchorTags(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.select("a[href]");
            return anchorTags;
        } catch (IllegalArgumentException | IOException ex) {
            System.out.println("Not a link " + url);
            return null;
        }
    }

    public static String[][] linksToArray(ArrayList<Link> links) {
        Link[] tmpLinks = new Link[links.size()];
        tmpLinks = links.toArray(tmpLinks);
        String[][] arr = new String[links.size()][Link.ArraySize()];
        for (int i = 0; i < tmpLinks.length; i++) {
            arr[i] = tmpLinks[i].toArray();
        }
        return arr;
    }

    public static String getDuration(long timeInNano) {
        String str;

        double duration = TimeUnit.SECONDS.convert(timeInNano, TimeUnit.NANOSECONDS);
        str = duration + " s";
        if (duration >= 60) {
            duration /= 60;
            str = duration + " m";
        }
        System.out.println("One Thread elapsed time: " + str);

        return str;
    }
}
