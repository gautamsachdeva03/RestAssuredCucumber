package UIController.LinkedIn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    AppiumDriver<MobileElement> driver;

    public SignInPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @AndroidFindBy(xpath = "")
    MobileElement emailTextBox;

    @AndroidFindBy(xpath = "")
    MobileElement passwordTextBox;

    @AndroidFindBy(xpath = "")
    MobileElement continueButton;

    public void enterEmail(String email) {
        try {
            emailTextBox.click();
            emailTextBox.sendKeys(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            passwordTextBox.click();
            passwordTextBox.sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickContinueButton() {
        try {
            continueButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
