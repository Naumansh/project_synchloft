	package all_operations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;


public class Browser_Config {
	
	
	public static WebDriver LoadBrowser (String browser) throws Exception{
		WebDriver driver;

		switch(browser){
		case "CHROME":
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\chromedriver.exe");
		//ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		break;
		case "IE":
		System.setProperty("webdriver.ie.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\IEDriverServer.exe");
		//InternetExplorerDriverManager.getInstance().setup();
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		break;
		
		case "FIREFOX":
		System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\geckodriver.exe");
		//FirefoxDriverManager.getInstance().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		break;
		
		case "OPERRA":
			OperaDriverManager.getInstance().setup();
			driver=new OperaDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			break;
			
		default: 
			throw new IllegalAccessException();
		}
	return driver;		
    }
    /*
    @Test
    public void load_url() throws IOException {
	Properties repository=rep.objects_fetch();
	System.out.println("run load url");
	driver.get(repository.getProperty(url));
}*/
}
