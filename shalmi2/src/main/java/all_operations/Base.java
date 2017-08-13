package all_operations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Base {
	
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	
	@Parameters({"browser_name"})
	@BeforeTest
	public void browser_init(String browser_name) throws Exception {
		WebDriver driver=new Browser_Config().LoadBrowser(browser_name);
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
