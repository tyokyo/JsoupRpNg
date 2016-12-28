package jsoup_demo;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import control.ParseHelper;

public class JsoupPost extends ParseHelper{
	
	private static Logger logger = Logger.getLogger(JsoupPost.class.getName());
	public static Document postUrl(String url,String parameter) throws IOException{
		logger.info(url);
		Document document = null;
		document = Jsoup.connect(url).
				data("theRegionCode",parameter).
				timeout(10000).
				post();
		return document;
	}
	public static void main(String args[]){
		
		Document document = null;
		try {
			document= JsoupPost.postUrl("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityString", "上海");
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
