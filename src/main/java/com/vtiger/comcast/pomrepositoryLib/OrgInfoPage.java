package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	WebDriver driver;
	public OrgInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfullMsg;
	
	
	@FindBy(id="dtlview_Industry")
	private WebElement industrySuccessMsg;
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getIndustrySuccessMsg() {
		return industrySuccessMsg;
	}
	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	
	

}
