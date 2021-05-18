/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import java.util.regex.Pattern;

/**
 *
 * @author hussein
 */
public class Helpers {

    public static boolean isValidUrl(String url) {
//        return url.startsWith("http://") || url.startsWith("https://") && !url.contains(" ");
        // Checks if it is a url using regex
        // regex source: https://regexr.com/38vdq
        // Regex to check valid URL
        String regex = "((https?)://)(([^:\\n\\r]+):([^@\\n\\r]+)@)?((www\\.)?([^/\\n\\r]+))/?([^?\\n\\r]+)?\\??([^#\\n\\r]*)?#?([^\\n\\r]*)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(url).find(); // return whatever the matcher returns true or false
    }
}
