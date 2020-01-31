package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase4PrdDelPOM {
	
private WebDriver driver; 
	
	public TestCase4PrdDelPOM(WebDriver driver) {
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
	
	@FindBy(xpath ="//*[@id=\"form-product\"]/div/table/tbody/tr[3]/td[1]/input")
	private WebElement selckbox;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement delbutton;
	
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
	
	public void clickprdt() {
		this.prdt.click();
	}
	
	public void selchkbox() {
		this.selckbox.click();
	}

	public void debox() {
		this.delbutton.click();
	}	
}
