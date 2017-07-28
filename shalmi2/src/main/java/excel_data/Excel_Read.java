package excel_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {
	
	public Sheet excel(String filepath,String filename,String sheetname) throws IOException{
		
		File file=new File(filepath+"\\"+filename);
		FileInputStream Istream=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(Istream);
		Sheet sheet=workbook.getSheet(sheetname);
		return sheet;
	}

}
