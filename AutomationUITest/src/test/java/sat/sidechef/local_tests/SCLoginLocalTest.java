package sat.sidechef.local_tests;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * This is the test suit for login facilities.
 * 
 */

import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.sidechef.ci_tests.SCLoginCITest;
import sat.utils.SCLocalTestSetUp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;;

public class SCLoginLocalTest extends SCLoginCITest{
	
	@Override
	@BeforeClass
	public void setUpDriver() throws MalformedURLException{
		capabilities = new DesiredCapabilities();
		serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
		SCLocalTestSetUp driverSetUp = new SCLocalTestSetUp();
		driverSetUp.setUpDriver(this.capabilities);
		
		driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
		
		super.setUp();
	}
	
	@Override
	@AfterClass(alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@Override
	@AfterClass
	public void resetApp(){
	
	}
}
