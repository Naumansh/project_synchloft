package all_operations;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {
	
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	/*
	@Parameters({"browser_name"})
	@BeforeTest(alwaysRun=false)
	public void LocalDriver(String browser_name) throws Exception {
		WebDriver driver=new Browser_Config().LocalLoadBrowser(browser_name);
		setdriver(driver);
	}*/
	//For Remote Driver use only
	@Parameters({"browser","node","OS","OS_model"})
	@BeforeTest(description="Remote driver")
	public void RemoteDriver(String browser,String node,String OS,String OS_model) throws Exception {
		WebDriver driver=new Browser_Config().RemoteLoadBrowser(browser,node,OS,OS_model);
		setdriver(driver);
	}
	
	public void setdriver(WebDriver driver) {
		tdriver.set(driver);
	}
	
	public WebDriver getdriver() {
		return tdriver.get();
	}
	
	@AfterTest
	public void close_driver() {
		getdriver().quit();
		tdriver.set(null);
	}
	

}
