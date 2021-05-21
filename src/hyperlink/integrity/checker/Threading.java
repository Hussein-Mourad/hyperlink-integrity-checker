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
public class Threading extends Thread {

    private String url;
    private boolean result;

    public Threading(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public boolean isValid() {
        return result;
    }

    @Override
    public void run() {
        int resCode = Utils.getResCode(url);
        this.result = resCode == 200;
    }

}
