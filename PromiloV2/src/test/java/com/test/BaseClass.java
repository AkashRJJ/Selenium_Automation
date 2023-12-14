package com.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static {
		WebDriverManager.chromedriver().setup();
	}
	public WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//"C:\Program Files\Google\Chrome\Application\chrome.exe" --profile-directory="Profile 10"
//		l.add("--disable-web-security"); l.add("--allow-running-insecure-content"); 		
		//List<String> l = new ArrayList<String>();
//		l.add("--profile-directory=Default");
//		l.add("--disable-extensions");		
//		options.addArguments("--user-data-dir= C:\\Program Files\\Google\\Chrome\\Application\\chrome\\Profile 10");
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1920,1080");
//	    options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://v2userwebstage.promilo.com");
		//driver.manage().window().setSize(new Dimension(1000, 800));
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
