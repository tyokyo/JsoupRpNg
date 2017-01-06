package web.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import web.util.VP;
//@Listeners({web.listener.TestNgListener.class})
public class AccountTest extends VP{
	//@Test(retryAnalyzer = TestRetryAnalyzer.class)
	public void LoginManagementAccount() {
		driver.findElement(By.id("kw")).sendKeys("selenium java");
		wait(3);
		driver.findElement(By.id("su")).click();
		wait(3);
		Assert.assertEquals(true,false);
	}
	@BeforeMethod
	public void setup() {
		startDriver();
	}

	@AfterMethod
	public void teardown() {
		stopDriver();
	}
}
