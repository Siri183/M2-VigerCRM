package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_002 extends BaseClass {
@Test(groups= {"Regression"})
public void LE_002() throws Exception {
	HomePage hp = new HomePage(driver);
	hp.clickLeadMenu();
	
	LeadsPage lp = new LeadsPage(driver);
	lp.clickOnCreatingNewLeadIcon();
	
	String lName = eUtil.getDataFromExcelFile("Leads", 4, 1);
	String company = eUtil.getDataFromExcelFile("Leads", 4, 2);
	String leadSource = eUtil.getDataFromExcelFile("Leads", 4, 3);
	String noOfEmployees = eUtil.getDataFromExcelFile("Leads", 4, 4);
	String mobile = eUtil.getDataFromExcelFile("Leads", 4, 5);
	CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
	cnlp.createNewLead(lName, company, leadSource, noOfEmployees, mobile);
}
}