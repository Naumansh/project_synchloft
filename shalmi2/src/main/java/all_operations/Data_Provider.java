package all_operations;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

import excel_data.Excel_Read;

public class Data_Provider {
	Excel_Read read=new Excel_Read();
	
	
	@DataProvider
	public Object[][] Driver_Config() throws IOException{
	
		Sheet fetch=read.excel(("user.dir")+"\\src\\main", "Shaalmi_Tests.xlsx", "Browser");
		
		int rows=fetch.getLastRowNum()-fetch.getFirstRowNum()+1;
		int columns=fetch.getRow(1).getLastCellNum();
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<columns;j++){
				data[i][j]=fetch.getRow(i).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	@DataProvider
	public Object[][] AdminLogin() throws IOException{
	
		Sheet fetch=read.excel(("user.dir")+"\\src\\main", "Shaalmi_Tests.xlsx", "Admin_SignIn_Tests");
		
		int rows=fetch.getLastRowNum()-fetch.getFirstRowNum()+1;
		int columns=fetch.getRow(1).getLastCellNum();
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<columns;j++){
				data[i][j]=fetch.getRow(i).getCell(j).toString();
			}
		}
		return data;
		
	}

	@DataProvider
	public Object[][] LogOut() throws IOException{
	
		Sheet fetch=read.excel(("user.dir")+"\\src\\main", "Shaalmi_Tests.xlsx", "LogOut");
		
		int rows=fetch.getLastRowNum()-fetch.getFirstRowNum()+1;
		int columns=fetch.getRow(1).getLastCellNum();
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<columns;j++){
				data[i][j]=fetch.getRow(i).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	@DataProvider
	public Object[][] Login() throws IOException{
	
		Sheet fetch=read.excel(("user.dir")+"\\src\\main", "Shaalmi_Tests.xlsx", "Login_Test");
		
		int rows=fetch.getLastRowNum()-fetch.getFirstRowNum()+1;
		int columns=fetch.getRow(1).getLastCellNum();
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<columns;j++){
				data[i][j]=fetch.getRow(i).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	@DataProvider
	public Object[][] Admin_TransportTab
	() throws IOException{
	
		Sheet fetch=read.excel(("user.dir")+"\\src\\main", "Shaalmi_Tests.xlsx", "Admin_TransportTab_Tests");
		
		int rows=fetch.getLastRowNum()-fetch.getFirstRowNum()+1;
		int columns=fetch.getRow(1).getLastCellNum();
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++){
			
			for(int j=0;j<columns;j++){
				data[i][j]=fetch.getRow(i).getCell(j).toString();
			}
		}
		return data;
		
	}

}
