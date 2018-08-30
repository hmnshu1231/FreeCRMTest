package com.crm.report;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.crm.Utility.AppConfig;
import com.crm.Utility.appUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport 
{
	public static ExtentReports extent;
	public static ExtentTest test;
	public static SimpleDateFormat sdf;
	//Extent Reporting
		static
		{
			sdf = new SimpleDateFormat("dd-MM-YYYY-hh-mm-SS-SSS");
			try {
				extent = new ExtentReports(AppConfig.getReportPath()+sdf.format(new Date())+".html",false);
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
		}
	
	public void getResult(ITestResult result) throws IOException 
	{
		appUtility util = new appUtility();
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			String screen = util.getScreenShot("");
			test.log(LogStatus.PASS, test.addScreenCapture(screen));
			test.log(LogStatus.PASS, result.getName() + " Test Passed Successfully");}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " Test is skipped due to: " + result.getThrowable());}
		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " Test is failed" + result.getThrowable());
			String screen = util.getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));}
		else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " Test has Started");}
	}

}