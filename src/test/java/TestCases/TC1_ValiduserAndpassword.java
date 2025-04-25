package TestCases;

import java.lang.reflect.Parameter;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class TC1_ValiduserAndpassword extends BaseClass{
	
	
	
	
	@Test(groups = {"sanity","master"})
	public void LoginTestValiduserandPassword() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver); 
		
		lp.enterUsername("student"); 
		lp.enterPassword("Password123");
		log.info("***********provided username and password***********"); 
		
		lp.clickOnsubmitBtn(); 
		log.info("***********clicked the submitbutton**********");
		
		
		
		log.info("***********varifying logged in sucess msg***********");
		String succesmsg = lp.getloginSuccessmsg(); 
		if(succesmsg.equals("Logged In Successfully")) {
			
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		
		lp.clickOnlogoutBtn();
		
		
	}

	
}
