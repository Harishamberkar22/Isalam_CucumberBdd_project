Feature: Usersearch
Scenario: Search a user in a list
Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "harishamberkar404@gmail.com" 
    When Click on login 
    When User Enters OTP  as "888888"
    When Click on Verify and continue
    And Click on the Language
    And Select English
    Then Click on identity access menubar
    Then Click on Registered users
    Then Enter a Emailid to search
    Then Enter on Search button
    Then User should found the emailin search