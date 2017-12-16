package sat.common_pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

/*
 * single user record.
 * 
 * you could say it as a sub page of search page(under user column).
 * we don't wanna mix things, so separate it, but really it just consists of three components.
 */


public class ProfilePreviewPage extends Page{

	public ProfilePreviewPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	// user image
	By userImageID = By.id("userProfile");
	
	// user name 
	By userNameID = By.id("userName");
	
	// user's latest recipe
	By userRecipeID = By.id("recipeSize");
	
	// "Follow" button, only in profile -> follower, click to follow
	By userFollowBtnID = By.id("followButton");
	
	// "Following" button, only in profile -> following, click to unfollow
	By userFollowingBtnID = By.id("followButton");

	
	/*
	 * get components
	 */
	
	public AndroidElement getUserImage(){
		return (AndroidElement) driver.findElement(userImageID);
	}
	
	public AndroidElement getUserName(){
		return (AndroidElement) driver.findElement(userNameID);
	}
	
	public AndroidElement getUserRecipe(){
		return (AndroidElement) driver.findElement(userRecipeID);
	}
	
	public AndroidElement getFollowBtn(){
		return (AndroidElement) driver.findElement(userFollowBtnID);
	}
	
	public AndroidElement getFollowingBtn(){
		return (AndroidElement)	driver.findElement(userFollowingBtnID);
	}
	
	
	/*
	 * util functions
	 */

	public String jumpToUser(){
		String userName = this.getUserName().getText();
		this.getUserImage().click();
		return userName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see scat.testbases.Page#checkPage()
	 */
	@Override
	public void checkPage() {
		Assert.assertNotNull(getUserImage());
		Assert.assertNotNull(getUserName());
	}
	
	
}
