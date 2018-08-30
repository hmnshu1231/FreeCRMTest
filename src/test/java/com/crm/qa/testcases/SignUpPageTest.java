package com.crm.qa.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;


public class SignUpPageTest extends TestBase {
	public static SignUpPage signUpPage;
	public static LoginPage loginPage;
	Select select;

	public SignUpPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
		loginPage.clickSignUpLink();
	}

	@Test(priority = 1)
	public void verifySignUpCrmLogoTest() {
		  Reporter.log("verifySignUpCrmLogoTest");
		Assert.assertTrue(signUpPage.verifyCrmLogo());
	}

	@Test(priority = 2)
	public void verifyEditionTextTest() {
		  Reporter.log("verifyEditionTextTest");
		Assert.assertTrue(signUpPage.selectEditionDdText());
	}

	@Test(priority = 3)
	public void validateSignUpPageTest() throws InterruptedException {
		  Reporter.log("validateSignUpPageTest");
		  signUpPage.selectEditionDd_Id("Free Edition");

	}

	@Test(priority = 4)
	public void signUpPageAllFieldsTest() throws InterruptedException {
		  Reporter.log("signUpPageAllFieldsTest");
		  signUpPage.signUpPageAllFields();
		Thread.sleep(5000);
	}

	@Test(priority = 5)
	public void verifySignUpFieldTextTest() {
		  Reporter.log("verifySignUpFieldTextTest");
		  Assert.assertTrue(signUpPage.verifyFieldText());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}