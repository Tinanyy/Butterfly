package sat.utils;
import java.util.concurrent.TimeUnit;
import sat.utils.Misc;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BBMisc extends Misc{

	public BBMisc(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	//override the method of scrollDown before
		public void swipeToUp(int duration,int num) throws InterruptedException{
		     TimeUnit.SECONDS.sleep(1);
			int width =driver.manage().window().getSize().width;
			int height =driver.manage().window().getSize().height;
			System.out.println(width);
			System.out.println(height);
			for (int i=0;i<num;i++){
				driver.swipe(width/2, height*3/4, width/2, height/4, duration);
				TimeUnit.SECONDS.sleep(1);
			}
			
		}
			
		public void tapRecipe(int fingers,int during)
	  {
		  int widthRecipe=driver.manage().window().getSize().width;
		  int heightRecipe=driver.manage().window().getSize().height;
		  System.out.println(widthRecipe);
		  System.out.println(heightRecipe);
		driver.tap(fingers, widthRecipe/2, heightRecipe*3/4, during);
		  
	  }
}
