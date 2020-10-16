@HRM_multiple_employess
Feature: multiple employees

Scenario Outline:
Given when user launches HRM site and login
When user add multiple employees with "<firstname>" "<lastname>" "<username>"
Then close the browser

Examples:
| firstname | lastname | username |
| AAAtestfirstname1 | AAAtestlastname1 | test1userid|
| AAAtestfirstname2 | AAAtestlastname2 | test2userid|