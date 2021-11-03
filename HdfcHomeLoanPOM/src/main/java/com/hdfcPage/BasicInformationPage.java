package com.hdfcPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hdfcMain.HdfcDrivers;
import com.hdfcUtility.DropdownUtility;

public class BasicInformationPage extends HdfcDrivers {
	
	@FindBy(how = How.ID, using = "type_of_loan")
	WebElement type_of_loan;
	
	@FindBy(name = "applicant_name")
	WebElement applicant_name;
	
	@FindBy(xpath = "//label[@for='shortlisted_property1']")
	WebElement shortlist_prop;
	
	@FindBy(id = "state")
	WebElement property_state;
	
	@FindBy(id = "city_name")
	WebElement property_city;
	
	@FindBy(id = "property_cost")
	WebElement prop_cost;
	
	@FindBy(xpath = "//button[@id='continue-button']")
	WebElement basic_continue;
	
	public String loan;
	public String newState;
	public String newCity;
	public String propAmount;
	public String name;
	
	DropdownUtility dropdown = new DropdownUtility();
	
	public BasicInformationPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectLoan(String loan_value)
	{
		dropdown.selectByValue(type_of_loan, loan_value);
		this.loan = loan_value;
	}
	
	public void applicantName(String app_name)
	{
		applicant_name.sendKeys(app_name);
		this.name = app_name;
	}
	
	public void shortProperty()
	{
		shortlist_prop.click();
	}
	
	public void propertyState(String state)
	{
		dropdown.selectByText(property_state, state);
		
		this.newState = state;
	}
	
	public void propertyCity(String city)
	{
		property_city.sendKeys(city);
		List<WebElement> cities= driver.findElements(By.xpath("//div[@class='tt-dataset tt-dataset-cities']//div/descendant::strong[@class='tt-highlight']"));
		int total = cities.size();
		System.out.println("Total cities are : " +total);
		
		for(int i=0; i<cities.size(); i++)
		{
			System.out.println("Cities are : " +cities.get(i).getText());
			
			if(cities.get(i).getText().equalsIgnoreCase(city))
			{
				cities.get(i).click();
			}
		}
		
		this.newCity = city;
	}
	
	public void propCost(String amount)
	{
		prop_cost.sendKeys(amount);
		
		this.propAmount = amount;
	}
	
	public void basicSubmit()
	{
		basic_continue.click();
	}
}
