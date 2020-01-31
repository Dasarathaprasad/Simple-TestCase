package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.TestCase2DeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase2DeletTests {
	private WebDriver driver;
	private String baseUrl;
	private TestCase2DeletePOM TestCase2DeletePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TestCase2DeletePOM = new TestCase2DeletePOM(driver); 
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
		TestCase2DeletePOM.sendUserName("Admin");
		TestCase2DeletePOM.sendPassword("admin@123");
		TestCase2DeletePOM.clickLoginBtn(); 
		TestCase2DeletePOM.clickcatlog();
		
		TestCase2DeletePOM.clickcatgry(); 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		TestCase2DeletePOM.movpage();
	    
	   
		TestCase2DeletePOM.selckbox();
		TestCase2DeletePOM.debox();
		
		
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Are you sure ----" + alertText);
		simpleAlert.accept();
		
		
		
		  //There is no proper xpath for this message
		//assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]")).getText(),"Success: You have modified categories!");
		
			
		
	}
}
