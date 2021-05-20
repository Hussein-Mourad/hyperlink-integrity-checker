/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

/**
 *
 * @author hussein
 */
public class Helpers {

    public static boolean isValidUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://") && !url.contains(" ");

//        try {
//            URL u = new URL(url);
//            return true;
//// Checks if it is a url using regex
//// regex source: https://regexr.com/38vdq
//// Regex to check valid URL
////        String regex = "((https?)://)(([^:\\n\\r]+):([^@\\n\\r]+)@)?((www\\.)?([^/\\n\\r]+))/?([^?\\n\\r]+)?\\??([^#\\n\\r]*)?#?([^\\n\\r]*)";
////        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
////        return pattern.matcher(url).find(); // return whatever the matcher returns true or false
//        } catch (MalformedURLException ex) {
//            return false;
//        }
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
}
