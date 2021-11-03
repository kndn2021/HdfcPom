package com.hdfcUtility;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.hdfcMain.HdfcDrivers;

public class ScrollUtility extends HdfcDrivers {

	JavascriptExecutor j_ex;
	
	public ScrollUtility() throws IOException
	{
		super();
		j_ex = (JavascriptExecutor)driver;
	}
	
	public void scrollDown()
	{
		j_ex.executeScript("scroll(0,300)");
	}
	
	public void scrollBottom()
	{
		j_ex.executeScript("scroll(0,document.body.scrollHeight)");
	}
	
	public void scrollUp()
	{
		j_ex.executeScript("scroll(0,-200)");
	}
	
	public void scrollElement(WebElement element)
	{
		j_ex.executeScript("arguments[0].scrollIntoView();", element);
	}
}
