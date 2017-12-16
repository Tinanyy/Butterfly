package sat.testbases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class AppiumCITestBase extends AppiumAndroidTestBase {

	@Override
	@BeforeClass
	public void setUpDriver() throws MalformedURLException {
		// TODO Auto-generated method stub
		capabilities = new DesiredCapabilities();
		
		serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void resetApp(){
		if(driver != null){
			driver.resetApp();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
		if(driver != null){
			driver.quit();
		}
	}

	
	
}
