package evaluation;


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {
	
	public static AndroidDriver<AndroidElement> AppiumCapabilities() throws MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
	
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3A");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.fdroid.fdroid");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.fdroid.fdroid.F-Droid");
	
	
	AndroidDriver<AndroidElement> driver  = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

	return driver;
	}
	

}
