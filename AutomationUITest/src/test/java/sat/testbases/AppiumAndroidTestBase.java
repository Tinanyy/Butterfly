package sat.testbases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class AppiumAndroidTestBase {
	
	public static AndroidDriver<AndroidElement> driver;
	public DesiredCapabilities capabilities;
	public URL serverAddress;
	
	public abstract void setUpDriver() throws MalformedURLException;
	
	public abstract void setUp();
	
}
