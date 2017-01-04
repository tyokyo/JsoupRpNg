package ckt.app.android;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.Reporters;

public class MainTest{
	@Test(description ="test one")
	public void test01() {
		System.out.println("test one");
		//Reporters.logInfo("<img src=../screenshot/" + "f3" + ".png onclick='window.open(\"../screenshot/"+"f3"+".png\")' height='50' width='50'/>");
		//Reporters.logInfo("<img src='"+"../screenshot/f3.png'  hight='100'  width='100'/><br>");
	}
	@Test(description ="test two")
	public void test02() {
		System.out.println("test two");
	}
	@Test(description ="test three")
	public void df3() {
		System.out.println("test three");
		Assert.assertEquals(true, false);
	}
	@Test(description ="test four")
	public void test03() {
		//Reporters.logInfo("<img src='"+"../screenshot/f3.png'  hight='100'  width='100'/><br>");
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
