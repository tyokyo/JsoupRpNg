package web.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

//import org.openqa.selenium.firefox.FirefoxProfile;

@Test
public class Discovery {
	public WebDriver driver;
	String baseUrl = "http://10.120.1.39/";
	@BeforeMethod
	public void BeforeMethod(){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void AfterMethod(){
		driver.quit();
	}
	//检查Top broadcasts
	public void Topbroadcasts(){

		//点击next
		WebElement next = driver.findElement(By.className("next"));
		Actions  builder=new Actions(driver);
		builder.doubleClick(next).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证next正确性
		WebElement prevabled = driver.findElement(By.cssSelector("a.btn_prev"));
		System.out.println(prevabled.isDisplayed());
		//点击prev
		WebElement prev = driver.findElement(By.className("prev"));
		//Actions  builder1=new Actions(driver);
		builder.doubleClick(prev).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证prey正确性
		WebElement nextbled = driver.findElement(By.cssSelector("a.btn_next"));
		System.out.println(nextbled.isDisplayed());

	}

	//未登录时，检查Who to follow
	public void WhoToFollow(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,750)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击refresh
		WebElement refresh = driver.findElement(By.className("refresh"));
		refresh.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//点击Follow
		WebElement follow1 = driver.findElements(By.linkText("关注")).get(1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		follow1.click();

		//验证是否弹出登录窗口
		WebElement submit = driver.findElements(By.className("submit")).get(1);
		String login = submit.getText();
		System.out.println(submit.isDisplayed());
		System.out.println(login);
	}

	//点击用户头像进入用户个人中心，检查Who To Follow
	public void User_WhoToFollow(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,800)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击用户头像
		WebElement head1 = driver.findElements(By.className("head")).get(1);
		head1.click();
		//验证是否进入此用户界面
		WebElement sioeyeid = driver.findElement(By.className("sioeye_id_val"));
		String id = sioeyeid.getText();
		System.out.println(sioeyeid.isDisplayed());
		System.out.println(id);

		//点击推荐达人中的刷新
		WebElement refresh1 = driver.findElement(By.className("refresh"));
		refresh1.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击推荐达人中的关注
		WebElement follow1 = driver.findElements(By.linkText("关注")).get(1);
		follow1.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证是否关注成功
		WebElement submit1 = driver.findElements(By.className("submit")).get(1);
		String login1 = submit1.getText();
		System.out.println(submit1.isDisplayed());
		System.out.println(login1);
		//点击关闭登录窗口
		WebElement close3 = driver.findElement(By.xpath("//span[@class='icon_close']"));
		close3.click();

		//先打印一个推荐达人的nickname
		WebElement nickname1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[1]/div/a/h1"));
		System.out.println(nickname1.getText());
		//检查鼠标悬浮在推荐达人的用户头像上
		WebElement wtfavatar = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[1]/a[1]/img"));
		//声明一个Action对象
		Actions actions =new Actions(driver);
		//调用Action对象的moveToElement方法
		actions.moveToElement(wtfavatar).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//打印悬浮推荐达人的nickname
		WebElement nickname2 =driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div[1]/div[2]/a/h2"));
		System.out.println(nickname2.getText()+"与上面的相同");
		//Assert.assertSame(nickname1.getText(), nickname2.getText());
		//在悬浮推荐达人中点击关注
		WebElement follow = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/a"));
		follow.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证是否关注成功
		WebElement submit2 = driver.findElements(By.className("submit")).get(1);
		String login2 = submit2.getText();
		System.out.println(submit2.isDisplayed());
		System.out.println(login2);
		//点击关闭登录窗口
		close3.click();
	}

	//点击用户头像进入用户个人中心，检查用户视频
	public void UserVideo(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,800)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击用户头像
		WebElement head1 = driver.findElements(By.className("head")).get(1);
		head1.click();
		//检查此用户是否有视频
		By dBy =  By.className("no_data_msg");
		List<WebElement> novideoDrivers = driver.findElements(dBy);
		//如果没有视频，则不点击分享
		if (novideoDrivers.size() > 0)
		{
			return ;
		}

