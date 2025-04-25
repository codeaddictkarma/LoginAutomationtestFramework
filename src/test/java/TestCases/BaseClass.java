package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;


import net.bytebuddy.asm.Advice.This;



public class BaseClass {
	public static WebDriver driver; 
	public  Logger log; 
	
	 
	 @BeforeClass 
	 @Parameters({"browser"})
	 public void setup(String br) {
		 
		 
     ChromeOptions chrmOptions = new ChromeOptions(); 
        chrmOptions.addArguments("--headless=new");
	    chrmOptions.addArguments("--no-sandbox");
	    chrmOptions.addArguments("--disable-dev-shm-usage");
	    chrmOptions.addArguments("--disable-gpu");
	    chrmOptions.addArguments("--window-size=1920,1080");
	    
	
	 EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");
        edgeOptions.addArguments("--window-size=1920,1080");
        
	 switch (br.toLowerCase()) {
	    
		case "chrome": driver = new ChromeDriver(); 
			break;
		
		case "firefox":driver = new FirefoxDriver(); 
		    break; 
		
		case "edge": driver = new EdgeDriver(); 
		    break; 

		default:
			driver = null; 
			break;
		}
	 
	     log = LogManager.getLogger(This.class); 
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		 driver.manage().deleteAllCookies();
		 log.info("*****************url opening******************"); 
		 driver.get("https://practicetestautomation.com/practice-test-login/");
		 
		
	 }
	 
	 public static String captureScreenshot( String testName) {
	        String screenshotPath = System.getProperty("user.dir") + "/ScreenShots/" + testName + ".png";
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            File destination = new File(screenshotPath);
	            FileUtils.copyFile(source, destination);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return screenshotPath;
	    }
	 
	 public String getRandomuser() {
		 
		 String Randomuser = RandomStringUtils.randomAlphabetic(7); 
		 if(Randomuser.equals("student") != true) {
			 return Randomuser; 
		 }
		 else {
			 return Randomuser + "wrong"; 
		 }
	 }
	 
	 public String GetRandomPassword() {
		 String RandomPass = RandomStringUtils.randomAlphabetic(8) + RandomStringUtils.randomNumeric(3); 
		 if(RandomPass.equals("Password123") != true) {
			 return RandomPass;
		 }
		 else {
			 return RandomPass + "wrongpass"; 
		 }
	 }

	 
	 @AfterClass
	 public void tearDown() {
		 driver.close();
		 log.info("***********browser closed**************");
	 }

}
