package account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Register 
{
	WebDriver wd;
	@Test
	public void login() throws IOException, InterruptedException 
	{
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		File in=new File("Data/SignUp.xlsx");

		FileInputStream fis=new FileInputStream(in);
		XSSFWorkbook wk=new XSSFWorkbook (fis);

		XSSFSheet sh=wk.getSheet("Sheet2");

		int size=sh.getLastRowNum();
		for(int i=1; i<=size; i++)
		{
			WebElement em=wd.findElement(By.id("standard-basic"));
			String e=sh.getRow(i).getCell(0).toString();
			em.sendKeys(e);	
			WebElement con=wd.findElement(By.xpath("//span[contains(text(),'Continue')]"));
			con.click();
			
			
			Thread.sleep(3000);
			WebElement st=wd.findElement(By.id("demo-simple-select-salutation"));
			st.click();
			wd.findElement(By.xpath("//body/div[@id='menu-']/div[3]/ul[1]/li[3]")).click();		  
			WebElement nm=wd.findElement(By.id("standard-basic-name"));
			WebElement mno=wd.findElement(By.id("standard-basic-mobile"));
			WebElement pw=wd.findElement(By.id("standard-adornment-password"));
			

			String n=sh.getRow(i).getCell(1).toString();
			String m=sh.getRow(i).getCell(2).toString();
			String p=sh.getRow(i).getCell(3).toString();

			nm.sendKeys(n);
			pw.sendKeys(p);
			mno.sendKeys(m);
			wd.findElement(By.xpath("//body/div[@id='__next']/main[@id='main']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/button[1]/span[1]")).click();
			try
			{
				WebElement lgt=wd.findElement(By.xpath("//i[contains(text(),'account_circle')]"));
				Actions actions = new Actions(wd);
				actions.moveToElement(lgt).perform();
				WebElement lgtclick = wd.findElement(By.xpath(""));
				// Capture x and y offset positions of element
				int xOffset = lgtclick.getRect().getX();
				int yOffset = lgtclick.getRect().getY();
				Actions actionProvider = new Actions(wd);
				// Performs mouse move action onto the offset position
				actionProvider.moveByOffset(xOffset, yOffset).build().perform();
			}
			catch(Exception a)
			{
				System.out.println("invalidinput");
			}
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
