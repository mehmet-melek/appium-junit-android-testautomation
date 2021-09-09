package qa.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait driverWait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, 10);
    }

    public void waitUntilVisible(MobileBy mobileBy) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(mobileBy));
    }
    public void click(MobileBy mobileBy) {
        waitUntilVisible(mobileBy);
        driver.findElement(mobileBy).click();
    }

    public void sendKeys(MobileBy mobileBy, String text) {
        waitUntilVisible(mobileBy);
        driver.findElement(mobileBy).sendKeys(text);
    }

}
