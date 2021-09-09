package qa.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public AndroidDriver driver;

    @BeforeSuite
    public void setupDeviceCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "Pixel_3a_API_31_arm64-v8a");
        capabilities.setCapability("app", "/Users/melek/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("avd", "Pixel_3a_API_31_arm64-v8a");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        // capabilities.setCapability("ensureWebviewsHavePages", true);
    }

/*    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }*/
}
