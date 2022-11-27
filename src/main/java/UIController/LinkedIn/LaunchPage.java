package UIController.LinkedIn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
    AppiumDriver<MobileElement> driver;

    public LaunchPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @AndroidFindBy(id = "growth_prereg_fragment_login_button")
    MobileElement signInButton;

    public void clickSignInButton() {
        try {
            signInButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
