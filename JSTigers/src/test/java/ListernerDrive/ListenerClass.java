package ListernerDrive;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseDrive.BaseClass;
import UtilityDrive.ExtendReport;

public class ListenerClass extends BaseClass implements ITestListener {

	WebDriver driver = null;
	ExtentReports extentReport = ExtendReport.getExtentReport();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.fail(result.getThrowable());
		String testName = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {

			e1.printStackTrace();
		}

		try {
			String screenshotPath = takeScreenshot(testName, driver);
			extentTest.addScreenCaptureFromPath(screenshotPath, testName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}
