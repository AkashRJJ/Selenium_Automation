package com.pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	@FindBy(id = "signup-email")
	private WebElement userIdTextBox;
	
	@FindBy(xpath = "//div[@id = 'container']/div")
	private WebElement googleLogin;
	
	@FindBy(xpath = "//img[@alt = 'Linkedin']")
	private WebElement linkedInLogin;
	
	@FindBy(xpath = "(//img[@alt = 'Facebook'])[1]")
	private WebElement fbLogin;
	
	@FindBy(xpath = "//button[text() = 'Send Verification Code']")
	private WebElement sendVerification;
	
	@FindBy(xpath = "//input[@placeholder = \"Enter OTP\"]")
	private WebElement otpTextBox;
	
	@FindBy(xpath = "//button[text() = 'Resend OTP']")
	private WebElement resendOtpBtn;
	
	@FindBy(id = "signup")
	private WebElement createPwdTextBox;
	
	@FindBy(id = "referral-code")
	private WebElement referralCodeTextBox;
	
	@FindBy(xpath = "//button[text() = \"Sign Up\"]")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//div[text()='Invalid Referral Code.']")
	private WebElement referralError;
	
	@FindBy(xpath = "//iframe[@title = 'Sign in with Google Button']")
	private WebElement googleIframe;
	
	public WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void enterEmailMobClick(String userId) {
		userIdTextBox.sendKeys(userId);
		sendVerification.click();
	}
	
	public void enterOtp(String otp) {
		otpTextBox.sendKeys(otp);
	}
	
	public void enterPasswordSubmit(String password) {
		createPwdTextBox.sendKeys(password);
		signUpBtn.click();
	}
	public void enterPasswordReferralSubmit(String password,String referral) throws InterruptedException {
		
		String s = "";
		for(int i=0;i<password.length();i++) {
		s=s+password.charAt(i);
		createPwdTextBox.sendKeys(password);
		}
		referralCodeTextBox.sendKeys(s);
		signUpBtn.sendKeys(Keys.ENTER);
	}
	
	public boolean isErrorExist(String errorType) {
		if(errorType.equals(errorType)) {
			return referralError.isDisplayed();
		}
		else {
			return false;
		}		
	}
	public void clickGoogle() throws InterruptedException {
		driver.switchTo().frame(googleIframe);
		googleLogin.click();
		Thread.sleep(5000);
	}
}
