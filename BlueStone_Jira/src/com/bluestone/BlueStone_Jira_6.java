
package com.bluestone;
/*
open browser
enter URL(blustone)
click on goldmine 10+1 Sceheme
enter monthly amount and email address and click on start now
with out filling any information click on next
verify wheather error msg is diaplaying or not in all fields
close browser

*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class BlueStone_Jira_6 {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException, InterruptedException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("gms-banner-inner")).click();
		
		String eEmail="testeng123demo@gmail.com";
		String eAmount="5000";
		Thread.sleep(1000);
		driver.findElement(By.id("amount")).sendKeys(eAmount);
		driver.findElement(By.id("Email")).sendKeys(eEmail);
		
		driver.findElement(By.id("tahLpSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement error=driver.findElement(By.id("fullname_error"));
		if (error.isDisplayed()) {
			System.out.println("error message displayed");
			Thread.sleep(2000);
		} else {
			System.out.println("error message not displayed");
			Assert.fail();
		}
		
		driver.close();
	}
}

