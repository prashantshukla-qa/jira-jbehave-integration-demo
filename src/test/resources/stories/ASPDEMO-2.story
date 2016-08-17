Feature: Advanced Search

Scenario: As a user, I want to perform advanced search
Given I am on home page
When I click Sign In button
Then I am navigated to login page
When I enter username testuser@qait.com
And I enter password password
And I click Log In button
Then I am navigated to home page
When I click on SEARCH ALL CONTENT link
And I click on Advanced Search link
Then I am navigated to Advanced Search Page
When I type video in Words Anywhere field
And I click Search button
Then I am navigated to search results page