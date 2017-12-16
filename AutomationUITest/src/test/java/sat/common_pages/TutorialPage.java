package sat.common_pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Point;

//This Page actually contains many pages, since the whole tutorial is composed of many pages.
public class TutorialPage {
	protected final AndroidDriver<AndroidElement> driver;	
	public TutorialPage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
	}
	
	// components 
	By skipTxtID = By.id("skipText");						// "Skip" label should exit in every page of tutorial
	By tip_boardID = By.id("blackShade");					// the white tip board
	By tipTitleTxtID = By.id("tipTitleText");				// tip: "scroll down"
	By tipConfirmBtnID = By.id("confirmButton");			// the confirm button for each tip
	// this arrow one doesn't have ID, let's deal with it later
	By tipArrowDownID = By.id("NO_ID");					// tip: "⬇️"
	
	
	// text
	private String confirm_btn_text = "OK, got it.";	// text for confirm button
	private String skip_text = "Skip";					// text for skip label
	public String scroll_text = "Scroll down";			// text "Scroll down"
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	 * the main tutorial page
	 */
	
	// massages should be matched
	//public String main_tip_title_text = "Welcome to the SideChef Tutorial";
	public String main_tip_body_text = "and choose a recipe";
	
	// components
	By welcomeTxtID = By.id("tutorialText");		// welcome text
	By tipMainTxtID = By.id("tipMainText");		// scroll tip: "and choose a recipe"
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	 * skip tutorial page
	 */
	By alertTitleID = By.id("alertTitle");		// "skip tutorial?"
	By skipMsgID = By.id("message");				// "you may view the tutorial again in settings"
	By skipConfirmBtnID = By.id("button1");		// btn "OK"
	By skipConcelBtnID = By.id("button2");		// btn "cancel"
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	 * tutorial preview(recipe overview) page
	 */
	
	// massages should be matched
	private String bm_tip_title_text = "Tap the bookmark";
	//public String bm_tip_body_text = "to save recipes or add to mealplan";
	//public String scroll_tip_body_text = "to see recipe overview"; 
	private String tip_cook_title_text = "Tap the button";
	private String tip_cook_body_text = "to start cook mode";
	
	// top navigation
	By backID = By.id("back");
	By bookmarkID = By.id("bookmark");
	By likeID = By.id("like");
	By shareID = By.id("share");
	
	// bookmark tips
	By bookmarkTitleTxtID = By.id("bookmarkTitleText");
	By bookmarkMainTxtID = By.id("bookmarkMainText");
	
	// scroll tip board
	By overview_scroll_boardID = By.id("previewScrollView");
	//By scroll_tip_body_ID = By.id("bookmarkMainText");
	
	// start cooking tip
	By tip_cook_titleID = By.id("tapTitleText");
	By tip_cook_bodyID = By.id("tapMainText");
	
	
	
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	 * util functions
	 */
	
	public void skipTutorial(){
		driver.findElement(skipTxtID).click();
		driver.findElement(skipConfirmBtnID).click();
	}
	
	/*public void scrollDown() throws InterruptedException{
		TimeUnit.SECONDS.sleep(2);
		driver.swipe(730, 2150, 730, 700, 100);
		driver.swipe(730, 2170, 730, 700, 100);
		TimeUnit.SECONDS.sleep(2);
	}  */

	
	/*
	 * check the main page of tutorial, everything should be there and appear as expected.
	 * of course we could only check their text, too bad
	 */
	public void checkMainpage() throws InterruptedException{
		
		// skip should always be there
		Assert.assertEquals(driver.findElement(skipTxtID).getText(), skip_text);
		// welcome info
		//Assert.assertEquals(driver.findElement(welcomeTxtID).getText(), main_tip_title_text);		
		// scroll tip board
		Assert.assertNotNull(driver.findElement(tip_boardID));
		Assert.assertEquals(driver.findElement(tipTitleTxtID).getText(), scroll_text);
		Assert.assertEquals(driver.findElement(tipMainTxtID).getText(), main_tip_body_text);
        //		Assert.assertNotNull(driver.findElement(tipArrowDown));
	}
    public void checkTapBookMark() throws InterruptedException{
    	Assert.assertEquals(driver.findElement(skipTxtID).getText(), skip_text);
    	      // the top navbar
    		//	Assert.assertNotNull(driver.findElement(backID));
    			Assert.assertNotNull(driver.findElement(bookmarkID));
    			Assert.assertNotNull(driver.findElement(likeID));
    			Assert.assertNotNull(driver.findElement(shareID));
    			// the bookmark tips
    			Assert.assertNotNull(driver.findElement(tip_boardID));
    			Assert.assertEquals(driver.findElement(bookmarkTitleTxtID).getText(), bm_tip_title_text);
    		//	Assert.assertEquals(driver.findElement(bookmarkMainTxtID).getText(), bm_tip_body_text);
    			Assert.assertEquals(driver.findElement(tipConfirmBtnID).getText(), confirm_btn_text);
    			// click "OK, I got it" and check the "scroll down" tip 
    	/*
    	 *      driver.findElement(tipConfirmBtnID).click();
    			// scroll tip board
    			Assert.assertNotNull(driver.findElement(overview_scroll_boardID));
    			Assert.assertEquals(driver.findElement(tipTitleTxtID).getText(), scroll_text);
    			Assert.assertEquals(driver.findElement(scroll_tip_body_ID).getText(), scroll_tip_body_text);
    			*/
    }
    
    public void checkTapTheBtn() throws InterruptedException{
    	// tips to press start cooking
    			Assert.assertNotNull(driver.findElement(tip_boardID));
    			Assert.assertEquals(driver.findElement(tip_cook_titleID).getText(), tip_cook_title_text);
    			Assert.assertEquals(driver.findElement(tip_cook_bodyID).getText(), tip_cook_body_text);
    }
	
	public void checkStepByStep(){
		
		AndroidElement cooking_tip = driver.findElement(tip_cook_bodyID);
		Point tip_cook_point =  cooking_tip.getCenter();	
		driver.tap(1, tip_cook_point.x, tip_cook_point.y+150, 10);
		
	}
	
}
