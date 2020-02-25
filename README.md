# bdd-with-cucumber-in-java

Parallel feature file execution using:

1. Java
2. JUnit 4
3. Selenium WebDriver 
4. Cucumber 


__Note.__ This example uses JUnit 4 and is limited to parallel feature files rather than scenarios. See this WIP pull request to monitor JUnit 5 support in Cucumber:

https://github.com/cucumber/cucumber-jvm/pull/1509

## Maven profiles

There are a number of Maven profiles which can be used to control the execution settings:

1. `firefox` or `chrome` will dictate the browser to use. *Default is `firefox`*
2. `dev`, `test` or `prod` will dictate the environment (only `prod` works in this example). *Default is `prod`*
3. `parallel` ensures parallel execution

### Examples

`mvn clean test` 

This will use the defaults and run `firefox`, `prod`, `parallel`

`mvn clean test -P chrome -P prod -P parallel`

This will execute the tests on Chrome in Selenium Grid with the Production URL.

`mvn clean test -P chrome,prod,parallel`

This is also valid syntax
