package all_operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Objects_Rep {

	Properties p=new Properties();
	
	public synchronized Properties objects_fetch() throws IOException{

		String resourceName = "Objects.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		    p.load(resourceStream);
		    return p;
		    }
	}
	
}
