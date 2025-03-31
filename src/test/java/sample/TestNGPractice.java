package sample;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Ignore
	@Test(priority = 4)
	public void createUser() {
		System.out.println("User created");                   
	}
	
	@Test(priority = 2, dependsOnMethods = {"deleteUser"})
	public void modifyUser()
	{
		System.out.println("User modified");
	}
	
	@Test(priority = 3)
	public void deleteUser() {
		System.out.println("User deleted");
	}
}
