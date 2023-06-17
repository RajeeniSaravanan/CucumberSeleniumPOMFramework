Feature: Salesforce login Functionality

Background:
Given application is up and running and in loginPage

Scenario: Select user menu dropdown in homepage
When user on "LoginPage"
When user enters correct username and correct password
And click on the login button
When user on "Homepage"
Then Validate the home page title
When user click on for user menu dropdown in homepage
Then user menu dropdown list is displayed
 

