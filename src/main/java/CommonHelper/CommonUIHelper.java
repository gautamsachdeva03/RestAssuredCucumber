package CommonHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUIHelper {
    AppiumDriver<MobileElement> driver;

    public CommonUIHelper(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void genericVerticalScroll(String xpath, int loopCount, double startyRatio, double endyRatio) {
        for (int i = 1; i < loopCount; ++i) {
            try {
                if (((MobileElement) this.driver.findElement(By.xpath(xpath))).isDisplayed()) {
                    break;
                }
            } catch (Exception var12) {
                System.out.println(var12.getMessage());
            }

            Dimension dim = this.driver.manage().window().getSize();
            int xval = dim.getWidth() / 2;
            int starty = (int) ((double) dim.getHeight() * startyRatio);
            int endy = (int) ((double) dim.getHeight() * endyRatio);
            (new TouchAction(this.driver)).press(ElementOption.point(xval, starty)).waitAction((new WaitOptions()).withDuration(Duration.ofMillis(500L))).moveTo(ElementOption.point(xval, endy)).release().perform();
        }
    }

    public void setAppInBackground(int duration) {
        try {
            driver.runAppInBackground(Duration.ofSeconds(duration));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitForElement(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
