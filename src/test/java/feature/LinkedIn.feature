@Test_LinkedIn @Test
Feature: Verify the linkedin application

  Scenario: LINKED_IN: User verifies the search bar functionality
    Given user launches the "LINKEDIN" app
    When user clicks on search bar
    And user enters "Callsign" in the search bar
    Then user verifies the search list contains "Callsign" text
    And user verifies the search all button

  Scenario: LINKED_IN: User verifies the chat window functionality
    Given user launches the "LINKEDIN" app
    When user clicks on chat bubble
    And user taps on filter icon
    And user applies "My Connections" filter
    Then user verifies the selected search filter as "My Connections"

  Scenario: LINKED_IN: User verifies the settings functionality
    Given user launches the "LINKEDIN" app
    When user taps on profile photo
    And user navigates to settings
    Then user verifies version tag in settings
