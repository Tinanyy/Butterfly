package sat.sidechef.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.NavigationBottomBarPage;

public class SCNavigationBottomBarPage extends NavigationBottomBarPage{
	
	public SCNavigationBottomBarPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	// Bottom bar background
	By btnHomeBkgID = By.id("bottomButtonHome");					// home
	By btnSearchBkgID = By.id("bottomButtonSearch");				// search
	By btnArticleBkgID = By.id("bottomButtonArticles");				// article
	By btnMealPlanBkgID = By.id("bottomButtonMealPlan");		// meal plan
	By btnProfileBkgID = By.id("bottomButtonProfile");				// profile
	
	
	public AndroidElement getHomeBtnLabel(){
		return (AndroidElement) driver.findElement(btnHomeBkgID);
	}
	
	public AndroidElement getSearchBtnLabel(){
		return (AndroidElement) driver.findElement(btnSearchBkgID);
	}
	public AndroidElement getArticleBtnLabel(){
		return (AndroidElement) driver.findElement(btnArticleBkgID);
	}
	public AndroidElement getMealPlanLabel(){
		return (AndroidElement) driver.findElement(btnMealPlanBkgID);
	}
	public AndroidElement getProfileLabel(){
		return (AndroidElement) driver.findElement(btnProfileBkgID);
	}
	
	public void clickHomeBtn(){
		getHomeBtnLabel().click();
	}
	public void clickSearchBtn(){
		getSearchBtnLabel().click();
	}
	public void clickArticleBtn(){
		getArticleBtnLabel().click();
	}
	public void clickMealPlanBtn(){
		getMealPlanLabel().click();
	}
	public void getProfileBtn(){
		getProfileLabel().click();
	}
}
