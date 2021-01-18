package com.qa.democart.pages;

import org.openqa.selenium.By;

public class ProfilePage {

	private By profile = By.id("profile");
	
	
	public ProfilePage() {
		System.out.println("PP -- default const...");
	}
	
	public void getTitle() {
		System.out.println("PP - title");
		System.out.println("click on profile...");
	}
	
	
	
	
}
