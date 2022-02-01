package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
   WebDriver driver;  // Global driver variable
   public Home(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   @FindBy(linkText="Organizations")
   private WebElement organizationLnk;
   
   @FindBy(linkText="Products")
   private WebElement productLnk;
   
   @FindBy(linkText = "Contacts")
   private WebElement contactLink;
   
   public WebElement getContactLink() {
	return contactLink;
}
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminstratorImg;
   
   @FindBy(linkText="Sign Out")
   private WebElement signOutLnk;
public WebDriver getDriver() {
	return driver;
}

public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getProductLnk() {
	return productLnk;
}

public WebElement getAdminstratorImg() {
	return adminstratorImg;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}
  public void logout() {
	  Actions act=new Actions(driver);
	  act.moveToElement(adminstratorImg).perform();
	  signOutLnk.click();
  } 
}
