package org.uncommons.reportng;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import web.listener.TestNgListener;

public class ExtendMain {
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static void main(String[] args) {
		//强制显示图片
		System.setProperty(ESCAPE_PROPERTY, "false");
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(false);
		testNG.addListener(new HTMLReporter());
		testNG.addListener(new JUnitXMLReporter());
		//自定义监听器
		testNG.addListener(new TestNgListener());
		List<String> suits = new ArrayList<String>();
		//添加测试套件
		suits.add("xml/demo.xml");
		suits.add("xml/demo2.xml");
		testNG.setTestSuites(suits);
		testNG.run();
	}
}
