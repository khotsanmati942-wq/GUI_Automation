@Sanity
Feature: Login

  Scenario Outline: Successful Login
    Given I navigate to the application URL
    And I log in to the application
    And I change the POS using "<salesoffice>" and "<currency>"
    And I am on the Home screen
    And I click on the Tools menu
    And I click on Native Shares
    And I Create a PNR in Native Shares using "<Origincity>" and "<Destinationcity>" and "<StartDate>"
    And I enter the Adult passenger count as <PAX> and Class of service <COS1> in Native Shares
    And I Create a PNR in Native Shares Using Passenger details
    And I click on the Reservation module
    And I retrive a PNR created from Native shares in GUI
    And I am on the Home screen
    And I click on the Check-in module
    And I search for the Order number on the Check-in page

    Examples:
      | salesoffice | currency | Origincity | Destinationcity | StartDate | StartDate1 | ADT | CHD | INF | INS | COS      | PriceOption     | Type | PAX  | COS1 |
      | PTY ATO     | USD      | PTY        | MDE             | 01 days   | 02 days    | 1   | 2   | 1   | 2   | Business | Price as Booked | CASH | 1    | Y    |
