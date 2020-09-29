#@SingleProduct-feature
Feature: This feature contains single product page's and its components' test

  Background:
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-100" username, "Test123!" password
    When Merchant should see "Sprint-100" username as on Home Page
    Then Merchant go to add product page

@add-single-product
  Scenario: Check add single product page opening
    Then Merchant should see title as "Ürün Ekle" in Single Product Page

@Single-product-add-feature
Scenario: Add new product and Check
  And Merchant click add single product tab
  Then Merchant should see add product modal
  When Merchant should select a category which name is "Panduf"
  And Merchant should set a random brand name
  And Merchant should set a random product name
  And Merchant should write a random barcode
  And Merchant should write a random merchant stock code
  #And Merchant should select a number which value is "1"
  #And Merchant should select a color which name is "Açık Yeşil"
  And Merchant should insert images "image.png"
  And Merchant should click the next step button
  Then Merchant should see product feature page

  When Merchant should write a warrant length is "2"
  And Merchant should write a tax percentage is "18"
  And Merchant should write a desi is "12"
  #And Merchant should write size property is "16"
  And Merchant should click the next step button
  Then Merchant should see product description page

  When Merchant should write description "test"
  And Merchant should click approval of add single product button
  Then Merchant should see successful message

