package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=genericUtility.RetryAnalyzerImplementation.class)
	public void Sample() {
		System.out.println("Hi"); 
		Assert.fail();
	}

	
}