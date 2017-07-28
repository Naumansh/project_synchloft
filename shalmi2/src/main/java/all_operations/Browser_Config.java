package all_operations;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import object_rep.Objects_Rep;


public class Browser_Config {
	public static WebDriver driver=null;
	Objects_Rep rep=new Objects_Rep();
	
    @Test(dataProvider ="Driver_Config",dataProviderClass=Data_Provider.class)
	public void LoadBrowser (String browser) throws Exception{
    	String url="url";
    	Properties repository=rep.objects_fetch();
	try{
		
		switch(browser){
		case "CHROME":
		//System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\chromedriver.exe");
		ChromeDriverManager.getInstance().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(repository.getProperty(url));
		break;
		case "IE":
		//System.setProperty("webdriver.ie.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\IEDriverServer.exe");
		InternetExplorerDriverManager.getInstance().setup();
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(repository.getProperty(url));
		break;
		case "FIREFOX":
		//System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\Selenium_Jars\\Supporting Drivers\\geckodriver.exe");
		FirefoxDriverManager.getInstance().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(repository.getProperty(url));
		break;
		case "OPERRA":
			
		OperaDriverManager.getInstance().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(repository.getProperty(url));
			break;
		default: 
			break;
		}} catch(Exception e){
			
		}
		
    }}
