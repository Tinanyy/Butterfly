package sat.common_pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ProfilePage extends Page{
	
	
	public ProfilePage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	// Header components
	By nameLabelID = By.id("userName");
	
	// User info
	By userImageID = By.id("profileImage");
	
	// followers view
	By userFollowersID = By.id("followerView");
	By userFollowersCountID = By.id("followersCount");
	By userFollowersTextID = By.id("followersText");
	
	// following view
	By userFollowingID = By.id("followingView");
	By userFollowingCountID = By.id("followingCount");
	By userFollowingTextID = By.id("followingText");
	
	By userRealNameID = By.id("realName");
	By userDecriptionID = By.id("description");
	By userWebsiteID = By.id("website");
	By userDropDownBtnID = By.id("dropDownTitle");
	
	// only for profile page of user itself
	By settingBtnID = By.id("setting");
	By editBtnID = By.id("followButton");				// "Edit" btn, counterpart of "Follow" btn
	
	// only for profile pages of other users
	By backBtnID =  By.id("back");	
	By followBtnID = By.id("tv_profile_edit_profile"); // UI changes and now this id is the copy of edit btn
	
	
	// cookbook part
	By cookbookTitleID = By.id("title");				// cookbook name or "Sorry, no cookbook results."
	// below only when user has cookbook
	By cookbookTypeID = By.id("type");
	By cookbookCountsID = By.id("counts");
	By cookbookImageID = By.id("mainImage");
	
	// strings
	private String noCookBookText = "Sorry, no cookbook results.";
	
	
	/*
	 * get components
	 */
	
	public AndroidElement getBackBtn(){
		return (AndroidElement) driver.findElement(backBtnID);
	}
	
	public AndroidElement getUserNameLabel(){
		return (AndroidElement) driver.findElement(nameLabelID);
	}
	
	public AndroidElement getProfileImage(){
		return (AndroidElement) driver.findElement(userImageID);
	}
	
	public AndroidElement getFollowersField(){
		return (AndroidElement) driver.findElement(userFollowersID);
	}
	
	public AndroidElement getFollowingField(){
		return (AndroidElement) driver.findElement(userFollowingID);
	}
	
	public AndroidElement getFollowBtn(){
		return (AndroidElement) driver.findElement(followBtnID);
	}
	
	public AndroidElement getDropDownBtn(){
		return (AndroidElement) driver.findElement(userDropDownBtnID);
	}
	
	public AndroidElement getCookBookTitle(){
		return (AndroidElement) driver.findElement(cookbookTitleID);
	}
	
	
	/*
	 * manipulate components
	 */
	
	public void clickEditBtn(){
		driver.findElement(editBtnID).click();
	}
	
	public void clickSettingLabel(){
		driver.findElement(settingBtnID).click();
	}
	
	public void clickUserWebLabel(){
		driver.findElement(userWebsiteID).click();
	}
	
	
	/*
	 * util functions
	 */
	
	// following functions return profile info
	
	public String getRealName(){
		return driver.findElement(userRealNameID).getText();
	}
	
	public String getWeb(){
		return driver.findElement(userWebsiteID).getText();
	}
	
	public String getBio(){
		return driver.findElement(userDecriptionID).getText();
	}
	
	public int getFolloersCount(){
		return new Integer(driver.findElement(userFollowersCountID).getText());
	}
	
	public int getFollowingCount(){
		return new Integer(driver.findElement(userFollowingCountID).getText());
	}
	
	
	// this function check if these three field match expected value, used in EditProfileTest
	public Boolean checkUserinfo(String userName, String web, String bio){
		
		if(this.getRealName().contentEquals(userName) && 
				this.getWeb().contentEquals(web) &&
				this.getBio().contentEquals(bio)){
			return true;
		}
		return false;
	}
	
	// this function make sure that the components show up as expected
	public void checkPage(){
		
		Assert.assertNotNull(this.getUserNameLabel());
		Assert.assertNotNull(this.getProfileImage());
		Assert.assertNotNull(this.getFollowersField());
		Assert.assertNotNull(this.getFollowingField());
		Assert.assertNotNull(this.getDropDownBtn());
		
		// assert cookbook
		Assert.assertNotNull(this.getCookBookTitle());
		
		// if user has cookbooks, then they should appear properly 
		if(this.getCookBookTitle().getText() != noCookBookText){
			Assert.assertNotNull(driver.findElement(cookbookImageID));
			Assert.assertNotNull(driver.findElement(cookbookTypeID));
			Assert.assertNotNull(driver.findElement(cookbookCountsID));
		}
		
	}
	
	//Probably we want to figure out the right way to test these cookbook
	
}
