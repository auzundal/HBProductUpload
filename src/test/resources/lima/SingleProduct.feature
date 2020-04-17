#@Single product add feature
Feature: This feature contains single product add page's and its components' test

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "TEST-AHMET" username, "Test123!" password
    When Merchant should see "TEST-AHMET" username as on Home Page
    Then Merchant go to add product page
    Then Merchant click add single product tab


  Scenario: Add a single product
