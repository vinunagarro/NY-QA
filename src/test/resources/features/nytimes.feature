Feature: New York Times Website Testing

  Scenario Outline: Home Page Load
    Given I navigate to the New York Times homepage
    Then I should see "<title>" in the header
    Examples:
      | title         |
      | Today’s Paper |

  Scenario Outline: Search Functionality
    Given I navigate to the New York Times homepage
    When I search for "<searchText>"
    Then I should see articles related to "<searchText>"
    Examples:
      | searchText |
      | COVID-19   |

  Scenario: Page Navigation
    Given I navigate to the New York Times homepage
    When I click on the world news
    Then I should see the world news title


  Scenario Outline: Footer Links
    Given I navigate to the New York Times homepage
    When I click on the "<webLinkTxt>" footer link
    Then I should be redirected to the contact page
    Examples:
      | webLinkTxt |
      | Contact Us |