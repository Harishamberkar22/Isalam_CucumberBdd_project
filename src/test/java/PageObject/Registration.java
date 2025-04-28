package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	WebDriver ldriver;
	WebDriverWait wait ;
	public Registration(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Mendaftar')]")
	WebElement registerbutton;
	
	@FindBy(xpath="//input[@id=\"fullName\"]")
	WebElement Entername;
	
	@FindBy(xpath="//input[@id=\"eMail\"]")
	WebElement Enteremail;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	WebElement Enternumber;
	
	@FindBy(xpath="//span[contains(text(),' Melanjutkan ')]")
	WebElement clickonMelanjutkan;
	
	@FindBy(xpath="//input[@id=\"mat-input-4\"]")
	WebElement Enterotp;
	
	@FindBy(xpath="//span[contains(text(),'Verifikasi & Lanjutkan')]")
	WebElement clickoncontinue;
	
	public void clickonreg() {
		registerbutton.click();
	}
	
	public void entername(String name) {
		wait = new WebDriverWait(ldriver, 5);

		wait.until(ExpectedConditions.elementToBeClickable(Entername)).click();
		Entername.sendKeys(name);
	}
	public void enteremail(String email) {
		wait= new WebDriverWait(ldriver, 5);

		wait.until(ExpectedConditions.elementToBeClickable(Enteremail)).click();
		Enteremail.sendKeys(email);
	}
	public void enterNum(String num) {
		wait= new WebDriverWait(ldriver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(Enternumber)).sendKeys(num);
	
		//Enternumber.sendKeys(num);
	}
	
		//WebDriverWait wait = new WebDriverWait(ldriver, 5);
		
	
		
		
		
	
	
	public void clickonok() {
		clickonMelanjutkan.click();
}
	public void enterotp(String otp) {
		wait.until(ExpectedConditions.elementToBeClickable(Enterotp)).click();
		Enterotp.sendKeys(otp);
	}
	
	public void clickoncontinue() {
		clickoncontinue.click();
	}
		

}
