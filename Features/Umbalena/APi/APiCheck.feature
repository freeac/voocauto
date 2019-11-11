Feature: Umbalena APi
  Run Umbalena Api script

  Scenario: /accounts/login/
    Given Execute call "POST" APi with uri: "/accounts/login/"
    Given Execute check status "200" response is true
    Given Execute check header response as below
      | Content-Type     | Content-Language |
      | application/json | vi               |
    Given Execute check body response with "profile" key as below
      | id  | is_active | username   | full_name       | email                       | phone        | birth_date | expiry_date      |
      | 255 | true      | nguyenphuc | Nguyễn Văn Phuc | Nguyenvanphuc2203@gmail.com | +84964357189 | 28-04-1997 | 10/14/2020 03:11 |

  Scenario: /profile/user/
    Given Execute call "GET" method with uri: "/profile/user/" and token
    Given Execute check status "200" response is true
    Given Execute check header response as below
      | Content-Type     | Content-Language |
      | application/json | vi               |
    Given Execute check body response with "Not Yet" key as below
      | id  | is_active | username   | full_name       | email                       | phone        | birth_date | expiry_date      |
      | 255 | true      | nguyenphuc | Nguyễn Văn Phuc | Nguyenvanphuc2203@gmail.com | +84964357189 | 28-04-1997 | 10/14/2020 03:11 |

  Scenario: /personal/package/info/
    Given Execute call "GET" method with uri: "/personal/package/info/" and token
    Given Execute check status "200" response is true
    Given Execute check header response as below
      | Content-Type     | Content-Language |
      | application/json | vi               |
    Given Execute check body response with "Not Yet" key as below
      | expiry_date | buy_date   | is_forever |
      | 14-10-2020  | 14-10-2019 | false      |
    Given Execute check body response with "time_package" key as below
      | name       | price  | status  |
      | Gói cơ bản | 699000 | publish |

  Scenario: /personal/info/
    Given Execute call POST method with uri: "/personal/info/" have params below
      | personal   |
      | nguyenphuc |
    Given Execute check status "200" response is true
    Given Execute check header response as below
      | Content-Type     | Content-Language |
      | application/json | vi               |
    Given Execute check body response with "personal" key as below
      | id  | username   | full_name       |
      | 255 | nguyenphuc | Nguyễn Văn Phuc |
    Given Execute check body response with "kid" key as below
      | id  | full_name | level | username  |
      | 227 | anabell   |    13 | anabell   |
      | 429 | phuc123   |     3 | admin1997 |