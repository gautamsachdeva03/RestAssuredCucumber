package UIController.Zoom;

import CommonHelper.CommonUIHelper;
import CommonHelper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
public class JoinAMeetingPage {

    AppiumDriver<MobileElement> driver;
    CommonUIHelper commonHelper;

    public JoinAMeetingPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonHelper = new CommonUIHelper(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "txtTitle")
    MobileElement pageHeader;

    @AndroidFindBy(id = "edtConfNumber")
    MobileElement meetingIdTextBox;

    @AndroidFindBy(id = "btnJoin")
    MobileElement joinButton;

    @AndroidFindBy(id = "chkNoAudio")
    MobileElement joinOptionNoAudio;

    @AndroidFindBy(id = "chkNoVideo")
    MobileElement joinOptionNoVideo;

    @AndroidFindBy(id = "txtMsg")
    MobileElement invalidPopupDescription;

    @AndroidFindBy(id = "button2")
    MobileElement invalidPopupOkButton;

    public void enterMeetingId(String meetingId) {
        try {
            meetingIdTextBox.sendKeys(meetingId);
            driver.hideKeyboard();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickJoinButton() {
        try {
            joinButton.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public Boolean getJoinButtonState() {
        try {
            return joinButton.isEnabled();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return false;
    }

    public void selectMeetingOptions(Boolean noAudio, Boolean noVideo) {
        if (noAudio) {
            enableNoAudioOption();
        }
        if (noVideo) {
            enableNoVideoOption();
        }
    }

    public void enableNoAudioOption() {
        try {
            do joinOptionNoAudio.click(); while (!joinOptionNoAudio.getAttribute("checked").equalsIgnoreCase("true"));
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void enableNoVideoOption() {
        try {
            do joinOptionNoVideo.click(); while (!joinOptionNoVideo.getAttribute("checked").equalsIgnoreCase("true"));
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public Boolean isDisplayedInvalidIdPopup() {
        try {
            commonHelper.waitForElement(invalidPopupDescription);
            return invalidPopupDescription.isDisplayed();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return false;
    }

    public void clickOk() {
        try {
            invalidPopupOkButton.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public String getPageHeader() {
        try {
            commonHelper.waitForElement(joinButton);
            return pageHeader.getText();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return "";
    }
}
