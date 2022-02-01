package practiceForTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class SamlpeForAssertionTest extends BaseClass {

	@Test
	public void verifyHomePage() {
		System.out.println("====TEST START==");
		String expectedTitle = "Home";
		System.out.println("capture page Title");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expectedTitle);
		System.out.println("====TEST END==");
	}

	@Test
	public void verifyLogoInHomePage() {
		System.out.println("====TEST START==");
		System.out.println("capture the Logo Status");
		boolean actstatus = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(actstatus);
		System.out.println("====TEST END==");  

	}
}
