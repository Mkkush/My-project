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

public class CreateContactTest {
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
			
			// Step 3: navigate to contact
			Home hp=new Home(driver);
			hp.getContactLink().click();;
			
			//Step 4: Navigate to create contact page
			Contacts cop=new Contacts(driver);
			cop.getContactBtn().click();
		
		  // Step 5: Create 
		 CreateNewContacts cncp=new CreateNewContacts(driver);
		 cncp.createContact(contName);
		  
		  // Step 6: verify
		
		 ContactInformation cip=new ContactInformation(driver);
		 wlib.waitForElementVisibility(driver,cip.getSuccessfullMsg());
		 String actSucMsg = cip.getSuccessfullMsg().getText();
		  
		 if(actSucMsg.contains(contName))
		 {
			 System.out.println("contact is created successfully ===>passs");
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
