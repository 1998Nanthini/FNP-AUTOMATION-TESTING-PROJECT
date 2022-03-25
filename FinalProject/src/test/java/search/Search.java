package search;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Search {
	WebDriver wd;	
	@Test
	public void search() 
	{
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*WebElement em=wd.findElement(By.id("standard-basic"));
		em.sendKeys("naren2466@gmail.com");
		wd.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();

		WebElement nm=wd.findElement(By.id("standard-basic-name"));
		nm.sendKeys("naren");
		WebElement mno=wd.findElement(By.id("standard-basic-mobile"));
		mno.sendKeys("7355245454");
		WebElement pw=wd.findElement(By.id("standard-adornment-password"));
		pw.sendKeys("kdfdr2557");*/

		/*wd.findElement(By.xpath("//body/div[@id='__next']/main[@id='main']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/button[1]/span[1]")).click();*/
		WebElement srch=wd.findElement(By.id("header-search-input"));
		srch.sendKeys("flowers");
		WebElement button=wd.findElement(By.xpath("//i[contains(text(),'search')]"));
		button.click();
		//wd.navigate().back();


	}
	@BeforeTest
	public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.fnp.com/");
	}

	@AfterTest
	public void afterTest() 
	{
		wd.close();
	}

}
