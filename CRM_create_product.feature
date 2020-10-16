@CRM_create_product
Feature: create product

Scenario Outline:
Given when user launches CRM site and login
When create product using "<productname>" "<price>" "<description>" and verify
Then quit the browser

Examples:
| productname | price | description |
| sampletestproduct | 1000 | sample test for project |