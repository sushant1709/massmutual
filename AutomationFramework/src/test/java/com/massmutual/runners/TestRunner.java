
package com.massmutual.runners;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.massmutual.automation.utils.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"json:target/cucumber-report.json", "html:target/cucumber-report", "com.cucumber.listener.ExtentCucumberFormatter:"},
		features={"src/test/resources"},
		glue={"com.massmutual.automation.stepdefinitions"},
		tags={"@Problem1"},
		dryRun = false
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests{	
	@BeforeClass
	public void reportSetup() throws IOException{

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String reportPath = "TestResult/Report_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date())+".html";
		extentProperties.setReportPath(reportPath);
	}

	@AfterMethod
	public void appendFinalHTMLReport(ITestResult result) throws InterruptedException{
		if(result.getStatus() == ITestResult.FAILURE)
		{
		
		}
	}

	public void teardown() {
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		if(System.getProperty("os.name").contains("Windows")){
			Reporter.setSystemInfo("os", "Windows");
		}    
	}


}
