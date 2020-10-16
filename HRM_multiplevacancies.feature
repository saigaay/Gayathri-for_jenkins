@HRM_multiplevacancies
Feature: job vacancy

Scenario Outline:
Given when user launches HRM site and login
When user creates multiple vacancies with "<jobtitle>" "<manager>"
Then close the browser

Examples:
| jobtitle | manager |
| ASenior Analyst 1 | demo user |
| ASenior Analyst 2 | demo user |