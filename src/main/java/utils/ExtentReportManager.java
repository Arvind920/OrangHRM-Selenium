package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ExtentTest extentTest;

	public static ExtentReports getReportInntance() {
		if (extent == null) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reprortPath = "reports/ExtentReprot_" + timeStamp + ".html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(reprortPath);

			reporter.config().setDocumentTitle("Automation Test Report");
			reporter.config().setReportName("Automation Test Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);

		}
		return extent;

	}

	public static ExtentTest createTest(String testName) {

		extentTest = getReportInntance().createTest(testName);

		return extentTest;
	}
	
	public static String takeScreenShot(WebDriver driver,String screenshotName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path= System.getProperty("user.dir")+ "/Screenshots/"+screenshotName+".png";
			
			FileUtils.copyFile(src, new File(path));
			
			
			return path;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

}
