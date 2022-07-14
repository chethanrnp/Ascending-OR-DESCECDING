package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * it;s contains External File specific libraries
 * @author HP
 *
 */
public class FileUtility {
/**
 * its used return the value from the property file based on key
 * @return
 * @throws Throwable 
 */
	public String getPropertyKeyValue(String path,String key)  {
		
		String value=null;
			try {
				FileInputStream fileInputStream=new FileInputStream(path);
				Properties prop=new Properties();
				prop.load(fileInputStream);
				value = prop.getProperty(key);
			} catch (Exception e) {
			
			}
			return value;
	}

 
}