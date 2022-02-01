package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {  //Rule :1 Create a seperate java class for every page in an application

	public Login(WebDriver driver) {  //Rule :3 Execute all the elements & initialize the elements PageFactory.initElements[called initialization]
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")      //Rule :2 Identify all the elements using @FindBy,@FindBys and @FindAll[called Declaration]
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userpassswordEdt;
	
	@FindAll({@FindBy(id="submitButton") ,@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	//Rule :4 Declare all the elements as private & provide getters method ,bussiness method for[called Utilization]

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserpassswordEdt() {
		return userpassswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String userName ,String password,String url) {
		// Step 1 : Login
		userNameEdt.sendKeys(userName);
		userpassswordEdt.sendKeys(password);
		loginBtn.click();
	}
}
