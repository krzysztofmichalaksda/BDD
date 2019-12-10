Feature: Test for google search functionality

  As a user, I want to search data in google, so that search result should be correct

  Scenario: Check that wikipedia occurs as first search result
    When I open https://google.pl
      And I type 'wikipedia' in text input
      And I click search button
    Then I should see 'wikipedia.org' as a first search result

  Scenario: Check that sda occurs as first search result
    When I open https://google.pl
      And I type 'sda' in text input
      And I click search button
    Then I should see 'sdacademy.pl' as a first search result