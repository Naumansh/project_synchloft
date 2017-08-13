package test_cases;


import org.testng.annotations.Test;

import all_operations.Browser_Config;
import all_operations.Data_Provider;
import all_operations.General_Operations;


public class Login_Test extends Browser_Config {
	General_Operations call_ops=new General_Operations();
	
	@Test(dataProvider="AdminLogin" , dataProviderClass=Data_Provider.class)
	public synchronized void Test_Login_Admin(String keyw,String objname,String objtype,String input) throws Exception{
		
		call_ops.Hybrid_Ops(keyw, objname, objtype, input);
	}

	@Test(dataProvider="Login" , dataProviderClass=Data_Provider.class)
	public synchronized void Test_Login(String keyw,String objname,String objtype,String input) throws Exception{
	
		call_ops.Hybrid_Ops(keyw, objname, objtype, input);
	}
}
