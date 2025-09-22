package Activity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activy1 {

	AppiumDriver driver;
	WebDriverWait wait;

	// Setup function

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// setup capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.noReset();
		options.setApp("C:/Users/AashishMehta/Downloads/calculatorMain.apk");

		URL serverurl = new URI("http://localhost:4723").toURL();

		// initialize driver

		driver = new AndroidDriver(serverurl, options);
	}

	@Test
	public void multiplyTest() {

		// Find First and click number
		driver.findElement(AppiumBy.id("digit_2")).click();

		// Find multiply button
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();

		// Find and click second number
		driver.findElement(AppiumBy.id("digit_7")).click();

		// click on equal to button
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("result is : " + result);

		// Assert result
		Assert.assertEquals(result, "= 14");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}