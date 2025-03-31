package sample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.ContactsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class PerformHpOperations {
	public static void main(String[] args) throws Exception {
		PropertiesUtility pUtil = new PropertiesUtility();
		String url = pUtil.getDataFromPropertiesFile("url");
		String username = pUtil.getDataFromPropertiesFile("username");
		String password = pUtil.getDataFromPropertiesFile("password");
		
		WebDriver driver =new ChromeDriver();
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.navigateToApplication(driver, url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(username, password);
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.clickLeadMenu();
		Thread.sleep(2000);
		LeadsPage leads = new LeadsPage(driver);
		leads.clickOnCreatingNewLeadIcon();
		ExcelUtility eUtil = new ExcelUtility();
		String firstName = eUtil.getDataFromExcelFile("Leads", 1, 1);
		WebElement element = driver.findElement(By.xpath("//input[@name='firstname']"));
		element.sendKeys(firstName);
		
	}

}