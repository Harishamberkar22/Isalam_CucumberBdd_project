Feature: Event

Background: Steps common for all scenrios
		Given User Launch Chrome browser
    When User opens url "https://preprod.isalaam.me/isalaamstaging/sign-in"
    When User Enters email as "harishamberkar404@gmail.com" 
    When Click on login 
    When User Enters OTP  as "888888"
    When Click on Verify and continue
    And Click on the Language 	
    And Select English

  Scenario: Add Event
    Then click on Events
    Then Click on Create event
    Then Enter event info
    Then Save and continue
    
    @Inventory
   Scenario: Add inventory
   		Then  Clicks on Mosque Maagement 
   		Then Click on inventory
   		Then Click on stock-in
   		Then Enter the details
   		Then Click on Add button
   		And check the add list should be displayed
  
   @Product_threshold	
   Scenario: Add product Threshold
   		Then click on Mosque Maagement
   		Then click on Product threshold
   		Then click on Add button
   		Then add details in popup page
   		Then Select on add to save the details 
   		And check the added product should be displayed
   
   @Supplier	
   Scenario Outline: Add suplier name
   		Then click on Master data
   		Then click on supplier option 
   		Then Click on Add button1
   		Then Enter the details "<SupplierName>", "<Address>", "<Mobile>", "<Email>"
   		Then select on  add to save details
   		And Verify the added Suplier "<SupplierEmail>" name should be dsiplayed 
   		
   	Examples:
  | SupplierName | Address       | Mobile      | Email             |
  | AlphaCorp    | Dubai Street  | 9876543210  | alpha@corp.com    |
   	
   	
   	@product_categories
   	Scenario: Add product categories
   		Then click on Master datas
   		Then click on products menu option 
   		Then Click on Add buttons
   		Then Enter the details "<CategoryName>","<DescName>"
   		Then select on  add to save details
   		And Check the added product "<CategoryName>" name should be dsiplayed
   		And click on three dotted menu 
   		Then click on subcategory
   		And click on Add_option inside subcategory 
   		And Enter the sub category details "<suCategoryName>","<subCategoryDesc>"
   		And click on Add option 
   		And check added list "<SubcatName>" should be displayed  
   		
   	Examples:
  | CategoryName 			 | DescName             | subCategoryName | subCategoryDesc      |
  | pencils						| All masks  items      | plastic         | All kinds of bottles |
