/*
 
 open browser
enter URL(blustone)
click on goldmine 10+1 Sceheme
with out entering monthly amount and email address and click on start now
verify wheather error msg is diaplaying or not .
Close browser.

 */

package com.bluestone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class BlueStone_Jira_4 {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new FirefoxDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("gms-banner-inner")).click();
		driver.findElement(By.id("tahLpSubmit")).click();
		WebElement error=driver.findElement(By.xpath("//form[@id='goldmineForm']/descendant::div[contains(@class,'col-xs-4 fl-wrap error')]"));
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
