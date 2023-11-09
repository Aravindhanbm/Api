Feature: To validate the post HTTP request
  Scenario: to validate the response of post request
    Given User set the baseurl for api
    And User set the payload and headers
    When User execute post Request
    Then User validate the Response for api