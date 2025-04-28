package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Event;

import PageObject.AddBankAcc;
import PageObject.EventCreation;
import PageObject.Login;
import PageObject.Newmsq;
import PageObject.Registration;
import PageObject.Searchuser;
import PageObject.SupplierAndProduct;
import PageObject.Ticketcreation;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;




public class StepDef extends BaseClass {
	///launch browser////
	@Before
	public void setup() {
		readConfig=new ReadConfig();
		log	= LogManager.getLogger("StepDef");	
		String browserff=readConfig.getbrowser();
	
		// Launch broswer///
	switch (browserff.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    log.info("Setup executed...");
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    log.info("Setup executed...");
		break;
		
	case "msedge":
		WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	    log.info("Setup executed...");
		break;
	default:
		if (driver == null) {
	        throw new RuntimeException("WebDriver is not initialized!");
	    }
		}
		
	    
	    
		}
		

	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    
	    // Optional: Maximize the browser window
	    driver.manage().window().maximize();

	    // Optional: Set implicit wait (if needed for page loading or element detection)
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    // Initialize  page object
	    loginpg = new Login(driver);
	    evntcre=new EventCreation(driver);
	    usersrch=new Searchuser(driver);
	    Newmosque=new Newmsq(driver);
	    addbank= new AddBankAcc(driver);
	    ticketcreation=new Ticketcreation(driver);
	    reg=new Registration(driver);
	    supandProd=new SupplierAndProduct(driver);
	   
	    log.info("User Launch  browser");
	    }

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("Url open");
	}

	@When("User Enters email as {string}")
	public void user_enters_email_as(String em) {
		loginpg.enterem(em);
		log.info("Valid Email address..");
	}

	@When("Click on login")
	public void click_on_login() {
		loginpg.clickonlogin();
		log.info("Clicked on Loginbutton");
	}

	@When("User Enters OTP  as {string}")
	public void user_enters_otp_as(String otpenter) {
		loginpg.enterOtp(otpenter);
		log.info("enter Valid OTP");
	}

	@When("Click on Verify and continue")
	public void click_on_verify_and_continue() {
		loginpg.clickoncontinue();
		log.info("click on continue");
	}

