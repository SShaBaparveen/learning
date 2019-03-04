/*
 Open browser
enter URL(bluestone)
scroll upto some axis 
check wheather top icon is dispalyed or not
if it displayed click on it
close browser
 */

package com.bluestone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BlueStone_Jira_3 {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FirefoxOptions option=new FirefoxOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		for (int i = 0; i < 10; i++) 
		{
			Thread.sleep(1000);
			exe.executeScript("window.scrollBy(500,500)","");
		}
		WebElement element=driver.findElement(By.className("logo-icon"));
		Thread.sleep(2000);
		if (element.isDisplayed()) {
			element.click();
			System.out.println("icon clicked");
		}
		else
			System.out.println("icon not present");
		driver.close();
	}

}