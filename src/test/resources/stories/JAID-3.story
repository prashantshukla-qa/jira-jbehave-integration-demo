This story has non-implemented steps

Narrative:
In order to create a user account
As a prospective user
I want to access Registration Page

Scenario: 1. User is able to access the Registration Page

Given I have launched the application
And I am on Home Page

When I click register link

Then I am on Registration Page

Scenario: 2. User gets registration form on the registration page

Given I have launched the application
And I click register link

When I am on Registration Page

Then the username field is displayed
And password field is displayed
And register button is displayed