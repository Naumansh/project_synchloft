package all_operations;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Admin_Func extends Base{
	
	General_Operations call_ops=new General_Operations();
	Objects_Rep or=new Objects_Rep();
	
	public void Transport_Tab_AddMedium(String keyword,String o_name,String o_type,String input) throws Exception {
		
		call_ops.Hybrid_Ops(keyword,o_name,o_type,input);
	}
	
	
	public void Transport_Tab_DelMedium(String keyword,String o_name,String o_type,String input) throws Exception {
		Properties repository=or.objects_fetch();
		if(keyword.equalsIgnoreCase("del_frm_table")){
			
	WebElement table=getdriver().findElement(By.cssSelector(repository.getProperty(o_name)));
	List<WebElement> tr=table.findElements(By.tagName("tr"));
	for(WebElement rows:tr){
		List<WebElement> col=rows.findElements(By.tagName("td"));
	for(WebElement td: col){
		System.out.println("reached here");
		int i=1;
		i++;
		if(td.getText().equalsIgnoreCase(input)){
		col.listIterator(i).next().findElement(By.cssSelector(repository.getProperty(o_type))).click();
	
		}continue;}continue;}}else
	
		call_ops.Hybrid_Ops(keyword,o_name,o_type,input);
}
}