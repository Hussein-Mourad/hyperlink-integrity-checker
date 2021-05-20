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
public class Link {

    private String relHref;
    private String absHref;
    private String text;
    private int statusCode = 200;
    private final int HTTP_OK = 200;

    /*
    * Creates a new link
    * @param relHref relative link
    * @param absHref absulute link
    * @param text text inside the link
     */
    public Link(String relHref, String absHref, String text) {
        this.relHref = relHref;
        this.absHref = absHref;
        this.text = text;
    }

    public boolean isValid() {
        return statusCode == HTTP_OK;
    }

    public String getRelHref() {
        return relHref;
    }

    public void setRelHref(String relHref) {
        this.relHref = relHref;
    }

    public String getAbsHref() {
        return absHref;
    }

    public void setAbsHref(String absHref) {
        this.absHref = absHref;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        String str = String.format("Status Code: %d, Relative Link: %s, Absolute Link: %s", statusCode, relHref, absHref);
        return str;
    }

    public String[] toArray() {
        String[] arr = new String[5];
        arr[0] = String.valueOf(statusCode);
        arr[1] = isValid() ? "Valid" : "Invalid";
        arr[2] = text;
        arr[3] = relHref;
        arr[4] = absHref;
        return arr;
    }

    public static String[] ArrayFields() {
        String[] arr = {"Status Code", "Status", "Text", "Relative Link", "Absolute Link"};
        return arr;
    }

    public static int ArraySize() {
        return 5;
    }
}
