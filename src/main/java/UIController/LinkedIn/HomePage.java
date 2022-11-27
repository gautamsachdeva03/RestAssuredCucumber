package UIController.LinkedIn;

import CommonHelper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    AppiumDriver<MobileElement> driver;

    public HomePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    @AndroidFindBy(xpath = "//*[@text='Search']")
    MobileElement searchBar;

    @AndroidFindBy(xpath = "//*[@content-desc='messaging']")
    MobileElement chatBubble;

    @AndroidFindBy(xpath = "//*[@text='See all results']")
    MobileElement seeAllResultsButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.linkedin.android:id/me_launcher_container']")
    MobileElement profileIcon;

    public void clickSearchBar() {
        try {
            searchBar.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void enterTextInSearchBar(String text) {
        try {
            searchBar.click();
            searchBar.sendKeys(text);
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public Boolean isSeeAllResultsPresent() {
        try {
            driver.hideKeyboard();
            return seeAllResultsButton.isDisplayed();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return false;
    }

    public void verifySearchListContent(String text) {
        try {
            driver.hideKeyboard();
            List<MobileElement> searchList = driver.findElementsByXPath("//*[@resource-id='com.linkedin.android:id/search_typeahead_entity_text']");
            Log.info("Search results found: " + searchList.size());
            for (MobileElement searchBarElement : searchList) {
                Log.info(searchBarElement.getText());
                Assert.assertTrue(searchBarElement.getText().toLowerCase().contains(text.toLowerCase()));
            }
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickChatBubble() {
        try {
            chatBubble.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }

    public void clickProfileIcon() {
        try {
            profileIcon.click();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }
}
