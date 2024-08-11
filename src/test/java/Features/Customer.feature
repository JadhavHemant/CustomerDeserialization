Feature: Test Customer APIs

  Scenario: Create new customer using Post request
    Given user configure Base URI
    And user get RequestSpecification Interface object
    And user add Request Header
    And user create request body using Serialization and Deserialization
    And user add request body for Post request
    When user select HTTP Post request
    Then user capture status code
    And user capture status line
    And user capture response time
    And user capture response body
    And user capture response headers
    And user capture id from response body

    Scenario: Retrieve customer information using Get request
    Given user configure Base URI
    And user get RequestSpecification Interface object
    When user select HTTP get request
    Then user capture status code
    And user capture status line
    And user capture response time
    And user capture response body
    And user capture response headers
    
    Scenario: Update customer information using Put request
    Given user configure Base URI
    And user get RequestSpecification Interface object
    And user add Request Header
    And user create request body Put request using Serialization and Deserialization
    And user add request body for Put request
    When user select HTTP Put request
    Then user capture status code
    And user capture status line
    And user capture response time
    And user capture response body
    And user capture response headers
    
    Scenario: Update customer partial information using Patch request
    Given user configure Base URI
    And user get RequestSpecification Interface object
    And user add Request Header
    And user create request body Patch request using Serialization and Deserialization
    And user add request body for Patch request
    When user select HTTP Patch request
    Then user capture status code
    And user capture status line
    And user capture response time
    And user capture response body
    And user capture response headers
    
    Scenario: Delete customer information using Delete Request
    Given user configure Base URI
    And user get RequestSpecification Interface object
    When user select HTTP delete request
    Then user capture status code
    And user capture status line
    And user capture response time

