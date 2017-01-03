package ckt.app.android;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.uncommons.reportng.Reporters;

public class MainTest2 {
	@Test(description ="切尔西")
	public void f1() {
		Reporters.logInfo("<img src='"+"../screenshot/1389967799784.png' onmousewheel=\"return bbimg(this)\"  hight='50'  width='50'/><br>");
		Reporters.logInfo("InstrumentationInfo: [com.squareup.spoon.SpoonInstrumentationInfoInstrumentationInfo: [com.squareup.spoon.SpoonInstrumentationInfoInstrumentationInfo: [com.squareup.spoon.SpoonInstrumentationInfoInstrumentationInfo: [com.squareup.spoon.SpoonInstrumentationInfo");
		Reporters.logInfo("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
		//Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
		System.out.println("test one");
	}

	@Test(description ="曼城")
	public void f2() {
		System.out.println("test two");
	}
	@Test(description ="曼联")
	public void f3() {
		//Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
		System.out.println("test three");
		//Reporter.log("Testcase for this..<br>");
		Assert.assertEquals(true, false);
	}
	@BeforeTest
	public void beforeTest() {
		//Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if (!result.isSuccess())
			catchExceptions(result);
	}

	public void catchExceptions(ITestResult result) {
		System.out.println("result" + result);
		String methodName = result.getName();
		System.out.println(methodName);
		if (!result.isSuccess()) {
			File file = new File("");
			Reporter.setCurrentTestResult(result);
			System.out.println(file.getAbsolutePath()+"<br>");
			Reporter.log(file.getAbsolutePath()+"<br>");
			String filePath = file.getAbsolutePath();
			filePath  = filePath.replace("/opt/apache-tomcat-7.0.64/webapps","http://172.18.44.114:8080");
			Reporter.log("<img src='"+"../screenshot/1389967799784.png'  hight='100'  width='100'/><br>");
			int width = 100;
			int height = 100;
			String s = "这是一张测试图片";
			File screenShotFile = new File(file.getAbsolutePath()+"/"+result.getName()+".jpg");

			Font font = new Font("Serif", Font.BOLD, 10);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = (Graphics2D)bi.getGraphics();
			g2.setBackground(Color.BLACK);
			g2.clearRect(0, 0, width, height);
			g2.setPaint(Color.RED);

			FontRenderContext context = g2.getFontRenderContext();
			Rectangle2D bounds = font.getStringBounds(s, context);
			double x = (width - bounds.getWidth()) / 2;
			double y = (height - bounds.getHeight()) / 2;
			double ascent = -bounds.getY();
			double baseY = y + ascent;

			g2.drawString(s, (int)x, (int)baseY);

			try {
				ImageIO.write(bi, "jpg", screenShotFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
