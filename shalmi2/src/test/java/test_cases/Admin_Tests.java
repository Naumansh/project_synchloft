package test_cases;

import org.testng.annotations.Test;

import all_operations.Admin_Func;
import all_operations.Data_Provider;

public class Admin_Tests {
	Admin_Func call_admin_func=new Admin_Func();
	
	@Test(dataProvider="Admin_TransportTab_add" , dataProviderClass=Data_Provider.class , description="Transportaion tab-Add Medium")
	public synchronized void Test_Transport_AddMedium(String keyword,String o_name,String o_type,String input) throws Exception {
		
		call_admin_func.Transport_Tab_AddMedium(keyword,o_name,o_type,input);
		
		
	}
	
	@Test(dataProvider="Admin_TransportTab_del" , dataProviderClass=Data_Provider.class , description="Transportaion tab-Del Medium")
	public synchronized void Test_Transport_DELMedium(String keyword,String o_name,String o_type,String input) throws Exception {
		
		call_admin_func.Transport_Tab_DelMedium(keyword,o_name,o_type,input);
		
		
	}

}
