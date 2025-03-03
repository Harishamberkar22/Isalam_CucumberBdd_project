package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features =".//Featuresfiles/usersearch.feature",
		glue= "StepDefinition",
		//tags="@Regression",
//		dryRun=true,
//		monochrome =true,
		plugin = {"html:target/cucumberreport.html"}
		
		)

public class Run extends AbstractTestNGCucumberTests{

}
