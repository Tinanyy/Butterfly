package sat.budgetbyte.pages;
import sat.common_pages.TutorialPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BBTutorialPage extends TutorialPage{
	
	public BBTutorialPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	/*overwrite BB single texts components,for there are some differences between the tutorial of BB and SC, 
	 * so we need to seperate the differences 
	 */
   public String main_tip_title_text = "Welcome to the Budget Bytes Tutorial";
   public String bm_tip_body_text = "to save recipes";
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
	
	   // welcome info
	
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
}
