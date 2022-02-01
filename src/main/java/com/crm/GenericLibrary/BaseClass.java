package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositoryLib.Home;
import com.vtiger.comcast.pomrepositoryLib.Login;

public class BaseClass {
	public WebDriver driver;
	/*Object Creation for Lib*/

	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();

	@BeforeSuite(groups = {"smokeTest"})
	public void configBS() {
		System.out.println("=======connect to DB==============");

	}

	@BeforeClass(groups = {"smokeTest"})

	public void configBC() {
		System.out.println("========Launch the Browser=====");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = {"smokeTest"})

	public void configBM() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");

		/* Navigate to app*/

		driver.get(URL);
		/* step 1 : login */
		Login loginPage = new Login(driver);
		loginPage.loginToApp(USERNAME, PASSWORD, URL);
	}


	@AfterMethod(groups = {"smokeTest"})

	public void configAM() {
		/*step 6 : logout*/

		Home homePage = new Home(driver);
		homePage.logout();
	}

	@AfterClass(groups = {"smokeTest"})

	public void configAC() {
		System.out.println("========Close the Browser===");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest"})

	public void configAS() {
		System.out.println("===========close DB============");
	}
}


