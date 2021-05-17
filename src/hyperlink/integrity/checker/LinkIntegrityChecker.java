/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author hussein
 */
public class LinkIntegrityChecker {

    public LinkIntegrityChecker(String url) {
//        try {
//            URL u = new URL(url);
//            System.out.println("Valid url");
//        } catch (MalformedURLException ex) {
//            System.out.println("Invalid url");
//            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
//        }
        checkLink(url);
    }

    private void checkLink(String url) {
        try {
            // TODO code application logic here
            Document doc = Jsoup.connect(url).get();
            Elements anchorTags = doc.getElementsByAttribute("href");
            anchorTags.forEach(tag -> System.out.println(tag.attributes().get("href")));
            System.out.println();
        } catch (IOException ex) {
            System.out.println("Invalid Link");
            Logger.getLogger(LinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
