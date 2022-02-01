package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewContacts extends WebDriverUtility {
	WebDriver driver=null;
	public CreateNewContacts(WebDriver driver) {
		PageFactory.initElements(driver,this);
  }
	@FindBy(name="lastname")
	private WebElement contactEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement selectBtn;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
		
		public void createContact(String lastName) {
			contactEdt.sendKeys(lastName);
			saveBtn.click();
		}
			public void createContact(String lastName,String orgName) {
				contactEdt.sendKeys(lastName);
				selectBtn.click();
				
				switchToWindow(driver,"Account&action");
				Organizations org=new Organizations(driver);
				org.getSearchBtn().click();
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				switchToWindow(driver,"Contacts&action");
				saveBtn.click();
				
			}
			
	
}
