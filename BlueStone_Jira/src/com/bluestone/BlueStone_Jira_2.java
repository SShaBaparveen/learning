package com.bluestone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BlueStone_Jira_2 {
	static
	{
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']")).click();
		driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']")).sendKeys("Rings");
		driver.findElement(By.xpath("//input[@class='button']")).click();
//		driver.findElement(By.xpath("//div[@class='top-filter-blocks']/section[@id='Gender-form']")).click();
		Thread.sleep(3000);
		String xp = "//span[@data-displayname='women']/span[@class='items-count']";
		String text = driver.findElement(By.xpath(xp)).getText();
		System.out.println(text);
		driver.close();
	}

}
