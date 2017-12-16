package sat.sidechef.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.ProfilePreviewPage;

/*
 * single user record.
 * 
 * you could say it as a sub page of search page(under user column).
 * we don't wanna mix things, so separate it, but really it just consists of three components.
 */


public class SCProfilePreviewPage extends ProfilePreviewPage{
	
	public SCProfilePreviewPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
}
