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
    Then Click on Ministry siloutte
    And click Registered Mosques
    And Click on Mosque Name
    Then get the mosque text
    Then Get the name and print it

@Dashboard
Scenario: Navigate to mosque 
		Given  User clicks on identity access
		Then   User clicks on roles options
		Then   Click on Members three dotted menu 
		Then   Click on Action option
		Then   Enable Dashord button and click on ok buton
		Then   Go to the Dashboard and enable the button 

@bankaccount 		
Scenario: Add the bank account 
		Then click on masterdata
    And  clicks on Banks account
    Then Click on add tobutton 
    Then Enter the deatails and click on Add button
    Then Check added account is displaying
    

    
@Productthreshold
Scenario: Add the product threshold
		Then click on Mosquemnagement 
		Then click on Add 
		Then Enter Details
		

@SMS
Scenario: Create the new service ticket
		Then click on Managament hub
		Then clicks on Service management
		Then Click on Any tabs
		Then click on New button
		Then Enter the Details
		
 
		
		

	 
		 