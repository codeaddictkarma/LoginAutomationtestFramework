package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;

public class ExtentTestsReport implements ITestListener{
	
	     ExtentSparkReporter spark; 
	     ExtentReports report; 
	     ExtentTest test; 
	     String reportPath = "C:\\Users\\psanj\\eclipse-workspace\\LoginAutomationTest\\extentTestReport"; 
	     
	     public void configureReport() {
	    	 
	    	 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    	 String reportName = reportPath + "\\ExtentTestReport" + timeStamp + ".html"; 
	    	 
	    	 spark = new ExtentSparkReporter(reportName); 
	    	 report = new ExtentReports(); 
	    	 report.attachReporter(spark);
	    	 
	    	 
	    	 spark.config().setDocumentTitle("----------Automation Test Extent Report-----------");
	    	 spark.config().setReportName("-------------Login Test Extent Report----------------");
	    	 spark.config().setTheme(Theme.DARK);
	    	 
	    	 
	    	 report.setSystemInfo("Tester", "Ajay Panchal");
	    	 report.setSystemInfo("os", "windows");
	    	 report.setSystemInfo("hostname", "localhost");
	    	 report.setSystemInfo("website", "https://practicetestautomation.com/practice-test-login/");
	    	 
	    	  
	     }
	     
	     public void onStart(ITestContext context) {
	         // Optional: log when test context starts
	    	 configureReport();
	     }
	     
	     
	     public void onTestStart(ITestResult result) {
	    	 
	    	 test = report.createTest(result.getMethod().getMethodName()); 
	    	 test.info("test started" + test); 
	    	 
	    	 
	         
	     }

	     
	     public void onTestSuccess(ITestResult result) {
	    	 
	    	 test.pass("Test Passed");
			 test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));
			 
//			 String screenshotpathinreport = BaseClass.captureScreenshot(result.getMethod().getMethodName()); 
//			 
//			 try {
//				test.addScreenCaptureFromPath(screenshotpathinreport);
//			} catch (Exception e) {
//				// TODO: handle exception
//			  e.printStackTrace();
//			}
	         
	     }

	     
	     public void onTestFailure(ITestResult result) {
	    	 
	    	 test.fail("test failed"); 
	    	 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "test case failed", ExtentColor.RED)); 
             
	    	 String screenshotpathinreport = BaseClass.captureScreenshot(result.getMethod().getMethodName()); 
	    	 
	    	 try {
				test.addScreenCaptureFromPath(screenshotpathinreport); 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	         
	     }

	     
	     public void onTestSkipped(ITestResult result) {
	         test.skip("test skipped"); 
	         test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "test case skipped", ExtentColor.YELLOW)); 
	     }

	     
	     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    	 test.skip("Test Failed but within success percentage");
	     }

	     
	     public void onTestFailedWithTimeout(ITestResult result) {
	         test.fail("test failed with timeout");
	         }

	    
	     public void onFinish(ITestContext context) {
	         // Optional: log when test context finishes
	    	 report.flush();
	     }
	     
	     
	
	

}
