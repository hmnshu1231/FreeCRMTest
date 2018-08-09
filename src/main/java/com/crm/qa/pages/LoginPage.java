package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(linkText = "Forgot Password?")
	WebElement forgotPassLink;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement featuresLink;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;

	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingLink;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customersLink;

	@FindBy(xpath = " //a[contains(text(),'Contact')]")
	WebElement contactLink;

	@FindBy(xpath = "//*[@class='fa fa-users skrollable skrollable-after']")
	WebElement CRMtextLogo;

	@FindBy(xpath = "//*[@class='fa fa-money skrollable skrollable-after']")
	WebElement salesPipelineLogo;

	@FindBy(xpath = "//*[@class='fa fa-envelope skrollable skrollable-after']")
	WebElement marketingAutomation;

	@FindBy(xpath = "//*[@class='fa fa-mobile-phone skrollable skrollable-after']")
	WebElement getMobile;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateLinkTexts() {
		if (featuresLink.isDisplayed() && signUpLink.isDisplayed() && pricingLink.isDisplayed()
				&& customersLink.isDisplayed() && contactLink.isDisplayed()) {
			System.out.println("All Links are Present on LoginPage");
		}
		return true;

	}

	public boolean ValidateCRMlogos() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		if (CRMtextLogo.isDisplayed() && salesPipelineLogo.isDisplayed() && marketingAutomation.isDisplayed()
				&& getMobile.isDisplayed()) {
			System.out.println("All Links are Present on LoginPage");
		}
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
		return true;
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public boolean validateSignUpBtn() {
		return signUpBtn.isDisplayed();
	}

	public boolean validateForgotPassLink() {
		return forgotPassLink.isDisplayed();
	}

	public SignUpPage clickSignUpLink() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", signUpLink);

		return new SignUpPage();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// loginBtn.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}

}