#language: en
#Proyecto: E2E
Feature: Successful purchase flow on SauceDemo

  Background:
    Given the user is on the SauceDemo login page

  @happypath
  Scenario Outline: : Successful purchase flow
    Given the user logs in with valid credentials
      | username   | password   |
      | <username> | <password> |
    When the user adds two products to the cart
      | products   |
      | <products> |
    And the user checks the cart
      | products   |
      | <products> |
    And the user completes the purchase
      | firstName   | lastName   | zipCode   | products   |
      | <firstName> | <lastName> | <zipCode> | <products> |
    Then the user should see the confirmation message "Thank you for your order!"
    Examples:
      | username      | password     | products                                  | firstName | lastName | zipCode |
      | standard_user | secret_sauce | Sauce Labs Backpack,Sauce Labs Bike Light | Julio     | Betancur | 5546    |