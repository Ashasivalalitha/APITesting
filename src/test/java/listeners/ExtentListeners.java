package listeners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener{

	static Date d = new Date();
	static String reportName = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	private static ExtentReports extentReports = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+reportName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();



	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extentReports.createTest(result.getTestClass().getName()+"    @TestCase: "+result.getMethod().getMethodName());
		testReport.set(extentTest);
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		//Markup final status	
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - PASSED!"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	}


	@Override
	public void onTestFailure(ITestResult result) {
		//exception details-1
		testReport.get().fail("Failed due to : "+result.getThrowable().getMessage().toString());
		
		//exception details-2
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>"+"<summary>"+"<b>"+"<font color="+"red>"+  "Exception Occured: Click to see "   +"</font>"+"</b>"+"</summary>"   + 
				exceptionMessage.replaceAll(",", "<br>")  +
				"</details>"+" \n");

		//screenshot
		/*	try {
		ExtentManager.captureScreenshot();
		testReport.get().fail("<b>"+"<font color"+"red>"+    "Screenshot of failure"     + "</font>"+"/b"),
						MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());

		}catch(IOException e) {

		}
		 */	

		//Markup final status
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - FAILED!"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//Markup final status
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>"+"TEST CASE: "+methodName.toUpperCase()+" - SKIPPED!"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREY);
		testReport.get().skip(m);
	}




	@Override
	public void onFinish(ITestContext context) {
		if(extentReports!=null) {
			extentReports.flush();
		}
	}


}
