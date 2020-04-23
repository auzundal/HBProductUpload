#@add-product-feature
Feature: Add Product Feature

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "TEST-MPOP" username, "Test123!" password
    When Merchant should see username as "TEST-MPOP" on Home Page
    Then Merchant click product page button

  Scenario: Check Product Add Modal Opened
    Given Merchant click add product button on product page
    Then Merchant should see add product modal
    Then Merchant should see all of the product add modal components

  Scenario: Check download category template for product upload
    Given Merchant click add product button on product page
    Then  Merchant select categories on Excel Template Download Page:
      | Anne / Bebek / Oyuncak  |
      | Oto Koltuğu & Aksesuarı |
      | Ana Kucağı              |




