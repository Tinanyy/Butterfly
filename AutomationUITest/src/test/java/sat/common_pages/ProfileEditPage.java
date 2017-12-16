package sat.common_pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ProfileEditPage extends Page{
	
	public ProfileEditPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}

	/*
	 * components ID
	 */
	
	// header elements
	By closeBtnID = By.id("closeButton");
	By editLabelID = By.id("userName");
	By doneBtnID = By.id("doneButton");
	
	// So we have the profile edit page here too
	By userPhotoID = By.id("editPhoto");
	By userPhotoPromptID = By.id("changeTitle");
	By nameFieldID = By.id("editName");
	By webFieldID = By.id("profileEditWebsite");
	By bioFieldID = By.id("profileEditBio");
	
	
	/*
	 * get components
	 */
	
	public AndroidElement getDoneBtn(){
		return driver.findElement(doneBtnID);
	}
	
	public AndroidElement getCloseBtn(){
		return driver.findElement(closeBtnID);
	}
	
	
	/*
	 * manipulate components
	 */
	
	public void clickDoneBtn(){
		getDoneBtn().click();
	}
	
	public void clickCloseBtn(){
		getCloseBtn().click();
	}
	
	public void setUsernameText(String userName){
		driver.findElement(nameFieldID).sendKeys(userName);
	}
	
	public void setWebText(String web){
		driver.findElement(webFieldID).sendKeys(web);
	}
	
	public void setBioText(String bio){
		driver.findElement(bioFieldID).sendKeys(bio);
	}
	
	/*
	 * util functions
	 */
	
	public void changeProfile(String userName, String web, String bio){
		this.setUsernameText(userName);
		this.setWebText(web);
		this.setBioText(bio);
	}

	@Override
	public void checkPage() {
		// we use all the other components in our profileEditTest, so no need to assert them
		Assert.assertNotNull(getCloseBtn());
	}
	
	
}
