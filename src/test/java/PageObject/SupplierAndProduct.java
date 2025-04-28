package PageObject;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

public class SupplierAndProduct {
	WebDriver ldriver;
	WebDriverWait wait ;
	public SupplierAndProduct(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	///// Adding New supplier////////////
	@FindBy(xpath="//span[contains(text(),' Suppliers ')]")
	WebElement suppliers;
	
	@FindBy(xpath="//span[contains(text(),'Add')]")
	WebElement Addbutton;
	
	@FindBy(xpath = "//input[@formcontrolname=\"supplierName\"]")
	WebElement Suppliername;
	
	@FindBy(xpath="//input[@formcontrolname=\"supplierAddress\"]")
	WebElement supplierAdd;
	
	@FindBy(xpath = "//input[@id=\"phoneNumber\"]")
	WebElement numphone;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath = "(//span[contains(text(),'Add')])[2]")
	WebElement Addtosave;
	
	@FindBy(xpath ="//span[contains(text(),' Master Data ')]")
	WebElement MasterData;
	
	///////////////Product category locators////////////////
	@FindBy(xpath = "//span[contains(text(), 'Products')]")
	WebElement product;
	
	@FindBy(xpath ="//span[contains(text(),' Add ')]")
	WebElement Add2 ;
	
	@FindBy(xpath ="//input[@formcontrolname=\"categoryName\"]")
	WebElement categoryName;
	
	@FindBy(xpath ="//textarea[@formcontrolname=\"categoryDescription\"]")
	WebElement categoryDesc ;
	
	@FindBy(xpath ="(//span[contains(text(),'Add')])[2]")
	WebElement Add3;
	
	@FindBy(xpath="//mat-select[@id=\"mat-select-0\"]")
	WebElement pagination;
	
	@FindBy(xpath = "//span[text()='Sub-Categories']")
	WebElement subcat;
	
	///// Product Action methods///////////
	
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void clickonProductmenu() {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();
		
		WebDriverWait wait = new WebDriverWait(ldriver, 10);
		WebElement pagination=ldriver.findElement(By.xpath("//button[@aria-label=\"Next page\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(pagination)).click();
	}
		
	public void clickonAdd2() {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(Add2));
		Add2.click();
		
		
	}
	
	public void enterCatName(String cat_Name, String des_Name) {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.visibilityOf(categoryName));
		categoryName.sendKeys(cat_Name);
		
		wait.until(ExpectedConditions.visibilityOf(categoryDesc));
		categoryDesc.sendKeys(des_Name);
		
		WebDriverWait wait = new WebDriverWait(ldriver, 10);

		
}
	
	
	
	public void clickonAdd3toSave() {
		
	wait=new WebDriverWait(ldriver, 2000);
	wait.until(ExpectedConditions.elementToBeClickable(Add3)).click();
		
		// Wait for the toast to appear
				WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//div[@id='toast-container']")
				));

				// Use JavascriptExecutor to get the text
				JavascriptExecutor js = (JavascriptExecutor) ldriver;
				String toastText = (String) js.executeScript(
				    "return arguments[0].innerText;", toastElement
				);

				System.out.println("Toast Message: " + toastText);
	
		
	}
	public void extendpage() {
		
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
	// Get all options
	List<WebElement> options = ldriver.findElements(By.xpath("//mat-option[@role='option']"));

	// Click the second one using JavaScript
	js.executeScript("arguments[0].click();", options.get(2));
	
}
	
	public int productAddedorNot(String ProdName)  {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//table[@role='table']//tbody/tr")));
		int ttlrows = ldriver.findElements(By.xpath("//table[@role='table']//tbody/tr")).size();
        boolean found = false;

        for (int i = 1; i <= ttlrows; i++) {
            System.out.println("Checking row " + i);
            try {
                
                WebElement categoryCell = ldriver.findElement(
                    By.xpath("//table[@role='table']//tbody/tr[" + i + "]/td[1]"));

                String actualCategory = categoryCell.getText().trim();
                System.out.println("Found category: " + actualCategory);
               

                if (actualCategory.equalsIgnoreCase(ProdName)) {
                    System.out.println("Product matched: " + actualCategory);
                    return i;


                    
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element at row " + i + ", re-trying...");
                i--; // Re-try current index on next iteration
            } catch (Exception e) {
                System.out.println("Error on row " + i + ": " + e.getMessage());
            }
        }

        if (!found) {
            System.out.println("Newly added category not found: " + ProdName);
            
		}
        return -1;

	}
	public void clickThreeDottedMenu(int rowIndex) {
	    if (rowIndex <= 0) {
	        System.out.println("Invalid row index. Cannot click 3-dotted menu.");
	        return;
	    }

	    try {
	        WebElement threeDotsBtn = ldriver.findElement(
	            By.xpath("//table[@role='table']//tbody/tr[" + rowIndex + "]//td[last()]//button"));
	        threeDotsBtn.click();
	        System.out.println("Clicked three-dotted menu at row: " + rowIndex);
	    } catch (Exception e) {
	        System.out.println("Failed to click three-dotted menu: " + e.getMessage());
	    }
	}

	public void clickonsubcat() {
		wait=new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(subcat));
		subcat.click();
	}
	
	
	
	/////suppliers Action methods//////
	public void clickonmaster() {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(MasterData));
		MasterData.click();
	}
	
	public void clickonSupplier() {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(suppliers));
		suppliers.click();
	}
	
	public void clickonAdd() {
		wait=new WebDriverWait(ldriver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(Addbutton));
		Addbutton.click();
	}
	
	public void EnterTheDetails(String supplierName, String supAddress, String supMobile, String supEmail) {
		wait=new WebDriverWait(ldriver, 2000);
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		wait.until(ExpectedConditions.visibilityOf(Suppliername));
	    js.executeScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'));", Suppliername, supplierName);
		
	    wait.until(ExpectedConditions.visibilityOf(supplierAdd));
	    js.executeScript("arguments[0].value=arguments[2]; arguments[0].dispatchEvent(new Event('input'));", supplierAdd, supAddress);

	    wait.until(ExpectedConditions.visibilityOf(numphone));
	    js.executeScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'));", numphone, supMobile);

	    wait.until(ExpectedConditions.visibilityOf(email));
	    js.executeScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'));", email, supEmail);
	}
	
	public void clickonAddtoSave() {
		wait.until(ExpectedConditions.elementToBeClickable(Addtosave));
		Addtosave.click();
	}
	
	public boolean verifyAddedSupplier(String expectedSupplierName) {
	    wait = new WebDriverWait(ldriver, 10);

	    // Wait until the table with supplier list is visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

	    // Use a dynamic XPath to locate the supplier name in the list
	    List<WebElement> supplierNames = ldriver.findElements(By.xpath("//table//tr/td[4]"));

	    
	    boolean found = false;

	    for (int i = 0; i < supplierNames.size(); i++) {
	    	System.out.println(supplierNames.size());
	        String actualName = supplierNames.get(i).getText();
	        if (actualName.equals(expectedSupplierName)) {
	            found = true;
	            break;
	        }
	    }

	    if (found) {
	        System.out.println("Supplier '" + expectedSupplierName + "' is displayed in the list.");
	    } else {
	        System.out.println("Supplier '" + expectedSupplierName + "' is NOT found in the list.");
	    }
		return found;
	    

	    // Optionally use an assertion if you're using TestNG
	   // Assert.assertTrue(isFound, "Supplier name '" + expectedSupplierName + "' not found in the list!");
	}
	
	
	
	
	
	
}
