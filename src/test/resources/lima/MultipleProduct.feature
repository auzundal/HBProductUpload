#@Multiple product add feature
Feature: This feature contains multiple product add page's and its components' test

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "TEST-AHMET" username, "Test123!" password

  @successfully-add-multiple-product
  Scenario: Merchant add a multiple product
    Given Merchant go to add multiple page
    When Merchant "record34.xlsx" excel file upload from pc
    When Merchant I would like to upload successfully icon
    When Merchant I would like going to upload history
    Then Merchant I would like to check successfully upload "record34.xlsx" file
