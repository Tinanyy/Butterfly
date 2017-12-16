package sat.sidechef.ci_tests;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidKeyCode;
import sat.common_pages.LoginPage;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;
public class SCLoginCITest extends SideChefCITestBase{
	
	protected SCLandingPage objLandingPage;
	protected SCTutorialPage objTutorial;
	protected LoginPage objLogin;
	protected SCMisc objMisc;

	@BeforeClass
	public void setUp(){
		objLogin =  new SCLoginPage(driver);
		objLandingPage = new SCLandingPage(driver);
	    objTutorial = new SCTutorialPage(driver);
	    objMisc = new SCMisc(driver);
	}	

	public void testSuccessfulLogin() throws InterruptedException{
		//deal with noGoogle
		objLogin.dealNoGoogle();
		
		// send correct info to login
		objLogin.loginSidechef("tina@sidechef.com","123456Nyy");
		TimeUnit.SECONDS.sleep(2);		
		//allow permission
         objMisc.allowPermission();

	}
	
	public void testFailedLogin(){
		//deal with noGoogle
		objLogin.dealNoGoogle();
		// send wrong info to login
		objLogin.loginSidechef("tina@sidechef.com", "123");
		assert(objLogin.getErrPwd() != null);	
		objLogin.loginSidechef("tina.tina.sidechef.com", "123456");
		assert(objLogin.getErrName() != null);			
	}
	 
	public void skipTutorial(){
		// skip tutorial , button1 following is the "OK" button 
		objTutorial.skipTutorial();
		
		objLandingPage.dealNoGoogle();
		
		objLandingPage.checkPage();
		
		objLandingPage.getLoginLabel().click();
	}
	
	public void testBackBtn(){
		
		objLogin.clickBackBtn();
		
		/*
		 *  if the back button doesn't work, we won't be able to click sign up again,
		 *  so no other assert needed here. But, actually, let's add some here
		 */
		objLandingPage.checkPage();
		
		objLandingPage.getLoginLabel().click();
	}
	
	/*
	 * Really, you can argue for separating successful, back btton and failure login.
	 * But since the startup is really time consuming, we combine them.
	 * 
	 */
	
	@Test
	public void testEmailLogin() throws InterruptedException{
		
		// skip tutorial
		skipTutorial();
		
		// test failed login
		testFailedLogin(); 
		  
		// test the "back" button         *for we remove the back btn in our android app, so all tests involved  back btn need to be changed
		//testBackBtn();       
		driver.pressKeyCode(AndroidKeyCode.BACK);
        objLandingPage.checkPage();
		objLandingPage.getLoginLabel().click();

		// test successful login
		testSuccessfulLogin(); 
		 
	}
	 
}
