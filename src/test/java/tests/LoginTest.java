package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pages.loginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends baseTest {

	@Test
	public void validLogin() {

		Log.info("Starting Login Test");
		extenTests = ExtentReportManager.createTest("Login Test");

		extenTests.info("Initalizing browser");
		loginPage loginpage = new loginPage(driver);

		Log.info("Entring User Details");
		extenTests.info("Entring User Details");

		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();

		extenTests.info("Getting the title of webdriver");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		extenTests.info(driver.getTitle());
		extenTests.pass("Login Pass");
	}
	
	@Test
	public void invalid() {

		Log.info("Starting Login Test");
		extenTests = ExtentReportManager.createTest("Login Test invalid creds");

		extenTests.info("Initalizing browser");
		loginPage loginpage = new loginPage(driver);

		Log.info("Entring User Details");
		extenTests.info("Entring User Details");

		loginpage.enterUsername("Admin1");
		loginpage.enterPassword("admin1231");
		loginpage.clickLogin();

		extenTests.info("Getting the title of webdriver");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM1");
		extenTests.info(driver.getTitle());
		extenTests.pass("Login Pass");
	}
}
