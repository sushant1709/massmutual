package com.massmutual.problem1.pageobject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.massmutual.automation.utils.Config;
import com.massmutual.automation.utils.Driver;

/**
 * @author sushant 
 *
 */
public class problemOnePageObject {

	
	WebDriver driver;
	public problemOnePageObject(){
		this.driver =Driver.getInstance();
		PageFactory.initElements(driver, this);	
	}
	
	

	@FindBy(xpath ="//*[contains(@id ='lbl_val')]")
	public List<WebElement> allvalues;
	
	@FindBy(xpath ="//*[contains(@id ='txt_val')]")
	public List<WebElement> allCurrencyvaluestxt;
	
	@FindBy(xpath ="//*[contains(@id ='txt_ttl_val')]")
	public WebElement totalBalancetxt;
	
	
	
	
	
	
	
	public void launchApplicationURL(){
		
		// method to launch URL
		driver.get(Config.getProperty("appUrl", "Configuration"));
	}
	
	public int getallValuesCount(){
		// method to get all the count values
		return allvalues.size();	
	}
	
	public int getAllValueTxtCount(){
		// method to get all the the value txt  count
		return allCurrencyvaluestxt.size();
	}
	
	public List<Double> parseCurrenciesToDoublelist(){
		
		// method to parse currencies to double
		List<Double> doublelist = new ArrayList<Double>();
		
		for(WebElement currency :allCurrencyvaluestxt ){
			//convert currency value to  double
			String currencyStr =currency.getText().replace("$", "");  // replace the " $ " from Currency txt value
			doublelist.add(Double.parseDouble(currencyStr));
		}
		
		return  doublelist;
			
	}
	
	
	public double  sumOfAllCurrencyValue(){
		
		double sum = 0.0;
		List <Double> doublelist = parseCurrenciesToDoublelist();  //  get the double list of values from previous Function parseCurrenciesToDouble()
		for(double value :doublelist){
			sum = sum+value;
		}
		return sum;
		
	}
	
	
	public double parsedTotalBalanceValue(){
		
		// replace $ from total balance and returned parsed double value
		return Double.parseDouble(totalBalancetxt.getText().replace("$", ""));
		
	}
	
	
	
}
