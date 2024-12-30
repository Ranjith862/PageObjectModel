package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboard;

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this); // Initialize elements
	}

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String getErrorMessageForInvalid() {
		return errorMessage.getText();
	}

	public String getDashBoardAfterLogin() {
		return dashboard.getText();
	}
}
