package sample;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import genericUtility.SeleniumUtility;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class PomPractice {
	@FindBy(xpath="//input[@id='name']")
	WebElement element;
	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
	//	Name.sendKeys("Dhivya");
		//Thread.sleep(2000);
	//	driver.navigate().refresh();
	//	Thread.sleep(2000);
	//	Name.sendKeys("Nive");
		SeleniumUtility sUtil = new SeleniumUtility();
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 15);
		sUtil.navigateToApplication(driver, "http://localhost:8888/");
		Thread.sleep(2000);
	//	WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
		//Name.sendKeys("Dhivya");
		//driver.navigate().refresh();
     	//Thread.sleep(2000);
		//Name.sendKeys("Nive");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication("admin", "admin");
		HomePage hp = new HomePage(driver);
		hp.clickLeadMenu();
		Thread.sleep(2000);
		hp.clickcontactsMenu();
		Thread.sleep(2000);
		hp.clickAccountsMenu(driver);
		Thread.sleep(2000);
		
		
	}
}