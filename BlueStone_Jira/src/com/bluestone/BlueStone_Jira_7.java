	/*
	 open browser
	enter URL(blustone)
	click on goldmine 10+1 Sceheme
	enter monthly amount and email address and click on start now
	fill necessary details and click on next
	Fill necessary details in next page
	verify wheather it is navigating to payment page or not .
	 */
package com.bluestone;	

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.firefox.FirefoxOptions;
    import org.testng.Assert;


public class BlueStone_Jira_7 {
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
			driver.findElement(By.className("gms-banner-inner")).click();
			
			String eEmail="testeng123demo@gmail.com";
			String eAmount="5000";
			Thread.sleep(1000);
			driver.findElement(By.id("amount")).sendKeys(eAmount);
			driver.findElement(By.id("Email")).sendKeys(eEmail);
			
			driver.findElement(By.id("tahLpSubmit")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("fullname")).sendKeys("Shaba Parveen");
			driver.findElement(By.id("contactNumber")).sendKeys("1234567890");
			driver.findElement(By.id("address")).sendKeys("Garebhavi Palya, Bangalore");
			driver.findElement(By.id("postcode_delivery")).sendKeys("560068");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			driver.findElement(By.id("nomineeName")).sendKeys("Zainab");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			String aPage=driver.findElement(By.xpath("//nav[@id='checkout-navigation']/descendant::span[@class='checkout-current']")).getText();
			String ePage="PAYMENT DETAILS";
			
			Assert.assertEquals(aPage, ePage);
			System.out.println("payment page displayed");		
			driver.close();
		}

}
