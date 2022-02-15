Requirements:
----
- Java 1.8
- Updated Chrome/Firefox browser to the latest version
- Clone the project from repository
- Installed Intellij Idea


Prepare Selenium Grid (Usage in Windows 10):
----
1. Open Command Prompt with the project path and use the following command:
##### java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubconfig.json
2. Open grid console in the browser:
#####  http://localhost:4444/grid/console
3. Open Command Prompt with the project path and use the following command:
#####  java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeconfig.json


Running tests in Intellij Idea:
----
1) Single test:
- run ‘TestApi’
- run ‘TestDb’
- run ‘TestIframe’
2) All test without Firfox: 
- run ‘test’ package
3) Parallel launch 'TestIframe' in Chrome and Firefox: 
- run ‘testing.xml’ file
