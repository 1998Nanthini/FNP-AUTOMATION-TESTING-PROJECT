package addtocart;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class AddToCart {
	WebDriver wd;
	@Test
	public void AddToCart() throws InterruptedException 
	{
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement em=wd.findElement(By.id("standard-basic"));
		em.sendKeys("nanthuroseheart@gmail.com");
		wd.findElement(By.xpath("//button[@id='']")).click();
		wd.findElement(By.id("standard-adornment-password")).sendKeys("Nanthu@1234");
		wd.findElement(By.xpath("//button[@id='']")).click();

		WebElement gift=wd.findElement(By.id("#birthdaymenu"));
		Actions act=new Actions(wd);
		act.moveToElement(gift).build().perform();
		wd.findElement(By.partialLinkText("All Birthday Gifts")).click();

		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,450)", "");
		
		WebElement img=wd.findElement(By.xpath("//body/div[@id='__next']/main[@id='main']/div[@id='plp-main-content']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/figure[1]/div[2]/img[1]"));
		img.click();
		String win1= wd.getWindowHandle();	// storing the parent/current window

		
		for(String win2 : wd.getWindowHandles())
		{
			wd.switchTo().window(win2);		// switch the control to the second window
		}
		// code for 2nd window

		//wd.switchTo().window(win1);
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.fnp.com/account/my-account");
	}

	@AfterTest
	public void afterTest() 
	{
		wd.close();
	}

}
