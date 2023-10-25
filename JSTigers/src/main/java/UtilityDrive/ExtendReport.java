package UtilityDrive;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	
	public static ExtentReports getExtentReport() {

		String extentReportPath = System.getProperty("user.dir") + "\\Reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("JSTigers Browser Results");
		reporter.config().setDocumentTitle("JSTigers Browser Test Results");

		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);

		return extentReport;
	}

}
