Feature: Get domestic payments

  Scenario Outline: Get domestic payment
    Given A domestic payment with id '<domesticPaymentId>' that is stored in our system
    When I get the domestic payment with id '<domesticPaymentId>'
    Then The system return the http status code 200
    Examples:
      | domesticPaymentId                    |
      | 40130e7c-10ec-42a1-89df-a7520bab3034 |
      | 827cbc41-f12a-49d3-bbb8-1e04cf19ed17 |

  Scenario Outline: Get domestic payment that not exist
    Given A domestic payment that is not stored in our system
    When I get the domestic payment with id '<domesticPaymentId>'
    Then The system return the http status code 404
    Examples:
      | domesticPaymentId                    |
      | 00f31418-31b6-4e23-84c5-06a93c7ed260 |