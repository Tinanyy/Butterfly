package sat.sidechef.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.ProfilePage;

import org.junit.Assert;
import org.openqa.selenium.By;

public class SCProfilePage extends ProfilePage{
	
	
	public SCProfilePage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	// components of new SC profile page
	By topUserNameID = By.id("userName");						
	By topSettingBtnID = By.id("setting");	
	
	// personal infomations
	By midUserNameID = By.id("tv_profile_username");				
	By followerBtnID = By.id("tv_profile_follower");			
	By followerCountID=By.id("tv_profile_follower_count");
	By followingBtnID=By.id("tv_profile_following");
	By followingCountID=By.id("tv_profile_following_count");
	By descriptionTxtID=By.id("tv_profile_description");
	By websiteTxtID=By.id("tv_profile_website");
	
	//edit profile btn
	By editProfileBtnID=By.id("tv_profile_edit_profile");
	
	//tabs
	By cookBooksTabID=By.id("rb_profile_tag_cookbook");
	By likesTabID=By.id("rb_profile_tag_like");
	
	//cookbooks tab
	By cookBookNameID=By.id("tv_profile_cookbook_name");
	By cookBookCountID=By.id("tv_profile_cookbook_counts");
	
	//like tab
	By likeTypeTitleID=By.id("tv_profile_like_type");
	By likeNameID=By.id("tv_profile_like_name");
	
	
	// get components
	
	public AndroidElement getTopUserName(){
		return (AndroidElement) driver.findElement(topUserNameID); 
	}
	
	public AndroidElement getTopSettingBtn(){
		return (AndroidElement) driver.findElement(topSettingBtnID); 
	}
	public String getMidUserName(){
		return driver.findElement(midUserNameID).getText(); 
	}
	public AndroidElement getFollowerBtn(){
		return (AndroidElement) driver.findElement(followerBtnID); 
	}
	public int getFollowerCount(){
		return new Integer(driver.findElement(followerCountID).getText()); 
	}
	public AndroidElement getFollowingBtn(){
		return (AndroidElement) driver.findElement(followingBtnID); 
	}
	
	public int getFollowingCount(){
		return new Integer(driver.findElement(followingCountID).getText()); 
	}
	
	public String getDescriptionTxt(){
		return driver.findElement(descriptionTxtID).getText(); 
	}
	public String getWebsiteTxt(){
		return  driver.findElement(websiteTxtID).getText(); 
	}
	public AndroidElement getEditProfileBtn(){
		return (AndroidElement) driver.findElement(editProfileBtnID); 
	}
	public AndroidElement getCookBookTab(){
		return (AndroidElement) driver.findElement(cookBooksTabID); 
	}
	
	public AndroidElement getLikesTab(){
		return (AndroidElement) driver.findElement(likesTabID); 
	}
	
	public AndroidElement getCookBookName(){
		return (AndroidElement) driver.findElement(cookBookNameID); 
	}
	
	public AndroidElement getCookBookCount(){
		return (AndroidElement) driver.findElement(cookBookCountID); 
	}
	
	public AndroidElement getLikeType(){
		return (AndroidElement) driver.findElement(likeTypeTitleID); 
	}
	public AndroidElement getLikeName(){
		return (AndroidElement) driver.findElement(likeNameID); 
	}
	
	// click incidents
	public void clickEditProfileBtn(){
		getEditProfileBtn().click();
	}
	
	// this function check if these three field match expected value, used in EditProfileTest
		public Boolean checkUserinfo(String userName, String web, String bio){
			
			if(this.getMidUserName().contentEquals(userName) && 
					this.getWebsiteTxt().contentEquals(web) &&
					this.getDescriptionTxt().contentEquals(bio)){
				return true;
			}
			return false;
		}
	
}
