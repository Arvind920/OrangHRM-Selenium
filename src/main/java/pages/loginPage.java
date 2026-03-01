package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	private WebDriver driver;

	// DEFINED POM TO USE
	private By userName = By.xpath("//input[@name='username']");
	private By passWord = By.xpath("//input[@name='password']");
	private By LogingButton = By.xpath("//button[@type=\"submit\"]");
	
	
	//DEFINEIG PAGE FACTORY HOW WE CAN USE\
	@FindBy(xpath="//input[@name='username']")	WebElement usernameTextBox ;
	
	@FindBy(xpath="//input[@name='password']")	WebElement password;
	
	@FindBy(xpath="//button[@type=\\\"submit\\\"]")	WebElement button;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String UserName) {
		usernameTextBox.clear();
		usernameTextBox.sendKeys("UserName");
//		driver.findElement(userName).sendKeys(UserName);
	}

	public void enterPassword(String Password) {
//		driver.findElement(passWord).sendKeys(Password);
		password.sendKeys(Password);

	}

	public void clickLogin() {
//		driver.findElement(LogingButton).click();
		button.click();
	}
}
