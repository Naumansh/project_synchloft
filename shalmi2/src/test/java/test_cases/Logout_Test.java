package test_cases;

import org.testng.annotations.Test;

import all_operations.Browser_Config;
import all_operations.Data_Provider;
import all_operations.General_Operations;

public class Logout_Test extends Browser_Config {
	General_Operations call_ops=new General_Operations();
	
	@Test(dataProvider="LogOut" , dataProviderClass=Data_Provider.class)
	public synchronized void Test_LogOut(String keyw,String objname,String objtype,String input) throws Exception{
		
		call_ops.Hybrid_Ops(keyw,objname,objtype,input);
	}
}
