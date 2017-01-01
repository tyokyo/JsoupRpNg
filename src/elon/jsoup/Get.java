package elon.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import control.ParseHelper;

/**
 * Created by dell on 2017/1/2.
 */
public class Get extends ParseHelper {
    public static Document getUrl(String url, String parameter) throws IOException {
        Document document = null;
        Connection conn = Jsoup.connect(url);
        conn.data("word", parameter);
        conn.data("pbook", "0");
        document = conn.get();
        return document;
    }

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
		Document docweb = getUrl("http://yuedu.baidu.com/search", "%D4%C6%B2%E3");
		System.out.println(docweb);
    }
}
