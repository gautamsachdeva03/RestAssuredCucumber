@Test_Zoom @Test
Feature: Testing join meeting feature in zoom app

  Scenario: ZOOM: Verify join a meeting feature with invalid meeting id
    Given user launches the "ZOOM" app
    When user clicks on "JOIN_MEETING" button
    Then user navigates to "Join a Meeting" page
    And user verifies join button to be in "Disabled" state
    When user enters "123456789" meeting id
    And user verifies join button to be in "Enabled" state
    And user selects joining options as audio "ON" and video "OFF"
    And user clicks on join button
    Then user verifies the invalid meeting popup
    And user puts the app in background for "2" seconds
    Then user verifies the invalid meeting popup
    Then user clicks ok for invalid meeting popup
    Then user navigates to "Join a Meeting" page