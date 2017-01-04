package web.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(web.listener.TestNgListener.class)
public class Notification {
	public WebDriver driver;
	String baseUrl = "http://10.120.1.39/";
	@BeforeMethod
	public void BeforeMethod(){
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		WebElement signupLogin = driver.findElement(By.className("login"));
		signupLogin.click();

		WebElement account = driver.findElement(By.name("account"));
		account.sendKeys(new CharSequence[]{"sunny2@qq.com"});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement password = (WebElement)driver.findElements(By.name("password")).get(1);
		password.sendKeys(new CharSequence[]{"123456"});

		WebElement signin = (WebElement)driver.findElements(By.className("submit")).get(1);
		signin.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	////检查新消息红点标记（New）
	@Test
	public void DispalyRedPoint() {

		WebElement redpoint = driver.findElement(By.cssSelector(".notifications.new"));
		if(redpoint.isDisplayed()){
			System.out.println("Pass,the red point is displayed!");
		}else{
			System.out.print("Failed");
		}
		redpoint.click();
		WebElement newmark = driver.findElement(By.className("new_mark"));
		Assert.assertEquals("NEW", newmark.getText());

	}

	/*private void moveEl(WebDriver driver,String xpath){
		//检查评论消息
		WebElement droplistvalue1 = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.moveToElement(droplistvalue1).perform();
	}*/

	//检查下拉列表各个选项
	@Test
	public void ClickDropList(){

		//moveEl(driver, "/html/body/div[3]/div[2]/div/h1/div/div");
		driver.findElement(By.className("notifications")).click();
		//检查评论消息
		WebElement droplistvalue = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/div"));
		Actions action = new Actions(driver);
		action.moveToElement(droplistvalue).perform();
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e){
			e.printStackTrace();

		}

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/ul/li[2]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement comment1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/span[1]"));
		Assert.assertTrue(comment1.getText().contains("评论了你的直播"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//检查关注消息
		action.moveToElement(droplistvalue).perform();
		try{
			Thread.sleep(4000);
		} catch(InterruptedException e){
			e.printStackTrace();

		}

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/ul/li[3]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement comment2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[2]/p[1]"));
		Assert.assertTrue(comment2.getText().contains("关注了你"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//检查赞消息
		action.moveToElement(droplistvalue).perform();
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e){
			e.printStackTrace();

		}

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/ul/li[4]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains("赞了你的直播"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//检查转发消息
		action.moveToElement(droplistvalue).perform();
		try{
			Thread.sleep(3000);
		} catch(InterruptedException e){
			e.printStackTrace();

		}

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/ul/li[5]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(driver.getPageSource().contains("转发了一个视频给你"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//检查被转发消息
		action.moveToElement(droplistvalue).perform();
		try{
			Thread.sleep(3000);
		} catch(InterruptedException e){
			e.printStackTrace();

		}

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/h1/div/ul/li[6]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(driver.getPageSource().contains("转发了你的视频"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
