package web.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.AfterClass;

import web.base.Constant;
import web.util.VP;

public class AccountTest extends VP{
	@Test
	public void LoginManagementAccount() {
		Navigation navigation = driver.navigate();
		navigation.to(Constant.url_management);
		clickById("UserName");
		clickById("Password");
		clickByCssSelector("btn green-turquoise btn-block bold uppercase");
	}
	@BeforeClass
	public void beforeClass() {
		driver = Browser.StartIE();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
