package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;

public class TC_006 extends BaseClass{
	@Test(groups= {"Smoke"})
	public void CON_003() throws Exception {
		HomePage hp = new HomePage(driver); 
		  hp.clickcontactsMenu();
		  
		  ContactsPage cp = new ContactsPage(driver);
		  cp.clickOnCreatingNewContactsIcon();
		  
		  String lName=eUtil.getDataFromExcelFile("contacts", 7, 1);
		  String eMail=eUtil.getDataFromExcelFile("contacts", 7, 3);
		  String mobile=eUtil.getDataFromExcelFile("contacts", 7, 2);
		  String mailingCity=eUtil.getDataFromExcelFile("contacts", 7, 4);
		  String mailingState=eUtil.getDataFromExcelFile("contacts", 7, 5);
		  String mailingCountry=eUtil.getDataFromExcelFile("contacts", 7, 6);
		  CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		  cncp.createNewContacts(lName, eMail, mobile, mailingCity, mailingCountry, mailingState);
		
	}

}