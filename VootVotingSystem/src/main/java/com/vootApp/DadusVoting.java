package com.vootApp;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DadusVoting {

	WebDriver driver;
	int i;
	@BeforeMethod
	public void setUp() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://voting.voot.com/vote/24a2c080-1793-11ec-b64d-d532943944f9?&uid=eVds5Z1uzjHvf9pUszxHtp21yt2R&device=web&belowPlayer=false&platform=web");

	}

	@Test
	public void voteDadus() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@class='kep-login-facebook medium']")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		ArrayList<String> list = new ArrayList<String>(child);
		
		driver.switchTo().window(list.get(1));

		driver.findElement(By.id("email")).sendKeys("9004844605");
		
		driver.findElement(By.id("pass")).sendKeys("rtyfgh");
		
		driver.findElement(By.name("login")).click();
		driver.switchTo().window(parent);
		Thread.sleep(3000);
		
		String sy = driver.getTitle();
		System.out.println(sy);
		
		do
		{
			i=1;
			WebElement dadus = driver.findElement(By.xpath("//img[@src='https://voot-interactivity.s3-ap-south-1.amazonaws.com/voting/contestant/image/Colors Marathi/Santosh (Dadus) Chaudhary Copy@1x.png']"));
			dadus.click();
			
			driver.findElement(By.xpath("//button[@class='jss190']")).click();
		//	Thread.sleep(2000);
			WebElement back = driver.findElement(By.xpath("//button[text()='Back']"));
			back.click();
			
			i++;
		}
		while(i<=100);
//		List<WebElement> cont = driver.findElements(By.xpath("//div[@class='jss220 jss242']"));
//		for(int i=0; i<cont.size();i++)
//		{
//			String ele = cont.get(i).getAttribute("innerHTML");
//			System.out.println(ele);
//		}
		
	}
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}

}
