package sat.sidechef.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.common_pages.SearchPage;

public class SCSearchPage extends SearchPage{
	
	AndroidDriver<AndroidElement>	driver;
	
	public SCSearchPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	@Override
	public void checkPage(){
		Assert.assertEquals("People", this.getUserLabel().getText());
		Assert.assertEquals("Recipes", this.getRecipeLable().getText());
		Assert.assertEquals("Wiki", this.getWikiLabel().getText());
	}

}
