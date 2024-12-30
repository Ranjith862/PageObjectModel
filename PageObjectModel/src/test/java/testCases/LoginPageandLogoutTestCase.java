package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
		login = new LoginPageObjects(driver); // Using inherited driver
	}

	@AfterSuite
	public void closeChrome() {
		System.out.println("Browser Close");
		driver.quit();
	}

	@Test
	public void validUnameAndInvalidPword() {
		// Verify valid Username and invalid Password
		login.enterUsername("Admin");
		login.enterPassword("Invalid");
		login.clickOnLoginButton();
		String errormessage = login.getErrorMessageForInvalid();
		Assert.assertEquals(errormessage, "Invalid credentials");

	}

	@Test(priority = 1)
	public void invalidUnameAndvalidPword() {
		// Verify invalid Username and valid Password
		login.enterUsername("Invalid");
		login.enterPassword("admin123");
		login.clickOnLoginButton();
		String errormessage = login.getErrorMessageForInvalid();
		Assert.assertEquals(errormessage, "Invalid credentials");
	}

	@Test(priority = 2)
	public void invalidUnameAndPword() {
		// Verify invalid Username and invalid Password
		login.enterUsername("Invalid");
		login.enterPassword("Invalid");
		login.clickOnLoginButton();
		String errormessage = login.getErrorMessageForInvalid();
		Assert.assertEquals(errormessage, "Invalid credentials");
	}

	
	@Test(priority = 3)
	public void validUnameAndvalidPword() {
		// Verify invalid Username and invalid Password
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLoginButton();
		String dashboardPage = login.getDashBoardAfterLogin();
		Assert.assertEquals(dashboardPage, "Dashboard");
	}

	@Test(priority = 4)
	public void logOut() {
		logout = new LogoutPageObjects(driver);
		logout.dropDownandLogOutClick();
	}

}
