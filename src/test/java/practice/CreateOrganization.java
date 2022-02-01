package practice;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.FileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.WebDriverUtility;
public class CreateOrganization 
{
	public static void main(String[] args) 
	{
		/*Object Creation for Lib*/
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		int randomInt = jLib.getRanDomNumber();
		
		/*common Data*/
	/*	String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/*test script Data*/
/*		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		
		/* Navigate to app*/
		ChromeDriver driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
    /*    driver.get(URL);
        
        /* step 1 : login */
  /*   Login loginPage = new Login(driver);
        loginPage.loginToApp(USERNAME, PASSWORD);
        
        /*step 2 : navigate to organization*/
     /*   Home homePage = new Home(driver);
        homePage.getOrganizationLnk().click();
        
        /*step 3 : navigate to "create new organization"page by click on "+" image */
   /*     Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
        /*step 4 : create organization*/
     /*   CreateNewOrganization cno = new CreateNewOrganization(driver);
        cno.createOrg(orgName);
        
       /*step 5 : verify the successful msg with org name*/
   /*     OrganizationInfo orginfoPage = new OrganizationInfo(driver);
        String  actSuccesfullMg =  orginfoPage.getSuccesfullMsg().getText();
        if(actSuccesfullMg.contains(orgName)) {
        	System.out.println(orgName + "==>created successfully");
        }else {
        	System.out.println(orgName + "==> not created successfully");

        }
       /*step 6 : logout*/
   //    homePage.logout();
	}




	}
	


