package sat.budgetbyte.ci_tests;

import org.testng.annotations.*;
import sat.budgetbyte.pages.BBLandingPage;
import sat.budgetbyte.pages.BBLoginPage;
import sat.budgetbyte.pages.BBTutorialPage;
import sat.testbases.BudgetByteCITestBase;
import sat.utils.BBMisc;
/* 
 * in this test,we want to test all login issue with BB
 * we could login BB with e-mail,FB,Google now,
 * so we need to test this three method,we also include skip choice in this test*/
public class BBLoginCITest extends BudgetByteCITestBase{
	
	BBLandingPage objBBLanding;
	BBLoginPage objBBLogin;
	BBTutorialPage objBBTutorial;
	BBMisc objBBMisc;
	
	@Override
	@BeforeClass
	public void setUp() {
		objBBLanding = new BBLandingPage(driver);
		objBBLogin = new BBLoginPage(driver);
		objBBTutorial =new BBTutorialPage(driver);
		objBBMisc =new BBMisc(driver);
	}
	
	
    public void testSuccessfulLogin(){
	 
    	objBBLogin.dealNoGoogle();
    	objBBLogin.loginBB();  //true test
    	
    	
    }
    public void testFailedLogin(){
		//deal with noGoogle
		objBBLogin.dealNoGoogle();
		// send wrong info to login
		objBBLogin.loginBB("tina@sidechef.com", "123");
		assert(objBBLogin.getErrPwd() != null);
		
		objBBLogin.loginBB("tina.tina.sidechef.com", "123456");
		assert(objBBLogin.getErrName() != null);
		
		
	}
    
    public void loginWithFB(){
    	
    }
    
    public void loginWithGoogle(){
    	
    }
    
    public void skipTutorial(){
    
    	objBBTutorial.skipTutorial();
		
		objBBLanding.dealNoGoogle();
		
		objBBLanding.checkPage();
		
		objBBLanding.getLoginLabel().click();
    }
    
public void testBackBtn(){
		
		objBBLogin.clickBackBtn();
		
		objBBLanding.checkPage();
		
		objBBLanding.getLoginLabel().click();
	}

@Test
public void loginTest(){

	// skip tutorial
	skipTutorial();
	
	// test failed login
	testFailedLogin();
	
	// test the "back" button
	testBackBtn();
	
	// test successful login
	testSuccessfulLogin();
	
	
}

}
