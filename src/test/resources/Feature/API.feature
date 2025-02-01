Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Verify get request
    When user send the GET request
    Then verify the response contains 3 BPIs  as "USD" and "GBP" and "EUR"
    And verify GBP description equals "British Pound Sterling"
    

