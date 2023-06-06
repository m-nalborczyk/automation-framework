@login
Feature: WebDriver University - Login Page

  Scenario: Validate Successful Login
    Given I access webdriver university login page
    When I enter a username webdriver
    And I enter a password webdriver123
    And I click on login button
    Then I should be presented with a successful validation info

  Scenario: Validate Unsuccessful Login
    Given I access webdriver university login page
    When I enter a username webdriver
    And I enter a password incorrect
    And I click on login button
    Then I should be presented with a unsuccessful validation info