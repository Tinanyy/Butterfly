package sat.sidechef.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.RecipeOverviewPage;

public class SCRecipeOverViewPage extends RecipeOverviewPage{
	
	public SCRecipeOverViewPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
}
