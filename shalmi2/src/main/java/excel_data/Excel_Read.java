package excel_data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import all_operations.Data_Provider;

public class Excel_Read {
	
	public Sheet excel(String filename,String sheetname) throws IOException{
		
		
		InputStream is = getClass().getResourceAsStream("/"+filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		XSSFWorkbook workbook=new XSSFWorkbook(is);
		Sheet sheet=workbook.getSheet(sheetname);
		return sheet;
	}

}
