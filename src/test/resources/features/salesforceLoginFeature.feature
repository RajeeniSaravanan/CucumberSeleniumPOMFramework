Feature: Salesforce login Functionality

Background:
Given application is up and running and in loginPage


Scenario: Unsuccessful login to salesforce application
When user on "LoginPage" 
When user enters username and leave the password field empty
And click on the login button
Then Error message should be displayed in Loginpage and validate the error message

Scenario: Successful Login to salesforce application
When user on "LoginPage"
When user enters correct username and correct password
And click on the login button
When user on "Homepage"
Then Validate the home page title

Scenario: Select rememberme checkbox in login page
When user on "LoginPage"
When user enters correct username and correct password
And select the rememberme checkbox
And click on the login button
When user on "Homepage"
Then Validate the home page title
And user click on the usermenu dropdown
And click on the logout 
When user on "LoginPage"
Then validate the username field in the loginpage

Scenario: Forgot Password without entering username and password
When user on "LoginPage"
And user clicks on forgot password link
When user on "ForgotpasswordPage"
When user provide username in forgot password page
And click on the continue button
Then password reset message is displayed

Scenario: Validate login error message if user enters incorrect username and incorrect password
When user on "LoginPage"
When When user enters incorrect username and incorrect password
And click on the login button
Then error message should be displayed in loginpage


 

