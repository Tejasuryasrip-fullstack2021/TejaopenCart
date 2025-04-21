package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class Tc002_LoginTest extends BaseTest {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("Starting Tc002_LoginTest ");
		try {
		//Home Page
		HomePage hp=new HomePage(driver);
		
		hp.clickAccount();
		hp.clickLogin();
		
		// Login Page
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
	
		//My Account
		
		MyAccountPage myacc=new MyAccountPage(driver);
boolean	res=myacc.isMyAccountPageExists();
		Assert.assertTrue(res);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Katam Tc002_LoginTest ");
	}

}
