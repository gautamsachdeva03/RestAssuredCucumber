package UIController.LinkedIn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessagingPage {

    AppiumDriver<MobileElement> driver;

    public MessagingPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @AndroidFindBy(xpath = "//*[@content-desc='Filter messages']")
    MobileElement filterIcon;

    public void clickFilterIcon() {
        try {
            filterIcon.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickSearchFilterButton(String filterText) {
        try {
            driver.findElementByXPath("//*[@text='" + filterText + "']").click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean isSelectedFilter(String filterText) {
        try {
            return driver.findElementByXPath("//*[@text='" + filterText + "']").getAttribute("checked").equals("true");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
