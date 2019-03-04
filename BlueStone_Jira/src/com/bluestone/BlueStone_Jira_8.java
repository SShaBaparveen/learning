	/*
	 * open browser
	enter url(bluestone)
	click on visit our stores
	check the count of locations
	close browser

	*/
package com.bluestone;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

	public class BlueStone_Jira_8 {
		static
		{
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		}
		public static void main(String[] args) throws Exception
		{
			FirefoxOptions option=new FirefoxOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new FirefoxDriver(option);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.bluestone.com/");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//ul[@class='pull-right list-inline']/li[@class='visit-our-stores']")).click();
			System.out.println("total no. of locations are : "+driver.findElements(By.className("map-wrap")).size());
			
			driver.close();
		}

}
