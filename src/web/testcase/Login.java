package web.testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class Login {
	//1. 输入正确的账号和密码，登录成功
	@Test
	public void loginWithSuccess(){

		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//设置浏览器语言为英文
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");





		WebDriver driver = new FirefoxDriver(profile);
		//打开内网首页
		driver.get("http://10.120.1.39/");
		driver.manage().window().maximize();
		//打开登录注册界面
		WebElement signupLogin = driver.findElement(By.className("login"));
		signupLogin.click();

		//打开登录界面
		WebElement loginbutton = driver.findElement(By.linkText("Log In"));
		loginbutton.click();
		//输入正确的账号和密码
		WebElement account = driver.findElement(By.name("account"));
		account.sendKeys(new CharSequence[]{"918@qq.com"});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement password = (WebElement)driver.findElements(By.name("password")).get(1);
		password.sendKeys(new CharSequence[]{"123456"});
		//点击登录按钮
		WebElement signin = (WebElement)driver.findElements(By.className("submit")).get(1);
		signin.click();
		//判断是否登录成功
		boolean flag = driver.getPageSource().contains("萌萌哒");
		System.out.println("登陆是否成功！！！"+flag);
		driver.quit();
	}
	//登录--输入密码为空
	@Test
	public void Loginfailed1(){
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");

		WebDriver driver = new FirefoxDriver(profile);
		//打开url
		driver.get("http://10.120.1.39/");
		driver.manage().window().maximize();
		//打开登录窗口
		WebElement element1 = driver.findElement(By.linkText("Sign up / Log in"));
		element1.click();

		WebElement element2 = driver.findElement(By.linkText("Log In"));
		element2.click();
		//输入用户名
		WebElement account = driver.findElement(By.name("account"));
		account.sendKeys(new CharSequence[]{"xuefan1@qq.com"});
		//点击登录
		WebElement submit = (WebElement) driver.findElements(By.className("submit")).get(1);
		submit.click();

		//检查错误提示
		WebElement Prompt = (WebElement) driver.findElements(By.cssSelector(".form_con .table_login .error")).get(1);
		String text = Prompt.getText();
		System.out.println(text);
		driver.quit();
	}
}
