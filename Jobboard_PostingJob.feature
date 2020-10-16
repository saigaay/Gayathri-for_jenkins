@Jobboard_PostingJob
Feature: Posting a job

Scenario:
Given when user launches jobs site for job posting
When user go to post a job page
Then fill details "sampletest1234@gmail.com" "Automation Test Specialist" "Hyderabad" " For posting Job activity" "sampletest1234@gmail.com" "IBM" and submit
And verify the posted job
Then close the browser