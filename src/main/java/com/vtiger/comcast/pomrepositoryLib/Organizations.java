package com.vtiger.comcast.pomrepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
public Organizations(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createOrgImg;

@FindBy(name="search_text")
private WebElement searchEdt;

@FindBy(name="search")
private WebElement searchBtn;

public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchBtn() {
	return searchBtn;
}

public WebElement getCreateOrgImg() {
	return createOrgImg;
}
}
