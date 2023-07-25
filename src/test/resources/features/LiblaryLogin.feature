Feature: Login feature

  Background:
    Given  Given I am on the login page

  @librarian
  Scenario: Login as a librarian

    When I login as a librarian
    Then dashboard should be displayed

  @all_accounts
  Scenario Outline: Login as a

    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"

    Examples:
      | email               | password    | name              |
      | librarian13@library | libraryUser | Test Librarian 13 |
      | librarian14@library | libraryUser | Test Librarian 14 |
      | librarian15@library | libraryUser | Test Librarian 15 |
      | librarian16@library | libraryUser | Test Librarian 16 |
      | librarian17@library | libraryUser | Test Librarian 17 |
