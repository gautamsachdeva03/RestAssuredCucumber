package UIController.LinkedIn;

import CommonHelper.CommonUIHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MyProfileSideDrawer {

    AppiumDriver<MobileElement> driver;
    CommonUIHelper commonHelper;

    public MyProfileSideDrawer(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        commonHelper = new CommonUIHelper(driver);
    }

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    MobileElement settingsIcon;

    public void clickSettingsButton() {
        try {
            settingsIcon.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean verifyVersionTagPresent() {
        try {
            commonHelper.genericVerticalScroll("//*[contains(@text,'VERSION')]", 4, 0.7, 0.2);
            return driver.findElementByXPath("//*[contains(@text,'VERSION')]").getText().contains("VERSION");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
