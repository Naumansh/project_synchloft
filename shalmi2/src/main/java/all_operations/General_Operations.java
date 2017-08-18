package all_operations;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class General_Operations extends Base{
	Objects_Rep or=new Objects_Rep();
	//Main operaional class
	public void Hybrid_Ops(String keyword,String obj_name,String obj_type,String input) throws Exception{
		
		Properties repository=or.objects_fetch();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		switch(keyword.toUpperCase()){
		case "GO2URL":
		getdriver().get(repository.getProperty(input));
		break;
		case "EWAIT":
			Thread.sleep(2000);
			break;
	
		case "SETTEXT":
			getdriver().findElement(Fetch_Elements(obj_name,obj_type)).sendKeys(input);
			break;
		case "GETTEXT":
			getdriver().findElement(Fetch_Elements(obj_name,obj_type)).getText();
			break;
		case "CLEANTEXT":
			getdriver().findElement(Fetch_Elements(obj_name,obj_type)).clear();
			break;
		case "CLICK":
		
			if(obj_type.equalsIgnoreCase("LINK TEXT") || obj_type.equalsIgnoreCase("PARTIAL TEXT")){
				getdriver().findElement(Fetch_Elements(obj_name,obj_type)).click();
				}else
					getdriver().findElement(Fetch_Elements(obj_name,obj_type)).click();
				break;
		case "MOUSE CLICK":
		
			if(obj_type.equalsIgnoreCase("LINK TEXT") || obj_type.equalsIgnoreCase("PARTIAL TEXT") ){
				Actions mc=new Actions(getdriver());	
				mc.moveToElement(getdriver().findElement(Fetch_Elements(obj_name,obj_type))).click().build().perform();
				}else{
					Actions mc=new Actions(getdriver());	
					mc.moveToElement(getdriver().findElement(Fetch_Elements(obj_name,obj_type))).click().build().perform();}
					break;
		case "MOVE MOUSE":
			Actions move=new Actions(getdriver());	
			move.moveToElement(getdriver().findElement(Fetch_Elements(obj_name,obj_type))).build().perform();
			break;
		case "DROPDOWN":
			WebElement dd_pointer=getdriver().findElement(Fetch_Elements(obj_name,obj_type));
			Select dropdown=new Select(dd_pointer);
			dropdown.selectByValue(input);
			break;
		
		case "ASSERT_ATT":
			Thread.sleep(1500);
			
			Assert.assertTrue(getdriver().findElement((Fetch_Elements(obj_name,obj_type))).getAttribute(("innerHTML")).contains(input),"Assert Failed leading Test to fail against Comparison value received" +getdriver().findElement((Fetch_Elements(obj_name,obj_type))).getAttribute(("innerHTML")));
			break;
		case "ASSERT_TEXT":
			Thread.sleep(1500);
			Assert.assertTrue(getdriver().findElement((Fetch_Elements(obj_name,obj_type))).getText().contains(input),"Assert Failed leading Test to fail against Comparison value received" + getdriver().findElement((Fetch_Elements(obj_name,obj_type))).getText());
			break;
		case "ASSERT-URL":
			Thread.sleep(1500);
			Assert.assertEquals(getdriver().getCurrentUrl(), input, "Invalid parameter:Assert match failed for " +input +"and found" +getdriver().getCurrentUrl());
			break;
		case "ASSERT_tab":
			Thread.sleep(1500);
			System.out.println("Assert table");
			WebElement tab=getdriver().findElement(By.id(repository.getProperty(obj_name)));
			List<WebElement> row=tab.findElements(By.tagName("tr"));
			for(WebElement rows:row){
				List<WebElement> col=rows.findElements(By.tagName("td"));
			for(WebElement td: col){
				String Entered_value=td.findElement(By.tagName("td")).getText();
			Assert.assertEquals(Entered_value, input, "Invalid parameter:Assert match failed for " +input +"and found" +Entered_value);
			System.out.println(Entered_value);
			}
				
		}
			break;
		case "NE-ASSERT-TEXT":
			Thread.sleep(1500);
			Assert.assertNotSame(getdriver().findElement((Fetch_Elements(obj_name,obj_type))).getText(), input, "Invalid parameter:Assert match failed for " +input +"and found" +getdriver().getCurrentUrl());
			System.out.println("Not equal");
			break;
		case "JS CLICK":
			JavascriptExecutor js=(JavascriptExecutor) getdriver();
			WebElement element=getdriver().findElement(Fetch_Elements(obj_name,obj_type));
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



