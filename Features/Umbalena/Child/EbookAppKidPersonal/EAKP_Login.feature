Feature: EAKP Login
  Function Login of Ebook App Kid Personal Project

  Scenario: LG_001
  Given Execute access into child account
	Given Execute input parent username "freeac" in child account login
	Given Execute click continue button
	Given Execute select child account
	Given Execute click continue with child button
	Given Execute choose password for child
	Given Execute click continue button
	Given Verify name of profile is "Na"
	
	Scenario: LG_002
  Given Execute access into child account
	Given Execute input parent username "0917794211" in child account login
	Given Execute click continue button
	Given Execute select child account
	Given Execute click continue with child button
	Given Execute choose password for child
	Given Execute click continue button
	Given Verify name of profile is "Na"
	
	Scenario: LG_004
	Given Execute access into child account
	Given Execute input parent username "nhan2211" in child account login
	Given Execute click continue button
	Given Verify message is display when input username is wrong
	
	Scenario: LG_005
	Given Execute access into child account
	Given Execute input parent username "0123456789" in child account login
	Given Execute click continue button
	Given Verify message is display when input username is wrong
	
	Scenario: LG_006
	Given Execute access into child account
	Given Execute input parent username "0917794211" in child account login
	Given Execute click continue button
	Given Execute select child account
	Given Execute click continue with child button
	Given Execute choose password for child
	Given Execute click continue button
	