//	@Then("Page Title should be {string}")
//	public void page_title_should_be(String expectedTitle) {
//		String actualTitle=driver.getTitle();
//		
//		
//		if (actualTitle.equals(expectedTitle)) {
//			
//           Assert.isTrue(false, expectedTitle);
//            }
//		else
//			{
//			Assert.isTrue(false, actualTitle);
//			}

	

	@Then("Click on profile settings")
	public void click_on_profile_settings() {
		loginpg.clickonprofile();
		log.info("Click on profile");
		}

	@Then("Click on Logout")
	public void click_on_logout() {
		loginpg.clickonLogout();
		log.info("click on Logout");
	}
	////Registration///////////
	@Then("user clicks on signup")
	public void user_clicks_on_signup() {
		reg.clickonreg();
	}

	@Then("User Enter Valid name as {string}")
	public void user_enter_valid_name_as(String nme) {
	   reg.entername(nme);
	}

	@Then("User Enter Valid Email as {string}")
	public void user_enter_valid_email_as(String emadd) {
	   reg.enteremail(emadd);
	}

	@Then("User Enter Valid Number as {string}")
	public void user_enter_valid_number_as(String phne) {
	   reg.enterNum(phne);
	}

	@Then("Click on Continue")
	public void click_on_continue() {
	    reg.clickonok();
	}

	@Then("Enter the Valid Otp as {string}")
	public void enter_the_valid_otp_as(String otp) {
	   reg.enterotp(otp);
	}

	@Then("Verifikasi & Lanjutkan")
	public void verifikasi_lanjutkan() {
	   reg.clickoncontinue();
	}



	/////////Slecct lang//////////
	@When("Click on the Language")
	public void click_on_the_language() {
		evntcre.clickonlang();
		log.info("click on Langauage selection");

	}
	/////Select english lang///////
	@When("Select English")
	public void select_english() {
		evntcre.eng();
		log.info("Select English");
	}
	
	//////Create event////////////
	@Then("click on Events")
	public void click_on_events() {
		evntcre.clickonevent();
		log.info("click on Event...");
	    
	}

	@Then("Click on Create event")
	public void click_on_create_event() {
		evntcre.clickoncreate();
		//evntcre.scrollDown(500);
		
	}

	@Then("Enter event info")
	public void enter_event_info() throws InterruptedException    {
		evntcre.enterevtname("Event");
		evntcre.enterdescription("Nice");
		evntcre.clickonDate();
		evntcre.clickoneventdate();
		evntcre.clickoneventhour();
		evntcre.clickoneventmin();
		
		evntcre.clicksaveandcontinue1();
		
		evntcre.paidregistration();
		evntcre.startdate();
		evntcre.selectregistrationstartdate();
		evntcre.selectregistrationstarthour();
		evntcre.selectregistrationstartmin();
		evntcre.enddate1();
		evntcre.clickondate1();
		evntcre.clickonhours();
		evntcre.clickonmin();
		evntcre.clickonradiobuttonunlimited();
		
		
		evntcre.clickonsaveandcontinue2();

	
		evntcre.clickonsaveandcontinue3();
		
		
	   
	}

	@Then("Save and continue")
	public void save_and_continue() {
		evntcre.clickonsaveandcontnue4();
	}
	
	////// Add inventory under mosque management/////////////
	@Then("Clicks on Mosque Maagement")
	public void clicks_on_mosque_maagement() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on inventory")
	public void click_on_inventory() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on stock-in")
	public void click_on_stock_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Enter the details")
	public void Enter_the_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on Add button")
	public void Click_on_add_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("check the add list should be displayed")
	public void check_the_add_list_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	//////////Add product Threshold under mosque management////////

	@Then("click on Mosque Maagement")
	public void click_on_mosque_maagement() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("click on Product threshold")
	public void click_on_product_threshold() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("click on Add button")
	public void click_on_add_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("add details in popup page")
	public void add_details_in_popup_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Select on add to save the details")
	public void select_on_add_to_save_the_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("check the added product should be displayed")
	public void check_the_added_product_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	////////////Add suplier name under master name/////////
	@Then("click on Master data")
	public void click_on_master_data() {
		supandProd.clickonmaster();
	}

	@Then("click on supplier option")
	public void click_on_supplier_option() {
	    supandProd.clickonSupplier();
	}
	@Then("Click on Add button1")
	public void Click_on_Add_button() {
	    supandProd.clickonAdd(); // calling method from Page Object class
	}

	@Then("Enter the details {string}, {string}, {string}, {string}")
	public void enter_the_details(String name, String address, String mobile, String email) {
		supandProd.EnterTheDetails(name, address, mobile, email);
	}

	@Then("select on  add to save details")
	public void select_on_add_to_save_details() {
		supandProd.clickonAddtoSave();
	    
	}

	@Then("Verify the added Suplier {string} name should be dsiplayed")
	public void verify_the_added_suplier_name_should_be_dsiplayed(String expectedSupplierEmail) {
		supandProd.verifyAddedSupplier(expectedSupplierEmail);
		boolean isDisplayed = supandProd.verifyAddedSupplier(expectedSupplierEmail);
		 WebElement addedSupplierEmail = driver.findElement(By.xpath("//td[contains(text(),'" + expectedSupplierEmail + "')]"));
		    
		    Assert.assertTrue(addedSupplierEmail.isDisplayed());
	    Assert.assertTrue("Supplier '" + expectedSupplierEmail + "' was not found in the list!", isDisplayed);
	   
	}

	
	///////Add product under masterdata/////////
	@Then("click on Master datas")
	public void click_on_master_datas() {
		supandProd.clickonmaster();
	
	}
	@Then("click on products menu option")
	public void click_on_products_menu_option() {
		supandProd.scroll();
		supandProd.clickonProductmenu();
	    
	}
	@Then("Click on Add buttons")
    public void click_on_add_buttons() {
		supandProd.clickonAdd2();
    }

    @Then("Enter the details {string},{string}")
    public void enter_the_details(String categoryName, String descName) {
    	supandProd.enterCatName(categoryName, descName);
        
    }

    @Then("select on add to save details")
    public void select_on_add_to_save_details1() throws InterruptedException {
    	supandProd.clickonAdd3toSave();
    	Thread.sleep(2000);
    	supandProd.scroll();
    	
    }

    @And("Check the added product {string} name should be dsiplayed")
    public void check_the_added_product_name_should_be_displayed(String catName) throws InterruptedException  {
    	Thread.sleep(2000);
    	supandProd.extendpage();
    	Thread.sleep(2000);
    	supandProd.productAddedorNot(catName);
        
    }

    @And("click on three dotted menu")
    public void click_on_three_dotted_menu() {
    }

    @Then("click on subcategory")
    public void click_on_subcategory() {
    	supandProd.clickonsubcat();
    }

    @And("click on Add_option inside subcategory")
    public void click_on_add_option_inside_subcategory() {
    }

    @And("Enter the sub category details {string},{string}")
    public void enter_sub_category_details(String subCategoryName, String subCategoryDesc) {
      
    }

    @And("click on Add option")
    public void click_on_add_option() {
        
    }

    @And("check added list {string} should be displayed")
    public void check_added_list_should_be_displayed(String subCatName) {
       
        }

	
	////click on identity access///////////
	@Then("Click on identity access menubar")
	public void click_on_identity_access_menubar() {
		usersrch.clickonidentity();
		log.info("clicked on clickonidentity");
	}
	
	/////////users search button/////////
	@Then("Click on Registered users")
	public void click_on_registered_users() {
		usersrch.clickonregistereduser();
		log.info("clicked on registered user option");
	}

	@Then("Enter a Emailid to search")
	public void enter_a_emailid_to_search() {
		usersrch.enteremailid("ha");
		log.info("Entered only two character email address ");
	}

	@Then("Enter on Search button")
	public void enter_on_search_button() {
		usersrch.searchemailadd();
		log.info("clicked on search button");
	}

	@Then("User should found the emailin search")
	public void user_should_found_the_emailin_search() {
		String expectedemail="haridg@gmail.com";
		
		if(usersrch.searchuseemailid(expectedemail)==true)
		{
			Assert.assertTrue(true);
			log.info("User should be able to found searhced email in the table -- Passed ");
		}else
			Assert.assertTrue(false);
			log.info("User didnot  be able to found searhced email in the table -- Failed ");
	}
	
	//////////ope new mosque////////
	@Then("Click on Ministry siloutte")
	public void click_on_ministry_siloutte() {
		Newmosque.clickonMSmenu();
	}

	@Then("click Registered Mosques")
	public void click_registered_mosques() {
		Newmosque.Selectregisteredmsq();
	}

	@Then("Click on Mosque Name")
	public void click_on_mosque_name() {
		Newmosque.clickonmosque();
	}
	
	
	@Then("get the mosque text")
	public void get_the_mosque_text() {
		Newmosque.switchToTab(1);
		Newmosque.performActionOnmasterdata();
		//Newmosque.switchToTabAndPerformAction(); // Switch to tab and perform the action
	    System.out.println("Completed action on Identity & Access in the second tab.");
	}
	
	@Then("Get the name and print it")
	public void get_the_name_and_print_it() {
	     Newmosque.getname(); // Call the getName() method
	     // Print the name
	}
	
	
	///////Enabling the radio button to member////////////
	@Given("User clicks on identity access")
	public void user_clicks_on_identity_access() {
		Newmosque.clickonidentityaccess();
	   
	}

	@Then("User clicks on roles options")
	public void user_clicks_on_roles_options() {
	   Newmosque.Clickonrolesandfunctions();
	}

	@Then("Click on Members three dotted menu")
	public void click_on_members_three_dotted_menu() {
		Newmosque.searchmember("Member");
	  
	}

	@Then("Click on Action option")
	public void click_on_action_option() {
		
		Newmosque.clickonActionbutton();
	
	}

	@Then("Enable Dashord button and click on ok buton")
	public void enable_dashord_button_and_click_on_ok_buton() throws InterruptedException {
		Newmosque.clickonradiobuttonundermember();
		Thread.sleep(3000);
		Newmosque.clickonok();
	    
	}

	@Then("Go to the Dashboard and enable the button")
	public void go_to_the_dashboard_and_enable_the_button() {
		
	}
	
	///  creating bank account//////
