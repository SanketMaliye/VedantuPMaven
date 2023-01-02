package Com.Vedantu.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Vedantu.BaseClass.Vedantu_BaseClass;

public class Vedantu_SignInPage extends Vedantu_BaseClass{

	public Vedantu_SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[text()=\"Sign in\"])[2]") public WebElement SignIn;
	@FindBy(xpath="//body/div[@id='login-signup-module-container']/div[1]/div[3]/div[3]/div[1]/form[1]/div[1]/div[2]/input[1]") public WebElement EnterPhone;
	@FindBy(id="login-submit3") public WebElement Next1;
	@FindBy(xpath="//input[@id='password-input-field']") public WebElement EnterPass;
	@FindBy(id="login-submit2") public WebElement Next2;
	 
	public void SignInButton() {
		SignIn.click();
	}
	public void EnterPhoneOrEmail(String P) {
		EnterPhone.sendKeys(P);
	}
	public void Next1Button() {
		Next1.click();
	}
	public void EnterPassword(String Pwd) {
		EnterPass.sendKeys(Pwd);
	}
	public void Next2Button() {
		Next2.click();
	}
}
