package web.listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;
import org.uncommons.reportng.ReportLogger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import web.util.TestBase;

public class TestNgListener extends TestListenerAdapter {
	private static Logger logger = Logger.getLogger(TestNgListener.class);

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		//takeScreenShot(tr);
		logger.info(tr.getName() + " Success");
		//takeScreenShot(tr);
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

	}
	private void takeScreenShot(ITestResult tr) {
		if (TestBase.driver!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String mDateTime = formatter.format(new Date());
			File location = new File("test-output/screenshot");
			String screenName = mDateTime+"_"+tr.getMethod().getMethodName()+".png";
			String screenShotPath = location.getAbsolutePath()+File.separator+screenName;
			File srcFile = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(screenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.setCurrentTestResult(tr);
			ReportLogger.logDebug(true,("<img src=../screenshot/" + screenName + ".png onclick='window.open(\"../screenshot/"+screenName+".png\")' height='50' width='80'/>"));
		}else {
			ReportLogger.logDebug(true,"driver is NULL, screenshot Skipped");
		}
	}
}