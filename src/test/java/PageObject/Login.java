package PageObject;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

	WebDriver ldriver;

	public Login(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath ="//*[@id=\"email\"]")
	WebElement emailid;
	
	@FindBy(xpath = "//span[@class='mdc-button__label']")
	WebElement Login;
	
	@FindBy(id = "mat-input-1")
	WebElement Otp;
	
	@FindBy(xpath="//span[contains(text(),'Verifikasi & Lanjutkan')]")
	WebElement Clickonotp;
	
	@FindBy(xpath =" //button[@class='mat-mdc-menu-trigger ml-3']")
	WebElement profile;
	
	@FindBy(xpath = "//div/button[4]/span/span/a")
	WebElement logout;
	
	
	public void enterem(String emailadd) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		emailid.sendKeys(emailadd);

	}
	
	public void clickonlogin() {
		Login.click();
	}
	public void enterOtp(String Enterotp) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Otp.click();
		Otp.sendKeys(Enterotp);
	}
	public void clickoncontinue() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Clickonotp.click( );
	}
	
	public void clickonprofile() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profile.click();
	}
	public void clickonLogout() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        logout.click();

		
		
	}
	
}
