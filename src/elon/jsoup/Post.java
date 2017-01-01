package elon.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by dell on 2017/1/2.
 */
public class Post {
    private static Logger logger = Logger.getLogger(Post.class.getName());
    public static Document postUrl(String url, String parameter) throws IOException {
        logger.info(url);
        Document document = null;
        document = Jsoup.connect(url).
                data("theRegionCode",parameter).
                timeout(10000).
                post();
        return document;
    }
    //http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityString?theRegionCode=sh
    public static void main(String args[]){

        Document document = null;
        try {
            document= Post.postUrl("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityString", "上海");
            Elements els = document.getElementsByTag("string");
            System.out.println("total size is :"+els.size());
            for (Element element : els) {
                System.out.println("======================");
                System.out.println(element.text());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
