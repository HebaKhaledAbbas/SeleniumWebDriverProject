@UI
Feature: Login Functionality for OrangeHRM then validate adding and deleting new user

  Scenario: Login to Admin page

    Given navigating to "https://opensource-demo.orangehrmlive.com/"
    And I enter a valid username "Admin" and password "admin123"


  Scenario Outline: adding new user and validate it is added successfully
    Given navigating to "https://opensource-demo.orangehrmlive.com/"
    And I enter a valid username "Admin" and password "admin123"
    Given I navigate to admin tab
    When Display the number of records found
    And I click on add button
    And I Fill the required fields <UserRole> , <Status>, <Password> , <EmployeeName>, <Username>, <ConfirmPassword>
    And I click on save button
    Then Validate Total Records Increased by 1


    Examples:
      | UserRole | Status  | Password          | EmployeeName     | Username | ConfirmPassword   |
      | Admin    | Enabled | testpasswordtest1 | manda akhil user | Test1008 | testpasswordtest1 |


  Scenario Outline: Search with the username and delete it then validate it is deleted
    Given navigating to "https://opensource-demo.orangehrmlive.com/"
    And I enter a valid username "Admin" and password "admin123"
    Given I navigate to admin tab
    Given Get Total Records Before Deletion
    When I Search for the new user <searchInput>
    And I Delete the new user
    And confirm to delete
    And wait for success message
    And I click on Reset Research
    Then Validate that the number of records decreased by 1

    Examples:
      | searchInput |
      | Test1008    |
