package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimleTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		//String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String password = p.getProperty("password");		 
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.close();
	}

}
