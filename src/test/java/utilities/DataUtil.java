package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import baseSetUp.BaseTest;

public class DataUtil extends BaseTest {


	@DataProvider(name = "data", parallel = true)
	public Object[][] getData(Method m) {


		int rows = excel.getRowCount(config.getProperty("testDataSheet"));

		System.out.println("Total rows: "+rows);
		//String testName = "AddCustomerTest";
		String testName = m.getName();


		//To know the which row test case starts
		int testCaseRowNum=1;
		for(testCaseRowNum=1; testCaseRowNum<=rows;testCaseRowNum++) {
			String testCaseName = excel.getCellData(config.getProperty("testDataSheet"), 0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test case starts from row: "+testCaseRowNum);


		//To know no. of rows for a test case
		int dataStartRowNum = testCaseRowNum+2;
		int testRows = 0;
		while(!excel.getCellData(config.getProperty("testDataSheet"), 0, dataStartRowNum+testRows).equals("")) {
			testRows++;
		}
		System.out.println("no. of rows for the test case '"+testName+"': "+testRows);



		//To get no. of cols in a test case
		int colStartColNum = testCaseRowNum+1;
		int testCols=0;
		while(!excel.getCellData(config.getProperty("testDataSheet"), testCols, colStartColNum).equals("")) {
			testCols++;
		}
		System.out.println("no. of cols for the test case '"+testName+"': "+testCols);

		System.out.println();

		
		
		
		//printing data

		Object[][] data = new Object[testRows][1];
		int i=0;
		
		for(int rNum=dataStartRowNum; rNum<(dataStartRowNum+testRows); rNum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for(int cNum=0; cNum<testCols; cNum++) {
				
				//System.out.println(excel.getCellData(Constants.SHEET_NAME, cNum, rNum));
				//data[rNum-dataStartRowNum][cNum]=excel.getCellData(Constants.SHEET_NAME, cNum, rNum);

				String colName = excel.getCellData(config.getProperty("testDataSheet"), cNum, colStartColNum);
				String testData = excel.getCellData(config.getProperty("testDataSheet"), cNum, rNum);


				table.put(colName, testData);

			}
			//System.out.println();

			data[i][0]=table;
			i++;
		}


		return data;







		/*
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];

		//the excel is built such a way - cols starts with 0 and rows start with 1
		//data[0][0] = excel.getCellData(sheetName, cols, rows);


		for(int rowNum=2; rowNum<=rows; rowNum++) {
			for(int colNum=0; colNum<cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}


		return data;
		 */
	}

}
