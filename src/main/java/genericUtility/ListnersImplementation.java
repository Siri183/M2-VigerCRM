package genericUtility;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener {
	JavaUtility jUtil=new JavaUtility();
	String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	ExtentReports report ;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
		@Override
		public void onTestStart(ITestResult result) {
			String methodName=result.getMethod().getMethodName();
			System.out.println(methodName+"On Test Start excuted");
			Reporter.log(methodName+"On Test Start excuted");
			
			//Adding test method to extent report
			test=report.createTest(methodName);
			extentTest.set(test);
		}
		@Override
		public void onTestSuccess(ITestResult result) {
			String methodName=result.getMethod().getMethodName();
			System.out.println(methodName+"On Test Success excuted");
			Reporter.log(methodName+"On Test Success excuted");
			
			//Logging test info
			//test.log(Status.PASS, methodName +"test successfully executed");
			extentTest.get().log(Status.PASS, methodName +"test successfully executed");
		}
		
		@Override
		public void onTestFailure(ITestResult result) {
			String methodName=result.getMethod().getMethodName();
			System.out.println(methodName+"On Test Failure excuted");
			Reporter.log(methodName+"On Test Failure excuted");
		
			//Logging test info
			extentTest.get().log(Status.FAIL, methodName+"test failed");
			
			//logging error message
			extentTest.get().log(Status.INFO, result.getThrowable());
			

			//taking screenshot when script fails
			SeleniumUtility sUtil=new SeleniumUtility();
			try {
				String path = sUtil.takeScreenshot(BaseClass.getDriver(), dateTimeStamp);
				//Attaching screenshot to report
				extentTest.get().addScreenCaptureFromPath(path);
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		@Override
		public void onTestSkipped(ITestResult result) {
			String methodName=result.getMethod().getMethodName();
			System.out.println(methodName+"On Test Skipped excuted");
			Reporter.log(methodName+"On Test Skipped excuted");
		
			//Logging test info
			test.log(Status.SKIP, methodName+"test skipped");
			
		}
		
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}
		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			
		}
		
		@Override
		public void onStart(ITestContext context) {
			System.out.println("On Start excuted");
			//Configuration of ExtentReports
			ExtentSparkReporter reporter = new ExtentSparkReporter(".\\ExtentReports\\report-"+dateTimeStamp+".html");
			reporter.config().setDocumentTitle("VTiger Report");
			reporter.config().setReportName("VTiger CRM Report");
			reporter.config().setTheme(Theme.DARK);
			
			//Create an empty report with the configuration
		    report = new ExtentReports();
		    report.attachReporter(reporter);
		    report.setSystemInfo("Base OS","Windows");
		    report.setSystemInfo("Base Url","http://localhost:8888/");
		    report.setSystemInfo("Base browser","Chrome");
		    report.setSystemInfo("Reporter","Siri");
		}
		@Override
		public void onFinish(ITestContext context) {
			System.out.println("On Finish excuted");
			report.flush();
			
			
		}
		
	}