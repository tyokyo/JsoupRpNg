package web.util;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	private static Logger logger=Logger.getLogger(TestBase.class.getName());
	private static String configPath = "properties/config.properties";
	private static  final String FIREFOX_BIN ="webdriver.firefox.bin";
	private static String driverName;
	private static String driver_firefox_bin;
	private static String url;
	public static WebDriver driver;
	private static WebDriver StartFireFox(){
		logger.info("Launch - Firefox ");
		System.setProperty(FIREFOX_BIN, driver_firefox_bin);
		System.setProperty("webdriver.gecko.driver","driver\\geckodriver_64.exe");
		FirefoxProfile profile = new FirefoxProfile();
		//For selenium 3.0
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");
		WebDriver driver = new FirefoxDriver(profile);
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
		//ChromeDriver v2.25 (2016-10-25)----------
		//Supports Chrome v53-55
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		driverName= Property.getValueByKey(configPath, "DRIVER");
		driver_firefox_bin=Property.getValueByKey(configPath, "WEBDRIVER_FIREFOX_BIN");
		url=Property.getValueByKey(configPath, "URL");
	}
	public static void stopDriver(){
		logger.info("stopDriver");
		if (driver!=null){
			driver.quit();
		}
	}
	public static  void startDriver() {
		logger.info("startDriver");
		switch(driverName) {
			case "IE":
				driver = StartIE();
				break;
			case "FireFox":
				driver = StartFireFox();
				break;
			case "Chrome":
				driver = StartChrome();
				break;
			default:
				driver = StartIE();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
}
