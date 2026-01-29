
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
   And I select "<Origincity>" and "<Destinationcity>" and date of journey as "<Date>"

    Examples:
      | salesoffice  | currency | Origincity | Destinationcity | Date    |
      | PTY ATO      | USD      | PTY        | LAX             | 01 days |


