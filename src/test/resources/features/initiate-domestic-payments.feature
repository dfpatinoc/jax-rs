Feature: Initiate domestic payments

  Scenario Outline: Invalid domestic payment
    Given A domestic payment that is not stored in our system
    When I initiate a domestic payment
      | amount   | currency   | debtorAccountScheme   | debtorAccount   | debtorAccountName   | creditorAccountScheme   | creditorAccount   | creditorAccountName   |
      | <amount> | <currency> | <debtorAccountScheme> | <debtorAccount> | <debtorAccountName> | <creditorAccountScheme> | <creditorAccount> | <creditorAccountName> |
    Then The system return the http status code 400
    And The error message '<errorMessage>'
    Examples:
      | amount | currency | debtorAccountScheme | debtorAccount            | debtorAccountName | creditorAccountScheme | creditorAccount          | creditorAccountName | errorMessage                       |
      | 600.01 | EUR      | IBAN                | ES9820385778983000760236 | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    | The amount cannot exceed 600       |
      |        | EUR      | IBAN                | ES9820385778983000760236 | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    | Validation error in the input data |
      | 599.99 |          | IBAN                | ES9820385778983000760236 | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    | Validation error in the input data |
      | 599.99 | EUR      |                     | ES9820385778983000760236 | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    | Validation error in the input data |
      | 599.99 | EUR      | IBAN                |                          | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    | Validation error in the input data |
      | 599.99 | EUR      | IBAN                | ES9820385778983000760236 | Debtor account    |                       | ES9820385778983000760236 | Creditor account    | Validation error in the input data |
      | 599.99 | EUR      | IBAN                | ES9820385778983000760236 | Debtor account    | IBAN                  |                          | Creditor account    | Validation error in the input data |

  Scenario Outline: Save domestic payment
    Given A domestic payment that is not stored in our system
    When I initiate a domestic payment
      | amount   | currency   | debtorAccountScheme   | debtorAccount   | debtorAccountName   | creditorAccountScheme   | creditorAccount   | creditorAccountName   |
      | <amount> | <currency> | <debtorAccountScheme> | <debtorAccount> | <debtorAccountName> | <creditorAccountScheme> | <creditorAccount> | <creditorAccountName> |
    Then The system return the http status code 201
    Examples:
      | amount | currency | debtorAccountScheme | debtorAccount            | debtorAccountName | creditorAccountScheme | creditorAccount          | creditorAccountName |
      | 599.99 | EUR      | IBAN                | ES9820385778983000760236 | Debtor account    | IBAN                  | ES9820385778983000760236 | Creditor account    |
      | 599.99 | EUR      | IBAN                | ES9820385778983000760236 |                   | IBAN                  | ES9820385778983000760236 |                     |
