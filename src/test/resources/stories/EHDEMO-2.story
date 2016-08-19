Feature: Validate Detailed Records

Scenario: As a user, I want to validate detailed records for a searched book
Given I am on homepage
When I search for book Computer
Then I can see search results for book Computer
When I select first result from search results to view detailed record
Then I can see detailed records for selected result