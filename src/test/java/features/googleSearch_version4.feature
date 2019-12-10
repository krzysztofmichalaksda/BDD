Feature: Test for google search functionality

  As a user, I want to search data in google, so that search result should be correct

  Scenario Outline: Check that wikipedia occurs as first search result
    When a user searches '<text>' in google
    Then the user should see '<page>' as a first search result

    Examples:
    | text       | page          |
    | wikipedia  | wikipedia.org |
    | sda        | sdacademy.pl  |
    | testowanie | testerzy.pl   |