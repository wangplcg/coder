package cn.com.core.aware;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * main
 *
 * @author wangplcg
 * @create 2018-04-15 22:29
 */

public class Main {
    public static String getHost(String link) {
        URL url;
        String host = "";
        try {
            url = new URL(link);
            host = url.getHost();
        } catch (MalformedURLException e) {
        }
        return host;
    }
    public static void main(String[] args) {
            System.out.println(getHost("https://192.168.149.165:8888/article/ca41422fc76c4a1eae99ed9f.html"));
    }
}
