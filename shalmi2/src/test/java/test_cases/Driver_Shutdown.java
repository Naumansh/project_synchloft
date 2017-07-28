package test_cases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import all_operations.Browser_Config;

public class Driver_Shutdown extends Browser_Config {

	@AfterSuite(alwaysRun=true)
	public void close_driver() throws InterruptedException{
		driver.manage().deleteAllCookies();
		Thread.sleep(500);
		driver.close();
	}
}
