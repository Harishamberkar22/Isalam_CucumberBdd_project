Feature: Login
  
	@Sanity
  Scenario: Valid Login Details
    Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "harishamberkar404@gmail.com" 
    When Click on login 
    When User Enters OTP  as "888888"
    When Click on Verify and continue
    And Click on profile settings
    Then Click on Logout 
   
  @Regression
 	Scenario Outline: Valid Login Details ddt
    Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "<email>" 
    When Click on login 
    When User Enters OTP  as "<otp>"
    When Click on Verify and continue
    And Click on profile settings
    Then Click on Logout 
    
    
Examples:
|email|otp|
|harishamberkar404@gmail.com|888888|
|harishamberk@gmail.com|888888|



 