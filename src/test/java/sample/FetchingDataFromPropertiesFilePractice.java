package sample;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingDataFromPropertiesFilePractice {
public static void main(String[] args) throws Exception {
//	FileInputStream fis = new FileInputStream("C:\\Users\\SiriG\\OneDrive\\Desktop\\Seleniumm\\com.crm.VTiger\\src\\test\\resources\\TestData\\CommonTestData.properties");
//	Properties prop= new Properties();
//	prop.load(fis);
//	String URL = prop.getProperty("url");
//	String UN = prop.getProperty("username");
//	String PWD = prop.getProperty("password");
//	System.out.println(value);
	
	PropertiesUtility pUtil = new PropertiesUtility();
	String URL = pUtil.getDataFromPropertiesFile("url");
	String UN = pUtil.getDataFromPropertiesFile("username");
	WebDriver driver = new  ChromeDriver();
	driver.get(URL);
	Thread.sleep(2000);
	
	
	
}
}
