package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static String URL = "http://localhost:3000";

	
	/*
	 * Initialize the Firefox driver and connect to the main page
	 * 
	 * */
	@Before
	public void setUp() throws InterruptedException {
		driver = getDriver();
		driver.get(URL);
	}

	/*
	 * Terminate the driver after all the tests
	 * */
	@After
	public void tearDown() {
		driver.quit();
		driver = null;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}

}
