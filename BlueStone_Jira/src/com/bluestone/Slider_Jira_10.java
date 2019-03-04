package com.bluestone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class Slider_Jira_10 {
		static
		{
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		}
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications");
			FirefoxDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/slider/");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement frme = driver.findElement(By.xpath("//div[@id='content']/iframe"));
			driver.switchTo().frame(frme);
			
			WebElement slide = driver.findElement(By.xpath("//div[@id='slider']/span"));
			Actions act = new Actions(driver);
			for(int i=0;i<101;i+=10)
			{
				act.clickAndHold(slide).moveByOffset(i, 0).perform();
			}
			for(int i=100;i>0;i-=10)
			{
				act.clickAndHold(slide).moveByOffset(-i, 0).perform();
			}
			driver.close();

		}
}
