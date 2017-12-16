package sat.common_pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

public class LandingPage extends Page{
	
	public LandingPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	
	/*
	 * components ID
	 */
	By facebookBtnID = By.id("iv_landing_facebook");
	By googleBtnID = By.id("iv_landing_google");
	By signUpBtnID = By.id("tv_landing_signup");
	By loginLabelID = By.id("tv_landing_havaaccount");
	By skipLabelID = By.id("tv_landing_skip");
	By noGoogleSerID = By.id("message");
	
	
	/*
	 * get components
	 */
	
	// return FB button
	public AndroidElement getFBBtn(){
		return (AndroidElement) driver.findElement(facebookBtnID);
	}
	
	// return Google button
	public AndroidElement getGoogleBtn(){
		return (AndroidElement) driver.findElement(googleBtnID);
	}
	
	// return Email Sign up button
	public AndroidElement getSignupBtn(){
		return (AndroidElement) driver.findElement(signUpBtnID);
	}
	
	// return login Label
	public AndroidElement getLoginLabel(){
		return (AndroidElement) driver.findElement(loginLabelID);
	}
	
	// return skip button
	public AndroidElement getSkipLabel(){
		return (AndroidElement) driver.findElement(skipLabelID);
	}

	
	/*
	 * util functions
	 */
	
	//This function deal with the situation which shows "Sidechef won't run withdout Google Play..."
	/*public void dealNoGoogle(){
		AndroidElement noGoogleMes = (AndroidElement) driver.findElement(noGoogleSerID);
		if(noGoogleMes != null){
			if(noGoogleMes.getText().contains("without Google Play")){
				driver.findElement(By.id("button1")).click();
			}
		}
	}*/

	@Override
	public void checkPage() {
		Assert.assertNotNull(getFBBtn());
		Assert.assertNotNull(getSignupBtn());
		Assert.assertNotNull(getLoginLabel());
		Assert.assertNotNull(getSkipLabel());
	}	
	
}
