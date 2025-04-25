package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//input[@id='username']") WebElement userNambox; 
	@FindBy(xpath = "//input[@id='password']") WebElement passWordbox; 
	@FindBy(xpath = "//button[@id='submit']")  WebElement submitBtn; 
	@FindBy(xpath = "//h1[normalize-space()='Logged In Successfully']") WebElement loginsuccesMsg; 
	@FindBy(xpath = "//a[normalize-space()='Log out']") WebElement logoutBtn; 
	@FindBy(xpath = "//div[@id='error']") WebElement loginerrorMsg; 
	
	
	public void enterUsername(String user) {
		userNambox.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		passWordbox.sendKeys(pass);
	}
	
	public void clickOnsubmitBtn() {
		submitBtn.click(); 
	}
	
	public  String getloginSuccessmsg() {
		
		try {
			return loginsuccesMsg.getText(); 
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage(); 
		}
	}
	
	public void clickOnlogoutBtn() {
		logoutBtn.click(); 
	}
	
	public String geterrorMsg() {
		try {
			return loginerrorMsg.getText(); 
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	
	//div[@id='error']
    //Your username is invalid!
}
