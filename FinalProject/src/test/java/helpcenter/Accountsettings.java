package helpcenter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Accountsettings {
  WebDriver wd;	
  @Test
  public void f() throws InterruptedException {
	    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//i[contains(text(),'help')]")).click();
		wd.findElement(By.xpath("//h3[contains(text(),'Account Settings')]")).click();
		Thread.sleep(3000);
		
		WebElement em=wd.findElement(By.id("standard-basic"));
		em.sendKeys("nanthuroseheart@gmail.com");
		wd.findElement(By.xpath("//button[@id='']")).click();
		wd.findElement(By.id("standard-adornment-password")).sendKeys("Nanthu@1234");
		wd.findElement(By.xpath("//button[@id='']")).click();
		Thread.sleep(3000);

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.fnp.com/");
		
  }

  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
