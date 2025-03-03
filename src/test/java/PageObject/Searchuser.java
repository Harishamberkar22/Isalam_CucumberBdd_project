package PageObject;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchuser {
	WebDriver ldriver;
	
	public  Searchuser(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
		}
	
	@FindBy(xpath ="/html/body/app-root/layout/classic-layout/fuse-vertical-navigation/div/div[2]/fuse-vertical-navigation-collapsable-item[2]/div[1]/div")
	WebElement identityandaccess;
	
	@FindBy(xpath = "//a[@href=\"/isalaamstaging/users/registeredusers\"]")
	WebElement userregisters;
	
	@FindBy(xpath="//input[@formcontrolname=\"emailId\"]")
	WebElement EmailAdd;
	
	@FindBy(xpath="//span[contains(text(),'Search')]")
	WebElement search;
	
	@FindBy(xpath = "//thead[@role='rowgroup']")
	WebElement searchresult;
	
	@FindBy(xpath = "//table[@role=\"table\"]//tbody/tr")
	List<WebElement> tablerows;
	
	
	public void clickonidentity()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		identityandaccess.click();
	}
	
	public void clickonregistereduser() {
		userregisters.click();
	}
	public void enteremailid(String email) {
		EmailAdd.sendKeys(email);
	}
	public void searchemailadd() {
		search.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean searchuseemailid(String expectedemail) {
		//System.out.println(expectedemail);
		boolean found=false;
		///total no of rows in table/
		int ttlrows=tablerows.size();
		
		
		for(int i=1;i<=ttlrows;i++) {
			System.out.println("Searching row:" +i );
			WebElement webelementemail= ldriver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr[" + i + "]/td[3]"));
			WebElement webelementemail1= ldriver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr[" + i + "]/td[8]"));
			String actualadd=webelementemail.getText();
			
			
			if(actualadd.equals(expectedemail)) {
				found=true;
				
				System.out.println("Actual= "+ actualadd + "  "+ "  expectedemail= " +expectedemail);
				System.out.println("Searcheduser status= "+webelementemail1.getText());
			}
		}
		return found;
	}
	
}
