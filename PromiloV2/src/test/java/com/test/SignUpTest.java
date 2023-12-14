package com.test;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.GoogleLoginPopup;
import com.pom.GuestHomePage;
import com.pom.SignUpPage;

public class SignUpTest extends BaseClass{
	
	@Test
	public void invalidReferralSignUp() throws InterruptedException {
		SignUpPage sp = new SignUpPage(driver);
		GuestHomePage ghp = new GuestHomePage(driver);
		ghp.clickSignUp();
		sp.enterEmailMobClick("9000012322");
		sp.enterOtp("9999");
		sp.enterPasswordReferralSubmit("akash1234", "abcd");
		boolean actual = sp.isErrorExist("Referral");
		Assert.assertTrue(actual);
	}
	
	@Test(enabled = false)
	public void googleLogin() throws InterruptedException {
		SignUpPage sp = new SignUpPage(driver);
		GuestHomePage ghp = new GuestHomePage(driver);
		ghp.clickSignUp();
		String parentWindow = driver.getWindowHandle();
		sp.clickGoogle();
		Set<String> windows = driver.getWindowHandles();
		for(String i : windows) {
			if(parentWindow != i) {
				driver.switchTo().window(i);
			}
		}
		GoogleLoginPopup gp = new GoogleLoginPopup(driver);
		gp.googleLogin("rjakash171996@gmail.com", "Akash@143");
		driver.switchTo().defaultContent();
	}
}
