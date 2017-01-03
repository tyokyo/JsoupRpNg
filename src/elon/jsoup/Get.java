package elon.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

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
    @Test(description ="测试百度搜索接口")
    public void testGetBaiduSearch() throws IOException {
        Document docweb = getUrl("http://yuedu.baidu.com/search", "%D4%C6%B2%E3");
        System.out.println(docweb);
    }
    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
		Document docweb = getUrl("http://yuedu.baidu.com/search", "%D4%C6%B2%E3");
		System.out.println(docweb);
    }
    /**
     * 发送get请求获取返回body
     * @param url  请求地址
     * @param cookie  请求cookie
     * @return
     * @throws IOException
     */
    public static String httpGet(String url,String cookie) throws IOException{
        //获取请求连接
        Connection con = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cookie);
        //解析请求结果
        Document doc=con.get();
        //获取标题
        //System.out.println(doc.title());
        return doc.toString();

    }

    /**
     * 发送get请求获取返回headers具体值
     * @param url  请求地址
     * @return
     * @throws IOException
     */
    public static String httpGetHeader(String url,String cook,String header) throws IOException{
        //获取请求连接
        Connection con = Jsoup.connect(url);
        //请求头设置，特别是cookie设置
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
        con.header("Cookie", cook);
        //发送请求
        Connection.Response resp=con.method(Connection.Method.GET).execute();
        //获取cookie名称为__bsi的值
        String cookieValue = resp.cookie(header);
//		System.out.println("cookie  __bsi值：  "+cookieValue);
//		//获取返回cookie所值
//		Map<String,String> cookies = resp.cookies();
//		System.out.println("所有cookie值：  "+cookies);
//		//获取返回头文件值
//		String headerValue = resp.header(header);
//		System.out.println("头文件"+header+"的值："+headerValue);
//		//获取所有头文件值
//		Map<String,String> headersOne =resp.headers();
//		System.out.println("所有头文件值："+headersOne);
        return cookieValue;

    }
}
