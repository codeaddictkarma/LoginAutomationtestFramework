package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC2_NegativeUsername extends BaseClass {
	
	 
	 @Test(groups = {"regression","master"})
	 public void NegetiveUsernameTest() throws InterruptedException {
		 
		 LoginPage lp = new LoginPage(driver); 
		 //incorrectUser
		 lp.enterUsername(getRandomuser());
		 lp.enterPassword("Password123");
		 log.info("*********incorrect user and correct password********");
		 
		 
		 lp.clickOnsubmitBtn();
		 log.info("*********clicked the submit button************");
		 
		 
		 
		 String erroMsg = lp.geterrorMsg(); 
		 if(erroMsg.equals("Your username is invalid!")) {
			 log.info("*******test passed********");
			 Assert.assertTrue(true);
		 }
		 else {
			 log.error("*******test failed********");
			 Assert.assertTrue(false);
		 }
		 
		 
		 Thread.sleep(3000);
		 
		 
	 }

}
