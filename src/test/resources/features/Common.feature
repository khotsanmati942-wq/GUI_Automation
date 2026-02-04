
Feature: Login

  Scenario Outline: Successful Login
    Given I navigate to the URL
    Then I perform login
    And I change the POS using "<salesoffice>" and "<currency>"
#    And I click on home screen
    And I click on Reservation module
#    And I click on Check-in module
#    And I click on gate module
    And I click on New Order tab to create a PNR
    And I select the from and to city "<Origincity>" and "<Destinationcity>"
    And I enter Start Date "<StartDate>" for one way booking
#    And I select return booking with "<StartDate1>"
    And I enter Adult passenger count as <ADT>
    And I enter Child passenger count as <CHD>
    And I enter INF passenger count as <INF>
    And I enter INS passenger count as <INS>
    And I click on search button
    And I select class of service as "<COS>"
    And I Select pricing option as "<PriceOption>"
    And I enter Passenger details

    Examples:
      | salesoffice  | currency | Origincity | Destinationcity | StartDate | StartDate1 | ADT | CHD | INF | INS | COS      | PriceOption     |
      | PTY - CC     | USD      | PTY        | LAX             | 01 days   | 02 days    | 2   | 2   | 1   | 2   | Business | Price as Booked |


