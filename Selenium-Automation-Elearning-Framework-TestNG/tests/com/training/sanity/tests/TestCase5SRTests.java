package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TestCase5SalesReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase5SRTests {
	
	private WebDriver driver;
	private String baseUrl;
	private TestCase5SalesReportPOM TestCase5SalesReportPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TestCase5SalesReportPOM = new TestCase5SalesReportPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test (priority=1)
	public void validLoginTest() {
		TestCase5SalesReportPOM.sendUserName("Admin");
		TestCase5SalesReportPOM.sendPassword("admin@123");
		TestCase5SalesReportPOM.clickLoginBtn(); 
		
		
	}
	
	@Test(priority=2)
	public void statusReport() {	
		TestCase5SalesReportPOM.clicksricon();
		TestCase5SalesReportPOM.clicksalelnk();
		TestCase5SalesReportPOM.validText();
		
		TestCase5SalesReportPOM.clickorderlnk();
		
		TestCase5SalesReportPOM.clickstddte();
		
		TestCase5SalesReportPOM.clickenddte();
		
		TestCase5SalesReportPOM.clickfilter();
		TestCase5SalesReportPOM.selgrpby();
		TestCase5SalesReportPOM.selordsts();
		TestCase5SalesReportPOM.clickfilter();
	}
}
