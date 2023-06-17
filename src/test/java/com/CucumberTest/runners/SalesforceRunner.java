package com.CucumberTest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = {"src/test/resources/features/salesforceLoginFeature.feature", 
				"src/test/resources/features/salesforceHomePageFeature.feature"},
		glue= {"com.CucumberTest.steps"}
		
		/*When monochrome value set to true, 
		It will make console output for the Cucumber test much 
		more readable and remove any unreadable character.*/
		//monochrome = true 
		
		/*dryrun: Setting this option to true checks if all the step definitions 
		have been implemented without actually running the scenarios. 
		It can be used to quickly validate the step definitions. 
		The default value is false.*/
		
		//dryRun = false
		//tags = "@cal and @sub"
		
)

public class SalesforceRunner extends AbstractTestNGCucumberTests 
{

}
