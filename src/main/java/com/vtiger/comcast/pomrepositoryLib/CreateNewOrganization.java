package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganization {
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
  }
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryInfo;
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		Select s=new Select(industryInfo);
		s.selectByVisibleText("Energy");
		saveBtn.click();
	}
	
}
	
