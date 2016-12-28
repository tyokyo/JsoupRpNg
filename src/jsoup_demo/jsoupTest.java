package jsoup_demo;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class jsoupTest {

	public static Document getUrl(String url,String parameter) throws IOException{
		Document document = null;
		Connection conn = Jsoup.connect(url);
		conn.data("word",parameter);
		conn.data("pbook","0");
		document=conn.get();
		return document;
	}
	public static Document postUrl(String url,String parameter) throws IOException{
		Document document = null;
		Connection conn = Jsoup.connect(url);
		conn.timeout(10000);
		conn.data("theRegionCode",parameter);
		document=conn.post();
		return document;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Document docweb = getUrl("http://yuedu.baidu.com/search", "%D4%C6%B2%E3");
		//System.out.println(docweb);

		System.out.println("=====================================");
		Document webdoc = postUrl("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?op=getSupportCityString", "上海");
		System.out.println(webdoc);
	}

}
