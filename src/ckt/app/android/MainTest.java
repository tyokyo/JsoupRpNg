package ckt.app.android;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainTest {
  @Test
  public void f1() {
	  System.out.println("test one");
  }
  @Test
  public void f2() {
	  System.out.println("test two");
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
