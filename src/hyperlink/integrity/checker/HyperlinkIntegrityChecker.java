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

/**
 *
 * @author hussein
 */
public class HyperlinkIntegrityChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Document doc = Jsoup.connect("https://www.google.com/").get();
            String title = doc.title();
            System.out.println(title);
        } catch (IOException ex) {
            Logger.getLogger(HyperlinkIntegrityChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