		//点击转发
		WebElement repost = driver.findElements(By.xpath("//a[@class='btn btn_repost']")).get(0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repost.click();
		//验证是否弹出登录窗口
		WebElement submit = driver.findElements(By.className("submit")).get(1);
		String login = submit.getText();
		System.out.println(submit.isDisplayed());
		System.out.println(login);
		//点击关闭登录窗口
		WebElement close1 = driver.findElement(By.xpath("//span[@class='icon_close']"));
		close1.click();
		//点击分享
		WebElement share = driver.findElements(By.xpath("//a[@class='btn share2']")).get(0);
		share.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击关闭
		WebElement close2 = driver.findElement(By.xpath("//button[@class='at-expanded-menu-close']"));
		close2.click();
	}

	//点击用户头像进入用户个人中心，检查用户关注页面
	public void UserFollowing(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,800)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击用户头像
		WebElement head1 = driver.findElements(By.className("head")).get(1);
		head1.click();
		//进入关注页面
		WebElement following = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/a[2]"));
		following.click();
		//检查此用户是否有关注者
		By dBy =  By.className("avatar");
		List<WebElement> noavatarDrivers = driver.findElements(dBy);
		//如果没有视频，则不点击分享
		if (noavatarDrivers.size() > 0)
		{
			return ;
		}
		//点击关注
		WebElement follow = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/a[2]"));
		follow.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证是否关注成功
		WebElement submit1 = driver.findElements(By.className("submit")).get(1);
		String login1 = submit1.getText();
		System.out.println(submit1.isDisplayed());
		System.out.println(login1);
		//点击关闭登录窗口
		WebElement close3 = driver.findElement(By.xpath("//span[@class='icon_close']"));
		close3.click();
	}

	//点击用户头像进入用户个人中心，检查用户粉丝页面
	public void UserFollowers(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,800)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击用户头像
		WebElement head1 = driver.findElements(By.className("head")).get(1);
		head1.click();
		//进入关注页面
		WebElement followers = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/a[3]"));
		followers.click();
		//检查此用户是否有关注者
		By dBy =  By.className("avatar");
		List<WebElement> noavatarDrivers = driver.findElements(dBy);
		//如果没有视频，则不点击分享
		if (noavatarDrivers.size() > 0)
		{
			return ;
		}
		//点击关注
		WebElement follow = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/a[2]"));
		follow.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//验证是否关注成功
		WebElement submit1 = driver.findElements(By.className("submit")).get(1);
		String login1 = submit1.getText();
		System.out.println(submit1.isDisplayed());
		System.out.println(login1);
		//点击关闭登录窗口
		WebElement close3 = driver.findElement(By.xpath("//span[@class='icon_close']"));
		close3.click();
	}

	//检查下载app二维码
	public void DownloadApp(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,800)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击用户头像
		WebElement head1 = driver.findElements(By.className("head")).get(1);
		head1.click();
		//验证是否显示Sioeye手机app
		WebElement downloadfree = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]"));
		String  free = downloadfree.getText();
		System.out.println(downloadfree.isDisplayed());
		System.out.println(free);

		//先将当前浏览器窗口的句柄存储到parentWindowHandle变量中
		String paerntWindowHandle = driver.getWindowHandle();
		WebElement appstore = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/a/img"));
		appstore.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取当前所有打开窗口的句柄，并把它存储到一个set容器中
		java.util.Set<String> allWindowHandles = driver.getWindowHandles();
		//如果容器存储的对象不为空，在遍历容器allWindowHandles中的所有浏览器句柄
		if (!allWindowHandles.isEmpty()){
			for (String windowHandle : allWindowHandles){
				try {
					if (driver.switchTo().window(windowHandle).getTitle().equals("应用详情"));
					//如果判断成立，则说明是Sioeye旗舰店 - 京东
				}catch (NoSuchWindowException e) {
					//如果没有找到浏览器的句柄，则会抛出NoSuchWindowException，打印异常的堆栈信息
					e.printStackTrace();
				}
			}
		}
		//返回到最开始打开的浏览器页面
		driver.switchTo().window(paerntWindowHandle);
	}

	//查看热门视频
	public void hotbroadcasts(){

		((JavascriptExecutor) driver).executeScript("window.scrollBy (0,1350)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击热门视频
		WebElement video1 = driver.findElements(By.className("hot_video")).get(1);
		video1.click();
		//验证是否进入此视频界面
		String pageurl=driver.getCurrentUrl();
		System.out.println(pageurl);
		Assert.assertTrue(pageurl.startsWith("https://10.120.1.39/promotion/"));
	}
}