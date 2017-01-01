package web.listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;
import org.uncommons.reportng.Reporters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import web.util.TestBase;
import web.util.VP;

public class TestNgListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		Reporters.logInfo(tr.getName() + " Failure");
		VP.takeScreenShot(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		Reporters.logInfo(tr.getName() + " Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		//takeScreenShot(tr);
		Reporters.logInfo(tr.getName() + " Success");
		//takeScreenShot(tr);
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		Reporters.logInfo(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

	}
}