package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadPage {
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement companyTextField;
	
	@FindBy(xpath="//select[@name='leadsource']")
	WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@name='noofemployees']")
	WebElement noOfEmployeesTextField;
	

	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobileTextField;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement cityTextField;
	
	@FindBy(xpath="//input[@name='country']")
	WebElement countryTextField;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement stateTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}
	

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createNewLead(String firstName,String lastName,String company) {
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getSaveButton().click();
	}
	public void createNewLead(String lastName,String company,String leadSource,String noOfEmployees,String mobile ) {
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		Select sel = new Select(getLeadSourceDropDown());
		sel.selectByValue(leadSource);
		getNoOfEmployeesTextField().sendKeys(noOfEmployees);
		getMobileTextField().sendKeys(mobile);
		getSaveButton().click();
	}
	public void createNewLead(String lastName,String company,String leadSource,String noOfEmployees,String mobile,String eMail,String country,String city,String state) {
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		Select sel = new Select(getLeadSourceDropDown());
		sel.selectByValue(leadSource);
		getNoOfEmployeesTextField().sendKeys(noOfEmployees);
		getMobileTextField().sendKeys(mobile);
		getEmailTextField().sendKeys(eMail);
		getCountryTextField().sendKeys(country);
		getCityTextField().sendKeys(city);
		getStateTextField().sendKeys(state);
		getSaveButton().click();
		
	}

}