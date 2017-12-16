package sat.sidechef.pages;

/*
 * This Page actually contains many pages, 
 * since the whole tutorial is composed of many pages.
 * 
 */

//import java.util.HashMap;
//import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.TutorialPage;


public class SCTutorialPage extends TutorialPage{
	
	public SCTutorialPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*overwrite BB single texts components,for there are some differences between the tutorial of BB and SC, 
	 * so we need to seperate the differences 
	 */
	
	public String main_tip_title_text = "Welcome to the SideChef Tutorial";
	public String bm_tip_body_text = "to save recipes or add to mealplan";
	public String scroll_tip_body_text = "to see recipe overview";
	public String scroll_text = "Scroll down";	
	
	    By welcomeTxtID = By.id("tutorialText");
		By bookmarkMainTxtID = By.id("bookmarkMainText");
		By scroll_tip_body_ID = By.id("bookmarkMainText");
		By tipConfirmBtnID = By.id("confirmButton");
		By overview_scroll_boardID = By.id("previewScrollView");
		By tipTitleTxtID = By.id("tipTitleText");
		
	   public void checkMainpage() throws InterruptedException{
		
		   super.checkMainpage();
		   Assert.assertEquals(driver.findElement(welcomeTxtID).getText(), main_tip_title_text);		
		
	}
	   
	   public void checkTapBookMark() throws InterruptedException{
		  
		        
		        super.checkTapBookMark();
		        Assert.assertEquals(driver.findElement(bookmarkMainTxtID).getText(), bm_tip_body_text);
		        driver.findElement(tipConfirmBtnID).click();
    			// scroll tip board
    			Assert.assertNotNull(driver.findElement(overview_scroll_boardID));
    			Assert.assertEquals(driver.findElement(tipTitleTxtID).getText(), scroll_text);
    			Assert.assertEquals(driver.findElement(scroll_tip_body_ID).getText(), scroll_tip_body_text);
	   			
	   }
	
	// SC universal components and text
	
	//universal components of homepage
	By topLogoID =By.id("top_logo");
	By homeFilterID =By.id("filter");
	By homeBtnID= By.id("bottomButtonHome");
	By searchBtnID= By.id("bottomButtonSearch");
	By articleBtnID= By.id("bottomButtonArticles");
	By mealPlanBtnID= By.id("bottomButtonMealPlan");
	By profileBtnID=By.id("bottomButtonProfile");
	
	
	public void checkHomeMainpage() throws InterruptedException{
		// top logo and bottom navigation bar components should always be there
		Assert.assertNotNull(driver.findElement(topLogoID));
		Assert.assertNotNull(driver.findElement(homeFilterID));
		Assert.assertNotNull(driver.findElement(homeBtnID));
		Assert.assertNotNull(driver.findElement(searchBtnID));
		Assert.assertNotNull(driver.findElement(articleBtnID));
		Assert.assertNotNull(driver.findElement(mealPlanBtnID));
		Assert.assertNotNull(driver.findElement(profileBtnID));
	}
	
	
}
