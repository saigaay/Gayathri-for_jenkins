@CRM_schedule_meeting
Feature: schedule meeting

Scenario Outline:
Given when user launches CRM site and login
When schedule meeting and verify "<firstname>" "<firstname1>" "<firstname2>"
Then quit the browser

Examples:
| firstname | firstname1 | firstname2 |
| test | test1 | testing1 |