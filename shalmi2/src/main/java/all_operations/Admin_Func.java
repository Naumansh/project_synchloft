package all_operations;

public class Admin_Func {
	General_Operations call_ops=new General_Operations();
	public void Transport_Tab(String keyword,String o_name,String o_type,String input) throws Exception {
		
		call_ops.Hybrid_Ops(keyword,o_name,o_type,input);
	}
}
