package sat.common_pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

public class RecipeOverviewPage extends Page{
	
	public RecipeOverviewPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}

	/*
	 * components ID
	 */
	
	// the top bar
	By backBtnID = By.id("back");
	By bookmarkID = By.id("bookmark");
	By likeID = By.id("like");
	By shareID = By.id("share");
	
	// the body
	By videoBtnID = By.id("videoButton");					// only for chefs from youtube
	By previewImageID = By.id("previewImage");
	By recipeNameID = By.id("overviewRecipeName");
	By starsViewID = By.id("starsView");					// rating view
	By timeTextID = By.id("minutesText");					// cooking time
	
	// like area
	By likeCountID = By.id("tvPreLikeCount");
	By cookbookCountID = By.id("cookbooks");
	
	// description area
	By descriptionID = By.id("description");
	
	// profile area
	By authorImageID = By.id("previewProfile");
	By authorNameID = By.id("name");
	By authorWebID = By.id("website");
	
	// serving area
	By serveSizeID = By.id("serversNum");
	By serveSubID = By.id("subtract");
	By serveAddID = By.id("add");
	
	// ingredients area
	By ingredientTitleID = By.id("ingredientsText");
	By ingredientUnitID = By.id("ingredientUnit");
	By ingredientNameID = By.id("ingredientName");			// "isClickable == true" if its a wiki
	By ingredientEmailID = By.id("emailShoppingListButton");
	
	// steps area
	By stepTitleID = By.id("stepTitle");					// the main title (i.e. "# Steps")
	By stepImageID = By.id("stepPhoto");
	By stepNumID = By.id("titleStep");						// subtitle(which step)
	By stepDescriptionID = By.id("stepDescription");
	
	// comment area
	By commentTitleID = By.id("listHeadTxt");
	By commentUserImageID = By.id("profileImage");
	By commentRatingID = By.id("starsView");
	By commentUserNameID = By.id("userName");
	By commentContentsID = By.id("comments");
	By commentflagID = By.id("flag");
	By commentViewAllID = By.id("listFootBtn");
	
	// user photos area
	By userPhotoTitleID = By.id("userPhotosTitle");
	By userPhotoImageID = By.id("image");
	By userPhotoUserImageID = By.id("profileImage");
	By userPhotoViewAllID = By.id("listFootBtn");

	// You might like area
	By youMightLikeTitleID = By.id("listHeadTxt");
	// all these recipes here are recipeCoverPage
	By viewMoreID = By.id("listFootBtn");
	
	// start cooking button
	By startCookingBtnID = By.id("cookRecipe");
	
	
	/*
	 * util functions
	 */

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
}
