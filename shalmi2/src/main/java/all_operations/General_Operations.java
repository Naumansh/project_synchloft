package all_operations;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import object_rep.Objects_Rep;

public class General_Operations extends Browser_Config {
	Objects_Rep or=new Objects_Rep();
	
	public void Hybrid_Ops(String keyword,String obj_name,String obj_type,String input) throws Exception{
		
		switch(keyword.toUpperCase()){
	
		case "SETTEXT":
			driver.findElement(Fetch_Elements(obj_name,obj_type)).sendKeys(input);;
			break;
		case "GETTEXT":
			driver.findElement(Fetch_Elements(obj_name,obj_type)).getText();
			break;
		case "CLEANTEXT":
			driver.findElement(Fetch_Elements(obj_name,obj_type)).clear();
			break;
		case "CLICK":
		
			if(obj_type.equalsIgnoreCase("LINK TEXT") || obj_type.equalsIgnoreCase("PARTIAL TEXT")){
				driver.findElement(Fetch_Elements(obj_name,obj_type)).click();
				}else
					driver.findElement(Fetch_Elements(obj_name,obj_type)).click();
				break;
		case "MOUSE CLICK":
		
			if(obj_type.equalsIgnoreCase("LINK TEXT") || obj_type.equalsIgnoreCase("PARTIAL TEXT") ){
				Actions mc=new Actions(driver);	
				mc.moveToElement(driver.findElement(Fetch_Elements(obj_name,obj_type))).click().build().perform();
				}else{
					Actions mc=new Actions(driver);	
					mc.moveToElement(driver.findElement(Fetch_Elements(obj_name,obj_type))).click().build().perform();}
					break;
		case "MOVE MOUSE":
			Actions move=new Actions(driver);	
			move.moveToElement(driver.findElement(Fetch_Elements(obj_name,obj_type))).build().perform();
			break;
		case "DROPDOWN":
			WebElement dd_pointer=driver.findElement(Fetch_Elements(obj_name,obj_type));
			Select dropdown=new Select(dd_pointer);
			dropdown.selectByValue(input);
			break;
		
		case "ASSERT-ATT":
			Thread.sleep(1500);
			System.out.println(driver.findElement((Fetch_Elements(obj_name,obj_type))).getAttribute(("innerHTML")));
			Assert.assertTrue(driver.findElement((Fetch_Elements(obj_name,obj_type))).getAttribute(("innerHTML")).contains(input),driver.findElement((Fetch_Elements(obj_name,obj_type))).getAttribute(("innerHTML")));
			break;
		case "ASSERT-TEXT":
			Thread.sleep(1500);
			System.out.println(driver.findElement((Fetch_Elements(obj_name,obj_type))).getText());
			Assert.assertTrue(driver.findElement((Fetch_Elements(obj_name,obj_type))).getText().contains(input),driver.findElement((Fetch_Elements(obj_name,obj_type))).getText());
			break;
		case "ASSERT-URL":
			Thread.sleep(500);
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(driver.getCurrentUrl().contains(input),driver.getCurrentUrl());
			
			break;
		case "JS CLICK":
			JavascriptExecutor js=(JavascriptExecutor) driver;
			WebElement element=driver.findElement(Fetch_Elements(obj_name,obj_type));
			js.executeScript("arguments[0].click();",element);
			break;
			
			default:
				break;
		}
	}

	public By Fetch_Elements(String obj_name,String obj_type) throws Exception{
		Properties repository=or.objects_fetch();

		if(obj_type.equalsIgnoreCase("XPATH")){
			return By.xpath(repository.getProperty(obj_name));
		}else if(obj_type.equalsIgnoreCase("CSS")){
			return By.cssSelector(repository.getProperty(obj_name));
		}else if(obj_type.equalsIgnoreCase("NAME")){
			return By.name(repository.getProperty(obj_name));
		}else if(obj_type.equalsIgnoreCase("CLASS")){
			return By.className(repository.getProperty(obj_name));
		}else if(obj_type.equalsIgnoreCase("LINK TEXT")){
			return By.linkText(obj_name);
		}else if(obj_type.equalsIgnoreCase("PARTIAL TEXT")){
			return By.partialLinkText(obj_name);
		}else if(obj_type.equalsIgnoreCase("ID")){
			return By.id(repository.getProperty(obj_name));
		}else if(obj_type.equalsIgnoreCase("TAG NAME")){
			return By.tagName(repository.getProperty(obj_name));
		}
		throw new Exception();
	}
		
	}



