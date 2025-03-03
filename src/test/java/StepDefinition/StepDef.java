package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.dockerjava.api.model.Event;

import PageObject.EventCreation;
import PageObject.Login;
import PageObject.Newmsq;
import PageObject.Searchuser;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
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


;

public class StepDef extends BaseClass {
	
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
			driver=null;
			break;
		}
		
	    
	    
		}
		

	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    
	    // Optional: Maximize the browser window
	    driver.manage().window().maximize();

	    // Optional: Set implicit wait (if needed for page loading or element detection)
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    // Initialize Login page object
	    loginpg = new Login(driver);
	    evntcre=new EventCreation(driver);
	    usersrch=new Searchuser(driver);
	    Newmosque=new Newmsq(driver);
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
	
	@After
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

}
