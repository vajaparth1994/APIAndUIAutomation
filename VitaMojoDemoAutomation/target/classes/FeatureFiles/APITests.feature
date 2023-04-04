@API
Feature: Verify  signup and login functionality for Vita Mojo demo website using API

  Scenario: Verify Successful signup for Vita Mojo Demo website
    Given User connects to user API
    Then User should get response code of 400


  Scenario: Verify Successful login for Vita Mojo Demo Website
    Given User connects to Auth API
    Then User should get response code of 201