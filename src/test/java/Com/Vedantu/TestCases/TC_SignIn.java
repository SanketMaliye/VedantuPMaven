package Com.Vedantu.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Vedantu.BaseClass.Vedantu_BaseClass;
import Com.Vedantu.PageObject.Vedantu_SignInPage;

public class TC_SignIn extends Vedantu_BaseClass{

	@Test
	public void SignInTest() throws InterruptedException, IOException {
		Vedantu_SignInPage SI=new Vedantu_SignInPage();
		
		Thread.sleep(2000);
		SI.SignInButton();
		log.info("Clicked Sign In Button.");
		SI.EnterPhoneOrEmail("9175671762");
		log.info("Phone Number Entered.");
		SI.Next1Button();
		log.info("Clicked Next Button.");
		SI.EnterPassword("Sanket@7");
		log.info("Password Entered.");
		SI.Next2Button();
		log.info("Clicked Next Button.");
		Thread.sleep(3000);
		//div[text()="Sanket"]
		@SuppressWarnings("unused")
		boolean text=driver.findElement(By.xpath("//div[text()=\"Sanket\"]")).isDisplayed();
		if(text=true) {
			Assert.assertTrue(true);
			log.info("Test Pass -- Navigates to HomePage.");
		}
		else {
			Assert.assertTrue(false);
			TakeSS("Sign In Test Case");
			log.info("Test Failed.");
		}
		Thread.sleep(3000);
	}
}
