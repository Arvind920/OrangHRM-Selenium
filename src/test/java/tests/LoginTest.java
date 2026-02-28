package tests;

import org.testng.annotations.Test;

import base.baseTest;
import pages.loginPage;
import utils.Log;

public class LoginTest extends baseTest{
	
	@Test
	public void validLogin() {
		
		Log.info("Starting Login Test");
		loginPage loginpage = new loginPage(driver);
		
		Log.info("Entring User Details");
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		
		System.out.println(driver.getTitle());
	}
}
