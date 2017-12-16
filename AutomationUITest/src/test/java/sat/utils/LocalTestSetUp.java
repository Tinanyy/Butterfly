package sat.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalTestSetUp {
	
	public void setUpDriver(DesiredCapabilities capabilities){
		//configure platform
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("PLATFORM_VERSION", "6.0.0");
		
		//configure client side, we leave appActivity to specific test
		capabilities.setCapability("deviceName","Android");
		
		capabilities.setCapability("--session-override", true);
		capabilities.setCapability("autoAcceptAlerts", true);
		
	}

}
