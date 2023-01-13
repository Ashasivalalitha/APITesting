package practice;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateReport {

	public ExtentSparkReporter extentSparkReporter; // to config report path, layout, etc
	public ExtentReports extentReports; // to create and flush test case
	public ExtentTest extentTest; // to update test case status

	@BeforeTest
	public void reportSetup() {
		//ExtentSparkReporter config
		extentSparkReporter = new ExtentSparkReporter("./reports/extent.html");
		extentSparkReporter.config().setReportName("TEST Automation Test Results");
		extentSparkReporter.config().setDocumentTitle("TEST Automation Reports");
		extentSparkReporter.config().setEncoding("utf-8");
		extentSparkReporter.config().setTheme(Theme.STANDARD);

		//ExtentReports config
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Automation Tester", "Asha");
		extentReports.setSystemInfo("Organization", "Company");
		extentReports.setSystemInfo("Build no", "123");
	}


	@Test
	public void doTC1() {
		

	}

	@Test
	public void doTC2() {
		
		Assert.fail("Login failed");

	}

	@Test
	public void doTC3() {
		
		throw new SkipException("Validate button skipped");
	}



	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {

		if(result.getStatus()==ITestResult.SUCCESS) {
			//Markup final status	
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - PASSED!"+"</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.pass(m);
		}
		
		
		
		else if(result.getStatus()==ITestResult.FAILURE) {

			//exception details
			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+  "Exception Occured: Click to see "   +"</font>"+"</b>"+"</summary>"   + 
					exceptionMessage.replaceAll(",", "<br>")  +
					"</details>"+" \n");

			//screenshot
			/*	try {
			ExtentManager.captureScreenshot();
			extentTest.fail("<b>"+"<font color"+"red>"+    "Screenshot of failure"     + "</font>"+"/b"),
							MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());

			}catch(IOException e) {

			}
			 */	

			//Markup final status
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - FAILED!"+"</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.log(Status.FAIL, m);

		}
		else if(result.getStatus()==ITestResult.SKIP) {
			//Markup final status
			String methodName = result.getMethod().getMethodName();
			String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - SKIPPED!"+"</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREY);
			extentTest.skip(m);
		}

	}


	@AfterTest
	public void endReport() {
		extentReports.flush();

	}

}
