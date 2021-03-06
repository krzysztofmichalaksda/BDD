Feature: Test for google search functionality

  As a user, I want to search data in google, so that search result should be correct

  Background: open google
    When I open https://google.pl

  Scenario Outline: Check that wikipedia occurs as first search result
    When I type '<text>' in text input
      And I click search button
    Then I should see '<page>' as a first search result

    Examples:
    | text      | page          |
    | wikipedia | wikipedia.org |
    | sda       | sdacademy.pl  |