//	@Then("click on masterdata")
//	public void click_on_masterdata() {
//		addbank.Masterdata();
//		
//	}

	@Then("clicks on Banks account")
	public void clicks_on_banks_account() {
		addbank.bankacc(); 
	}

	@Then("Click on add button")
	public void click_on_add_tobutton() {
	   addbank.addbutton();
	}

	@Then("Enter the deatails and click on Add button")
	public void enter_the_deatails_and_click_on_add_button() {
		addbank.enterdetails();
	    
	}

	@Then("Check added account is displaying")
	public void check_added_account_is_displaying() {
	   
	}
	
	////Create SMS Ticket////////
	@Then("click on Managament hub")
	public void click_on_managament_hub() {
	    ticketcreation.clickonMangmntHub();
	}

	@Then("clicks on Service management")
	public void clicks_on_service_management() {
		ticketcreation.clickonSMS();
	}

	@Then("Click on Any tabs")
	public void click_on_any_tabs() {
	    ticketcreation.clickonbox();
	}

	@Then("click on New button")
	public void click_on_new_button() {
	   ticketcreation.clickonNew();
	}

	@Then("Enter the Details")
	public void enter_the_details() {
		ticketcreation.Category();
	   
	}
	//@After
	public void teardown(Scenario sc) {
		if(sc.isFailed()) {
			String filepath="C:\\Users\\Harish\\Desktop\\selenium islaam\\isalaam\\Screenshot\\Test.png";
			TakesScreenshot scrshot=((TakesScreenshot)driver);
			File scrfile=scrshot.getScreenshotAs(OutputType.FILE);
			File destfile= new File(filepath);
			try {
				FileUtils.copyFile(scrfile, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//driver.quit();
	}
	@AfterStep
	public void screenshotafterfailedcases(Scenario scenario) {
		
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//attact image  file report(data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
		
	}

}
