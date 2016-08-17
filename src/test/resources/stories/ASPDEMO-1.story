Feature: Basic Search

Scenario: As a user, I want to perform basic search
Given I am on home page
When I click on Sign In link
Then I am navigated to login page
When I enter username testuser@qait.com
And I enter password password
And I click Log In button
Then I am navigated to home page
When I click on SEARCH ALL CONTENT link to show menu
And I type video in Search field to perform basic search
And I click Search button
Then I am navigated to search results page