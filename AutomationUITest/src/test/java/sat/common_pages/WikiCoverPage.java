package sat.common_pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.testbases.Page;

public class WikiCoverPage extends Page{

	public WikiCoverPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * components ID
	 */
	
	By typeID = By.id("type");
	By wikiNameID = By.id("titleText");
	
	
	/*
	 * get components
	 */

	public AndroidElement getWikiNameLabel(){
		return driver.findElement(wikiNameID);
	}
	
	public AndroidElement getWikiTypeLabel(){
		return driver.findElement(typeID);
	}
	
	/*
	 * manipulate components
	 */
	public void clickWikiNameLabel(){
		this.getWikiNameLabel().click();
	}
	
	
	/*
	 * util functions
	 */
	public String getWikiName(){
		return driver.findElement(wikiNameID).getText();
	}
	
	public String jumpToWiki(){
		String wikiName;
		wikiName = this.getWikiName();
		this.clickWikiNameLabel();
		return wikiName;
	}
	
	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		Assert.assertNotNull(getWikiNameLabel());
		Assert.assertNotNull(getWikiTypeLabel());
	}


}
