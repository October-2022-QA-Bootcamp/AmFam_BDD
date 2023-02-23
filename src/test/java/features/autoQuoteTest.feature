Feature: Auto Quote Testing

Background:
* this is a quote test 

  @smoke
  Scenario: Create an Auto Quote
    Given validating landing page title
    When click start quote button
    Then validate get quote page title
    When insert zipcode '54115'
    And click car lob button
    And click lets go button
    Then verify address page title

  @dataDriven @csr-453 @regression
  Scenario Outline: Auto Quote with <zipCode>
    Given validating landing page title
    When click start quote button
    Then validate get quote page title
    When insert zipcode <zipCode>
    And click car lob button
    And click lets go button
    Then verify address page title
    Examples:
    |zipCode|
    |'54115'|
    |'54114'|
    |'54113'|
    