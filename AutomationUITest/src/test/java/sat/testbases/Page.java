package sat.testbases;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class Page {

	protected final AndroidDriver<AndroidElement> driver;
	
	public Page(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
	}
    //deal with no google 
	By noGoogleSerID = By.id("message");
	
	//This function deal with the situation which shows "Sidechef won't run withdout Google Play..."
	/*public void dealNoGoogle(){
		AndroidElement noGoogleMes = (AndroidElement) driver.findElement(noGoogleSerID);
		if(noGoogleMes != null){
			if(noGoogleMes.getText().contains("without Google Play")){
				driver.findElement(By.id("button1")).click();
			}
		}
	}
	*/
	
	public  void dealNoGoogle(){
		try{
	      driver.findElement(noGoogleSerID);
		 driver.findElement(By.id("button1")).click(); 
		 }
		catch(Exception e){
		  System.out.println("there is no noGoogle pop up");	  
		  return;
		 }
	}
	  
	public abstract void checkPage();
	
}
