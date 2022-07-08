package log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver rdriver;
	public loginPage(WebDriver ldriver) {
		this.rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	@FindBy(name="uid")
	WebElement userIdField;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(name="btnLogin")
	WebElement loginButton;
	public void enterUserId(String userId) {
		userIdField.sendKeys(userId);
	}
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickLogin( ) {
		loginButton.click();
	}
	
}
