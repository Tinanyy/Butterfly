package sat.budgetbyte.ci_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.budgetbyte.pages.BBLandingPage;
import sat.budgetbyte.pages.BBLoginPage;
import sat.budgetbyte.pages.BBSignupPage;
import sat.budgetbyte.pages.BBTutorialPage;
import sat.sidechef.pages.SCLoginPage;
import sat.testbases.BudgetByteCITestBase;
import sat.utils.BBMisc;

public class BBSignupCITest extends BudgetByteCITestBase{

	
	BBLandingPage bbLanding;
	BBSignupPage bbSignup;
	BBLoginPage bbLogin;
	BBTutorialPage bbTutorial;
	BBMisc bbMisc;
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		
		bbLanding =new BBLandingPage(driver);
		bbSignup=new BBSignupPage(driver);
		bbLogin=new BBLoginPage(driver);
		bbTutorial=new BBTutorialPage(driver);
		bbMisc=new BBMisc(driver);
				
	}
	

	@Test
	public void registationTest() throws MalformedURLException{
		//skip tutorial first
		bbTutorial.skipTutorial();
		
		// go to signup with email
		bbMisc.dealNoGoogle();
		bbLanding.getSignupBtn().click();
		// using default account to signup
		
		bbSignup.signUp();
		bbMisc.allowPermission();
		
		// verify signup by login 
		verifyRegistration();

		
	}
	
	public void verifyRegistration() throws MalformedURLException{
		driver.quit();
		capabilities.setCapability("appActivity", "com.sidechef.sidechef.activity.LoginActivity");
		driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		SCLoginPage objLogin = new SCLoginPage(driver);
		objLogin.dealNoGoogle();
		objLogin.loginSidechef(bbSignup.getMockEmail(), "123456Nyy");
		bbMisc = new BBMisc(driver);
		bbMisc.allowPermission();
		
	}
	
	

}
