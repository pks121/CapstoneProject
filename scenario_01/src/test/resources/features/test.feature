Feature: Automate Web Application using Selenium with BDD

  Scenario: Verify the Page Title and Navigation Flow
    Given I launch the application "http://the-internet.herokuapp.com/"
    Then I should see the title of the page as "The Internet"

  Scenario: Verify A/B Testing Page
    Given I am on the Home Page 
    When I click on "A/B Testing" link
    Then I should see the text on the page as "A/B Test Control"

  Scenario: Verify Dropdown Selection
    Given I am on the Home Page
    When I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then "Option 1" should be selected

  Scenario: Verify Frames Page Links
    Given I am on the Home Page
    When I click on "Frames" link
    Then I should see the following hyperlinks on the Frames page:
      | Nested Frames |
      | iFrame        |
    Then I_quit_the_application