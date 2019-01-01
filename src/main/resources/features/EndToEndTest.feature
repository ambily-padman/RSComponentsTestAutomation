@Test4
Feature: End to End Tests

  Background: Log into the RS Componants Web Site
    Given I am navigated to in RS component web page
    And I log into the website
    Then I am in the Rs componant home page

  Scenario:Check out from All Product Menu
    Given I click the All Product  menu
    And I select The Product Type from the menu
    And I click the given category On the Product type page
    And I Click the given Sub Category On the Product type page
    When I add the Item to cart
    And click on the basket
    And check out securely
    Then I can see the delivery information page

  Scenario: Check out from Our Brands Menu
    Given I Click the  Our Brands Menu
    And I select the Brand from the menu list
    And I Select the Category from the brand page
    When I add the Item to cart
    And click on the basket
    And check out securely
    Then I can see the delivery information page
