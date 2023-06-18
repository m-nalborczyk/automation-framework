@login @regression
Feature: WebDriver University - Login Page

  Background:
    Given I access webdriver university login page
  @target
  Scenario: Validate Successful Login
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on login button
    Then I should be presented with a successful validation info

  Scenario: Validate Unsuccessful Login
    When I enter a username webdriver
    And I enter a password incorrect
    And I click on login button
    Then I should be presented with a unsuccessful validation info

  @ignore
  Scenario Outline: Validate Successful & Unsuccessful Login
    When I enter an outlined username <username>
    And I enter an outlined password <password>
    And I click on login button
    Then I should be presented with a validation message <validationMessage>

    Examples:
      | username          | password          | validationMessage    |
      | webdriver         | webdriver123      | validation succeeded |
      | webdriver         | incorrectPassword | validation failed    |
      | incorrectUsername | webdriver123      | validation failed    |
      | incorrectUsername | incorrectUsername | validation failed    |