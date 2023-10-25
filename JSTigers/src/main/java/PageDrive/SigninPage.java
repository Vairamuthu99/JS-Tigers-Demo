package PageDrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityDrive.UtilClass;

public class SigninPage extends UtilClass {

	WebDriver driver;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement Email;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement Password;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Login;

	public void Login1(String MailID, String Pass) {
		Email.sendKeys(MailID);
		Password.sendKeys(Pass);
		Login.click();
	}
}
