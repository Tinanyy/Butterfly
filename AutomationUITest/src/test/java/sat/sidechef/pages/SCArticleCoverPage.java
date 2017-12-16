package sat.sidechef.pages;

/*
 * Page of article cover in Homescroll
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.ArticleCoverPage;


public class SCArticleCoverPage extends ArticleCoverPage{
	
	public SCArticleCoverPage(AndroidDriver<AndroidElement> driver){
		super(driver);
	}

}
