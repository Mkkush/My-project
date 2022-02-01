package com.vtiger.comcast.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositoryLib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositoryLib.Home;
import com.vtiger.comcast.pomrepositoryLib.Login;
import com.vtiger.comcast.pomrepositoryLib.OrgInfoPage;
import com.vtiger.comcast.pomrepositoryLib.Organizations;

public class CreateOrgWithIndustry {
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
			String orgName = elib.getDataFromExcel("org", 4, 3)+"_"+jlib.getRanDomNumber();
	//		String industry = elib.getDataFromExcel("org", 4, 3);
			
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
			
			// Step 3: navigate to org
			Home hp=new Home(driver);
			hp.getOrganizationLnk().click();
			
			//Step 4: Navigate to create org page
		  Organizations co=new Organizations(driver);
		  co.getCreateOrgImg().click();
		  // Step 5: Create new org
		  CreateNewOrganization cnop=new CreateNewOrganization(driver);
		  cnop.createOrg(orgName);
		  
		  // Step 6: verify
		  OrgInfoPage orginfo=new OrgInfoPage(driver);
		  wlib.waitForElementVisibility(driver, orginfo.getSuccessfullMsg());
		  String actSucMsg = orginfo.getSuccessfullMsg().getText();
		  
		  
		 if(actSucMsg.contains(orgName))
		 {
			 System.out.println("org is created successfully ===>passs");
		 }
		 else
		 {
			 System.out.println("org is not created successfully ===>");
		 }
		 
		  // Step 7 : Logout
		  hp.logout();
		  
		  // Step 8 : Close the Browser
		  driver.close();
		}
}
