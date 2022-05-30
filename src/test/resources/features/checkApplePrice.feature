@web
Feature: Stock Price

  @apple
  Scenario: Validate Apple Stock Price
    Given I Logon to Investopedia
    When The Stock Name Matches the Expected "APPLE INC"
    Then Validate the Apple Stock Price with 140 USD
