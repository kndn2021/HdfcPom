package com.hdfcTest;

import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hdfcMain.HdfcDrivers;
import com.hdfcPage.OTPVerificationPage;
import com.hdfcUtility.ScrollUtility;

public class OTPVerificationTest extends HdfcDrivers {
	
	ApplicantsTest app_test;
	OTPVerificationPage otp_verify;
	Scanner scanner;
	ScrollUtility scroll;
	Logger log;
	
	public OTPVerificationTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void otpSetup() throws IOException, InterruptedException
	{
		app_test = new ApplicantsTest();
		app_test.applicantsSetup();
		
		log = LogManager.getLogger(OTPVerificationTest.class);
		DOMConfigurator.configure("log4j2.xml");
		
		log.info(prop.getProperty("Browser_Type") +" browser is found and initiated successfully..");
		
		app_test.appTest();
		scroll = new ScrollUtility();
		
		otp_verify = new OTPVerificationPage();
		scanner = new Scanner(System.in);
	}
	
	@Test
	public void otpTest() throws InterruptedException
	{
		scroll.scrollUp();
		scroll.scrollDown();
		
		otp_verify.resendOTP();
		
		log.info("Clicked on Resend OTP button");
		
		System.out.println("Please enter the OTP that you received on mobile number..");
		String newOtp = scanner.next();
		
		log.warn("Please do check the entered OTP carefully");
		
		Thread.sleep(2000);
		otp_verify.enterOTP(newOtp);
		
		log.info("OTP entered successfully");
		
		otp_verify.verifyButton();
		
		log.info("Clicked on Verify Button");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
		log.info("Chrome browser is closed");
	}
	
}
