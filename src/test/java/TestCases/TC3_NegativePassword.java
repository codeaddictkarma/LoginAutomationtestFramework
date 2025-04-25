package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC3_NegativePassword extends BaseClass {
	
	@Test
	public void negativePasswordTest() throws InterruptedException{
		LoginPage lp = new LoginPage(driver); 
		lp.enterUsername("student");
		lp.enterPassword(GetRandomPassword());
		log.info("*********correct user and incorrect password********");
		
		lp.clickOnsubmitBtn();
		log.info("*********clicked the subumit button********");
		
		String errorMsg = lp.geterrorMsg(); 
		if(errorMsg.equals("Your password is invalid!")) {
			log.info("********test passed**********");
			Assert.assertTrue(true);
		}
		else {
			log.error("*******test failed**********");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		
		
	}

}
