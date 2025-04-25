package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.ReadingExcelData;
import net.bytebuddy.asm.Advice.This;

public class TC4_DataDriven extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass = ReadingExcelData.class)
	public void dataDrivenLoginTest(String username,String password,String status) throws InterruptedException {
		
         LoginPage lp = new LoginPage(driver); 
         lp.enterUsername(username);
         lp.enterPassword(password);
         lp.clickOnsubmitBtn();
         
         log.info("*********provided username and password and clicked the submit button********");
         
         
         if(status.equalsIgnoreCase("valid")) {
        	 log.info("*********valid credentials***********");
        	 String loginsuccesMsg = lp.getloginSuccessmsg(); 
        	 if(loginsuccesMsg.equals("Logged In Successfully")) {
        		 
        		 log.info("*******able to login*******");
        		 log.info("*******test passed*********");
        		 lp.clickOnlogoutBtn(); 
        		 Assert.assertTrue(true);
        	 }
        	 
        	 else {
        		
        		 log.info("*********unable to login*******");
        		 log.error("********test failed********");
        		 Assert.assertTrue(false);
        	 }
         }
         
         
         Thread.sleep(3000);
         
         if(status.equalsIgnoreCase("invalid")) {
        	 log.info("*********invalid credentials*******"); 
        	 String loginsuccesmsg = lp.getloginSuccessmsg(); 
        	 if(loginsuccesmsg.equals("Logged In Successfully")) {
        		
        		 log.info("**********able to login*******");
        		 log.error("*********test failed*********"); 
        		 lp.clickOnlogoutBtn();
        		 Assert.assertTrue(false);
        	 }
        	 
        	 else {
        		 
        		 log.info("*********unable to login******");
        		 log.info("*********test passed**********");
        		 Assert.assertTrue(true); 
        	 }
         }
         
         
         
        
         
         
	}

}
