package com.test;

import org.testng.annotations.Test;

import com.pom.GuestHomePage;

public class Example1 extends BaseClass{
	
	@Test
	public void login() {
		GuestHomePage hp = new GuestHomePage(driver);
		hp.clickLogin();
	}

}
