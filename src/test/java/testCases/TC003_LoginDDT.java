package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseTest{

	
	@Test(dataProvider="logindata", dataProviderClass=DataProviders.class ,groups= {"DataDriven"}) 
	public void verify_LoginDDT (String email,String pwd, String exp)
	{
		try {
		
		logger.info("TC_003 Started LoginDDT");

HomePage hp=new HomePage(driver);
		
		hp.clickAccount();
		hp.clickLogin();
		
		// Login Page
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
	
		//My Account
		
		MyAccountPage myacc=new MyAccountPage(driver);
boolean	res=myacc.isMyAccountPageExists();
/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

if(exp.equalsIgnoreCase("Valid"))
{
	if(res==true)
	{
		myacc.clickLogout();
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	
}

if(exp.equalsIgnoreCase("Invalid"))
{
	if(res==true)
	{
		myacc.clickLogout();
		Assert.assertTrue(false);
	}
	else
		Assert.assertTrue(true);
}
	}
	catch(Exception e)
	{
		Assert.fail();
	}

logger.info("Login DDT Test Completed");
	}
}



