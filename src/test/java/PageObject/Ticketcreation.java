package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ticketcreation {
	WebDriver ldriver;
	WebDriverWait wait;
	public Ticketcreation(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath="//span[contains(text(),' Management Hub ')]")
	WebElement clickonMH;
	
	@FindBy(xpath = "//span[contains(text(),' Service Management ')]")
	WebElement clickonSM;
	
	@FindBy(xpath="(//div[@class=\"card ng-star-inserted\"])[1]")
	WebElement clickonTab;
	
	@FindBy(xpath="//span[contains(.,' New')]")
	WebElement clickonNew;

	////ticket details element////////
	@FindBy(xpath="//mat-select[@id=\"mat-select-46\"]")
	WebElement clickoncategory;
	
	@FindBy(xpath="//mat-option[@id=\"mat-option-73\"]")
	WebElement selectcategory;
	
	@FindBy(xpath="//div[@id=\"mat-select-value-57\"]")
	WebElement clickonsubctgry;
	
	@FindBy(xpath="//mat-option[@id=\"mat-option-99\"]")
	WebElement clickonplastic;
	
	@FindBy(xpath = "//div[@id=\"mat-select-value-59\"]")
	WebElement clickonselectproducts;
	
	@FindBy(xpath="//mat-option[@id=\"mat-option-100\"]")
	WebElement selectChair;
	
	@FindBy(xpath = "//div[@id=\"mat-select-value-61\"]")
	WebElement clickonvendor;
	
	@FindBy(xpath = "//input[@formcontrolname='visitTimeFrom']")
	WebElement clickonscheduleFrom;
	
	@FindBy(xpath = "(//td[4])[1])")
	WebElement selectdatefrom;
	
	@FindBy(xpath="(//div[contains(.,\" 6 \")])[7]")
	WebElement selecttime1;
	
	@FindBy(xpath = "(//div[contains(.,\" 30 \")])[7]")
	WebElement selectseconds1;
	
	@FindBy(xpath = "//input[@formcontrolname='visitTimeTo']")
	WebElement selectvisitimeTo;
	
	@FindBy(xpath = "(//div[contains(.,\" 10 \")])[5]")
	WebElement selectdateTo;
	
	@FindBy(xpath="(//div[contains(.,\" 6 \")])[7]")
	WebElement selecttime2;
	
	@FindBy(xpath = "(//div[contains(.,\" 30 \")])[7]")
	WebElement selectseconds2;
	
	@FindBy(xpath="//input[@formcontrolname=\"natureOfFault\"]")
	WebElement Entercomplaint;
	
	@FindBy(xpath="//textarea[@formcontrolname=\"adminDescription\"]")
	WebElement Enterdescription;
	
	@FindBy(xpath="//input[@formcontrolname=\"quantity\"]")
	WebElement quantity;
	
	@FindBy(xpath = "//button[@mattooltip=\"Upload File\"]")
	WebElement fileupload;
	
	@FindBy(xpath="//span[contains(.,\"Create\")]")
	WebElement clickoncreate;
	
	
	
	
	
	
	public void clickonMangmntHub() {
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;

		js.executeScript("document.body.style.zoom='80%'");

//		js.executeScript("window.scrollBy(0, 500);");
//		js.executeScript("arguments[0].scrollIntoView(true);", clickonMH);
//		js.executeScript("arguments[0].click();", clickonMH);
		
//		wait =new WebDriverWait(ldriver, 15);
//		WebElement clickonsms1=	wait.until(ExpectedConditions.visibilityOf(clickonMH));
//		System.out.println(clickonsms1.getText());
//		WebElement clickonsms=	wait.until(ExpectedConditions.elementToBeClickable(clickonMH));
//		
		
		
		//clickonMH.click();
	}
	public void clickonSMS() {
		wait =new WebDriverWait(ldriver, 10);
		WebElement clickonsms1=	wait.until(ExpectedConditions.visibilityOf(clickonSM));
		System.out.println(clickonsms1.getText());
		WebElement clickonsms=	wait.until(ExpectedConditions.elementToBeClickable(clickonSM));
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickonSM);
		js.executeScript("arguments[0].click();", clickonSM);
		clickonsms.click();
	}
	
	public void clickonbox() {
		clickonTab.click();
	}
	
	public void clickonNew() {
		
		clickonNew.click();
	}
	
	public void Category() {
		wait =new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickoncategory)).click();
		//clickoncategory.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> options = ldriver.findElements(By.xpath("//mat-option[@role='option']"));

		if (options.size() >= 1) { // Ensure there are at least two options
		    options.get(0).click(); // Index 1 represents the second option
		} else {
		    System.out.println("Less than two options available.");
		}
	}

	public void clicksubcategory() {
		clickonsubctgry.click();
		clickonplastic.click();
	}
	
	public void clickonselectproducts() {
		clickonselectproducts.click();
		
	}

}


	
	
	
	
//	// Get all list items
//	List<WebElement> users = dropdown.findElements(By.tagName("mat-option"));
//
//	
//	if (index < users.size()) {
//	    users.get(2).click();
//	} else {
//	    
//	}
//
//	}}
