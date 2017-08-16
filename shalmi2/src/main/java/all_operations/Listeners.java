package all_operations;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Listeners extends Base implements ITestListener{
	


	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log("Test '" + result.getName() + "' PASSED");

		// This will print the class name in which the method is present
		log(result.getTestClass());

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		log("Priority of this method is " + result.getMethod().getPriority());

		System.out.println(".....");

		
	}
	@AfterMethod
	public void onTestFailure(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)getdriver()).getScreenshotAs(OutputType.FILE); 
			try {
				FileUtils.copyFile(scrFile, new File("C:\\eclipse\\GIT_Repo\\shalmi2\\FailedTestsScreenShots\\" + result.getName() + "-" 
						+ Arrays.toString(result.getParameters()) +  ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	     
	        }
	

	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}

}
