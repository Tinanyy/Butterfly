package sat.sidechef.ci_tests;

import org.testng.annotations.*;

import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCProfileEditPage;
import sat.sidechef.pages.SCProfilePage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;

public class SCProfileEditCITest extends SideChefCITestBase{

	SCLoginPage objLogin;
	SCMisc objMisc;
	SCProfilePage objProfile;
	SCProfileEditPage objProEdit;
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCNavigationBottomBarPage objNavBottom;
	
	@BeforeTest
	public void setUp(){
		// set up pages
		objTutorial = new SCTutorialPage(driver);
		objLogin = new SCLoginPage(driver);
		objMisc = new SCMisc(driver);
		objLanding = new SCLandingPage(driver);
		objProfile = new SCProfilePage(driver);
		objProEdit = new SCProfileEditPage(driver);
		objNavBottom = new SCNavigationBottomBarPage(driver);
	}
	
	@Test
	public void testEditProfile() throws InterruptedException{
		
		// login
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
		
		// go to Profile page
		objNavBottom.getProfileBtn();
		
		// get the current user info from profile page
		String oldname = objProfile.getMidUserName();
		String oldweb = objProfile.getWebsiteTxt();
		String oldbio = objProfile.getDescriptionTxt();
		objProfile.clickEditProfileBtn();
		
		// edit profile info through a profileEdit page
		objProEdit.changeProfile("test_name", "test_web", "test_bio");
		objProEdit.clickDoneBtn();
		
		// should have changed to what we entered
		assert(objProfile.checkUserinfo("test_name", "test_web", "test_bio"));
		
		// change user info back
		objProfile.clickEditProfileBtn();
		objProEdit.changeProfile(oldname, oldweb, oldbio);
		objProEdit.clickDoneBtn();
	} 
	
}

