package com.massmutual.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author /sushant
 * 
 *         Custom built  WebDriver Methods
 *
 */

public class SeleniumTestHelper {

	static WebDriver driver = Driver.getInstance();


	public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeDisplayed(WebDriver driver, List<WebElement> element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBePresent(WebDriver driver, By element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	
	public static void assertEquals(Object actual, Object expected, String message) {

	try {
			
		if (message != null) {
			System.out.println(message + "actual is - " + actual + "expected is - " + expected);
			Assert.assertEquals(actual, expected, message);
			com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
			com.cucumber.listener.Reporter
					.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
		} else {
			Assert.assertEquals(actual, expected);
			com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
			com.cucumber.listener.Reporter
					.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
		}
		
	} catch (IOException e) {
		e.printStackTrace();

	}
	}

	public static void assertNotEquals(Object actual, Object expected, String message) {

		
		try {
				
		if (message != null) {
			System.out.println(message + "actual is - " + actual + "expected is - " + expected);
			Assert.assertNotEquals(actual, expected, message);
			com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
			com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
		} else {
			
			Assert.assertNotEquals(actual, expected);
			com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
			com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
		}
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void assertEquals(Object actual, Object expected) throws IOException {
		assertEquals(actual, expected, null);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
	}

	public static void assertNotEquals(Object actual, Object expected) throws IOException {
		assertNotEquals(actual, expected, null);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + actual + "</B>");
	}

	public static void assertTrue(boolean bool, String message) throws IOException {
		assertEquals(bool, true, message);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + message + "</B>");
	}


	public static void assertFalse(boolean bool, String message) throws IOException {
		assertEquals(bool, false, message);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + message + "</B>");
	}

	public static void assertFalse(boolean bool) throws IOException {
		assertFalse(bool, null);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + null + "</B>");
	}

	public static void fail(String message) throws IOException {
		assertEquals(true, false, message);
		com.cucumber.listener.Reporter.addScreenCaptureFromPath(getScreenshot());
		com.cucumber.listener.Reporter.addStepLog("<B style=\"color:green\">" + "Expected and Actual are : " + message + "</B>");
	}




	public static String getScreenshot() throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		WebDriver driver = Driver.getInstance();
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/PassedScreenshots/" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		FileInputStream is = new FileInputStream(source);
		byte[] imageBytes = IOUtils.toByteArray(is);
		String Base64 = java.util.Base64.getEncoder().encodeToString(imageBytes);
		return "data:image/png;base64," + Base64;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	

	


	
}
