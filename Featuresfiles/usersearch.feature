Feature: Usersearch

Background: Steps common for all scenrios
		Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"

@Usersearch
Scenario: Search a user in a list
		
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
 
@Registrationvalidscenario   
Scenario Outline: Register the user
		Then user clicks on signup 
		Then User Enter Valid name as "<name>"
		Then User Enter Valid Email as "<email>"
		Then User Enter Valid Number as "<phone>"
		Then Click on Continue 
		Then Enter the Valid Otp as "<otp>"
		Then  Verifikasi & Lanjutkan
		
Examples:
    | name    | email              | phone       | otp    |
    | John    | john120@example.com   | 987654984  | 888888 |
    		
@Registrationvalidscenario1		
Scenario Outline: Register the user
		Then user clicks on signup 
		Then User Enter Valid name as "<name>"
		Then User Enter Valid Email as "<email>"
		Then User Enter invalid Number as "<phone>"
		Then Click on Continue 
		Then Enter the Valid Otp as "<otp>"
		Then  Verifikasi & Lanjutkan
		
Examples:
    | name    | email              | phone  | otp    |
    | John    | john@example.com   | 98765  | 888888 |
    | John    | john.example.com   | 9876543210  | 888888 |	


    
    	
		
 