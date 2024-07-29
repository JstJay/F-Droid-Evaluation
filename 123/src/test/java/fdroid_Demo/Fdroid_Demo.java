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
			driver.findElement(MobileBy.AccessibilityId("name of the id")).click();
			driver.findElement(MobileBy.AccessibilityId("id name")).click();
			driver.findElement(MobileBy.id("android:id/checkbox")).click();
				
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"text name\")")).click();
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
 		
		@Test(enabled = false) 
		public void opennotificaitons() {
			driver.openNotifications();
			driver.findElement(MobileBy.className("android.widget.ImageView")).get(4).click();
		}
		
		
		@Test(enabled = false) 
		public void scroll() {
			driver.findElement(MobileBy.AccessibilityId("Views")).click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		}
		
		@Test(enabled = false) 
		public void longpress() {
			driver.findElement(MobileBy.AccessibilityId("Views")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UISelector().text(\"text here\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UISelector().text(\"text here\")")).click();
			AndroidElement names = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"names\")"));
			
			TouchAction ta = new TouchAction(driver);
			ta.longPress(longPressOptions().withElement(element(fishnames)).withDuration(ofSeconds(3))).release().perform();
		}
		
		
		
		
		  @Test(enabled = false) 
		  	public void drag_and_drop() {
			  driver.findElement(MobileBy.AccessibilityId("text")).click();
			  driver.findElement(MobileBy.AccessibilityId("Id Name")).click();
			  
			  AndroidElement ele1 = driver.findElement(MobileBy.id("org.fdroid.fdroid:id/drag_dot_1"));
			  AndroidElement ele2 = driver.findElement(MobileBy.id("org.fdroid.fdroid:id/drag_dot_2"));
			  
			  TouchAction ta = new TouchAction(driver);
			  ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		  
		  }
		  
		  @Test(enabled = false) 
		  public void typeswipe() {
			driver.findElement(MobileBy.AccessibilityId("text here")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Id name\")")).click();
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"text")")).click();

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
			
			driver.findElement(MobileBy.id("org.fdroid.fdroid/sms_recipient")).sendKeys("(650)555-1212");
			driver.findElement(MobileBy.id("org.fdroid.fdroid/sms_content")).sendKeys("hello there...");
			driver.findElement(MobileBy.id("org.fdroid.fdroid/sms_send-message")).sendKeys("(650)555-1212");
			
			//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			
			driver.activateApp("com.google.android.apps.messaging");
			
			String exp = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"You: Hello There...\")")).getText();
			System.out.println(exp);
			
			driver.activateApp("org.fdroid.fdroid");
			
			
		}
		
		
}

