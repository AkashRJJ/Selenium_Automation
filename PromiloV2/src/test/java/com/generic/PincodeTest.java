package com.generic;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PincodeTest {
	
	public static void main(String [] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://v2advertiserwebstage.promilo.com/register");
		WebElement state = driver.findElement(By.xpath("//input[@placeholder = 'State *']"));
		WebElement pincodeBox = driver.findElement(By.xpath("//input[@placeholder = 'Pincode*']"));
		FileInputStream fis = new FileInputStream("./utils/Pincodes.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		//int firstRow = sheet.getFirstRowNum();
		try {
		for(int i=1;i<=lastRow;i++) {
			 double x = sheet.getRow(i).getCell(1).getNumericCellValue();
			 int y = (int) x;
			 pincodeBox.sendKeys(""+y);
			 Thread.sleep(1000);
			 String actState = state.getAttribute("value");
			 sheet.getRow(i).createCell(2).setCellValue(actState);
			 pincodeBox.clear();
		}
		}
		finally {
		FileOutputStream fos = new FileOutputStream("./utils/Pincodes.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
		}
		
	}

}
