Feature: Filter Search Results

Scenario: As a user, I want to filter search results by source type
Given I am on homepage
When I search for book Computer
Then I can see search results for book Computer
When I filter search results by Source Type
Then I can see correct no of search items found