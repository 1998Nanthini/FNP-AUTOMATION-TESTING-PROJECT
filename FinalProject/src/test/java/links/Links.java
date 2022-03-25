package links;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Links {
	WebDriver wd;
	@Test
	public void Links() throws InterruptedException 
	{
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement em=wd.findElement(By.id("standard-basic"));
		em.sendKeys("nanthuroseheart@gmail.com");
		wd.findElement(By.xpath("//button[@id='']")).click();
		wd.findElement(By.id("standard-adornment-password")).sendKeys("Nanthu@1234");
		wd.findElement(By.xpath("//button[@id='']")).click();
		Thread.sleep(3000);
		List<WebElement> Links= wd.findElements(By.tagName("a"));
		int size=Links.size();
		System.out.println("no.of links are :" +size);
		for (int i=0; i<size; i++)
		{
			System.out.println(Links.get(i).getText());
		}

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
