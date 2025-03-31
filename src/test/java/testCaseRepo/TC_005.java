package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;

public class TC_005 extends BaseClass{

	@Test(groups= {"Sanity"})
	public void CON_002() throws Exception {
		HomePage hp = new HomePage(driver); 
		  hp.clickcontactsMenu();
		  
		  ContactsPage cp = new ContactsPage(driver);
		  cp.clickOnCreatingNewContactsIcon();
		  
		  String lName=eUtil.getDataFromExcelFile("contacts", 4, 1);
		  String title=eUtil.getDataFromExcelFile("contacts", 4, 2);
		  String eMail=eUtil.getDataFromExcelFile("contacts", 4, 3);
		  String mobile=eUtil.getDataFromExcelFile("contacts", 4, 4);
		  
		  CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		  cncp.createNewContacts(lName, title, eMail, mobile);
	}
}