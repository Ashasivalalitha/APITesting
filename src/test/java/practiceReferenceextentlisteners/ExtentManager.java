package practiceReferenceextentlisteners;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {



	private static ExtentReports extentReports;
	public static String screenshotPath;
	public static String screenshotName;



	public static ExtentReports createInstance(String reportPath) {
		//ExtentSparkReporter config
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath); // to config report path, layout, etc
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

		return extentReports;
	}

	

/*
	public static void captureScreenshot() {

		File srcFile = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		try {
			FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\reports\\"+screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

*/

}
