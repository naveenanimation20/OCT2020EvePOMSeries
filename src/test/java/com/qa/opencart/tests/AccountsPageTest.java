package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ExcelUtil;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC 300: Desgin full Accounts page for open cart application....")
@Story("US 301: Accounts page feature story")
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Description("acc page title test...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("acc page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Description("acc page header test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifyAccPageHeaderTest() {
		String accHeader = accountPage.getHeaderValue();
		System.out.println("Acc page header : " + accHeader);
		Assert.assertEquals(accHeader, Constants.ACCOUNTS_PAGE_HEADER);
	}

	@Description("acc page sections count test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyAccSectionsCountTest() {
		Assert.assertTrue(accountPage.getAccountSectionsCount() == Constants.ACCOUNT_SECTIONS_COUNT);
	}

	@Description("acc page sections list test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyAccountsSectionsListTest() {
		List<String> accSecList = accountPage.getAccountSectionsList();
		Assert.assertEquals(accSecList, Constants.getExpectedAccountsSectionslist());
	}

//	@DataProvider
//	public Object[][] productTestData() {
//		return new Object[][] { 
//								{ "iMac" }, 
//								{ "Macbook"},
//								{"iPhone"}
//								};
//    }

	@DataProvider
	public Object[][] getProductSearchData() {
		Object data[][] = ExcelUtil.getTestData(Constants.SEARCH_SHEET_NAME);
		return data;
	}

	@Description("product search test...")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5, dataProvider = "getProductSearchData")
	public void searchTest(String productName) {
		Assert.assertTrue(accountPage.doSearch(productName));
	}

}
