package stepDefinition;

import UIController.AppiumHelper;
import CommonHelper.CommonUIHelper;
import UIController.Zoom.JoinAMeetingPage;
import UIController.Zoom.LaunchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Zoom {

    LaunchPage launchPage = new LaunchPage(AppiumHelper.driver);
    JoinAMeetingPage joinMeetingPage = new JoinAMeetingPage(AppiumHelper.driver);
    CommonUIHelper commonHelper = new CommonUIHelper(AppiumHelper.driver);

    @When("user clicks on {string} button")
    public void clickJoinAMeeting(String button) {
        switch (button.toUpperCase()) {
            case "JOIN_MEETING":
                launchPage.clickJoinMeeting();
                break;
            case "SIGN_UP":
                launchPage.clickSignUp();
                break;
            case "SIGN_IN":
                launchPage.clickSignIn();
                break;
            default:
                break;
        }
    }

    @Then("user navigates to {string} page")
    public void verifyPageHeader(String pageTitle) {
        String actualPageHeader = joinMeetingPage.getPageHeader();
        Assert.assertEquals(pageTitle, actualPageHeader);
    }

    @And("user verifies join button to be in {string} state")
    public void verifyJoinButton(String buttonState) {
        switch (buttonState.toUpperCase()) {
            case "ENABLED":
                Assert.assertTrue(joinMeetingPage.getJoinButtonState());
                break;
            case "DISABLED":
                Assert.assertFalse(joinMeetingPage.getJoinButtonState());
                break;
            default:
                break;
        }
    }

    @When("user enters {string} meeting id")
    public void enterMeetingId(String meetingId) {
        joinMeetingPage.enterMeetingId(meetingId);
    }

    @And("user selects joining options as audio {string} and video {string}")
    public void selectMeetingOptions(String audioOption, String videoOption) {
        boolean noAudio = audioOption.equalsIgnoreCase("OFF");
        boolean noVideo = videoOption.equalsIgnoreCase("OFF");
        joinMeetingPage.selectMeetingOptions(noAudio, noVideo);
    }

    @And("user clicks on join button")
    public void clickJoinButton() {
        joinMeetingPage.clickJoinButton();
    }

    @Then("user verifies the invalid meeting popup")
    public void verifyInvalidMeetingPopup() {
        Assert.assertTrue(joinMeetingPage.isDisplayedInvalidIdPopup());
    }

    @And("user clicks ok for invalid meeting popup")
    public void clickOkInvalidMeetingPopup() {
        joinMeetingPage.clickOk();
    }

    @And("user puts the app in background for {string} seconds")
    public void putAppState(String duration) {
        commonHelper.setAppInBackground(Integer.parseInt(duration));
    }
}
