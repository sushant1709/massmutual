
package com.massmutual.runners;




import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"json:target/cucumber-report.json", "html:target/cucumber-report", "com.cucumber.listener.ExtentCucumberFormatter:TestResult/MyOwnReport.html"},
		features={"src/test/resources"},
		glue={"com.broadcom.aisecops.automation.stepdefinitions"},
		tags={"@Problem1"},
		
		
		dryRun = true
		
		
)
@Test
public class DryTestRunner extends AbstractTestNGCucumberTests{
	
	@AfterClass
	public static void teardown() {
        
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
    
   
}


