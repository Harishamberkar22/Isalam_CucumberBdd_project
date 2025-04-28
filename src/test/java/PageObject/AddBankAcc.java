package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.reactivex.rxjava3.functions.Action;

public class AddBankAcc {
	WebDriver ldriver;
	WebDriverWait wait;
	public AddBankAcc(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(css = "span.ng-tns-c16806796-12")
	WebElement clickonmasterdata;
	
	@FindBy(xpath="//span[contains(.,' Bank Accounts ')]")
	WebElement clickonbankacc;
	
	@FindBy(xpath="(//span[contains(., 'Add')])[1]")
	WebElement clickonaddbutton;
	
	@FindBy(xpath = "//mat-select[@id=\"bank-select\"]")
	WebElement EnterBankname;
	
	@FindBy(xpath = "//div[@role=\"listbox\"]")
	WebElement banklist;
	
	@FindBy(xpath = "//input[@id=\"mat-input-0\"]")
	WebElement Bankcode;
	
	@FindBy(xpath = "//input[@id=\"mat-input-1\"]")
	WebElement EnterBranchcode;
	
	@FindBy(xpath = "//input[@id=\"mat-input-16\"]")
	WebElement Enterbranchname;
	
	@FindBy(xpath = "//input[@id=\"mat-input-17\"]")
	WebElement EnterAccNum;
	
	@FindBy(xpath = "//input[@id=\"mat-input-18\"]")
	WebElement EnterconfirmationAccNum;
	
	@FindBy(xpath = "//input[@id=\"mat-input-19\"]")
	WebElement EnterAccholderNum;
	
	@FindBy(xpath = "//div[@id=\"mat-select-value-9\"]")
	WebElement BankAccType;
	
	@FindBy(xpath = "//input[@id=\"mat-input-20\"]")
	WebElement Enterswiftcode;
	
	
	public void Masterdata() {
		//Actions actions = new Actions(ldriver);
	    WebDriverWait wait = new WebDriverWait(ldriver, 10);
	    // Verify if the element is displayed after clicking
	    if (clickonmasterdata.isDisplayed()) {
	        System.out.println("Element is displayed");
	    } else {
	        System.out.println("Element is not displayed");
	    }
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickonmasterdata));
	    JavascriptExecutor js = (JavascriptExecutor) ldriver;
	    js.executeScript("arguments[0].click();", element);

	   
	}
	    	
	   
		
		
	
	public void bankacc() {
		 wait = new WebDriverWait(ldriver, 20);
		WebElement visible=wait.until(ExpectedConditions.elementToBeClickable(clickonbankacc));
		SoftAssert sa= new SoftAssert();
		 sa.assertTrue(clickonbankacc.isDisplayed());

		    // Check if the element is clickable
		    sa.assertTrue(clickonbankacc.isEnabled(), "❌ Bank Account option is NOT clickable!");

		    // Click on the element if all conditions are met
		    if (clickonbankacc.isDisplayed() && clickonbankacc.isEnabled()) {
		        clickonbankacc.click();
		        System.out.println("✅ Clicked on Bank Account successfully!");
		    } else {
		        System.out.println("⚠️ Bank Account is either not displayed or not clickable.");
		    }
		    sa.assertAll();

		//wait.until(ExpectedConditions.elementToBeClickable(clickonbankacc)).click();
		
		//clickonbankacc.click();
	}
	public void addbutton() {
		clickonaddbutton.click();
	}
	
	public void listofbanks() {
		List<WebElement> banklist=ldriver.findElements(By.xpath("//div[@role=\'[listbox\']"));
		banklist.get(2).click();
	}
	
	public void enterdetails() {
		EnterBankname.click();
		WebDriverWait wait=new WebDriverWait(ldriver, 15);
		List<WebElement> banklist1=ldriver.findElements(By.xpath("//div[@id='bank-select-panel']"));
		//System.out.println(banklist1.);
		List<WebElement> banklist=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role=\'[listbox\']")));
		if (banklist.size() >= 0) {
			System.out.println(banklist.size());
			
		    banklist.get(1).click();  // 2nd element (index starts from 0)
		} else {
		    System.out.println("Not enough options in the list.");
		}
		
		
//		Bankcode.sendKeys(null);
//		EnterBranchcode.sendKeys(null);
//		Enterbranchname.sendKeys(null);
//		
	}
	

}
