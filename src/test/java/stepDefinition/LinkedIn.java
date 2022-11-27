package stepDefinition;

import UIController.AppiumHelper;
import UIController.LinkedIn.HomePage;
import UIController.LinkedIn.MessagingPage;
import UIController.LinkedIn.MyProfileSideDrawer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LinkedIn {

    HomePage homePage = new HomePage(AppiumHelper.driver);
    MessagingPage messagingPage = new MessagingPage(AppiumHelper.driver);
    MyProfileSideDrawer myProfileSideDrawer = new MyProfileSideDrawer(AppiumHelper.driver);

    @When("user clicks on search bar")
    public void clickSearchBar() {
        homePage.clickSearchBar();
    }

    @And("user enters {string} in the search bar")
    public void enterTextInSearchBar(String text) {
        homePage.enterTextInSearchBar(text);
    }

    @Then("user verifies the search list contains {string} text")
    public void verifySearchList(String text) {
        homePage.verifySearchListContent(text);
    }

    @And("user verifies the search all button")
    public void verifySearchAllButton() {
        Assert.assertTrue("Search all button not present", homePage.isSeeAllResultsPresent());
    }

    @When("user clicks on chat bubble")
    public void selectChatBubble() {
        homePage.clickChatBubble();
    }

    @And("user taps on filter icon")
    public void tapFilterIcon() {
        messagingPage.clickFilterIcon();
    }

    @And("user applies {string} filter")
    public void applyFilter(String filter) {
        messagingPage.clickSearchFilterButton(filter);
    }

    @Then("user verifies the selected search filter as {string}")
    public void verifySearchFilter(String filter) {
        messagingPage.isSelectedFilter(filter);
    }

    @When("user taps on profile photo")
    public void clickProfileIcon() {
        homePage.clickProfileIcon();
    }

    @And("user navigates to settings")
    public void clickOnSettings() {
        myProfileSideDrawer.clickSettingsButton();
    }

    @Then("user verifies version tag in settings")
    public void verifyVersionTag() {
        Assert.assertTrue(myProfileSideDrawer.verifyVersionTagPresent());
    }
}
