## Api test framework
Create test using java8 + gradle + RestAssured + Allure
<br/>
* Please use Java JDK 8 for framework
* Test will be run in two threads. Change number of threads you can in build.gradle file 
<br/>
To run ui test on chrome 84 you need to pass in framework folder ./gradlew clean -Dbrowser=chrome ui:test
<br/>
To run on firefox ./gradlew clean -Dbrowser=firefox ui:test
<br/>
To run on remote ./gradlew clean -DremoteDriverUrl=http://{selenoid.ip}:4444/wd/hub ui:test
<br/>
To run Api test ./gradlew clean api:test in project directory
<br/>
To run api + ui ./gradlew clean test
Result you can find in build/reports/tests/test/index.html or generate allure report from allure-result folder
<br/>
