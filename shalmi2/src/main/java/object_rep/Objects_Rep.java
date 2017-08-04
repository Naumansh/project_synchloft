package object_rep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Objects_Rep {

	Properties p=new Properties();
	String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\object_rep\\Objects.properties";
	public Properties objects_fetch() throws IOException{
		InputStream stream=new FileInputStream(new File(filepath));
		p.load(stream);
		return p;
	}
	
}
