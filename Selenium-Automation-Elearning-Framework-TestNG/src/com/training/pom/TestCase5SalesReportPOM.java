package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase5SalesReportPOM {
	
private WebDriver driver; 
	
	public TestCase5SalesReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"reports\"]/a/i")
	private WebElement sricon;

	@FindBy(xpath="//*[@id=\"reports\"]/ul/li[1]/a")
	private WebElement salelnk;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Orders')]")
	private WebElement orderlnk;
	
	@FindBy(id="input-date-start")
	private WebElement startdte;
	
	
	@FindBy(id="input-date-end")
	private WebElement Enddte;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn;
	
    @FindBy(id="input-group")
	private WebElement grpby;
    
    @FindBy(id="input-status")
    private WebElement ordsts;
	
	
	 
	
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
	
	public void clicksricon() {
		this.sricon.click();
	}
	
	public void clicksalelnk() {
		this.salelnk.click();
	}
	
	public void validText() {
		String expectedText = "Orders";
		String actualText = driver.findElement(By.xpath("//ul[@class='collapse in']//a[contains(text(),'Orders')]")).getText();
		assertEquals(actualText, expectedText);
		
	}
	
	public void clickorderlnk() {
		this.orderlnk.click();
	}
	
	public void clickstddte() {
		this.startdte.clear();
		this.startdte.sendKeys("2019-01-28");
	}
	
	
	
	public void clickenddte() {
		this.Enddte.clear();
		this.Enddte.sendKeys("2020-01-27");
	}
	
	public void clickfilter( ) {
		this.filterbtn.click();
	}
	
	public void selgrpby() {
	  Select GroBy = new Select(grpby);
	  GroBy.selectByVisibleText("Days");
	}
	
	public void selordsts( ) {
		Select OrderStatus = new Select(ordsts);
		OrderStatus.selectByVisibleText("Complete");
	}
	
}
