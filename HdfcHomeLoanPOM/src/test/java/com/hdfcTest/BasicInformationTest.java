package com.hdfcTest;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdfcMain.HdfcDrivers;
import com.hdfcPage.BasicInformationPage;
import com.hdfcUtility.ScrollUtility;

public class BasicInformationTest extends HdfcDrivers {
	
	BasicInformationPage basic_info;
	ScrollUtility scroll;
	Logger log;
	
	public BasicInformationTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void basicinfoSetup() throws IOException
	{
		initDrivers();
		basic_info = new BasicInformationPage();
		scroll = new ScrollUtility();
		
		log = LogManager.getLogger(BasicInformationTest.class);
		DOMConfigurator.configure("log4j2.xml");
	}
	
	@Test
	public void basicInfo() throws InterruptedException
	{
		scroll.scrollDown();
		basic_info.selectLoan("HOU");
		log.info("Selected Loan Type is : " +basic_info.loan);
		
		basic_info.shortProperty();
		log.info("Property is shorted");
		
		basic_info.propertyState("MAHARASHTRA");
		log.info("Selected property state is : "+basic_info.newState);
		
//		time.threadTimeOut();
		Thread.sleep(2000);
		
		basic_info.propertyCity("Nashik");
		log.info("Searched property city is : " +basic_info.newCity);
		
		basic_info.propCost("4500000");
		log.info("The entered property cost is : " +basic_info.propAmount);
		
		basic_info.applicantName("Shrikant agrawal");
		log.info("Applicant Name is : " +basic_info.name);
		
		scroll.scrollBottom();
		basic_info.basicSubmit();
		log.info("Clicked on Basic information continue button");
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//	}
}
