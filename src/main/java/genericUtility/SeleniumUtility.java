package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {

	public void navigateToApplication(WebDriver driver,String url ) {
		driver.get(url);
	}
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getAlertMessage(WebDriver driver) {
		String value = driver.switchTo().alert().getText();
		return value;
			
	}
	public void sendValueToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	public void selectOptionByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	public void selectOptionByValue(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void selectOptionByVisibleText(WebElement element, String Visibletext) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Visibletext);
	}
	public void mouseHoveringAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	public void doubleClickOperation(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void contextClickOperation(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void clickAndHoldOperation(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	public void releaseOperation(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	public void dragAndDropOperation(WebDriver driver,WebElement element1, WebElement element2) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2);
	}
	public void dragAndDropBy(WebDriver driver, WebElement element,int xoffset, int yoffset) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(element, xoffset, yoffset).perform();
	}
	public String takeScreenshot(WebDriver driver, String dateTimeStamp) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshots//image.png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
	
}
