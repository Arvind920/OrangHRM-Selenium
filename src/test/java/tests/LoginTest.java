package tests;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.baseTest;
import pages.loginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends baseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLocingData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/Include/Test Data.xlsx";
		ExcelUtils.LoadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowcount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0);// userName
			data[i - 1][1] = ExcelUtils.getCellData(i, 1);// password

		}
		ExcelUtils.closeExcel();
		return data;
	}

	// Creating the local dataprovider
	@DataProvider(name="loginData2")
	public Object [][] getData(){
		return new Object[][] {
			{"Admin","Admin2"},
			{"Admin","Admin2"},
			{"Admin","Admin2"}
		};
	}

//	@Test(dataProvider ="LoginData") //to pass the data form excel
	@Test
	@Parameters({"userName","passWord"})    //this is help to pass parameter on suit lavel
	public void validLogin(String userName, String passWord) {

		Log.info("Starting Login Test");
		extenTests = ExtentReportManager.createTest("Login Test" + userName);

		extenTests.info("Initalizing browser");
		loginPage loginpage = new loginPage(driver);

		Log.info("Entring User Details");
		extenTests.info("Entring User Details");

//		loginpage.enterUsername("Admin");
//		loginpage.enterPassword("admin123");
		loginpage.enterUsername(userName);
		loginpage.enterPassword(passWord);
		loginpage.clickLogin();

		extenTests.info("Getting the title of webdriver");
		System.out.println(driver.getTitle());
		AssertJUnit.assertEquals(driver.getTitle(), "OrangeHRM");
		extenTests.info(driver.getTitle());
		extenTests.pass("Login Pass");
	}

//	@Test
//	public void invalid() {
//
//		Log.info("Starting Login Test");
//		extenTests = ExtentReportManager.createTest("Login Test invalid creds");
//
//		extenTests.info("Initalizing browser");
//		loginPage loginpage = new loginPage(driver);
//
//		Log.info("Entring User Details");
//		extenTests.info("Entring User Details");
//
//		loginpage.enterUsername("Admin1");
//		loginpage.enterPassword("admin1231");
//		loginpage.clickLogin();
//
//		extenTests.info("Getting the title of webdriver");
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM1");
//		extenTests.info(driver.getTitle());
//		extenTests.pass("Login Pass");
//	}
}
