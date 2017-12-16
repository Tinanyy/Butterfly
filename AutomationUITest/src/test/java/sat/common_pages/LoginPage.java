package sat.common_pages;

/*
 * This is the page for login.
 * 
 */

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.testbases.Page;

public class LoginPage extends Page{
	
	public LoginPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	
	/*
	 * components ID
	 */
	
	// top bar items
	By backBtnID = By.id("back");					// back btn
	By loginLableID = By.id("topBarTitle");			// "Log in"
	
	// page body items
	By userNameID = By.id("et_login_username");	// username field, put email here
	By pwdID = By.id("et_login_password");	// pwd field
	By loginBtnID = By.id("btn_login_signin"); // login btn
	By forgetPwdID = By.id("tv_login_forgot");	// "forget password?"
	
	// Error info 
	By pwdErrMesID = By.id("tv_login_tip");       // Error pwdMessage: ""
	
	By nameErrMesID = By.id("tv_login_tip");       // Error nameMessage: ""
    //deal with no google
	//By noGoogleSerID = By.id("message");
	
	/*
	 * get components
	 */
	
	// return Log in title
	public AndroidElement getTitleLabel(){
		return (AndroidElement) driver.findElement(loginLableID); 
	}
	
	public AndroidElement getBackBtn(){
		return driver.findElement(backBtnID);
	}
	
	public AndroidElement getUserNameField(){
		return driver.findElement(userNameID);
	}
	
	public AndroidElement getPwdField(){
		return driver.findElement(pwdID);
	}
	
	public AndroidElement getLoginBtn(){
		return driver.findElement(loginBtnID);
	}

	public AndroidElement getErrPwd(){
		return (AndroidElement) driver.findElement(pwdErrMesID);
	}
	public AndroidElement getErrName(){
		return (AndroidElement) driver.findElement(nameErrMesID);
	}
	
	// return forget password label
	public AndroidElement getForgetPwdLabel(){
		return (AndroidElement) driver.findElement(forgetPwdID);
	}
	
	
	
	/*
	 * manipulate components
	 */
	
	// click on login button
	public void clickLoginBtn(){
		getLoginBtn().click();
	}
	
	// click on back button
	public void clickBackBtn(){
			getBackBtn().click();
	}

	// set username in the username textbox
	public void setUserNameText(String strUsername){
		getUserNameField().sendKeys(strUsername);
	}
	
	// set password in the password textbox
	public void setPasswordText(String strPassword){
		getPwdField().sendKeys(strPassword);
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
	
	}
	*/
	//interface to test case
	
  public void loginSidechef(String strUsername, String strPassword){
	   setUserNameText("");
		setUserNameText(strUsername);
	    setPasswordText("");
		setPasswordText(strPassword);
		System.out.println("method 1");
		clickLoginBtn();
	}

	
	@Override
	public void checkPage() {
		Assert.assertNotNull(getBackBtn());
		Assert.assertNotNull(getTitleLabel());
		Assert.assertNotNull(getUserNameField());
		Assert.assertNotNull(getPwdField());
		Assert.assertNotNull(getLoginBtn());
		Assert.assertNotNull(getForgetPwdLabel());
	}
	
}