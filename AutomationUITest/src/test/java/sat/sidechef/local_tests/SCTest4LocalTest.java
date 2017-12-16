package sat.sidechef.local_tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import sat.utils.SCMisc;
import sat.sidechef.ci_tests.SCTest4CITest;
import sat.sidechef.pages.SCLandingPage;
import sat.sidechef.pages.SCNavigationBottomBarPage;
import sat.sidechef.pages.SCTutorialPage;
import sat.utils.SCLocalTestSetUp;

public class SCTest4LocalTest extends SCTest4CITest{

	SCTutorialPage objTutorial;
	SCMisc objMisc;
	SCLandingPage objLanding;
	SCNavigationBottomBarPage objNavBar;
	
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
