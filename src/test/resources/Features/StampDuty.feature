Feature: OpenLibrary Author API Validation

  Scenario: Verify Author Sachi Rautroy Data
    Given I set the API endpoint for the author
    When I send a GET request to the author endpoint
    Then the response status code should be 200
    And the personal name should be "Sachi Rautroy"
    And the alternate names should contain "Yugashrashta Sachi Routray"