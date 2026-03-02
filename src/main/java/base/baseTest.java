package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtils;
import utils.ExtentReportManager;
import utils.Log;

public class baseTest {

	protected WebDriver driver;
	private By LogingButton = By.xpath("//button[@type=\"submit\"]");
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	protected static ExtentReports extent;
	protected static ExtentTest extenTests;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInntance();
	}

	@AfterSuite
	public void teardownReport() {
		extent.flush();
		
		String reportPath = ExtentReportManager.reprortPath;
		EmailUtils.sendTestReport(reportPath);
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		Log.info("Startign WebDriver........");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		Log.info("Navigatting to URL");
		driver.get("https://opensource-demo.orangehrmlive.com/");
//		WebElement element = wait.until(
//		        ExpectedConditions.visibilityOfElementLocated(LogingButton));
		Thread.sleep(5000);
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() ==ITestResult.FAILURE){
			String screenshotPath = ExtentReportManager.takeScreenShot(driver, "Login Fauilure");
			extenTests.fail("Test Failed. Screenshot Attached",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		if (driver != null) {
			Log.info("Closing the driver");
//			driver.quit();
		}
	}
}
