package elon.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
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
    /**
     * 发送post请求获取返回body
     * @param url  请求地址
     * @param map  请求参数
     * @param cookie  请求cookie
     * @return
     * @throws IOException
     */
    public static String httpPost(String url, Map<String,String> map, String cookie) throws IOException{
        //获取请求连接
        Connection con = Jsoup.connect(url);
        //遍历生成参数
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //添加参数
                con.data(entry.getKey(), entry.getValue());
            }
        }
        //插入cookie（头文件形式）
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cookie);
        Document doc = con.post();
        return doc.toString();
    }



    /**
     * 发送post请求获取返回头文件获这cookie
     * @param url  请求地址
     * @param map  请求参数
     * @param cookie  请求cookie
     * @param header  返回获取cookie或者头文件
     * @return
     * @throws IOException
     */
    public static String httpPost(String url,Map<String,String> map,String cookie,String header) throws IOException{
        //获取请求连接
        Connection con = Jsoup.connect(url);
        //遍历生成参数
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //添加参数
                con.data(entry.getKey(), entry.getValue());
            }
        }
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        //插入cookie（头文件形式）
        con.header("Cookie", cookie);
        //发送请求
        Connection.Response resp=con.method(Connection.Method.POST).execute();
        //获取cookie名称为__bsi的值
        String cookieValue = resp.cookie(header);
        System.out.println(cookieValue);
        return cookieValue;
    }
}
