package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features ={".//Featuresfiles/Event.feature"},
		glue= "StepDefinition",
		tags="@product_categories",
		dryRun=false,
		monochrome =false,
		plugin = {"html:target/cucumberreport.html","pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: "}
		//plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}		
		//plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: "}
		)

public class Run extends AbstractTestNGCucumberTests{
	

}
