package sat.common_pages;

/*
 * Page of article cover in Homescroll
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

import org.junit.Assert;
import org.openqa.selenium.By;


public class ArticleCoverPage extends Page{

	
	public ArticleCoverPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	/*
	 * components ID 
	 */
	By typeID = By.id("type");
	By titleID = By.id("titleText");
	
	
	/*
	 * get components
	 */
	
	// type should be "ARTICLE"
	public AndroidElement getTypeLabel(){
		return driver.findElement(typeID);
	}
	
	public AndroidElement getTitleLabel(){
		return driver.findElement(titleID);
	}

	
	/*
	 * util functions
	 */
	
	/*
	 * (non-Javadoc)
	 * @see scat.testbases.Page#checkPage()
	 */
	@Override
	public void checkPage() {
		Assert.assertNotNull(getTitleLabel());
		Assert.assertNotNull(getTypeLabel());
	}
	
	public String jumpToArticle(){
		String name;
		name = this.getTitleLabel().getText();
		this.getTitleLabel().click();
		return name;
	}
	
}
