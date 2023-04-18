@WEB
Feature: Verify  Compose function of Gmail

  Scenario: Verify Compose email functionality of Gmail
    Given User launch application "https://gmail.com"
    Then User should be able to send email successfully
