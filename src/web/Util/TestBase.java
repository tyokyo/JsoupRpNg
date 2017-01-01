package web.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;
public class TestBase {
	private static String configPath = "properties/config.properties";
	private static String driverName;
	public static WebDriver driver;
	private static WebDriver StartFireFoxByDefault(){
		System.out.println("start firefox browser...");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	private static WebDriver StartFireFoxNotByDefault(){
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		System.out.println("start firefox browser succeed...");
		return driver;
	}
	private static void StartFireFoxByProxy(){
		String proxyIp = "10.17.171.11";
		int proxyPort = 8080;
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.firefox.bin",
				"D:/Program Files/Mozilla Firefox/firefox.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", proxyIp);
		profile.setPreference("network.proxy.http_port", proxyPort);

		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "D:\\");

		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.baidu.com");
		System.out.println("start firefox browser succeed...");
	}
	private static void StartFireFoxLoadPlugin(){
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.firefox.bin",
				"D:/Program Files/Mozilla Firefox/firefox.exe");
		File file = new File("files/firebug-2.0.7-fx.xpi");
		FirefoxProfile profile = new FirefoxProfile();
		profile.addExtension(file);
		profile.setPreference("extensions.firebug.currentVersion", "2.0.7");
		//active firebug extensions
		profile.setPreference("extensions.firebug.allPagesActivation", "on");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.baidu.com");
		System.out.println("start firefox browser succeed...");
	}
	private static WebDriver StartChrome(){
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("start firefox browser succeed...");
		return driver;
	}
	private static void StartChromeLoadPlugin(){
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
		File file = new File ("files\\youtube.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(file);
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.baidu.com/");
		System.out.println("start firefox browser succeed...");
	}
	public static WebDriver StartIE(){
		System.out.println("start firefox browser...");
		System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		System.out.println("start firefox browser succeed...");
		return driver;
	}
	static{
		  driverName= Property.getValueByKey(configPath, "Driver");
	}
	public static void stopDriver(){
		if (driver!=null){
			driver.quit();
		}
	}
	public static  void startDriver() {
		switch(driverName) {
			case "IE":
				driver = StartIE();
				break;
			case "FireFox":
				driver = StartIE();
				break;
			case "Chrome":
				driver = StartIE();
				break;
			default:
				driver = StartIE();
		}
	}
}
