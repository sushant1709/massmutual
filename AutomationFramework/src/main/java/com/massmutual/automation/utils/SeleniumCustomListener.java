package com.massmutual.automation.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sushant Implementation of WebDriverEventListener Interface
 *
 */

public class SeleniumCustomListener implements WebDriverEventListener {

	public static int externalTimeout = 30;
	public static Operations operation;

	public enum Operations {
		FIND_ELEMENTS, FIND_ELEMENT, CLICK, SEND_KEYS, GET_TEXT, VERIFY_ELEMENT;
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		waitForPageToBeLoaded(driver, 120);
		switch (operation) {
		case CLICK:
			waitForTheElement(by, driver, externalTimeout);
			break;
		case FIND_ELEMENT:
			waitForTheElement(by, driver, externalTimeout);
			break;
		case FIND_ELEMENTS:
			waitForTheElement(by, driver, externalTimeout);
			break;
		case GET_TEXT:
		case VERIFY_ELEMENT:
			waitForTheElementWithOutException(by, driver, externalTimeout);
			break;
		}

	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, externalTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		waitForPageToBeLoaded(driver, externalTimeout);
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {

		File f = ((TakesScreenshot) (Driver.getInstance())).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f, new File("./screenshots/" + new Random().nextInt() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void waitForTheElement(By by, WebDriver driver, int timeout) {

		long start = System.currentTimeMillis();
		while (true) {

			try {
				driver.findElement(by);
				return;
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
				continue;

			} finally {

				long end = System.currentTimeMillis();
				if ((end - start) / 1000 > timeout) {
					throw new NoSuchElementException("Timeout exceeded and element couldn't be found in " + timeout
							+ " seconds. " );
				}
			}
		}
	}

	private void waitForTheElementWithOutException(By by, WebDriver driver, int timeout) {

		long start = System.currentTimeMillis();
		while (true) {

			try {
				driver.findElement(by);
				return;
			} catch (Exception e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
				continue;

			} finally {

				long end = System.currentTimeMillis();
				if ((end - start) / 1000 > timeout) {
					break;
				}
			}
		}
	}

	private static void waitForPageToBeLoaded(WebDriver driver, int maxTimeOutInSec) {
		long intialTime = System.currentTimeMillis();
		long currentTime = intialTime;
		long maxWaitTime = maxTimeOutInSec * 1000;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (!(js.executeScript("return document.readyState").equals("complete"))
				&& currentTime - intialTime < maxWaitTime) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			currentTime = System.currentTimeMillis();
		}
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

		@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}
}
