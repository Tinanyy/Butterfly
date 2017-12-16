package sat.sidechef.ci_tests;

/*
 * This test class tests the following function.
 * 
 * Two places we could follow a user.
 * - in the "Followers"  list in profile page(of user itself)
 * - in the profile page of other user
 * 
 * Once we follow somebody, he/she will be the first one in our "Following" list,
 * So, we follow him/her, check if he/she shows up in our following list, then we unfollow him/her,
 * check the number of following decreased by 1.
 */

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCProfilePage;
import sat.sidechef.pages.SCProfilePreviewPage;
import sat.sidechef.pages.SCSearchPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.SCMisc;

public class SCFollowCITest extends SideChefCITestBase{

	SCSearchPage objSearch;
	SCProfilePreviewPage objProfilePreview;
	SCProfilePage objProfile;
	SCNavigationBottomBarPage objNavBottomBar;
	SCMisc objMisc;
	
	// for login
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCLoginPage objLogin;
	
	int followingCountBefore;
	int followingCountAfter;
	String userName;
	
	@BeforeClass
	public void setUp(){
		
		objSearch = new SCSearchPage(driver);
		objProfilePreview = new SCProfilePreviewPage(driver);
		objProfile = new SCProfilePage(driver);
		objNavBottomBar = new SCNavigationBottomBarPage(driver);
		objMisc = new SCMisc(driver);
		
		objTutorial = new SCTutorialPage(driver);
		objLanding = new SCLandingPage(driver);
		objLogin = new SCLoginPage(driver);
	}
	
	
	/*
	 * This one test the "Follow" button in other users' profile pages.
	 * 
	 * we search one user then jump to his profile page, follow it.
	 */
	@Test
	public void testFollowUserInUserProfile() throws InterruptedException{
		
		// login first
	
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
		
		// get the # of following now
		objNavBottomBar.getProfileBtn();
		followingCountBefore = objProfile.getFollowingCount();
		
		// search and follow someone
		objNavBottomBar.clickSearchBtn();
		objSearch.getUserLabel().click();
		
		userName = "test_tina";                //please do not change the account easily,or you will need to modify a lot
		objSearch.search4Item(userName, false);
		
		if(objSearch.isResultEmpty()){
			System.out.println("The user you searched is not exist,please change another user to follow.");
			System.exit(-1);
		}
		
		userName = objProfilePreview.getUserName().getText();
		
		objProfilePreview.getUserImage().click();
		objProfile.getFollowBtn().click();
		
		// check we followed successfully 
		objNavBottomBar.getProfileBtn();
		this.checkAndUnfollow();
	}

	
	@Test
	public void testFollowUserInFollowerList() throws InterruptedException{
		
		// login first
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
		
		// get the # of following now
		objNavBottomBar.toProfile();
		followingCountBefore = objProfile.getFollowingCount();
		
		// now we go to follow the first one in our follower list
		objProfile.getFollowerBtn().click();
		TimeUnit.SECONDS.sleep(1);
		userName = objProfilePreview.getUserName().getText();
		objProfilePreview.getFollowBtn().click();
		objProfile.getBackBtn().click();
		
		// check we followed successfully 
		this.checkAndUnfollow();
	}
	
	public void checkAndUnfollow() throws InterruptedException{
		 
		TimeUnit.SECONDS.sleep(1);
		objMisc.swipeToDown(500, 1);
		followingCountAfter = objProfile.getFollowingCount();
		Assert.assertEquals(followingCountBefore + 1, followingCountAfter);				// the following number
		objProfile.getFollowingBtn().click();
		Assert.assertEquals(objProfilePreview.getUserName().getText(), userName);		// we do follow  him
		Assert.assertEquals(objProfilePreview.getFollowingBtn().getText(),"Following"); // click "following" to unfollow
		
		// unfollow him
		objProfilePreview.getFollowingBtn().click();
		Assert.assertEquals(objProfilePreview.getFollowingBtn().getText(),"Follow");	// now it should become "follow"
		objProfile.getBackBtn().click();
		TimeUnit.SECONDS.sleep(1);
		objMisc.swipeToDown(500, 1);
		Assert.assertEquals(followingCountBefore, objProfile.getFollowingCount());		// check the following number 
	}
	
	@Override
	@AfterMethod
	public void resetApp(){
		super.resetApp();
	}
	
}
