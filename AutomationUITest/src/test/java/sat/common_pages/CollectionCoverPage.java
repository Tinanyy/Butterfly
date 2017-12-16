package sat.common_pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.testbases.Page;

public class CollectionCoverPage extends Page{
	
	public CollectionCoverPage(AndroidDriver<AndroidElement> driver){
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
	
	// type should be "COLLECTION"
	public AndroidElement getTypeLabel(){
		return driver.findElement(typeID);
	}
	
	public AndroidElement getTitleLabel(){
		return driver.findElement(titleID);
	}

	@Override
	public void checkPage() {
		Assert.assertNotNull(getTypeLabel());
		Assert.assertNotNull(getTitleLabel());
	}
	
	public String jumpToCollection(){
		String name;
		name = this.getTitleLabel().getText();
		this.getTitleLabel().click();
		return name;
	}

}
