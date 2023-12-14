package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLoginPopup {
	
	@FindBy(id = "identifierId")
	private WebElement userId;
	
	@FindBy(name = "Passwd")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement signUpBtn;
	
	@FindBy(id = "confirm_yes")
	private WebElement confirm;

	public GoogleLoginPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void googleLogin(String userId, String password) {
		this.userId.sendKeys(userId);
		signUpBtn.click();
		this.password.sendKeys(password);
		signUpBtn.click();
		if(confirm.isDisplayed()) {
			confirm.click();
		}
	}
}