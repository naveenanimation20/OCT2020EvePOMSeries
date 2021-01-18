package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// page locators : BY locators : OR
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgotPwdLinks = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// page constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// page actions:
	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.LOGIN_PAGE_TITLE, 5);
	}

	@Step("forgot pwd link is displyed on login page....")
	public boolean isForgotPwdLinkExist() {
		if (elementUtil.getElements(forgotPwdLinks).size() == Constants.FORGOTTEN_PWD_LINK_COUNT)
			return true;
		return false;
	}

	@Step("Login with username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with username : " + un + " and password : " + pwd);
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);

		return new AccountsPage(driver);
	}

	@Step("navigating to reg page")
	public RegisterPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
