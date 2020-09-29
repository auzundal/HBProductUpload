#@Multiple product add feature
Feature: This feature contains multiple product add page's and its components' test

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "TEST-AHMET" username, "Test123!" password

  @successfully-add-multiple-product
  Scenario: Merchant add a multiple product
    Given Merchant go to add multiple page
    When Merchant "test-panduf.xlsx" excel file upload from pc
    Then I would like to wait "36" second
    Then I would like to check successfully upload "test-panduf.xlsx" file