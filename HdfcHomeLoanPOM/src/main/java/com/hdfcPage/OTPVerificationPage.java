package com.hdfcPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hdfcMain.HdfcDrivers;

public class OTPVerificationPage extends HdfcDrivers {

	@FindBy(how = How.ID, using = "otp")
	WebElement verify_otp;
	
//	@FindBy(how = How.ID, using = "resend-otp-button")
	@FindBy(xpath = "//a[text()='Resend OTP']")
	WebElement resend_otp;
	
	@FindBy(xpath = "//button[@id='back-verify-button']//following-sibling::button[@type='submit']")
	WebElement verify_otp_button;
	
	public OTPVerificationPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void resendOTP()
	{
		resend_otp.click();
	}
	
	public void enterOTP(String otp)
	{
		verify_otp.sendKeys(otp);
	}
	
	public void verifyButton()
	{
		verify_otp_button.click();
	}
}
