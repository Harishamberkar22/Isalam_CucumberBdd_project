Feature: Performing actions in new mosque

Background: Steps common for all scenrios
		Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "harishamberkar404@gmail.com" 
    When Click on login 
    When User Enters OTP  as "888888"
    When Click on Verify and continue
    And Click on the Language 	
    And Select English


Scenario: Navigate to mosque 
		Then Click on Ministry siloutte
    And click Registered Mosques
    And Click on Mosque Name
    Then get the mosque text
    Then Get the name and print it
		Given  User clicks on identity access
		Then   User clicks on roles options
		Then   Click on Members three dotted menu 
		Then   Click on Action option
		Then   Enable Dashord button and click on ok buton
		Then   Go to the Dashboard and enable the button 
	 
		 