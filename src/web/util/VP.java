package web.util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.uncommons.reportng.Reporters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class VP extends TestBase {
	private  static Logger logger = Logger.getLogger(VP.class.getName());
	//click By.id
	public static void clickById(String id){
		driver.findElement(By.id(id)).clear();
	}
	//By.cssSelector
	public static void clickByCssSelector(String id){
		driver.findElement(By.cssSelector(id)).click();
	}
	//By.linkText
	public static void clickByLinkText(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
	//By.name
	public static void clickByName(String name){
		driver.findElement(By.name(name)).click();
	}
	//By.xpath
	public static void clickByXpath(String xpathExpression){
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	//By.partialLinkText
	public static void clickByPartialLinkText(String linkText){
		driver.findElement(By.partialLinkText(linkText)).click();
	}
	//click By.id
	public static void getElementById(String id){
		driver.findElement(By.id(id));
	}
	//By.cssSelector
	public static void getElementByCssSelector(String id){
		driver.findElement(By.cssSelector(id));
	}
	//By.linkText
	public static void getElementByLinkText(String linkText){
		driver.findElement(By.linkText(linkText));
	}
	//By.name
	public static void getElementByName(String name){
		driver.findElement(By.name(name));
	}
	//By.xpath
	public static void getElementByXpath(String xpathExpression){
		driver.findElement(By.xpath(xpathExpression));
	}
	//By.partialLinkText
	public static void getElementByPartialLinkText(String linkText){
		driver.findElement(By.partialLinkText(linkText));
	}
	public static void takeScreenShot(ITestResult tr) {
		logger.info("takeScreenShot-ITestResult-Fail");
		if (TestBase.driver!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String mDateTime = formatter.format(new Date());
			File location = new File("test-output/screenshot");
			String screenName = mDateTime+"_"+tr.getMethod().getMethodName()+".png";
			String screenShotPath = location.getAbsolutePath()+File.separator+screenName;
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(screenShotPath));
				logger.info(screenShotPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.setCurrentTestResult(tr);
			//Reporters.logInfo("<img src=../screenshot/" + "1389967799784" + ".png onclick='window.open(\"../screenshot/"+"1"+".jpg\")' height='50' width='50'/>");
			Reporters.logDebug(true,("<img src=../screenshot/" + screenName + ".png onmousewheel=\"return bbimg(this)\"  height='50' width='50'/>"));
		}else {
			Reporters.logDebug(true,"driver is NULL, screenshot Skipped");
		}
	}
	public static void wait(int time){
		try {
			Thread.currentThread();
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
