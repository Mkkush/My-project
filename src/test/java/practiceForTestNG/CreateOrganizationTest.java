package practiceForTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositoryLib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositoryLib.Home;
import com.vtiger.comcast.pomrepositoryLib.Login;
import com.vtiger.comcast.pomrepositoryLib.OrgInfoPage;
import com.vtiger.comcast.pomrepositoryLib.Organizations;

public class CreateOrganizationTest extends BaseClass {
	 @Test(groups = {"smokeTest"})
	 public void CreateOrgTest() throws Throwable {
		 int randomInt = jLib.getRanDomNumber();
			String orgName = eLib.getDataFromExcel("org", 1, 2)+"_"+jLib.getRanDomNumber();
				
			// Step 3: navigate to org
			Home hp=new Home(driver);
			hp.getOrganizationLnk().click();
			
			//Step 4: Navigate to create org page
		  Organizations co=new Organizations(driver);
		  co.getCreateOrgImg().click();
		  // Step 5: Create org
		  CreateNewOrganization cnop=new CreateNewOrganization(driver);
		  cnop.createOrg(orgName);
		  
		  // Step 6: verify
		  OrgInfoPage orginfo=new OrgInfoPage(driver);
		  wLib.waitForElementVisibility(driver, orginfo.getSuccessfullMsg());
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
