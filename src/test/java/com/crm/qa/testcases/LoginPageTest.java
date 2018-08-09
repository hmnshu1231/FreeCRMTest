package com.crm.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3, expectedExceptions = NoSuchElementException.class)
	public void signUpBtnTest() {

		loginPage.validateSignUpBtn();
		// Assert.assertTrue(status);
		// Assert.assertFalse(status);
		// try {
		// loginPage.validateSignUpBtn();
		// } catch (NoSuchElementException e) {
		// return false;
		// }
		// return true;
	}

	@Test(priority = 4)
	public void forgotPassLinkTest() {
		Assert.assertTrue(loginPage.validateForgotPassLink());
	}

	@Test(priority = 5)
	public void allLinkTexts() {
		Assert.assertTrue(loginPage.validateLinkTexts());
	}

	// retryAnalyzer=Retry.class
	@Test(priority = 6)
	public void CRMlogosTest() {
		Assert.assertTrue(loginPage.ValidateCRMlogos());
	}

	@Test(priority = 7)
	public void loginTest() {

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}