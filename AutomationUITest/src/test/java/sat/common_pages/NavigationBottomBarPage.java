package sat.common_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBottomBarPage extends Page{
	
	public NavigationBottomBarPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID
	 */
	
	// Bottom bar background
	By btnHomeBkgID = By.id("bottomButtonHome");					// home
	By btnSearchBkgID = By.id("bottomButtonSearch");				// search
	By btnArticleBkgID = By.id("bottomButtonAdd");				// article
	By btnMealPlanBkgID = By.id("bottomButtonNotification");		// meal plan
	By btnProfileBkgID = By.id("bottomButtonMenu");				// profile
	
	// Bottom bar image 
	By btnHomeID = By.id("bottomButtonHomeImage");				// home
	By btnSearchID = By.id("bottomButtonSearchImage");			// search
	By btnArticleID = By.id("bottomButtonAddImageImage");			// article
	By btnMealPlanID = By.id("bottomButtonNotificationImage");	// meal plan
	By btnProfileID = By.id("bottomButtonMenuImage");				// profile
	

	
	/*
	 * util functions
	 */
	
	// the dimension of each nav bar button
	Dimension screenSize;
	int screenHeight;
	int screenWidth;
	int navBottomBarY;
	int btnHomeX;
	int btnSearchX;
	int btnArticleX;
	int btnMealPlanX;
	int btnProfileX;
	int unit;
	
	public void getCoordinate(){
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;	
		System.out.println("height: " + new Integer(screenHeight).toString());
		System.out.println("width: " + new Integer(screenWidth).toString());
		unit = screenWidth/(10);
		navBottomBarY = screenHeight - 50;
		btnHomeX = unit;
		btnSearchX = unit*3;
		btnArticleX = unit*5;
		btnMealPlanX = unit*7;
		btnProfileX = unit*9;
	}
	
	public WebElement getProfileIcon(){
		return driver.findElement(btnProfileBkgID);
	}
	
	// click home
	public void toHome(){
		this.getCoordinate();
		driver.swipe(screenWidth/2, navBottomBarY-500, screenWidth/2, navBottomBarY-400, 1000);
		driver.tap(1, btnHomeX, navBottomBarY,10);
	}
	
	// click search
	public void toSearch(){
		this.getCoordinate();
		driver.swipe(screenWidth/2, navBottomBarY-500, screenWidth/2, navBottomBarY-400, 1000);
		driver.tap(1, btnSearchX, navBottomBarY,10);
	}
	
	// click article
	public void toArticle(){
		driver.swipe(screenWidth/2, navBottomBarY-500, screenWidth/2, navBottomBarY-400, 1000);
		driver.tap(1, btnArticleX, navBottomBarY,10);
	}
	
	// click Meal plan
	public void toMealPlan(){
		this.getCoordinate();
		driver.swipe(screenWidth/2, navBottomBarY-500, screenWidth/2, navBottomBarY-400, 1000);
		driver.tap(1, btnMealPlanX, navBottomBarY,10);
	}
	
	// click profile
	public void toProfile(){
		this.getCoordinate();
		driver.swipe(screenWidth/2, navBottomBarY-500, screenWidth/2, navBottomBarY-400, 1000);
		driver.tap(1, btnProfileX, navBottomBarY,10);
//		driver.tap(1, 1297, 2328, 10);
/*	try{
			driver.findElement(By.xpath("//android.widget.RelativeLayout[@id='bottomButtonMenu']")).click();
		}catch(Exception Bkg){
			try{
				driver.findElement(btnProfile).click();
			}catch(Exception image){
				try{
					driver.findElement(btnProfileBkg).click();
				}catch(Exception text){
					System.out.println("bottom bar \"profile\" not functional.\n");
					System.exit(1);
				}	
			}
		}*/
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	
	
}
