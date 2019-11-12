Feature: Umbalena APi
  Run Umbalena Api script

  Scenario: /accounts/login/
    Given Execute call "POST" APi with uri: "/accounts/login/"
    Given Execute check status "200" response is true

  Scenario: /ebook/distributor/
    Given Execute call "GET" method with uri: "/ebook/distributor/" and token
    Given Execute check status "200" response is true

  Scenario: /ebook/distributor/66/
    Given Execute call "GET" method with uri: "/ebook/distributor/66/" and token
    Given Execute check status "200" response is true

  Scenario: /ebook/post/list/
    Given Execute call "GET" method with uri: "/ebook/post/list/" and token
    Given Execute check status "200" response is true

  Scenario: /ebook/post/list/80/
    Given Execute call "GET" method with uri: "/ebook/post/list/80/" and token
    Given Execute check status "200" response is true
	
	Scenario: /ebook/post/slug/
    Given Execute call "GET" method with uri: "/ebook/post/slug/" and token
    Given Execute check status "200" response is true
	
  Scenario: /profile/user/
    Given Execute call "GET" method with uri: "/profile/user/" and token
    Given Execute check status "200" response is true

  Scenario: /personal/package/info/
    Given Execute call "GET" method with uri: "/personal/package/info/" and token
    Given Execute check status "200" response is true

  Scenario: /personal/info/
    Given Execute call GET method with uri: "/personal/info/" have params below
      | personal   |
      | nguyenphuc |
    Given Execute check status "200" response is true
