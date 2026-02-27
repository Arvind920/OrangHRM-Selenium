package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	private WebDriver driver;

	private By userName = By.xpath("//input[@name='username']");
	private By passWord = By.xpath("//input[@name='password']");
	private By LogingButton = By.xpath("//button[@type=\"submit\"]");

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String UserName) {

		driver.findElement(userName).sendKeys(UserName);
	}

	public void enterPassword(String Password) {
		driver.findElement(passWord).sendKeys(Password);

	}

	public void clickLogin() {
		driver.findElement(LogingButton).click();
	}
}
