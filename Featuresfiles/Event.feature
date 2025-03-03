Feature: Event
Scenario: Add Event
Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "harishamberkar404@gmail.com" 
    When Click on login 
    When User Enters OTP  as "888888"
    When Click on Verify and continue
    And Click on the Language
    And Select English
    Then click on Events 
    Then Click on Create event
    Then Enter event info
 		Then Save and continue 
 		   