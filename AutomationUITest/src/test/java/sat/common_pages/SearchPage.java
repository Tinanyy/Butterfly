package sat.common_pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

public class SearchPage extends Page{
	
	public SearchPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	// the top bar 
	By searchBtnID = By.id("searchButton");
	By searchTxtID = By.id("searchEditText");
	By searchKeyInputID = By.id("dropDownEdit");
	
	// the three subsearch field
	By searchRecipeID = By.id("searchRecipeText");
	By searchRecipeQuickTextID = By.id("quickText");
	
	By searchWikiID = By.id("searchExploreText");
	By searchWikiTypeID = By.id("type");
	By serachWikiTitleID = By.id("titleText");
	
	By searchUserID = By.id("searchUserText");
	/* the "subpages" of user column, its the ProfilePreviewPage*/
	
	// the search result page
	By searchBackID = By.id("closeButton");
	By searchKeyID = By.id("topBarTitle");
	By searchResultEmptyID = By.id("noResultTip");

	
	/*
	 * get components
	 */
	
	public AndroidElement getRecipeLable(){
		return (AndroidElement) driver.findElement(searchRecipeID);
	}
	
	public AndroidElement getWikiLabel(){
		return (AndroidElement) driver.findElement(searchWikiID);
	}
	
	public AndroidElement getUserLabel(){
		return (AndroidElement) driver.findElement(searchUserID);
	}
	
	public AndroidElement getQuickSearchText(){
		return (AndroidElement) driver.findElement(searchRecipeQuickTextID);
	}
	
	public AndroidElement getSearchResultKeyLabel(){
		return (AndroidElement) driver.findElement(searchKeyID);
	}
	
	
	/*
	 * manipulate components
	 */
	
	public void clickSearchBtn(){
		driver.findElement(searchBtnID).click();
	}
	
	public void clickBackBtn(){
		driver.findElement(searchBackID).click();
	}
	
	/*
	 * Here is the tricky part, once you click on(if you simply use senKeys, it will click firstly as well)
	 * the search text field. It will jump to the "search result" view. 
	 * So we click it explicitly, then sends key to the text field in current view, press "enter".
	 */
	public void setSearchText(String item, boolean isRecipe){
		if(isRecipe){
			driver.findElement(searchTxtID).click();
			driver.findElement(searchKeyInputID).sendKeys(item);
		}else{
			driver.findElement(searchTxtID).sendKeys(item);
		}
	}
	
	
	/*
	 * util functions
	 */
	
	public void search4Item(String item, boolean isRecipe){
		this.setSearchText(item,isRecipe);
		if(isRecipe){
			driver.pressKeyCode(66);					// press "enter" on device
		}else{
			driver.findElement(searchBtnID).click();
		}
	}
	
	public boolean isResultEmpty(){
		try{
			driver.findElement(searchResultEmptyID);
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see scat.testbases.Page#checkPage()
	 * 
	 * Search pages are very different between SC and BB
	 * 
	 */
	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	

}
