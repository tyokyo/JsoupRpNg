package ckt.app.android;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainTest {
	@Test(description ="test one")
	public void af() {
		System.out.println("test one");
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
