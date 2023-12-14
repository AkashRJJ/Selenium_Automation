package com.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.GenericMethods;
import com.pom.GuestHomePage;


public class ImageTest extends BaseClass{
	
	@Test(enabled = false)
	public void signUpPageLogo() throws IOException {
		GuestHomePage gp = new GuestHomePage(driver);
		String actUrl = gp.getLogoUrl();
		String expectedUrl = "./Utils/ExpectedLogo.png";
		boolean result = GenericMethods.imageComparison(actUrl, expectedUrl);
		Assert.assertTrue(result);
	}
	
	@Test
	public void signUpPageWrongLogo() throws IOException {
		GuestHomePage gp = new GuestHomePage(driver);
		String actUrl = "./Utils/ExpectedLogo1.png";
		String expectedUrl = "./Utils/ExpectedLogo.png";
		boolean result = GenericMethods.imageComparison(actUrl, actUrl);
		Assert.assertTrue(result);
	}

}
