@login-feature
Feature: Login

  @login-feature-ldap-successful
  Scenario: User login successful
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-100" username, "Test123!" password
    Then Merchant should see "Sprint-100" username as on Home Page

  @login-feature-ldap-unsuccessful
  Scenario: User login failed
    Given Merchant is on the Login Page
    When Merchant login with "Sprint-100" username, "Test12345!" password
    Then Merchant should see Access Denied Message

