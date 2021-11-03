package com.hdfcUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {

	Select select;
	
	public void selectByIndex(WebElement element, int index)
	{
		select = new Select(element);
		select.selectByIndex(index);
	} 
	
	public void selectByValue(WebElement element, String value)
	{
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByText(WebElement element, String text)
	{
		select = new Select(element);
		select.selectByVisibleText(text);
	}
}
