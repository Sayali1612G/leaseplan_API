# Getting started with REST API testing with Serenity and Cucumber 6

This tutorial show you how to get started with REST-API testing using Serenity and Cucumber 6. 

## Get the code

Git:

    git clone https://github.com/Sayali1612G/leaseplan_API.git
    cd Leaseplan

## The starter project
The best place to start with Serenity and Cucumber is to clone or download the starter project on Github.
This project gives you a basic project setup, along with some sample tests and supporting classes. 

### The project directory structure
The project has build scripts Maven, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                                Test runners and supporting code
    + resources
      + features                          Feature files 
          + status
          + trades
             API_checks.feature 
      + templates                          Templates and properties files                

```

## A simple GET scenario
The project comes with two simple scenarios, one that illustrates a GET with positive and negative scenarios.
Both variations of the sample project uses the sample Cucumber scenario. 
```Gherkin
  Scenario: Application status end-point
    Given the application is running
    When I check the application status
    Then the API should return "Serenity REST Starter project up and running"
```

The glue code for this scenario illustrates the layered approach we find works well for both web and non-web acceptance tests.
The glue code is responsible for orchestrating calls to a layer of more business-focused classes, which perform the actual REST calls.

```java
    @Steps
    ApplicationStatus theApplication;

    @Given("the application is running")
    public void the_application_is_running() {
        assertThat(theApplication.currentStatus()).isEqualTo(RUNNING);
    }

    @When("I check the application status")
    public void i_check_the_application_status() {
        theApplication.readStatusMessage();
    }
```

## Living documentation

You can generate full Serenity reports by running `mvn clean verify`. 
This includes both the living documentation from the feature files:


## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity BDD Dojo**](https://serenitydojo.teachable.com) - Online training on Serenity BDD and on test automation and BDD in general.
