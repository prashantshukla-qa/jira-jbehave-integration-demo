Feature: Search

Scenario: As a user, I want to perform a search
Given I am on home page
When I click Search icon
And I type Music into Enter your Keywords field
And I select Our video radio button to specify search criteria
And I click Search button to perform search
Then I am navigated to Search Results page
And I can see 298 search results