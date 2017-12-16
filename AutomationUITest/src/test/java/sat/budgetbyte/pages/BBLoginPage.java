package sat.budgetbyte.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.LoginPage;

public class BBLoginPage extends LoginPage{

	public BBLoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	//interface to test case
		public void loginBB(String strUsername, String strPassword){
			setUserNameText("");
			setUserNameText(strUsername);
			setPasswordText("");
			setPasswordText(strPassword);
			clickLoginBtn();
		}
		
	  public void loginBB()
	{
		setUserNameText("");
		setUserNameText("tina@sidechef.com");
		setPasswordText("");
		setPasswordText("12345678Nyy");
		clickLoginBtn();
	}
	
}
