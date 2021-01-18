package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regPageSetup() {
		regPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider(parallel = true)
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}

	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String email, String phone, String pwd,
			String subsribe) {
		regPage.accountRegistration(firstName, lastName, email, phone, pwd, subsribe);
	}

}
