package StepDefinition;

import org.openqa.selenium.WebDriver;

import PageObject.AddBankAcc;
import PageObject.EventCreation;
import PageObject.Login;
import PageObject.Newmsq;
import PageObject.Registration;
import PageObject.Searchuser;
import PageObject.SupplierAndProduct;
import PageObject.Ticketcreation;
import Utilities.ReadConfig;

import java.util.Properties;

//import io.cucumber.core.logging.Logger;
//import org.apache.logging.log4J.*;
import org.apache.logging.log4j.*;
public class BaseClass {
	public static WebDriver driver;
	public Login loginpg;
	public EventCreation evntcre;
	public Searchuser usersrch;
	public Newmsq Newmosque;
	public static Logger log;
	public ReadConfig readConfig;
	public AddBankAcc addbank;
	public Registration reg;
	public Ticketcreation ticketcreation;
	public SupplierAndProduct supandProd;
}

