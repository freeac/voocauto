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

  Scenario: /home/data/
    Given Execute call "GET" method with uri: "/home/data/" and token
    Given Execute check status "200" response is true

  Scenario: /kid/248/get/avatar/
    Given Execute call "GET" method with uri: "/kid/248/get/avatar/" and token
    Given Execute check status "200" response is true

  Scenario: /list/time/package/ebook/
    Given Execute call "GET" method with uri: "/list/time/package/ebook/" and token
    Given Execute check status "200" response is true

  Scenario: /list/top/system/tag/
    Given Execute call "GET" method with uri: "/list/top/system/tag/" and token
    Given Execute check status "200" response is true

  Scenario: /notifications/
    Given Execute call GET method with uri: "/notifications/" have params below
      | device_uid       |
      | 1231231231231232 |
    Given Execute check status "200" response is true

  Scenario: /notifications/116/read/
    Given Execute call POST method nobody with uri: "/notifications/116/read/" and token
    Given Execute check status "200" response is true

  Scenario: /personal/package/info/
    Given Execute call "GET" method with uri: "/personal/package/info/" and token
    Given Execute check status "200" response is true

  Scenario: /personal/info/
    Given Execute call GET method with uri: "/personal/info/" have params below
      | personal   |
      | nguyenphuc |
    Given Execute check status "200" response is true

  Scenario: /promotion/data/
    Given Execute call "GET" method with uri: "/promotion/data/" and token
    Given Execute check status "200" response is true

  Scenario: /send/otp/forgot/password/
    Given Execute call "POST" APi with uri: "/send/otp/forgot/password/"
    Given Execute check status "200" response is true
    
   Scenario: /time/package/list/
    Given Execute call "GET" method with uri: "/time/package/list/" and token
    Given Execute check status "200" response is true
    
   Scenario: /user/resend/active/
    Given Execute call "PATCH" APi with uri: "/user/resend/active/"
    Given Execute check status "200" response is true
