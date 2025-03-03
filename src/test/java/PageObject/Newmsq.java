package PageObject;

import java.util.*;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newmsq {

WebDriver ldriver;
	public Newmsq(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		@FindBy(xpath = "//span[contains(.,'Ministry Silhouette')]")
		WebElement MSMenu;
		
		@FindBy(xpath = "//span[contains(.,' Registered Mosques ')]")
		WebElement clickonregisteredmsq;
		
		@FindBy(xpath = "//a[contains(., 'New Mosque')]")
		WebElement clickonmosquehyperlink;
		
		/////new tab/////////
		@FindBy(xpath = "/html/body/app-root/layout/classic-layout/div[1]/div/div[1]/span")
		WebElement Getmsqname;
		
		@FindBy(xpath = "/html/body/app-root/layout/classic-layout/fuse-vertical-navigation/div/div[2]/fuse-vertical-navigation-collapsable-item[1]/div")
		WebElement Masterdata;
		
		////clickonidentityaccess///
		@FindBy(xpath="/html/body/app-root/layout/classic-layout/fuse-vertical-navigation/div/div[2]/fuse-vertical-navigation-collapsable-item[2]/div[1]/div")
		WebElement identityacces;
		
		@FindBy(xpath= "//span[contains(text(),' Roles, Menus & Functions')]")
		WebElement Rolesandfunctions;
		
		@FindBy(xpath="//input[@id=\"mat-input-0\"]")
		WebElement Searchbuton;
		
		
		@FindBy(xpath="//table[@role=\"table\"]//tbody/tr")
		WebElement searchmember;
		
		@FindBy(xpath="/html/body/app-root/layout/classic-layout/div[2]/div[2]/app-menu-mapping/div/div/div[3]/div/table/tbody/tr/td[4]/button/mat-icon")
		WebElement Actionbutton;
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/button/span")
		WebElement clickonactionbutton;
		
		@FindBy(xpath="//table[@role=\"table\"]//tbody/tr[2]/td[5]")
		WebElement Clickonradiobutton;
		
		@FindBy(xpath = "//span[normalize-space(text())='Ok']")
		WebElement clickonokaybutton;
		
		
		
		public void clickonMSmenu()  {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MSMenu.click();
		}
		
		public void Selectregisteredmsq() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clickonregisteredmsq.click();
		}
		
		public void clickonmosque() {
			
			
			clickonmosquehyperlink.click();
			
		}
		// Switch to a specific tab by index
	    public void switchToTab(int tabIndex) {
	        // Get all window handles
	        Set<String> handles = ldriver.getWindowHandles();
	        List<String> windowList = new ArrayList<>(handles);

	        // Check if tab index is valid
//	        if (tabIndex < 0 || tabIndex >= windowList.size()) {
//	            throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
//	        }

	        // Switch to the desired tab
	        ldriver.switchTo().window(windowList.get(tabIndex));
	        System.out.println("Switched to tab " + tabIndex + ": " + ldriver.getTitle());
	    }

	    // Perform action on Identity & Access
	 
//	    public void switchToTabAndPerformAction() {
//	        // Switch to the second tab (index 1)
//	        switchToTab(1);
//	        performActionOnIdentityAccess(); // Only call this method to avoid redundancy
//	    }
	    
	    public void getname() {
	    	try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	WebElement name1=ldriver.findElement(By.xpath("/html/body/app-root/layout/classic-layout/div[1]/div/div[1]/span"));
	    	String nameText = name1.getText(); // Fetch the text of the element
	        System.out.println("Name retrieved: " + nameText); // Optional: Print the text for debugging
	       // return; // Return the fetched text
	    	
	    }
		
	    public void performActionOnmasterdata() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable(Masterdata));
	    	List<WebElement> elements = ldriver.findElements(By.xpath("/html/body/app-root/layout/classic-layout/fuse-vertical-navigation/div/div[2]/fuse-vertical-navigation-collapsable-item[1]/div"));
	    	System.out.println("Number of matching elements: " + elements.size());
	        try {
	            Thread.sleep(3000); // Optional wait for visibility
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        if (Masterdata.isDisplayed() && Masterdata.isEnabled()) { // Check if the element is clickable
	        	Masterdata.click();
	            System.out.println("Clicked on Identity & Access.");
	        } else {
	            System.out.println("Element is not clickable.");
	        }
	    }

	  /////Enabling the button Member/////
	    public void clickonidentityaccess() {
	    	identityacces.click();
	    }
	    
	    public void Clickonrolesandfunctions() {
	    	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Rolesandfunctions.click();
	    }
	    
	    
	    
	    public void searchmember(String RoleName) {
			//System.out.println(expectedemail);
			boolean found=false;
			Searchbuton.click();
			Searchbuton.sendKeys(RoleName);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			///total no of rows in table/
			List<WebElement> rows = ldriver.findElements(By.xpath("//table[@role='table']//tbody/tr"));
			int rowCount = rows.size(); // Get the number of rows in the table
			WebElement getnameofseatchrole=ldriver.findElement(By.xpath("//table[@role='table']//tbody/tr[1]/td[1]"));
			WebElement clickonmenuonmemberrole=ldriver.findElement(By.xpath("//table[@role='table']//tbody/tr[1]/td[4]"));
			clickonmenuonmemberrole.click();
			System.out.println("Clicked on three dotted menu");
			System.out.println("Searched user roles is member: " + getnameofseatchrole.getText());
			
			System.out.println("Total number of rows: " + rowCount);
			System.out.println(rowCount);
		}
	    
	    public void clickonActionbutton() {
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    	
	    	clickonactionbutton.click();
	    }
	    
	    public void clickonradiobuttonundermember() {
	    		   
	    	Clickonradiobutton.click();
	    }
	    
	    public void clickonok() {
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	clickonokaybutton.click();
	        //handleAlertPopup();
	    	
	    	if(Clickonradiobutton.isEnabled())
	    	{
	    		System.out.println("enabled");
	    	}else {
	    		System.out.println("No");
	    	}
	    }


	    
	    
	    
	    	
	    		
	    	
	    	
	    	
			
		}
 
		
		


