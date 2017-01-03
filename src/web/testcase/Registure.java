package com.sio.webtestin;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Registure {

	//1. 输入正确的内容注册成功
	@Test
	public void registerWithSuccess(){

		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");


		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://10.120.1.39/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.className("login"));
		login.click();
		WebElement register = driver.findElement(By.className("btn_register"));
		register.click(); // nickname
		WebElement nickname = driver.findElement(By.name("nickname"));
		nickname.sendKeys(new CharSequence[]{"xiao"
				+ UUID.randomUUID().toString().substring(0, 15)});
		// email
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys(new CharSequence[]{UUID.randomUUID().toString().substring(0, 12)
				+ "@ctk.com"});
		// password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(new CharSequence[]{"123456"});
		// repeat_password
		WebElement repeat_password = driver.findElement(By
				.name("repeat_password"));
		repeat_password.sendKeys(new CharSequence[]{"123456"});
		// class:submit
		WebElement submit = driver.findElement(By.className("submit"));
		submit.click();
		// 等待sioeye_id元素出现，一直到40秒的超时。
		new WebDriverWait(driver, 40).until(ExpectedConditions
				.presenceOfElementLocated(By.className("sioeye_id")));

		// class:sioeye_id
		WebElement sioeye_id = driver.findElement(By.className("sioeye_id"));
		boolean flag = sioeye_id != null;
		Assert.assertEquals(flag,true);
		System.out.print("注册成功！！！");
		driver.quit();
	}
	//2. 注册--输入所有内容为空
	@Test
	public void registerWithoutValue(){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");

		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://10.120.1.39/");
		//放大窗口
		driver.manage().window().maximize();
		//打开登录界面
		WebElement login = driver.findElement(By.className("login"));
		login.click();
		//打开注册界面
		WebElement register = driver.findElement(By.className("btn_register"));
		register.click();
		// 点击log in
		WebElement submit = driver.findElement(By.className("submit"));
		submit.click();
		//检查提示需要输入nickname
		WebElement naickname = (WebElement) driver.findElements(By.cssSelector(".form_con .table_register .error")).get(0);
		if(naickname.isDisplayed()){
			String nickname = naickname.getText();
			System.out.println(nickname);
			if(naickname.equals("Nickname is required")){
				// TODO
				System.out.println("Pass");
			}else{
				System.out.println("Failed");
			}
		}else {
			System.out.println("Failed");
		}
		//检查提示要输入email
		WebElement email = (WebElement) driver.findElements(By.cssSelector(".form_con .table_register .error")).get(1);
		if(email.isDisplayed()){
			String email_error = email.getText();
			System.out.println(email_error);
			if(email_error.equals("Nickname is required")){
				// TODO
				System.out.println("Pass");
			}else{
				System.out.println("Failed");
			}
		}else {
			System.out.println("Failed");
		}
		//检查提示要输入password
		WebElement password = (WebElement) driver.findElements(By.cssSelector(".form_con .table_register .error")).get(2);
		if(password.isDisplayed()){
			String password_error = password.getText();
			System.out.println(password_error);
			if(password_error.equals("Nickname is required")){
				// TODO
				System.out.println("Pass");
			}else{
				System.out.println("Failed");
			}
		}else {
			System.out.println("Failed");
		}
		//检查提示要输入repeat password
		WebElement repeat_password = (WebElement) driver.findElements(By.cssSelector(".form_con .table_register .error")).get(3);
		if(repeat_password.isDisplayed()){
			String repeat_password_error = repeat_password.getText();
			System.out.println(repeat_password_error);
			if(repeat_password_error.equals("Nickname is required")){
				// TODO
				System.out.println("Pass");
			}else{
				System.out.println("Failed");
			}
		}else {
			System.out.println("Failed");
		}
		driver.quit();
	}
	//注册--输入短字符
	@Test
	public void RegiterWithShort(){
		//设置测试浏览器
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//设置浏览器的语言
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");
		WebDriver driver= new FirefoxDriver(profile);
		//打开浏览器
		driver.get("http://10.120.1.39/");
		//点击注册登录按钮
		WebElement login = driver.findElement(By.className("login"));
		login.click();
		//点击注册按钮
		WebElement register = driver.findElement(By.className("btn_register"));
		register.click();

		//输入短字符
		WebElement nickname = driver.findElement(By.name("nickname"));
		nickname.sendKeys("12");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("1999@163.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("12");
		WebElement repeat_password = driver.findElement(By.name("repeat_password"));
		repeat_password.sendKeys("12");

		//点击注册按钮
		WebElement submit = driver.findElement(By.className("submit"));
		submit.click();

		//验证输入短nickname是否有提示
		WebElement ShortNick = (WebElement) driver.findElements(By.cssSelector("label[class='error has_error']")).get(0);
		if(ShortNick.isDisplayed()){
			String shortnick_prompt_error= ShortNick.getText();
			System.out.println(shortnick_prompt_error);

			if(shortnick_prompt_error.equals("Nickname should be 3 ~ 20 characters")){
				System.out.println("Pass");
				// TODO
			}else{
				System.out.println("Fail");
			}
		}else {
			System.out.println("Fail");
		}
		//验证输入短的password是否有提示
		WebElement ShortPassword = (WebElement) driver.findElements(By.cssSelector("label.error")).get(2);
		if(ShortPassword.isDisplayed()){
			String shortpassword_prompt_error = ShortPassword.getText();
			System.out.println(shortpassword_prompt_error);
			if(shortpassword_prompt_error.equals("Password should be at least 6 characters")){
				System.out.println("Pass");
			}else{
				System.out.println("False");
			}

		}else{
			System.out.println("Failed");
		}
	}
	//注册--输入长字符
	@Test
	public void RegiterWithLong(){
		//设置测试浏览器
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//设置浏览器的语言
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.locale", "en-US");
		profile.setPreference("intl.accept_languages", "en-US");
		WebDriver driver= new FirefoxDriver(profile);
		//打开浏览器
		driver.get("http://10.120.1.39/");
		//点击注册登录按钮
		WebElement login = driver.findElement(By.className("login"));
		login.click();
		//点击注册按钮
		WebElement register = driver.findElement(By.className("btn_register"));
		register.click();

		//输入长字符
		WebElement nickname = driver.findElement(By.name("nickname"));
		nickname.sendKeys("123456789012345678901234567890");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("1999@qq.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456789012345678901234567890");
		WebElement repeat_password = driver.findElement(By.name("repeat_password"));
		repeat_password.sendKeys("123456789012345678901234567890");

		//点击注册按钮
		WebElement submit = driver.findElement(By.className("submit"));
		submit.click();

		//验证输入短nickname是否有提示
		WebElement ShortNick = (WebElement) driver.findElements(By.cssSelector("label[class='error has_error']")).get(0);
		if(ShortNick.isDisplayed()){
			String shortnick_prompt_error= ShortNick.getText();
			System.out.println(shortnick_prompt_error);

			if(shortnick_prompt_error.equals("Nickname should be 3 ~ 20 characters")){
				System.out.println("Pass");
				// TODO
			}else{
				System.out.println("Fail");
			}
		}else {
			System.out.println("Fail");
		}
		//验证输入长的password是否有提示
		WebElement ShortPassword = (WebElement) driver.findElements(By.cssSelector("label.error")).get(2);
		if(ShortPassword.isDisplayed()){
			String shortpassword_prompt_error = ShortPassword.getText();
			System.out.println(shortpassword_prompt_error);
			if(shortpassword_prompt_error.equals("Password should be at most 24 characters")){
				System.out.println("Pass");
			}else{
				System.out.println("False");
			}

		}else{
			System.out.println("Failed");
		}
	}
	//注册--输入格式不对的密码

}





