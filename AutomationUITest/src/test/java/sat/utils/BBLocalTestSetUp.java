package sat.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BBLocalTestSetUp extends LocalTestSetUp{
	
	public void setUpDriver(DesiredCapabilities capabilities){
		super.setUpDriver(capabilities);
		
		capabilities.setCapability("appPackage","com.sidechef.sidechef.partner.budgetbytes");
		capabilities.setCapability("appActivity", "com.sidechef.sidechef.activity.SplashActivity");
	}

}
