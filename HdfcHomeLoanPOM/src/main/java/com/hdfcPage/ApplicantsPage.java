package com.hdfcPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hdfcMain.HdfcDrivers;
import com.hdfcUtility.DropdownUtility;

public class ApplicantsPage extends HdfcDrivers {

	@FindBy(how = How.ID, using = "applicant_state")
	WebElement residing_state;
	
	@FindBy(id = "applicant_city_name")
	WebElement residing_city;
	
	@FindBy(id = "applicant_gender_1")
	WebElement gender_male;
	
	@FindBy(id = "applicant_gender_2")
	WebElement gender_female;
	
	@FindBy(id = "applicant_age")
	WebElement applicant_age;
	
	@FindBy(id = "applicant_occupation")
	WebElement occupation;
	
	@FindBy(id = "applicant_monthly_income")
	WebElement applicant_income;
	
	@FindBy(id = "applicant_retiring_age")
	WebElement retirement_age;
	
	@FindBy(id = "applicant_other_emi")
	WebElement monthly_emi;
	
	@FindBy(id = "applicant_email")
	WebElement applicant_email;
	
	@FindBy(id = "applicant_mobile_no")
	WebElement applicant_mobile;
	
	@FindBy(name = "agree") 
	WebElement agree;
	
	@FindBy(id = "continue-button")
	WebElement applicant_continue;
	
	public String r_state;
	public String r_city;
	public String ap_age;
	public String occ;
	public String inc;
	public String rt_age;
	public String m_emi;
	public String aEmail;
	public String mob;
	
	DropdownUtility dropdown = new DropdownUtility();
	
	public ApplicantsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void residingState(String res_state)
	{
		dropdown.selectByText(residing_state, res_state);
		this.r_state = res_state;
	}
	
	public void residingCity(String res_city) throws InterruptedException
	{
		residing_city.sendKeys(res_city);
		this.r_city = res_city;
//		List<WebElement> res_cities = driver.findElements(By.xpath("//label[@for='applicant_city_name']//following-sibling::span[@class='twitter-typeahead']//following-sibling::div[@class='tt-menu']//div[@class='tt-dataset tt-dataset-cities']//div[@class='tt-suggestion tt-selectable']//strong[text()='MUMBAI']"));
//		
//		for(int i=0; i<res_cities.size(); i++)
//		{
//			String iterate_cities = res_cities.get(i).getText();
//			if(iterate_cities.equalsIgnoreCase(res_city))
//			{
//				System.out.println("Residing cities are : " +res_cities);
//				Thread.sleep(2000);
//				res_cities.get(i).click();
//			}
//			
//		}
	}
	
//	public void radioGender(String gender)
//	{
//		if(gender.equalsIgnoreCase("Male"))
//		{
//			gender_male.click();
//		}
//		else if(gender.equalsIgnoreCase("Female"))
//		{
//			gender_female.click();
//		}
//		else
//		{
//			System.out.println("Invalid Gender input");
//			driver.quit();
//		}
//	}
	
	public void applicantAge(String age)
	{
		applicant_age.sendKeys(age);
		this.ap_age = age;
	}
	
	public void selectOccupation(String enterOccupation)
	{
		dropdown.selectByText(occupation, enterOccupation);
		this.occ = enterOccupation;
	}
	
	public void applicantIncome(String income)
	{
		applicant_income.sendKeys(income);
		this.inc = income;
	}
	
	public void retirementAge(String retire_age)
	{
		dropdown.selectByText(retirement_age, retire_age);
		this.rt_age = retire_age;
	}
	
	public void monthlyEmi(String emi)
	{
		monthly_emi.sendKeys(emi);
		this.m_emi = emi;
	}
	
	public void applicantEmail(String email)
	{
		applicant_email.sendKeys(email);
		this.aEmail = email;
	}
	
	public void applicantMobile(String appl_mobile)
	{
		applicant_mobile.sendKeys(appl_mobile);
		this.mob = appl_mobile;
	}
	
	public void checkAgree()
	{
		agree.click();
	}
	
	public void applicantSubmit()
	{
		applicant_continue.click();
	}
	
}
