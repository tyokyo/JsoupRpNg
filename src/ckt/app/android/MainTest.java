package ckt.app.android;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.ReportLogger;

public class MainTest{
	@Test(description ="test one")
	public void af() {
		System.out.println("test one");
		ReportLogger.logDebug(true,("<img src=../screenshot/" + "1389967799784" + ".png onclick='window.open(\"../screenshot/"+"1389967799784"+".png\")' height='50' width='50'/>"));
		Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
	}
	@Test(description ="test two")
	public void cf2() {
		System.out.println("test two");
	}
	@Test(description ="test three")
	public void df3() {
		System.out.println("test three");
		Assert.assertEquals(true, false);
	}
	@Test(description ="test four")
	public void bf4() {
		Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
		System.out.println("test four");
		Assert.assertEquals(true, true);
	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
