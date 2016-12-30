package web.util;
import org.openqa.selenium.By;

public class VP extends TestBase {
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
