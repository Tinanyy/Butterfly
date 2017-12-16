package sat.common_pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.testbases.Page;

public class RecipeCoverPage extends Page{
	

	public RecipeCoverPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	By recipePicID = By.id("recipePic");
	By recipeNameID = By.id("recipeName");
	By recipeAuthorNameID = By.id("authorName");
	By recipeAuthorProfileID = By.id("authorProfile");
	
	
	/*
	 * get components
	 */
	public AndroidElement getRecipeImage(){
		return driver.findElement(recipePicID);
	}
	
	public AndroidElement getRecipeNameLabel(){
		return driver.findElement(recipeNameID);
	}
	
	public AndroidElement getRecipeAuthorNameLabel(){
		return driver.findElement(recipeAuthorNameID);
	}
	
	public AndroidElement getRecipeAuthorProfileImage(){
		return driver.findElement(recipeAuthorProfileID);
	}
	
	
	/*
	 * util functions 
	 */
	
	public String jumpToRecipe(){
		String recipeName;
		recipeName = this.getRecipeNameLabel().getText();
		getRecipeImage().click();
		return recipeName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see scat.testbases.Page#checkPage()
	 * 
	 * the recipe covers of BB and SC are different
	 */

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		//Assert.assertNotNull(this.getRecipeImage());
		Assert.assertNotNull(this.getRecipeAuthorNameLabel());
		Assert.assertNotNull(this.getRecipeNameLabel());
	}
	
	
	
}
