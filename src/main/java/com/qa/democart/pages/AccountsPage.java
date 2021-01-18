package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constants;
import com.qa.democart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage {

	private ElementUtil elementUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input");
	private By searchButton = By.cssSelector("div#search button");
	private By searchItemsResult = By.cssSelector("div.product-layout .product-thumb");

	public AccountsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}

	@Step("getting Account Page Title")
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.ACCOUNTS_PAGE_TITLE, 5);
	}

	@Step("getting Account Page header value")
	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	@Step("getting Account Page sections count")
	public int getAccountSectionsCount() {
		return elementUtil.getElements(accountSectionHeaders).size();
	}

	@Step("getting Account Page sections list for the user...")
	public List<String> getAccountSectionsList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accSectionList = elementUtil.getElements(accountSectionHeaders);
		for (WebElement e : accSectionList) {
			String secText = e.getText();
			accountList.add(secText);
		}
		return accountList;
	}

	@Step("search the product with : {0}")
	public boolean doSearch(String productName) {
		System.out.println("searching for : " + productName);
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if (elementUtil.getElements(searchItemsResult).size() > 0) {
			return true;
		}
		return false;
	}

}
