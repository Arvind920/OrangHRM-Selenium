package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {

	protected WebDriver driver;
	private By LogingButton = By.xpath("//button[@type=\"submit\"]");
	private  WebDriverWait  wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
//		WebElement element = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(LogingButton));
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!= null) {
		}
	}
}
