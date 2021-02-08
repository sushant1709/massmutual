package com.massmutual.automation.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * @author sushant
 * This Class is used to initialize Webdriver Instance 
 *
 */

public class Driver {
		
	public static WebDriver driver;
	static ChromeOptions options ;
	public static WebDriver getInstance() {
		if (driver == null)
		{
			switch (Config.getProperty("browser")) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/"+Config.getProperty("firefox"));
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/"+Config.getProperty("ie"));
				driver = new InternetExplorerDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+Config.getProperty("chrome"));
				options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--start-maximized");
				options.addArguments("disable-infobars");
				options.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(options);
				break;
			default:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/"+Config.getProperty("chrome"));
				options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--start-maximized");
				options.addArguments("disable-infobars");
				options.addArguments("--ignore-certificate-errors");
				driver = new ChromeDriver(options);
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		WebDriverDispatcher disp = new WebDriverDispatcher(driver);
		disp.registerListener(new SeleniumCustomListener());
		
		return disp;
	}
	
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver=null;
		}
	}
}
