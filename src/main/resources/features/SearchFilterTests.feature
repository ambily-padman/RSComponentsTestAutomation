@Test4
Feature: Search Filter Tests
  As a user I want to search the Product
  so that I can view them

  Background:Log into the RS Componants Web Site
    Given I am navigated to in RS component web page
    And I log into the website
    Then I am in the Rs componant home page

  Scenario: Search the product with RS Stock Number
    Given I enter the RS Stock Number in the search box
    Then I can see the product is listed in the product page



  Scenario:Search the product with the product  and add single filter
    Given I enter the Main Product Type in the search box
    And I Click on Category On the Product type page
    And I Click on Sub Category On the sub category page
    When I Select the Filter Type1 on the sub category page
    And I select Filter1
    And I apply the filter
    Then I can see the filter applied and number of result displayed are correct



  Scenario:Search the product with keyword and add multifilters
    Given I enter the keyword in the search box for multifilter
    And I click on Category On the SearchResultPage
    When I Select the Filter Type1 on the sub category page
    And I select Filter1
    When I Select Filter Type2 on the sub category page
    And I select  Filter2
    And I apply the filter
    Then I can see the filter applied and number of result displayed are correct
