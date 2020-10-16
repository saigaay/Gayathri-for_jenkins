@Jobboard_PostingJob_examplestable
Feature: Posting a job

Scenario Outline:
Given when user launches jobs site for job posting
When user go to post a job page
Then fill details "<gmail>" "<job_title>" "<location>" "<description>" "<company_url>" "<company>" and submit
And verify the posted job
Then close the browser

Examples:
| gmail | job_title | location | description | company_url | company |
| testsample_job215@gmail.com | Automation Test Specialist | Hyderabad |  For posting Job activity | testsample_job215@gmail.com  | IBM |