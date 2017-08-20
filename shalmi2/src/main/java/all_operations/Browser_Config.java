	package all_operations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	
	
	public static WebDriver LocalLoadBrowser (String browser) throws Exception{
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
	
	
	public static WebDriver RemoteLoadBrowser (String browser,String node,String OS,String OS_model) throws Exception{
		WebDriver driver;

		switch(browser){
		case "CHROME":
			//System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\chromedriver.exe");
		DesiredCapabilities capabilities=new DesiredCapabilities().chrome();
		capabilities.setBrowserName("chrome");
		if (OS.equalsIgnoreCase("windows")){
			switch(OS_model){
			case "vista":
				capabilities.setPlatform(Platform.VISTA);
				break;
			case "7":
				capabilities.setPlatform(Platform.WINDOWS);
				break;
			case "8":
				capabilities.setPlatform(Platform.WIN8);
			break;
			case "8.1":
				capabilities.setPlatform(Platform.WIN8_1);
				break;
			case "xp":
				capabilities.setPlatform(Platform.XP);
				break;
				default:
					capabilities.setPlatform(Platform.WIN10);
					break;
			}
		}else
			if(OS.equalsIgnoreCase("mac")){
				
					capabilities.setPlatform(Platform.MAC);
					
			}
		
		driver=new RemoteWebDriver(new URL(node),capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		break;
		case "IE":
	
			//System.setProperty("webdriver.ie.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\IEDriverServer.exe");
		DesiredCapabilities cap_ie=new DesiredCapabilities().internetExplorer();
		cap_ie.setBrowserName("internet explorer");
		cap_ie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		cap_ie.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
		cap_ie.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		cap_ie.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
		cap_ie.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap_ie.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap_ie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		cap_ie.setJavascriptEnabled(true); 
		if (OS.equalsIgnoreCase("windows")){
			switch(OS_model){
			case "vista":
				cap_ie.setPlatform(Platform.VISTA);
				break;
			case "7":
				cap_ie.setPlatform(Platform.WINDOWS);
				break;
			case "8":
				cap_ie.setPlatform(Platform.WIN8);
			break;
			case "8.1":
				cap_ie.setPlatform(Platform.WIN8_1);
				break;
			case "xp":
				cap_ie.setPlatform(Platform.XP);
				break;
				default:
					cap_ie.setPlatform(Platform.WIN10);
					break;
			}
		}else
			if(OS.equalsIgnoreCase("mac")){
				
				cap_ie.setPlatform(Platform.MAC);
				
		}
		driver=new RemoteWebDriver(new URL(node),cap_ie);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		break;
		
		case "FIREFOX":
		//System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\geckodriver.exe");
		//FirefoxDriverManager.getInstance().setup();
		DesiredCapabilities cap_ff=new DesiredCapabilities().firefox();
		cap_ff.setBrowserName("firefox");
		if (OS.equalsIgnoreCase("windows")){
			switch(OS_model){
			case "vista":
				cap_ff.setPlatform(Platform.VISTA);
				break;
			case "7":
				cap_ff.setPlatform(Platform.WINDOWS);
				break;
			case "8":
				cap_ff.setPlatform(Platform.WIN8);
			break;
			case "8.1":
				cap_ff.setPlatform(Platform.WIN8_1);
				break;
			case "xp":
				cap_ff.setPlatform(Platform.XP);
				break;
				default:
					cap_ff.setPlatform(Platform.WIN10);
					break;
			}
		}else
			if(OS.equalsIgnoreCase("mac")){
				
				cap_ff.setPlatform(Platform.MAC);
				
		}
		driver=new RemoteWebDriver(new URL(node),cap_ff);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		break;
		
		case "OPERRA":
			DesiredCapabilities cap_opera=new DesiredCapabilities().operaBlink();
			cap_opera.setBrowserName("operaBlink");
			if (OS.equalsIgnoreCase("windows")){
				switch(OS_model){
				case "vista":
					cap_opera.setPlatform(Platform.VISTA);
					break;
				case "7":
					cap_opera.setPlatform(Platform.WINDOWS);
					break;
				case "8":
					cap_opera.setPlatform(Platform.WIN8);
				break;
				case "8.1":
					cap_opera.setPlatform(Platform.WIN8_1);
					break;
				case "xp":
					cap_opera.setPlatform(Platform.XP);
					break;
					default:
						cap_opera.setPlatform(Platform.WIN10);
						break;
				}
			}else
			if(OS.equalsIgnoreCase("mac")){
				
				cap_opera.setPlatform(Platform.MAC);
					
			}
			driver=new OperaDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			break;
			
		default: 
			throw new IllegalAccessException();
		}
	return driver;		
    }
}
