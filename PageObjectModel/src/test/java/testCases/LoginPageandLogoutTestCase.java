package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import pageObjects.LogoutPageObjects;

public class LoginPageandLogoutTestCase {

	LoginPageObjects login;
	LogoutPageObjects logout;
	WebDriver driver;

	@BeforeSuite
	public void openChrome() throws IOException {
		System.out.println("Browser Open");
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void closeChrome() {
		System.out.println("Browser Close");
		driver.quit();
	}

	@Test
	public void loginFunction() {
		// Initialize the page object with the driver from the inherited
		// OpenAndCloseBrowser
		login = new LoginPageObjects(driver); // Using inherited driver
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginButton();
		logout = new LogoutPageObjects(driver);
		logout.dropDownandLogOutClick();
	}

}
