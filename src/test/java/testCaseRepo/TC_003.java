package testCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_003 extends BaseClass {
	@Test(groups= {"Regression","Sanity"})
	public void LE_003() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.clickLeadMenu();
		
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreatingNewLeadIcon();
		
		String lName = eUtil.getDataFromExcelFile("Leads", 7, 1);
		String company = eUtil.getDataFromExcelFile("Leads", 7, 2);
		String leadSource = eUtil.getDataFromExcelFile("Leads", 7,9 );
		String noOfEmployees = eUtil.getDataFromExcelFile("Leads", 7, 3);
		String mobile = eUtil.getDataFromExcelFile("Leads", 7, 4);
		String email = eUtil.getDataFromExcelFile("Leads", 7, 5);
		String city = eUtil.getDataFromExcelFile("Leads", 7, 6);
		String country = eUtil.getDataFromExcelFile("Leads", 7, 7);
		String state = eUtil.getDataFromExcelFile("Leads", 7, 8);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company, leadSource, noOfEmployees, mobile, email, country, city, state);
	}

}