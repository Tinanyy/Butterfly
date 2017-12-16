package sat.sidechef.ci_tests;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCLoginPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCRecipeCoverPage;
import sat.sidechef.pages.SCSearchPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.testbases.SideChefCITestBase;
import sat.utils.JumpToHelper;
import sat.utils.SCMisc;

public class SCSearchRecipeCITest extends SideChefCITestBase{
	SCMisc objMisc;
	JumpToHelper ojbTestJumpTo;
	SCSearchPage objSearch;
	SCNavigationBottomBarPage objNavBottomBar;
	
	// for login 
	SCTutorialPage objTutorial;
	SCLandingPage objLanding;
	SCLoginPage objLogin;
	
	// for recipe sub search page
	SCRecipeCoverPage objRecipeCover;
	
	
	
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
		objRecipeCover = new SCRecipeCoverPage(driver);
	}
	
	public void testSearchEmpty(boolean isRecipe){
		// search for "...", result should be empty
		objSearch.search4Item("...", isRecipe);
		Assert.assertTrue(objSearch.isResultEmpty());
		objSearch.clickBackBtn();
	}
	
	
	@Test
	public void searchRecipeColumnTest() throws InterruptedException{
		
		isRecipe = true;
		
		objMisc.loginFromSplash(objTutorial, objLanding, objLogin);
//		objMisc.skipLogin(objTutorial, objLanding);
		objNavBottomBar.toSearch();
		
		// make sure the text shows properly 
		objSearch.getRecipeLable().click();
		objSearch.checkPage();
		
		// test empty result
		this.testSearchEmpty(isRecipe);
		
		// check recipe column and Quicksearch
		this.testRecipeColumn();
		
		// test search Recipe
		this.testSearchRecipe(isRecipe);
	}
	
	public void testRecipeColumn(){
		
		String searchKey = objSearch.getQuickSearchText().getText();
		objSearch.getQuickSearchText().click();
	
		// check the searching keyword matches quick search key
		Assert.assertEquals(searchKey, objSearch.getSearchResultKeyLabel().getText());
		
		// quick search must not be empty result, and recipe should appear properly.
		objRecipeCover.checkPage();
		
		/*
		 *  need to add testRecipeJumpTo here
		 */
		
		
		objSearch.clickBackBtn();
	
	}
	
	/*
	 * we search for "Beef": 
	 * although its quite reasonable that we just check if the result recipe name 
	 * contains the keyword, but still, we give it three shoots(swipe twice, should be at least 6 recipes).
	 * each time, we got all the recipe name, if they don't have recipe name, then we try next one, test past
	 * once we found the recipe which contains "beef" in its name.
	 * 
	 * Cause, when searching, the tag of recipe is matched, but we cant assume that the "tag" will always 
	 * appear in recipe name.
	 */
	public void testSearchRecipe(boolean isRecipe) throws InterruptedException{
		
		int times = 0;
		boolean passed = false;
		String keyWord = "Beef";
		objSearch.search4Item(keyWord, isRecipe);
		
		// shouldn't be empty result, and recipe should appear properly.
		objRecipeCover.checkPage();
		
		// make sure we got the right result
		ArrayList<AndroidElement> recipeNames;
		recipeNames = (ArrayList<AndroidElement>) driver.findElements(By.id("recipeName"));
		
		do{
			for(AndroidElement recipeName : recipeNames){
				if(recipeName.getText().contains(keyWord)){
					passed = true;
					break;
				}
			}
			//objMisc.scrollDown();
			objMisc.swipeToUp(1000, 1);
			recipeNames = (ArrayList<AndroidElement>) driver.findElements(By.id("recipeName"));
		}while(++times<3 & !passed);
		
		Assert.assertTrue(passed);
	}
	
}
