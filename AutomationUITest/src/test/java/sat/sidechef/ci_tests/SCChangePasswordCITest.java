package sat.sidechef.ci_tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.sidechef.pages.SCChangePasswordPage;
import sat.sidechef.pages.SCLoginPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;
import sat.sidechef.pages.SCTutorialPage;
import sat.sidechef.pages.SCLandingPage;
public class SCChangePasswordCITest extends SideChefCITestBase{

	SCChangePasswordPage objChangePwd;
	SCMisc objMisc;
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCLoginPage objLogin;
	@BeforeMethod
	public void setUp() {
		// TODO Auto-generated method stub
		objChangePwd=new SCChangePasswordPage(driver);
	    objMisc=new SCMisc(driver);
	    objTutorial=new SCTutorialPage(driver);
	    objLanding=new SCLandingPage(driver);
	    objLogin=new SCLoginPage(driver);
	}
     
	@Test
     public void testChangePassword() throws InterruptedException{
	  signIn();   //verify login to make sure the account is useful
	  objChangePwd.enterChangePwdPage();
	  objChangePwd.checkPage();
	  objChangePwd.inputPwd();
	  objChangePwd.clickCheckMark();
	  TimeUnit.SECONDS.sleep(1);
	  objMisc.swipeToUp(500,2);
	  objChangePwd.clickLogOutLabel();	
	  loginWithNewPwd();
	  /*for we use production server to test, could not change the production data easily,
	   *  so we just change the pwd back in a stupid way..
	   */
	  objChangePwd.enterChangePwdPage();
	  objChangePwd.inputPwdBack();
	  objChangePwd.clickCheckMark(); 
	  TimeUnit.SECONDS.sleep(1);
	  
}

     public void signIn() throws InterruptedException{
    	objTutorial.skipTutorial();
    	objLanding.dealNoGoogle();
    	objLanding.getLoginLabel().click();
 		objLogin.dealNoGoogle();
 		objChangePwd.login("tina@sidechef.com","123456Nyy");
 		TimeUnit.SECONDS.sleep(2);
 		objMisc.allowPermission();
     }
     
     public void loginWithNewPwd() throws InterruptedException{
      /*	driver.quit();
 		capabilities.setCapability("appActivity", ".activity.LoginActivity");
 		driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
 		
 	//	SCLoginPage objLogin = new SCLoginPage(driver);
    		objLanding.dealNoGoogle();
        	objLanding.getLoginLabel().click();
 		objLogin.dealNoGoogle();
 		objChangePwd.login("tina@sidechef.com", "12345678Nyy");
 	//	objMisc = new SCMisc(driver);
 		TimeUnit.SECONDS.sleep(3);
 		objMisc.allowPermission();
    	 }
}
