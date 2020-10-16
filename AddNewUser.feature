@AddNewUser
Feature: creating new user

Scenario:
Given when user launches page
When user enters "root" and "pa$$w0rd"
Then add new user
And close the browser

