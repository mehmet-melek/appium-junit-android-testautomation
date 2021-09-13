package qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait driverWait;

    public PageBase(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        driverWait = new WebDriverWait(driver, 10);
    }

    public void waitUntilVisible(MobileElement mobileElement) {
        driverWait.until(ExpectedConditions.visibilityOf(mobileElement));
    }
    public void click(MobileElement mobileElement) {
        waitUntilVisible(mobileElement);
        mobileElement.click();
    }

    public void sendKeys(MobileElement mobileElement, String text) {
        waitUntilVisible(mobileElement);
        mobileElement.sendKeys(text);
    }
}
