@WEB
Feature: Verify  signup and login functionality for Vita Mojo demo website

  Scenario: Verify Successful signup for Vita Mojo Demo website
    Given User launch application "https://fego.vmos-demo.com/"
    And  User provide details on signup pages
    Then User should get successful signup message

  Scenario: Verify Successful login for Vita Mojo Demo Website
    Given User launch application "https://fego.vmos-demo.com/"
    And User Provide username "Demo@gmail.com" and password "Demo@123"
    Then User should be able to login successfully
