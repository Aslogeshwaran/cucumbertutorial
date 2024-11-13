Feature: Verifying the facebook loginpage functionality

  @regression
  Scenario Outline: Verifying login functionality with invalid credentials
    When User enters the username  as "<username>" and password as "<password>"
    And User clicks the login Button
    Then User gets warning message

    Examples: 
      | username            | password |
      | logeshwaran         |   123456 |
      | logeshwaranas       |   123456 |
      | logeshwaransivasamy |   123456 |

  @smoke
  Scenario: Verifying login page title and url
    When User gets facebook title and url

  @smoke @sanity
  Scenario: Verifying login page links
    When User gets links count
    And User prints links text and hrefattribute
