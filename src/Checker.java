
import hyperlink.integrity.checker.Link;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Checker extends Thread {

    public static String url;
    //public static final String url="https://www.youtube.com";
    //public static final String url="https://www.google.com";
    public static String[] links = new String[1000];
    private static int works = 0;
    private static int fails = 0, i, k = 0, n = 0, loop = 0, j = 0;
    ;
        public static int x = 0;
    public static int numberOfLinks = 0;
    public static int numberOfThreads, depth;
    private static long startTime;

    public static void execution() throws IOException {
        startTime = System.nanoTime();
        Link.linksSet.addAll(Links.findLinks(url));
        if (depth > 0) {
            Links.depthLinks(Links.linksSet);
        }

        for (String link : Links.linksSet) {
            links[numberOfLinks] = link;
            numberOfLinks++;
        }
        Checker t[] = new Checker[1000];
        for (i = 1; i < numberOfThreads + 1; i++) {
            loop = i - 1;
            t[loop] = new Checker();
            t[loop].start();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }

    public void run() {
        if (numberOfThreads == 0) {
            n = numberOfLinks;
        } else {
            n = numberOfLinks / numberOfThreads;
            if (numberOfThreads == 0 || numberOfThreads == 1) {
                Links.comp(0, n);
            } else if (n * (loop + 1) > numberOfLinks || (numberOfLinks - n * (loop + 1)) <= 3) {
                Links.comp((loop) * n, numberOfLinks);
            } else {
                Links.comp(loop * n, n * (loop + 1));
            }
            k++;
            if (x == numberOfLinks) {
                double finishTime = System.nanoTime();
                double duration = (finishTime - startTime) / (1000000000);
                JOptionPane.showMessageDialog(null, "Duration: " + duration);
                JOptionPane.showMessageDialog(null, "Number of links found: " + incrementLinks(3));
                JOptionPane.showMessageDialog(null, "Number of links that work: " + (incrementLinks(1) - 1));
                JOptionPane.showMessageDialog(null, "Number of links that fail: " + (incrementLinks(0) - 1));
            }
        }
    }

    public static void print(String url) {
        int i = 1;
        for (String link : Links.findLinks(url)) {
            System.out.println(i);
            link = Links.concatinateLink(url, link);
            System.out.println(link);
            int l = Links.checkConnection(link);
            incrementLinks(l);
            System.out.println("valid" + l);
            i++;
        }
        System.out.println("The total number of links: " + (incrementLinks(3)) + "\n");
        System.out.println("Number of links that work: " + (incrementLinks(1) - 1) + "\n");
        System.out.println("Number of links that fail: " + (incrementLinks(0) - 1) + "\n");
    }

    public static int incrementLinks(int check) {
        if (check == 1) {
            works++;
            return works;
        } else if (check == 0) {
            fails++;
            return fails;
        } else {
            return works + fails;
        }
    }

}
