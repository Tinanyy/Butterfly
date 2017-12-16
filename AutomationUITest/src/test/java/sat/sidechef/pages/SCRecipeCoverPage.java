package sat.sidechef.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.common_pages.RecipeCoverPage;

public class SCRecipeCoverPage extends RecipeCoverPage{
	
	AndroidDriver<AndroidElement> driver;

	public SCRecipeCoverPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	@Override
	public void checkPage(){
		super.checkPage();
		//Assert.assertNotNull(this.getRecipeAuthorNameLabel());
		//Assert.assertNotNull(this.getRecipeAuthorProfileImage());
	}

	public String jumpToUser() {
		String userName;
		userName = this.getRecipeAuthorNameLabel().getText();
		this.getRecipeAuthorProfileImage().click();
		return userName;
	}
	
}
