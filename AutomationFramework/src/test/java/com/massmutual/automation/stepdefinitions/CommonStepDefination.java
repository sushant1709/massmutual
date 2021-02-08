   
package com.massmutual.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.massmutual.automation.utils.SeleniumTestHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author sk037008/sushant
 *
 */

public class CommonStepDefination {
	
	WebDriver driver;
	static String currentScenario;
	
    @Before
    public void intiate(Scenario scenario){
    	
    	System.out.println("Execution started for : "+scenario.getName());
    	if(!scenario.getName().equals(currentScenario)){
    		currentScenario = scenario.getName();
    	}
    	
    
    }
    
    @After
    public void cleanUp(Scenario scenario){
    	
    	if(scenario.getStatus().equals("failed")){
    		try {
    			com.cucumber.listener.Reporter.addScreenCaptureFromPath(SeleniumTestHelper.getScreenshot());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	

 //   Driver.closeDriver();

	
    }

 	
}
