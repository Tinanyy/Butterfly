package sat.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class SCLocalTestSetUp extends LocalTestSetUp{
	
	public void setUpDriver(DesiredCapabilities capabilities){
		super.setUpDriver(capabilities);
		
		capabilities.setCapability("appPackage","com.sidechef.sidechef");
		capabilities.setCapability("appActivity", ".activity.SplashActivity");

	}

}
