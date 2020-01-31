package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TestCase4PrdDelPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase4PrdDelTests {
	
	private WebDriver driver;
	private String baseUrl;
	private TestCase4PrdDelPOM TestCase4PrdDelPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TestCase4PrdDelPOM = new TestCase4PrdDelPOM(driver); 
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
	@Test
	public void validLoginTest() {
		TestCase4PrdDelPOM.sendUserName("Admin");
		TestCase4PrdDelPOM.sendPassword("admin@123");
		TestCase4PrdDelPOM.clickLoginBtn(); 
		TestCase4PrdDelPOM.clickcatlog();
		TestCase4PrdDelPOM.clickprdt();
		TestCase4PrdDelPOM.selchkbox();
		TestCase4PrdDelPOM.debox();
		
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Are you sure ----" + alertText);
		simpleAlert.accept();
		
	}
}
