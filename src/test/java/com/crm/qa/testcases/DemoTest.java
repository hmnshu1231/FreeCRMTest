package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class DemoTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	ContactsPage contactsPage;

	public DemoTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
	}

	@Test
	public void getElementText() {
		System.out.println(loginPage.validatCRM_Description());
		String expectedDescription = "Keep  single shared customer profile, company-wide. Know you're looking at the same "
				+ "up-to-date contact as service and marketing. Gain insight through a shared database system -- that's CRM.";

		Assert.assertEquals(loginPage.validatCRM_Description(), expectedDescription, "CRM description not matched");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}