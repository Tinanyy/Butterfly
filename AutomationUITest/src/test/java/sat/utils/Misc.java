package sat.utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.common_pages.LandingPage;
import sat.common_pages.LoginPage;
import sat.common_pages.ProfilePage;
import sat.common_pages.ProfilePreviewPage;
import sat.common_pages.RecipeCoverPage;
import sat.common_pages.TutorialPage;
/*
 * This is the page which contains many miscellaneousness.
 * Really, you can call it alerts if you want(for now).
 * 
 */
public class Misc {
	
	protected final AndroidDriver<AndroidElement> driver;
	
	TutorialPage objTutorial;
	LandingPage objLanding;
	LoginPage objLogin;
	Misc objMisc;
	
	ProfilePreviewPage objProfilePreview;
	ProfilePage objProfile;
	RecipeCoverPage objRecipeCover;
	By noGoogleSerID = By.id("message");
	

	public Misc(AndroidDriver<AndroidElement> driver){
		this.driver = driver;		
		
		// set up pages
		objTutorial = new TutorialPage(driver);
		objLanding = new LandingPage(driver);
		objLogin = new LoginPage(driver);
		objProfilePreview = new ProfilePreviewPage(driver);
		objProfile = new ProfilePage(driver);
		
		objRecipeCover = new RecipeCoverPage(driver);
	}
	 

	public void loginFromSplash(TutorialPage objTutorial, LandingPage objLanding, LoginPage objLogin){		
		
			objTutorial.skipTutorial();
			this.dealNoGoogle();
			objLanding.getLoginLabel().click();
			this.dealNoGoogle();
			objLogin.loginSidechef("tina@sidechef.com","123456Nyy");
			this.allowPermission();
	}
	
	public void skipLogin(TutorialPage objTutorial, LandingPage objLanding){
		
		objTutorial.skipTutorial();
		this.dealNoGoogle();
		objLanding.getSkipLabel().click();
		this.allowPermission();
	}
	
	public void allowPermission(){
	
		/*
		try{
			driver.findElementByAndroidUIAutomator("text(\"ALLOW\")").click();
		}catch(Exception e){
			System.out.println("can't catch 'ALLOW', means class findElementByAndroidUIAutomator doesn't work here,"
					+ " So we gusses its id is \"button1\",hope it works");
			try{
				driver.findElement(By.id("button1")).click();
			}catch(Exception noAllow){
				System.out.println("fine....");
			
			}
		}
		*/
		try{
		
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}
		catch(Exception noAllow){
			System.out.println("there is no Allow pop up");
		}
		
	}
	
	/*
	 * The function deal with situation without google service.
	 * 
	 * when running locally, we will get an "SideChef won't run without google service"
	 * alert, unfortunately, we wont get it when running in ADF.
	 * 
	 * "button1" is just the "OK", but may not work, so we use class "findElementByAndroidUIAutomator" 
	 * 
	 */
	public void dealNoGoogle(){
		AndroidElement noGoogleMes = (AndroidElement) driver.findElement(noGoogleSerID);
     if(noGoogleMes != null){
		try{
			driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
		}catch(Exception idNoEffect){
			
		}
		
		}
    
	}
	
	public void tapRecipe(int fingers,int during){
		
	}
	
}
