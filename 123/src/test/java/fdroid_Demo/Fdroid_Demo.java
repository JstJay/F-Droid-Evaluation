package fdroid_Demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import evaluation.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
// static import for time
import static java.time.Duration.ofSeconds;

// static imports for long press
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

// static import for elements
import static io.appium.java_client.touch.offset.ElementOption.element;



public class Fdroid_Demo extends Capabilities {
		AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void setup() throws MalformedURLException {
			driver = AppiumCapabilities();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@Test(enabled = false)
		public void tcl() throws InterruptedException {
			driver.findElement(MobileBy.AccessibilityId("Preference")).click();
			driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
			driver.findElement(MobileBy.id("android:id/checkbox")).click();
			//driver.findElement(MobileBy.id("android:id/checkbox")).click();
			
			//Another way of using text is 
			//If your using android to identify an element using an attribute then you can use ui selector
			//method for selecting the attribute.
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
			driver.findElement(MobileBy.id("android:id/edit")).sendKeys("sfdw");
			driver.findElement(MobileBy.id("android:id/button2")).click();
			
			driver.hideKeyboard();
			
			//To navigate back to the previous screen.
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			
		}
 		
/*		@Test(enabled = false) 
		public void opennotificaitons() {
			driver.openNotifications();
			driver.findElement(MobileBy.className("android.widget.ImageView")).get(4).click();
		}*/
		
		
		@Test(enabled = false) 
		public void scroll() {
			driver.findElement(MobileBy.AccessibilityId("Views")).click();
			/* If you want to scroll you need 4 things
			 * 1. UIAutomater
			 * 2. UiSelector
			 * 3. UiScrollable
			 * 4. scrollIntoView
			 */
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		}
		
		@Test(enabled = false) 
		public void longpress() {
			driver.findElement(MobileBy.AccessibilityId("Views")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UISelector().text(\"Expandable Lists\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UISelector().text(\"1. Custom Adapter\")")).click();
			AndroidElement fishnames = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
			
			TouchAction ta = new TouchAction(driver);
			ta.longPress(longPressOptions().withElement(element(fishnames)).withDuration(ofSeconds(3))).release().perform();
		}
		
		
		
		
		  @Test(enabled = false) 
		  	public void drag_and_drop() {
			  driver.findElement(MobileBy.AccessibilityId("Views")).click();
			  driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
			  
			  AndroidElement ele1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
			  AndroidElement ele2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
			  
			  TouchAction ta = new TouchAction(driver);
			  ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		  
		  }
		  
		  @Test(enabled = false) 
		  public void typeswipe() {
			driver.findElement(MobileBy.AccessibilityId("Views")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Date Widgets\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"2. Inline\")")).click();

			AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));
			AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("7"));
			
			TouchAction ta = new TouchAction(driver);
			ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		  }
		 
		@Test(enabled = true) 
		public void switchapp() {
			//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			
			driver.findElement(MobileBy.AccessibilityId("OS")).click();
			driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
			driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcasr receiver")).click();
			driver.hideKeyboard();
			
			driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
			driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("hello there...");
			driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_send-message")).sendKeys("(650)555-1212");
			
			//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			
			driver.activateApp("com.google.android.apps.messaging");
			
			String exp = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"You: Hello There...\")")).getText();
			System.out.println(exp);
			
			driver.activateApp("io.appium.android.apis");
			
			
		}
		
		
}

