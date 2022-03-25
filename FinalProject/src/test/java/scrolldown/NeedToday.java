package scrolldown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NeedToday {
  WebDriver wd;
  @Test
  public void needtoday() {
	   wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*WebElement em=wd.findElement(By.id("standard-basic"));
		em.sendKeys("nanthuroseheart@gmail.com");
		wd.findElement(By.xpath("//button[@id='']")).click();
		wd.findElement(By.id("standard-adornment-password")).sendKeys("Nanthu@1234");
		wd.findElement(By.xpath("//button[@id='']")).click();*/
        
	    wd.findElement(By.xpath("//span[contains(text(),'Need Today?')]")).click();
	    JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1200)", "");
		

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.fnp.com");
  }

  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
