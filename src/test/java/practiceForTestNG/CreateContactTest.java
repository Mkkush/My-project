package practiceForTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.vtiger.comcast.pomrepositoryLib.ContactInformation;
import com.vtiger.comcast.pomrepositoryLib.Contacts;
import com.vtiger.comcast.pomrepositoryLib.CreateNewContacts;
import com.vtiger.comcast.pomrepositoryLib.Home;
import com.vtiger.comcast.pomrepositoryLib.Login;

public class CreateContactTest extends BaseClass {
	@Test
	public void CreateContactTest() throws Throwable {
		int randomInt = jLib.getRanDomNumber();
	String contName = eLib.getDataFromExcel("contact", 1, 2)+"_"+jLib.getRanDomNumber();
	
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
 wLib.waitForElementVisibility(driver,cip.getSuccessfullMsg());
 String actSucMsg = cip.getSuccessfullMsg().getText();
  
 if(actSucMsg.contains(contName))
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
