# xero-tests

Steps to run the Xero Selenium Tests

1. Clone the project
`git clone https://github.com/anksolanki/xero-tests.git`
2. Import the project xero-tests in Eclipse
3. Install latest Testng plugin for eclipse from Eclipse marketplace
4. Download the latest chrome driver from this url(http://chromedriver.chromium.org/downloads)
5. Update the local path of the chrome driver binary in the xeroSeleniumTest.java file
`System.setProperty("webdriver.chrome.driver", <chromedriver path>); `
6. Update the username & password in the xeroSeleniumUtil.java file

```
public String username = "<username>";
public String password = "<password>";
```

7. Right click on testng.xml in the project and "Run As" -> "TestNG Suite"
