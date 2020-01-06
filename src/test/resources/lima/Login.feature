#@login-feature
Feature: Login

#  @login-feature-ldap-successful
  Scenario: User login successful
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-85" username, "Test123!" password
    Then Merchant should see "Sprint-85" username as on Home Page


  Scenario: User login failed
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-85" username, "Test12345!" password
    Then Merchant should see Access Denied Message

