package tests;

import org.testng.annotations.Test;

import base.baseTest;
import pages.loginPage;

public class LoginTest extends baseTest{
	
	@Test
	public void validLogin() {
		loginPage loginpage = new loginPage(driver);
		
		
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		
		System.out.println(driver.getTitle());
	}
}
