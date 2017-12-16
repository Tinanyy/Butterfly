package sat.sidechef.ci_tests;

import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCSignupPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import sat.utils.SCMisc;
public class SCSignupCITest extends SideChefCITestBase{
	
	SCLandingPage objLanding;
	SCSignupPage objSignup;
	SCLoginPage objLogin;
	SCTutorialPage objTutorial;
	SCMisc objMisc;

	@BeforeClass
	public void setUp(){
	
		// set up pages
		objLanding = new SCLandingPage(driver);
		objSignup = new SCSignupPage(driver);
		objTutorial = new SCTutorialPage(driver);
		objMisc = new SCMisc(driver);	
	}
	
	@Test
	public void registationTest() throws MalformedURLException{
		//skip tutorial first
		objTutorial.skipTutorial();
		
		// go to signup with email
		objMisc.dealNoGoogle(); 
		objLanding.getSignupBtn().click();
		// using default account to signup
		
		objSignup.signUp();
		objMisc.allowPermission();
		
		// verify signup by login 
		verifyRegistration();

		
	}
	
	public void verifyRegistration() throws MalformedURLException{
		driver.quit();
//		super.setUp();
		capabilities.setCapability("appActivity", ".activity.LoginActivity");
		driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		SCLoginPage objLogin = new SCLoginPage(driver);
		objLogin.dealNoGoogle();
		objLogin.loginSidechef(objSignup.getMockEmail(), "123456Nyy");
		objMisc = new SCMisc(driver);
		objMisc.allowPermission();
		
	}
	
	// need to add login with google
	
	// need to add login with FB
}
