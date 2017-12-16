package sat.common_pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import sat.testbases.Page;

public class WikiPage extends Page{

	public WikiPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//components ID
	
	By backBtnID=By.id("back");
	By likeIconID=By.id("like");
	By shareIconID=By.id("share");
	By typeID = By.id("wiki");
	By wikiNameID = By.id("titleText");
	By likeCountsID= By.id("likeCounts");
	By listHeadID=By.id("listHeadTxt");
	By contentTxtID=By.id("contentText");
	
	//get components

	public AndroidElement getBackBtn(){
		return driver.findElement(backBtnID);
	}
	
	public AndroidElement getLikeIcon(){
		return driver.findElement(likeIconID);
	}
	
	public AndroidElement getShareIcon(){
		return driver.findElement(shareIconID);
	}
	public AndroidElement getWikiType(){
		return driver.findElement(typeID);
	}
	
	public AndroidElement getWikiName(){
		return driver.findElement(wikiNameID);
	}
	
	public AndroidElement getLikeCounts(){
		return driver.findElement(likeCountsID);
	}
	public AndroidElement getListHead(){
		return driver.findElement(listHeadID);
	}
	public AndroidElement getContentTxt(){
		return driver.findElement(contentTxtID);
	}
	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		Assert.assertNotNull(getBackBtn());
		Assert.assertNotNull(getLikeIcon());
		Assert.assertNotNull(getShareIcon());
		Assert.assertNotNull(getWikiType());
		Assert.assertNotNull(getWikiName());
		Assert.assertNotNull(getLikeCounts());
		Assert.assertNotNull(getListHead());
		Assert.assertNotNull(getContentTxt());	
	}

}
