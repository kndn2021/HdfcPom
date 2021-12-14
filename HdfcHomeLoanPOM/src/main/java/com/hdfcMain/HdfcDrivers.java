package com.hdfcMain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class HdfcDrivers {

	public static WebDriver driver;
	public Properties prop;
	public FileInputStream file_input;
	
	public HdfcDrivers() throws IOException
	{
//		prop = new Properties();
//		file_input = new FileInputStream("C:\\Users\\Bhushan\\eclipse-workspace\\HdfcHomeLoanPOM\\src\\main\\resources\\HdfcConfig.properties");
//		prop.load(file_input);
	}
	
	public void initDrivers()
	{	
	//	String browser = prop.getProperty("Browser_Type");
	//	if(browser.equalsIgnoreCase("Chrome"))
//		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
	//	}
//		else
//		{
//			System.out.println("=========No browser found==========");
//			driver.quit();
//		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//	driver.get(prop.getProperty("App_Url"));
		driver.get("https://portal.hdfc.com/campaign/new?utm_agency=Metier&utm_source=Google&utm_medium=Text-Ad&loantype=NEW&gclid=EAIaIQobChMIkbGXx6jo8wIVBjUrCh0K8QJuEAAYASAAEgJIxPD_BwE");
	}
	
}
