package sat.sidechef.ci_tests;
import org.testng.annotations.BeforeClass;
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
import sat.utils.JumpToHelper;
import sat.utils.SCMisc;

public class SCSearchUserCITest extends SideChefCITestBase{
	
	SCMisc objMisc;
	JumpToHelper ojbTestJumpTo;
	SCSearchPage objSearch;
	SCNavigationBottomBarPage objNavBottomBar;
	
	// for login 
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCLoginPage objLogin;
	
	// for user sub search page
	SCProfilePreviewPage objProfilePreview;
	SCProfilePage objProfile;
	
	boolean isRecipe;
	
	@BeforeClass
	public void setUp(){
		// set up pages
		objMisc = new SCMisc(driver);
		ojbTestJumpTo = new JumpToHelper();
		objSearch =  new SCSearchPage(driver);
		objNavBottomBar = new SCNavigationBottomBarPage(driver);
		
		objTutorial = new SCTutorialPage(driver);
		objLanding = new SCLandingPage(driver);
		objLogin = new SCLoginPage(driver);
	
		objProfilePreview = new SCProfilePreviewPage(driver);
		objProfile = new SCProfilePage(driver);
	
	
	}
	
	/*
	 *  empty result should be prompted for each kind of search(if your keyword has not match of course)
	 *  so this test is called in every test
	 */
	public void testSearchEmpty(boolean isRecipe){
		// search for "...", result should be empty
		objSearch.search4Item("...", isRecipe);
		Assert.assertTrue(objSearch.isResultEmpty());
		objSearch.clickBackBtn();
	}
	
	/*
	 *-----------------------------------------------------------------------------------------------------------------
	 * below is "search user" part, function names are quiet self-explanatory.
	 * 
	 */
	
	@Test            
	public void searchUserColumnTest(){
		
		isRecipe = false;
		
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
		objNavBottomBar.toSearch();
		
		objSearch.getUserLabel().click();
		objSearch.checkPage();
		
		// test empty result
		this.testSearchEmpty(isRecipe);
		
		// check user column
		this.testUserColumn();
		
		// test search users
		this.testsearchUser(isRecipe);
	
	}
	
	public void testUserColumn(){
		
		objSearch.getUserLabel().click();
		
		objProfilePreview.checkPage();
		Assert.assertNotNull(objProfilePreview.getUserRecipe());
		
		ojbTestJumpTo.testUserJumpTo(objProfilePreview, objProfile);
		
	}
	
	public void testsearchUser(boolean isRecipe){
		
		objSearch.getUserLabel().click();
		
		String userName = "automationyy";
		objSearch.search4Item(userName, isRecipe);
		
		if(!objSearch.isResultEmpty()){
			// if result is not empty, we check the result
			//Assert.assertNotNull(objProfilePreview.getUserImage());
			Assert.assertTrue(objProfilePreview.getUserName().getText().toLowerCase().contains(userName));
		}
		
		ojbTestJumpTo.testUserJumpTo(objProfilePreview, objProfile);
	}
	
	
}
	
	



