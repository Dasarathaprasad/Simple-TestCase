package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase3ProductPOM {
	
private WebDriver driver; 
	
	public TestCase3ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(id ="catalog")
	private WebElement catlog;
	
	@FindBy(xpath ="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement prdt;
	
	@FindBy(id ="input-name")
	private WebElement prdtname;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn;
	
	@FindBy(xpath ="//tbody//tr[1]//td[3]")
	private WebElement vrytxt;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickcatlog() {
		this.catlog.click();
	}
	
	public void validtext() {
		  String expectedText = "Categories";
		  String actualText = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).getText();
		  assertEquals(actualText, expectedText);
	}
	
	public void valtxt() {
		String expectedText1 = "Products";
		String actualText1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).getText();
		assertEquals(actualText1, expectedText1);
	}
	
	public void clickprdt() {
		this.prdt.click();

	}
	
	public void inputprdtname() {
		this.prdtname.sendKeys("Blazer-Boys");
	}

	public void clickfilter() {
		this.filterbtn.click();
	}
	
	public void vertext() {
	   this.vrytxt.getAttribute("Denim");
	
	}
}
