package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageObjects {

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement drop;

	@FindBy(linkText = "Logout")
	private WebElement logOutLink;

	public LogoutPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void dropDownandLogOutClick() {
		drop.click();
		logOutLink.click();
	}

}
