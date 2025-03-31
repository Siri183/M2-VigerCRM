package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_004 extends BaseClass{
    @Test(groups= {"Smoke","Regression"})
	public void CON_001() throws Exception {
		HomePage hp = new HomePage(driver); 
		  hp.clickcontactsMenu();
		  
		  ContactsPage cp = new ContactsPage(driver);
		  cp.clickOnCreatingNewContactsIcon();
		  
		  String fName=eUtil.getDataFromExcelFile("contacts", 1, 1);
		  String lName=eUtil.getDataFromExcelFile("contacts", 1, 2);
		  String title=eUtil.getDataFromExcelFile("contacts", 1, 3);
		  
		  CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		  cncp.createNewContacts(fName, lName, title);
	}
}