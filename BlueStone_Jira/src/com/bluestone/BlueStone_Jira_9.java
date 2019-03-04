/*
 * open browser
enter url(bluestone)
search for rings
click on any product
verify original price discount price and actual price
 */


package com.bluestone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BlueStone_Jira_9 {
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
		driver.findElement(By.id("search_query_top_elastic_search")).click();
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("Rings");
		driver.findElement(By.xpath("//form[@id='searchbox_elastic_search']/descendant::input[@name='submit_search']")).submit();
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::div[@class='inner pd-gray-bg']" + "/descendant::span[@class='b-price-wrapper']/descendant::span[@class='new-price' and @id='bst-discounted-price']"));
		
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::div[@class='inner pd-gray-bg']/descendant::span[@class='b-price-wrapper']" + "/descendant::span[@class='new-price' and @id='bst-discounted-price']/following-sibling::span[@id='bst-actual-price']"));
		
		System.out.println(list.get(0).getText().replace("RS.", "").replace(",", "").trim());
		System.out.println(list2.get(0).getText().replace("RS.", "").replace(",", "").trim());
		int OriginalPrice=Integer.parseInt(list.get(0).getText().replace("RS.", "").replace(",", "").trim());
		System.out.println("actual price : "+OriginalPrice);
		int discountedPrice=Integer.parseInt(list2.get(0).getText().replace("RS.", "").replace(",", "").trim());
		System.out.println("Discounted price"+discountedPrice);
		
		System.out.println("saved amount: "+(discountedPrice-OriginalPrice));
	
		driver.close();
	}

}
