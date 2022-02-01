package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;
	public ContactInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successfullMsg;
	
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgNameIcon() {
		return orgNameIcon;
	}
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameIcon;
	
	
	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}	
	
	
	
	
	
}
