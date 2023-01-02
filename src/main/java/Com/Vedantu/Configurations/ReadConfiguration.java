package Com.Vedantu.Configurations;

import java.io.File;
import java.io.FileInputStream;
 
import java.util.Properties;

public class ReadConfiguration {

	Properties pro;
	
	public ReadConfiguration() {
		String path="C:\\Users\\SHREE\\eclipse-workspace\\Vedantu\\src\\main\\java\\Com\\Vedantu\\Configurations\\Config.properties";
		File src=new File(path);
		FileInputStream fis;
		
		try {
			fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
			 
		}
	}
	
	public String getBaseUrl() {
		String Url=pro.getProperty("baseurl");
		return Url;
	}
	public String getPhone() {
		String Phone=pro.getProperty("phone");
		return Phone;
	}
	public String getPassword() {
		String Pass=pro.getProperty("password");
		return Pass;
	}
	public String getChromePath() {
		String CPath=pro.getProperty("chrompath");
		return CPath;
	}
	
}
