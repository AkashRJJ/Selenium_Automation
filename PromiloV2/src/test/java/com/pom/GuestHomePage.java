package com.pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;

public class GuestHomePage {
	
	@FindBy(xpath = "//div[@id = 'navbarScroll']//a[text()='SignUp']")
	private WebElement signUpBtn;
	@FindBy(xpath = "//a[text()='LogIn']")
	private WebElement loginBtn;
	@FindBy(xpath = "//img[@class = 'logo']")
	private WebElement logo;
	
	public WebDriver driver ;
	
	public GuestHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void clickSignUp() {
		signUpBtn.click();
	}
	public String getLogoUrl() throws IOException {
		File srcFile = ((TakesScreenshot) logo).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Utils/actualLogo.png"));
		return "./Utils/actualLogo.png";
	}
	
	

}
