Feature: Auto Quote Testing

  @auto
  Scenario: Create an Auto Quote
    Given validating landing page title
    When click start quote button
    Then validate get quote page title
    When insert zipcode '11423'
    And click car lob button
    And click lets go button
    Then verify address page title
