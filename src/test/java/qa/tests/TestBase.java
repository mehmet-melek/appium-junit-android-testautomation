package qa.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.appmanagement.ApplicationState;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver<MobileElement> driver;
    ApplicationState state = driver.queryAppState(ManagementFactory.getRuntimeMXBean().getName());


    @BeforeAll
    public static void setupDeviceCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "Pixel_3a_API_31_arm64-v8a");
        capabilities.setCapability("app", "/Users/melek/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("avd", "Pixel_3a_API_31_arm64-v8a");
        driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        // capabilities.setCapability("ensureWebviewsHavePages", true);
    }

/*    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }*/

    @AfterEach
    public void after() {
        //driver.closeApp();
    }

}
