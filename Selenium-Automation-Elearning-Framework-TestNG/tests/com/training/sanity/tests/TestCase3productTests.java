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
import com.training.pom.TestCase3ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase3productTests {
	
	private WebDriver driver;
	private String baseUrl;
	private TestCase3ProductPOM TestCase3ProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TestCase3ProductPOM = new TestCase3ProductPOM(driver); 
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
		TestCase3ProductPOM.sendUserName("Admin");
		TestCase3ProductPOM.sendPassword("admin@123");
		TestCase3ProductPOM.clickLoginBtn(); 
		TestCase3ProductPOM.clickcatlog();
		TestCase3ProductPOM.validtext();
		TestCase3ProductPOM.valtxt();
	
		//screenShot.captureScreenShot("First");
		
		TestCase3ProductPOM.clickprdt();
		TestCase3ProductPOM.inputprdtname();
		String prdname = driver.findElement(By.id("input-name")).getAttribute("value");
		System.out.println("Input  :" +prdname);
		TestCase3ProductPOM.clickfilter();
		String filterproductname = driver.findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();
		String trname=filterproductname.substring(0, 11);
		System.out.println("Inputname  :" +trname);
		System.out.println("showthevalue  :" +filterproductname);
		TestCase3ProductPOM.vertext();
			
			if (prdname.contentEquals(trname)) {
				System.out.println("Product name is filtering correctly");
			}else {
				System.out.println("Product name is not filtering correctly");
				
			}
			
			
	}

}
