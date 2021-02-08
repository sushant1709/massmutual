/**
 * 
 */
package com.massmutual.automation.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.massmutual.automation.utils.Driver;
import com.massmutual.automation.utils.SeleniumTestHelper;
import com.massmutual.problem1.pageobject.problemOnePageObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author Sushant
 * 
 * This stepDefinition contains all the necessary steps for problem1.feature file
 *
 */
public class Problem1StepDefinition extends CommonStepDefination {
	
	public Problem1StepDefinition(){
		
		this.driver = Driver.getInstance();
	}
	
	@Before
	public void intiate(Scenario scenario) {

	}

	@After
	public void cleanUp(Scenario scenario) {

	}
	problemOnePageObject objectone = new problemOnePageObject();
	
	

	@Given("^User in on values Page$")
	public void user_in_on_values_Page() throws Throwable {
	    
		objectone.launchApplicationURL();
	}
	
	@Then("^User verify right count of values appear on screen$")
	public void User_verify_right_count_of_values_appear_on_screen() throws Throwable {
	 
		int valueCount = objectone.getallValuesCount();
		int valueTxtCount = objectone.getAllValueTxtCount();
		
		SeleniumTestHelper.assertTrue((valueCount==valueTxtCount), "Total values are :" +valueCount);
	
	}
	

	@Then("^User verify the value on the screen are greater then (\\d+)$")
	public void user_verify_the_value_on_the_screen_are_greater_then(int arg1) throws Throwable {
	 
		// verify values greater than 0
		
		List<Double> valuelist = objectone.parseCurrenciesToDoublelist();
		
		for(double value: valuelist){
			SeleniumTestHelper.assertTrue((value>0), "Value :" +value);
		}		
		
	}

	@Then("^User verify total balance is correct based on listed values$")
	public void user_verify_total_balance_is_correct_based_on_listed_values() throws Throwable {
	    
		double totalValueSum = objectone.sumOfAllCurrencyValue();
		double totalsum = objectone.parsedTotalBalanceValue();
		SeleniumTestHelper.assertEquals(totalValueSum, totalsum, " total value :" + totalValueSum +" and total sum :" +totalsum);
		
		
	}

	@Then("^User verify values are formmated as currencies$")
	public void user_verify_values_are_formmated_as_currencies() throws Throwable {
	    
		List<WebElement> listvalue = objectone.allvalues;
		for(WebElement value :listvalue){
			String valuetxt = value.getText();
			SeleniumTestHelper.assertTrue(valuetxt.startsWith("$"), valuetxt);
			
		}
		
	}

	
	
}
