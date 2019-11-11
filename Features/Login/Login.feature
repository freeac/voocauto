Feature: Login

  Scenario: TC0001
  Given I execute login app with user and pass
  Given I verify message when user login fail
  
  Scenario: TC0002
  Given I execute login app with user and pass
  Given I verify user login app is success