package baseSetUp;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class BaseTest {
	
	public static Properties config;
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
	
	
	@BeforeSuite
	public void setUp() throws Exception {
		
		config = new Properties();
		fis = new FileInputStream(".\\src\\test\\resources\\ObjectRepo\\config.properties");
		config.load(fis);
		
		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath = config.getProperty("basePath");
		
	}
	
	
	@AfterSuite
	public void tearDown() throws Exception {
		
	}


}
