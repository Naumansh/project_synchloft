package test_cases;

import org.testng.annotations.Test;

import all_operations.Admin_Func;
import all_operations.Data_Provider;

public class Admin_Tests {
	Admin_Func call_admin_func=new Admin_Func();
	
	@Test(dataProvider="Admin_TransportTab" , dataProviderClass=Data_Provider.class)
	public void Test_Transport_AddMedium(String keyword,String o_name,String o_type,String input) throws Exception {
		
		call_admin_func.Transport_Tab(keyword,o_name,o_type,input);
		
	}

}
