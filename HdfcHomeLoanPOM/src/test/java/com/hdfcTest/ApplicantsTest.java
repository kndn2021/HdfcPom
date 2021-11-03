package com.hdfcTest;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdfcMain.HdfcDrivers;
import com.hdfcPage.ApplicantsPage;
import com.hdfcUtility.ScrollUtility;

public class ApplicantsTest extends HdfcDrivers {

	BasicInformationTest basic_test;
	ApplicantsPage app_page;
	ScrollUtility scroll;
	Logger log;
	
	public ApplicantsTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void applicantsSetup() throws IOException, InterruptedException
	{
		basic_test = new BasicInformationTest();
		basic_test.basicinfoSetup();
		basic_test.basicInfo();
		app_page = new ApplicantsPage();
		scroll = new ScrollUtility();
		log = LogManager.getLogger(ApplicantsTest.class);
		DOMConfigurator.configure("log4j2.xml");
	}
	
	@Test
	public void appTest() throws InterruptedException
	{
		app_page.residingState("MAHARASHTRA");
		log.info("Selected residing state is : " +app_page.r_state);
		
		Thread.sleep(2000);
		
		app_page.residingCity("MUMBAI");
		log.info("Searched residing city is : " +app_page.r_city);
		
//		app_page.radioGender("Male");
		app_page.applicantAge("35");
		log.info("Entered age of applicant is : " +app_page.ap_age);
		
		app_page.selectOccupation("EMPLOYED");
		log.info("Occupation of employee is : " +app_page.occ);
		
		app_page.applicantIncome("55000");
		log.info("Income of applicant is : " +app_page.inc);
		
		app_page.retirementAge("60");
		log.info("Retirement age of applicant is : " +app_page.rt_age);
		
		app_page.monthlyEmi("26");
		log.info("Monthly EMI's of applicant is : " +app_page.m_emi);
		
		app_page.applicantEmail("kndn@gmail.com");
		log.info("Applicant Email ID is : " +app_page.aEmail);
		
		app_page.applicantMobile("7219577480");
		log.info("Mobile number of applicant is : " +app_page.mob);
		
		scroll.scrollBottom();
		app_page.checkAgree();
		log.info("Agree box checked successfully");
		
		app_page.applicantSubmit();
		log.info("Clicked on Applicants continue button");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
