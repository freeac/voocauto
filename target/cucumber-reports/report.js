$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("APiCheck.feature");
formatter.feature({
  "line": 1,
  "name": "Umbalena APi",
  "description": "Run Umbalena Api script",
  "id": "umbalena-api",
  "keyword": "Feature"
});
formatter.before({
  "duration": 35058362,
  "status": "passed"
});
formatter.before({
  "duration": 1071360,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "/accounts/login/",
  "description": "",
  "id": "umbalena-api;/accounts/login/",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Execute call \"POST\" APi with uri: \"/accounts/login/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Execute check status \"200\" response is true",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Execute check header response as below",
  "rows": [
    {
      "cells": [
        "Content-Type",
        "Content-Language"
      ],
      "line": 8
    },
    {
      "cells": [
        "application/json",
        "vi"
      ],
      "line": 9
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Execute check body response with \"profile\" key as below",
  "rows": [
    {
      "cells": [
        "id",
        "is_active",
        "username",
        "full_name",
        "email",
        "phone",
        "birth_date",
        "expiry_date"
      ],
      "line": 11
    },
    {
      "cells": [
        "255",
        "true",
        "nguyenphuc",
        "Nguyễn Văn Phuc",
        "Nguyenvanphuc2203@gmail.com",
        "+84964357189",
        "28-04-1997",
        "10/14/2020 03:11"
      ],
      "line": 12
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "POST",
      "offset": 14
    },
    {
      "val": "/accounts/login/",
      "offset": 35
    }
  ],
  "location": "CommonApiSteps.ExecuteAPiWithUri(String,String)"
});
formatter.result({
  "duration": 1816531549,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckStatusResponse(String)"
});
formatter.result({
  "duration": 5111042,
  "status": "passed"
});
formatter.match({
  "location": "CommonApiSteps.ExecuteCheckHeaderResponse(DataTable)"
});
formatter.result({
  "duration": 6027522,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "profile",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 16722781,
  "status": "passed"
});
formatter.after({
  "duration": 3534082,
  "status": "passed"
});
formatter.after({
  "duration": 6920536,
  "status": "passed"
});
formatter.before({
  "duration": 4545709,
  "status": "passed"
});
formatter.before({
  "duration": 1088001,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "/profile/user/",
  "description": "",
  "id": "umbalena-api;/profile/user/",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Execute call \"GET\" method with uri: \"/profile/user/\" and token",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Execute check status \"200\" response is true",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Execute check header response as below",
  "rows": [
    {
      "cells": [
        "Content-Type",
        "Content-Language"
      ],
      "line": 18
    },
    {
      "cells": [
        "application/json",
        "vi"
      ],
      "line": 19
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "Execute check body response with \"Not Yet\" key as below",
  "rows": [
    {
      "cells": [
        "id",
        "is_active",
        "username",
        "full_name",
        "email",
        "phone",
        "birth_date",
        "expiry_date"
      ],
      "line": 21
    },
    {
      "cells": [
        "255",
        "true",
        "nguyenphuc",
        "Nguyễn Văn Phuc",
        "Nguyenvanphuc2203@gmail.com",
        "+84964357189",
        "28-04-1997",
        "10/14/2020 03:11"
      ],
      "line": 22
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 14
    },
    {
      "val": "/profile/user/",
      "offset": 37
    }
  ],
  "location": "CommonApiSteps.ExecuteAPiWithUriToken(String,String)"
});
formatter.result({
  "duration": 204896514,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckStatusResponse(String)"
});
formatter.result({
  "duration": 1277440,
  "status": "passed"
});
formatter.match({
  "location": "CommonApiSteps.ExecuteCheckHeaderResponse(DataTable)"
});
formatter.result({
  "duration": 3834029,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not Yet",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 18057394,
  "status": "passed"
});
formatter.after({
  "duration": 2370135,
  "status": "passed"
});
formatter.after({
  "duration": 1834241,
  "status": "passed"
});
formatter.before({
  "duration": 3566509,
  "status": "passed"
});
formatter.before({
  "duration": 1163520,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "/personal/package/info/",
  "description": "",
  "id": "umbalena-api;/personal/package/info/",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Execute call \"GET\" method with uri: \"/personal/package/info/\" and token",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Execute check status \"200\" response is true",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Execute check header response as below",
  "rows": [
    {
      "cells": [
        "Content-Type",
        "Content-Language"
      ],
      "line": 28
    },
    {
      "cells": [
        "application/json",
        "vi"
      ],
      "line": 29
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Execute check body response with \"Not Yet\" key as below",
  "rows": [
    {
      "cells": [
        "expiry_date",
        "buy_date",
        "is_forever"
      ],
      "line": 31
    },
    {
      "cells": [
        "14-10-2020",
        "14-10-2019",
        "false"
      ],
      "line": 32
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 33,
  "name": "Execute check body response with \"time_package\" key as below",
  "rows": [
    {
      "cells": [
        "name",
        "price",
        "status"
      ],
      "line": 34
    },
    {
      "cells": [
        "Gói cơ bản",
        "619000",
        "publish"
      ],
      "line": 35
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 14
    },
    {
      "val": "/personal/package/info/",
      "offset": 37
    }
  ],
  "location": "CommonApiSteps.ExecuteAPiWithUriToken(String,String)"
});
formatter.result({
  "duration": 170391113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckStatusResponse(String)"
});
formatter.result({
  "duration": 1320107,
  "status": "passed"
});
formatter.match({
  "location": "CommonApiSteps.ExecuteCheckHeaderResponse(DataTable)"
});
formatter.result({
  "duration": 4002989,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Not Yet",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 6070189,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "time_package",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 4230402,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat com.vooc.Pages.CommonApi.CheckContentResponse(CommonApi.java:125)\r\n\tat com.vooc.StepDefinition.CommonApiSteps.ExecuteCheckContentResponse(CommonApiSteps.java:41)\r\n\tat ✽.Given Execute check body response with \"time_package\" key as below(APiCheck.feature:33)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 19001390507,
  "status": "passed"
});
formatter.after({
  "duration": 7900164,
  "status": "passed"
});
formatter.before({
  "duration": 12291419,
  "status": "passed"
});
formatter.before({
  "duration": 1713921,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "/personal/info/",
  "description": "",
  "id": "umbalena-api;/personal/info/",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 38,
  "name": "Execute call POST method with uri: \"/personal/info/\" have params below",
  "rows": [
    {
      "cells": [
        "personal"
      ],
      "line": 39
    },
    {
      "cells": [
        "nguyenphuc"
      ],
      "line": 40
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "Execute check status \"200\" response is true",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "Execute check header response as below",
  "rows": [
    {
      "cells": [
        "Content-Type",
        "Content-Language"
      ],
      "line": 43
    },
    {
      "cells": [
        "application/json",
        "vi"
      ],
      "line": 44
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "Execute check body response with \"personal\" key as below",
  "rows": [
    {
      "cells": [
        "id",
        "username",
        "full_name"
      ],
      "line": 46
    },
    {
      "cells": [
        "255",
        "nguyenphuc",
        "Nguyễn Văn Phuc"
      ],
      "line": 47
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 48,
  "name": "Execute check body response with \"kid\" key as below",
  "rows": [
    {
      "cells": [
        "id",
        "full_name",
        "level",
        "username"
      ],
      "line": 49
    },
    {
      "cells": [
        "227",
        "anabell",
        "13",
        "anabell"
      ],
      "line": 50
    },
    {
      "cells": [
        "429",
        "phuc123",
        "3",
        "admin1997"
      ],
      "line": 51
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "/personal/info/",
      "offset": 36
    }
  ],
  "location": "CommonApiSteps.ExecuteAPiWithUriHaveParams(String,DataTable)"
});
formatter.result({
  "duration": 281231907,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckStatusResponse(String)"
});
formatter.result({
  "duration": 1125547,
  "status": "passed"
});
formatter.match({
  "location": "CommonApiSteps.ExecuteCheckHeaderResponse(DataTable)"
});
formatter.result({
  "duration": 4037548,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "personal",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 6261336,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kid",
      "offset": 34
    }
  ],
  "location": "CommonApiSteps.ExecuteCheckContentResponse(String,DataTable)"
});
formatter.result({
  "duration": 16292701,
  "status": "passed"
});
formatter.after({
  "duration": 1853868,
  "status": "passed"
});
formatter.after({
  "duration": 2308694,
  "status": "passed"
});
});