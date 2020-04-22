package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testbase.Constants;
import testbase.TestBase;

public class Freecrm {
	
	@BeforeClass
	public static void setUp() {
		TestBase.init();
	}
	@Test
	public void VerifyCRmTitle() {
		String title = TestBase.driver.getTitle();
		System.out.println("The Title is "+ title );
		Assert.assertEquals(title, Constants.pageTitle);
	}
	
	@AfterClass
	public void tearDown() {
		TestBase.quit();
	}

}
