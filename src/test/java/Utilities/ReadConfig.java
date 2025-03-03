package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="config.properties";
	////constructor////
		public ReadConfig() {
			properties=new Properties();
			try {
				FileInputStream File= new FileInputStream(path);
				properties.load(File);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public String getbrowser() {
			String value1 = properties.getProperty("browser");
			return value1;
		}

}
