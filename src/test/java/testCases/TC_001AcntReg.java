package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegestration;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001AcntReg extends BaseTest {

 @Test(groups= {"Regression","Master"})
 public void verify_account_registration()
	{
	 
	 
	 logger.info("Test started");
		HomePage hp=new HomePage(driver);
		hp.clickAccount();logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Registration");
		
		AccountRegestration regpage=new AccountRegestration(driver);
		logger.info("Customer details");
try
{
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
	logger.info("Validating expected message..");
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
  }
}
