package PageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventCreation {

	WebDriver ldriver;
	public EventCreation(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath ="/html/body/app-root/layout/classic-layout/div/div[1]/div/languages/button")
	WebElement Lang;

	@FindBy(xpath = "//*[@id='mat-menu-panel-0']/div/button[2]")
	WebElement engli;

	@FindBy(xpath = "//span[contains(text(), 'Islamic Events')]")
	WebElement Event;

	@FindBy(xpath= "//span[contains(text(), 'Create Event')]")
	WebElement createevent;

	@FindBy(xpath = "//input[@formcontrolname=\'eventName\']")
	WebElement entereventname;



	@FindBy(xpath = "//textarea[@formcontrolname=\'eventDescription\']")
	WebElement enterdescription;

	@FindBy(xpath = "//input[@formcontrolname=\"eventDate\"]")
	WebElement clickondatelabel;

	@FindBy(xpath = "//div[2]/mat-datetimepicker-month-view/table/tbody/tr[2]/td[6]/div")
	WebElement clickoneventdate;

	@FindBy(xpath="//div[2]/mat-datetimepicker-clock/div/div[3]/div[7]")
	WebElement clickoneventhour;

	@FindBy(xpath="//mat-datetimepicker-clock/div/div[4]/div[7]")
	WebElement clickoneventmin;

	@FindBy(xpath = "//div/form/div[6]/button[1]/span[2]")
	WebElement saveandcontinue1;

	///////////////second page
	@FindBy(xpath = "//*[@id=\"mat-radio-3\"]/div/label")
	WebElement No;

	@FindBy(xpath="//input[@formcontrolname=\"registrationDateFrom\"]")
	WebElement registrationstartdate;

	@FindBy(xpath = "//*[@id=\"mat-datetimepicker-1\"]/div[2]/mat-datetimepicker-month-view/table/tbody/tr[2]/td[4]/div")
	WebElement registrationselectdate;

	@FindBy(xpath = "//div[2]/mat-datetimepicker-clock/div/div[3]/div[7]")
	WebElement registrationselecthour;

	@FindBy(xpath = "//div[2]/mat-datetimepicker-clock/div/div[4]/div[7]")
	WebElement registrationselectmin;

	@FindBy(xpath="//input[@formcontrolname=\"registrationDateTo\"]")
	WebElement registrationenddateto;

	@FindBy(xpath="//*[@id=\"mat-datetimepicker-2\"]/div[2]/mat-datetimepicker-month-view/table/tbody/tr[2]/td[5]/div")
	WebElement selectenddate;

	@FindBy(xpath = "//div[2]/mat-datetimepicker-clock/div/div[3]/div[7]")
	WebElement selecthours;

	@FindBy(xpath ="//div[2]/mat-datetimepicker-clock/div/div[4]/div[7]")
	WebElement selectmin;

	@FindBy(xpath = "//label[contains(text(), 'Unlimited')]")
	WebElement clickonunlimited;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/mat-dialog-container/div/div/app-create-update-event/div[2]/mat-stepper/div[2]/div/div/div/form/div[7]/button[1]/span[1]")
	WebElement saveandcontinue2;

	////////third page/////////////////
	@FindBy(xpath = "//div/form/div[4]/button[1]/span[2]")
	WebElement saveandcontinue3;
	//// 4thpage/////
	@FindBy(xpath = "//div/div[16]/button[1]/span[2]")
	WebElement savenandcontinue4;







	public void clickonlang() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lang.click();
	}

	public void eng() {
		engli.click();
	}

	public void clickonevent() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Event.click();
	}

	public void clickoncreate() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createevent.click();  
		//scrollDown(500);
	}
	//		public void scrollDown(int pixels) {
	//	        JavascriptExecutor js = (JavascriptExecutor) ldriver;
	//	        js.executeScript("window.scrollBy(0," + pixels + ");");
	//	    }
	//		public void scrollToElement(WebElement element) {
	//	        JavascriptExecutor js = (JavascriptExecutor) ldriver;
	//	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	//	    }

	public void enterevtname(String name) {
		entereventname.click();
		entereventname.sendKeys(name);
	}
	public void enterdescription(String desc) {
		enterdescription.sendKeys(desc);
	}

	public void clickonDate()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickondatelabel.click();
	}
	public void clickoneventdate()  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickoneventdate.click();
	}
	public void clickoneventhour() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickoneventhour.click();
	}
	public void clickoneventmin() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickoneventmin.click();
	}
	public void clicksaveandcontinue1() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveandcontinue1.click();

	}
	///second screen/////
	public void paidregistration() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		No.click();

	}




	public void startdate() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registrationstartdate.click();
	}
	public void selectregistrationstartdate() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registrationselectdate.click();
	}
	public void selectregistrationstarthour() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registrationselecthour.click();

	}
	public void selectregistrationstartmin() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registrationselectmin.click();
	}
	public void enddate1() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registrationenddateto.click();

	}
	public void clickondate1()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectenddate.click();
	}
	public void clickonhours() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selecthours.click();
	}

	public void clickonmin() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectmin.click();

	}

//	public void clickonradiobuttonunlimited() {
//		clickonunlimited.click();
//		System.out.println("dateclicked");
//		
//			
//		
//		JavascriptExecutor js = (JavascriptExecutor) ldriver;
//
//		// Scroll to the "Save and Continue" button before clicking
//		js.executeScript("window.scrollBy(0, 5000);");
//		
//		
//	}
	public void clickonradiobuttonunlimited() {
	    clickonunlimited.click();
	    System.out.println("Radio button clicked");

	   
	}

	  
	

	public void clickonsaveandcontinue2() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions actions = new Actions(ldriver);

        // Simulate pressing "Enter" key
        actions.sendKeys(Keys.ENTER).perform();
        System.out.println("Pressed Enter globally");
		
		//saveandcontinue2.click();
	}


	public void clickonsaveandcontinue3() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveandcontinue3.click();
	}
	public void clickonsaveandcontnue4() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savenandcontinue4.click();

	}

}