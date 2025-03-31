package genericUtility;
	
	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;
	
	import objectRepo.HomePage;
	import objectRepo.LoginPage;
	
	
	
	public class BaseClass {
		public WebDriver driver;
		public static WebDriver sDriver;
		public SeleniumUtility sUtil=new SeleniumUtility();
		public PropertiesUtility pUtil=new PropertiesUtility();
		public ExcelUtility eUtil=new ExcelUtility();
		//for making WebDriver reference variable as thread safe
		public static ThreadLocal<WebDriver> driverInstance=new ThreadLocal<>();
		
		@BeforeSuite(alwaysRun=true)
		public void dbConnection()
		{
			System.out.println("DB Cnnection created");
		}
		
		@Parameters("browser")
		@BeforeClass(alwaysRun=true)
		public void launchBrowser(@Optional("chrome")String BROWSER) throws Exception
		{
			if(BROWSER.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("edge"))
			{
				driver=new EdgeDriver();
			}
			else if(BROWSER.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			//sDriver=driver;
			//driver=new ChromeDriver();
			setDriver(driver);
			sUtil.maximizeWindow(driver);
			sUtil.implicitWait(driver,15);
			
			String URL=pUtil.getDataFromPropertiesFile("url");
			sUtil.navigateToApplication(driver, URL);
		}
		
		@BeforeMethod(alwaysRun=true)
		public void loginOperation() throws Exception
		{
			String UN = pUtil.getDataFromPropertiesFile("username");
			String PWD = pUtil.getDataFromPropertiesFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApplication(UN, PWD);
			
		}
	   @AfterMethod(alwaysRun=true)
	   public void logOutOperation() {
		   HomePage hp = new HomePage(driver);
		   hp.clickAccountsMenu(driver);
	   }
	   @AfterClass(alwaysRun=true)
	   public void closeBrowser() {
		   driver.quit();
	   }
	   @AfterSuite(alwaysRun=true)
	   public void closeDBConnection() {
		   System.out.println("DB connection is closed");
	   }
	   //sets the current thread's copy of this thread-local variable to the specified value
	   public static void setDriver(WebDriver driver) {
		   driverInstance.set(driver);
	   }
	   //Returns the value in the current thread's copy of this thread-local variable
	   public static  WebDriver getDriver() {
		   return driverInstance.get();
	   }
	}