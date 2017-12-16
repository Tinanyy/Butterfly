package sat.utils;
import sat.utils.Misc;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SCMisc extends Misc {
	
	public SCMisc(AndroidDriver<AndroidElement> driver){
		super(driver);
	}
	
	//override the method of scrollDown before
	public void swipeToUp(int duration,int num) throws InterruptedException{
	     TimeUnit.SECONDS.sleep(2);
		int width =driver.manage().window().getSize().width;
		int height =driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
		for (int i=0;i<num;i++){
			driver.swipe(width/2, height*3/4, width/2, height/4, duration);
			driver.swipe(width/2, height*3/4, width/2, height/4, duration);
			TimeUnit.SECONDS.sleep(1);
		}
		
	}
	
	public void swipeToDown(int duration,int num) throws InterruptedException{
	     TimeUnit.SECONDS.sleep(2);
		int width =driver.manage().window().getSize().width;
		int height =driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
		for (int i=0;i<num;i++){
			driver.swipe(width/2, height*1/4, width/2, height*3/4, duration);
			driver.swipe(width/2, height*1/4, width/2, height*3/4, duration);
			TimeUnit.SECONDS.sleep(1);
		}
		
	}
		
	public void tapRecipe(int fingers,int during)
  {
	  int widthRecipe=driver.manage().window().getSize().width;
	  int heightRecipe=driver.manage().window().getSize().height;
	  System.out.println(widthRecipe);
	  System.out.println(heightRecipe);
	driver.tap(fingers, widthRecipe/2, heightRecipe/4, during);   ////tap(int fingers, int x, int y, int duration)
	  
  }

}
	

