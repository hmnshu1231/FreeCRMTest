package com.crm.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class appUtility {
	public static FileInputStream fis;
	public static SimpleDateFormat sdf;
	public static WebDriver driver;

	// taking screenshots
	public String getScreenShot(String imageName) throws IOException {
		if (imageName.equals("")) {
			imageName = "SS";
		}
		String imagelocation = AppConfig.getScreenShotPath();
		sdf = new SimpleDateFormat("dd-MM-YYYY-hh-mm-SS-SSS");
//			String actualImageName = imagelocation+imageName+""+sdf.format(new Date())+".mp4"; //for video file
		String actualImageName = imagelocation + imageName + "" + sdf.format(new Date()) + ".png";

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(actualImageName);
		FileUtils.copyFile(sourceFile, destFile);
		return actualImageName;
	}
}