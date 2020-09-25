#@Single product add feature
Feature: SingleProduct

Scenario: Add new product and Check
Given Merchant is on the Login Page
When Merchant login with "TEST-MPOP" username, "Test123!" password
Then Merchant should see username as "TEST-MPOP" on Home Page

And Merchant go to add product page
And Merchant click add single product tab
Then Merchant should see add product modal

When Merchant should select a category which name is "Panduf"
And Merchant should set a random brand name
And Merchant should set a random product name
And Merchant should write a random barcode
And Merchant should write a random merchant stock code
And Merchant should select a number which value is "1"
And Merchant should select a color which name is "Açık Yeşil"
And Merchant should insert images "image.png"
And Merchant should click the next step button
Then Merchant should see product feature page

When Merchant should write a warrant length is "2"
And Merchant should write a tax percentage is "18"
And Merchant should write a desi is "12"
And Merchant should write size property is "16"
And Merchant should click the next step button
Then Merchant should see product description page

When Merchant should write description "test"
And Merchant should click approval of add single product button
Then Merchant should see successful message