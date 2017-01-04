package web.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.AfterClass;

import web.base.Constant;
import web.util.VP;
//@Listeners({web.listener.TestNgListener.class})
public class AccountTest extends VP{
	@Test
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
