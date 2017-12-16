package sat.sidechef.local_tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.sidechef.ci_tests.SCSearchRecipeCITest;
import sat.utils.SCLocalTestSetUp;

public class SCSearchRecipeLocalTest extends SCSearchRecipeCITest{
	@Override
	@BeforeMethod
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
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@Override
	@AfterClass
	public void resetApp(){
	
	}
}


