package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase2DeletePOM {

private WebDriver driver; 
	
	public TestCase2DeletePOM(WebDriver driver) {
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
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
	private WebElement catgry;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/ul/li[7]/a")
	private WebElement mpage;
	
	@FindBy(xpath="//tr[15]//td[1]//input[1]")
	private WebElement ckbox;
	
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
	
	public void clickcatgry() {
		this.catgry.click();
			
	}
	
	public void movpage() {
		this.mpage.click();
	}
	
	public void selckbox() {
		 this.ckbox.click();
		 
	}		 
	
	public void debox() {
		this.delbutton.click();
	}

}
