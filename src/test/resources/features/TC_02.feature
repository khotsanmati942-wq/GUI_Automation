@Sanity
Feature: Login

  Scenario Outline: Successful Login
    Given I navigate to the application URL
    And I log in to the application
    And I change the POS using "<salesoffice>" and "<currency>"
    And I am on the Home screen
    And I click on the Reservation module
    And I click on the New Order tab to create a PNR
    And I select the From and To cities "<Origincity>" and "<Destinationcity>"
    And I enter the Start Date "<StartDate>" for a one-way booking
    And I enter the Adult passenger count as <ADT>
    And I enter the Child passenger count as <CHD>
    And I click on the Search button
    And I select the class of service as "<COS>"
    And I select the pricing option as "<PriceOption>"
    And I enter the passenger details
    And I perform payment using "<Type>"
    And I am on the Home screen
    And I click on the Check-in module
    And I search for the Order number on the Check-in page
    And I am on the Home screen
    And I click on the Check-in module
    And I search for the flight details on the Check-in page



    Examples:
      | salesoffice | currency | Origincity | Destinationcity | StartDate | StartDate1 | ADT | CHD | INF | INS | COS      | PriceOption       | Type | PAX  | COS1 |
      | PTY ATO     | USD      | PTY        | MCO             | 01 days   | 02 days    | 1   | 1   | 1   | 1   | Economy  | Price as Best Buy | CASH | 1    | Y    |


