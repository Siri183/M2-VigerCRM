package testCaseRepo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;
@Listeners(genericUtility.ListnersImplementation.class)
public class TC_001 extends BaseClass {
   @Test(groups= {"Smoke","Sanity"})
   public void LE_001() throws Exception {
	  HomePage hp = new HomePage(driver); 
	  hp.clickLeadMenu();
	  
	  LeadsPage lp = new LeadsPage(driver);
	  lp.clickOnCreatingNewLeadIcon();
	  
	  String fName=eUtil.getDataFromExcelFile("Leads", 1, 1);
	  String lName=eUtil.getDataFromExcelFile("Leads", 1, 2);
	  String company=eUtil.getDataFromExcelFile("Leads", 1, 3);
	  Assert.fail();
	 CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
	 cnlp.createNewLead(fName, lName, company);
	  }
}