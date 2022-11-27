package UIController.Zoom;

import CommonHelper.Log;
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

    @AndroidFindBy(id = "btnJoinConf")
    MobileElement joinAMeetingButton;

    @AndroidFindBy(id = "btnSignup")
    MobileElement signUpButton;

    @AndroidFindBy(id = "btnLogin")
    MobileElement signInButton;

    public void clickJoinMeeting() {
        try {
            joinAMeetingButton.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickSignIn() {
        try {
            signInButton.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickSignUp() {
        try {
            signUpButton.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

}
