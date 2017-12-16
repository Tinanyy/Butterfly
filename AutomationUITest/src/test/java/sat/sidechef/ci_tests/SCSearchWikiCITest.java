package sat.sidechef.ci_tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCSearchPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.sidechef.pages.SCWikiCoverPage;
import sat.sidechef.pages.SCWikiPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.JumpToHelper;
import sat.utils.SCMisc;

public class SCSearchWikiCITest extends SideChefCITestBase{
	SCMisc objMisc;
	JumpToHelper ojbTestJumpTo;
	SCSearchPage objSearch;
	SCNavigationBottomBarPage objNavBottomBar;
	
	// for login 
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCLoginPage objLogin;
	
	
	
	// for wiki sub search page
	SCWikiCoverPage objWikiCover;
	SCWikiPage objWiki;
	
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
		
		objWikiCover = new SCWikiCoverPage(driver);
		objWiki = new SCWikiPage(driver);
	}
	
	
	@Test
	public void searchWikiColumnTest() throws InterruptedException{
		
		isRecipe = false;
		
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
//		objMisc.skipLogin(objTutorial, objLanding);
		objNavBottomBar.toSearch();
		
		objSearch.getWikiLabel().click();
		objSearch.checkPage();
		
		// test empty result
		this.testSearchEmpty(isRecipe);	
		
		// test wiki column 
		this.testWikiColumn();
		
		// test search wiki
		this.testSearchWiki(isRecipe);
	}
	
	public void testWikiColumn(){
		
		objWikiCover.checkPage();
		ojbTestJumpTo.testWikiJumpTo(objWikiCover, objWiki);
		objWiki.getBackBtn().click();
		
	}
	
	public void testSearchEmpty(boolean isRecipe){
		// search for "...", result should be empty
		objSearch.search4Item("...", isRecipe);
		Assert.assertTrue(objSearch.isResultEmpty());
		objSearch.clickBackBtn();
	}
	
	
	public void testSearchWiki(boolean isRecipe) throws InterruptedException 
	{
		
	    int times=0;
		boolean passed = false;
		isRecipe = false;
		
		String keyWord = "apple";
		objSearch.search4Item(keyWord, isRecipe);
		TimeUnit.SECONDS.sleep(3);
		objWikiCover.checkPage();
		
		// make sure we got the right result
				ArrayList<AndroidElement> wikiNames;
				wikiNames = (ArrayList<AndroidElement>) driver.findElements(By.id("titleText"));
				

				do{
					for(AndroidElement wikiName : wikiNames){
						if(wikiName.getText().contains(keyWord)){
							passed = true;
							break;
						}
					}
					objMisc.swipeToUp(1000, 1);
				 wikiNames = (ArrayList<AndroidElement>) driver.findElements(By.id("titleText"));
				}while(++times<2 & !passed);
				
				Assert.assertTrue(passed);
			}
			
}
	
	


