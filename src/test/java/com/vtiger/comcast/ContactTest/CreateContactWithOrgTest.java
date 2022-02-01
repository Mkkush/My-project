package com.vtiger.comcast.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositoryLib.ContactInformation;
import com.vtiger.comcast.pomrepositoryLib.Contacts;
import com.vtiger.comcast.pomrepositoryLib.CreateNewContacts;
import com.vtiger.comcast.pomrepositoryLib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositoryLib.Home;
import com.vtiger.comcast.pomrepositoryLib.Login;
import com.vtiger.comcast.pomrepositoryLib.OrgInfoPage;
import com.vtiger.comcast.pomrepositoryLib.Organizations;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws Throwable {
		// create object
			ExcelUtility elib=new ExcelUtility();
			FileUtility flib=new FileUtility();
			JavaUtility jlib=new JavaUtility();
			WebDriverUtility wlib=new WebDriverUtility();
			WebDriver driver=null;
			
			// Read common data
			String BROWSER = flib.getPropertyKeyValue("browser");
			String URL = flib.getPropertyKeyValue("url");
			String USERNAME = flib.getPropertyKeyValue("username");
			String PASSWORD = flib.getPropertyKeyValue("password");
			
			//Read test data
			
			String orgName = elib.getDataFromExcel("org", 1, 2)+"_"+jlib.getRanDomNumber();
			String contName = elib.getDataFromExcel("contact", 1, 2)+"_"+jlib.getRanDomNumber();
			
			// Step 1: Launch the browser
			
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			
			//Step 2 : Login to app
			driver.get(URL);
			Login lp=new Login(driver);
			lp.loginToApp(USERNAME,PASSWORD,URL);
			
			// Step 3: navigate to home page
			Home hp=new Home(driver);
			hp.getOrganizationLnk().click();
			
			//Step 4: Navigate to create contact page
			Contacts cop=new Contacts(driver);
			cop.getContactBtn().click();
		
		  // Step 5: Navigate to Create org page
			
		 Organizations org=new Organizations(driver);
		 org.getCreateOrgImg().click();
		 
		 // Step 5: Navigate to new Create org pag
		 CreateNewOrganization cno=new CreateNewOrganization(driver);
		 cno.createOrg(orgName);
		 
		 // Step 6: Wait for Header Element
		 OrgInfoPage oip=new OrgInfoPage(driver);
		 wlib.waitForElementVisibility(driver,oip.getSuccessfullMsg());
		 
		  // Step 7: Navigate the contact page
		 
		 hp.getContactLink().click();
		 
		// Step 8: Navigate the new contact page
		 
	 CreateNewContacts cnc=new CreateNewContacts(driver);
	    cnc.createContact(contName, orgName);
		// // Step 8: verify the details 
		 
		 ContactInformation cip=new ContactInformation(driver);
		 wlib.waitForElementVisibility(driver,cip.getSuccessfullMsg());
		 String actSucMsg = cip.getSuccessfullMsg().getText();
		  
		 if(actSucMsg.contains(contName))
		 {
			 System.out.println("Contact is created successfully ===>passs");
		 }
		 else
		 {
			 System.out.println("contact is not created successfully ===>");
		 }
		 
		  // Step 7 : Logout
		  hp.logout();
		  
		  // Step 8 : Close the Browser
		  driver.close();
		}
}
