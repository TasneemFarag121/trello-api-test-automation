# trello-api-test-automation
### About
**Testing suite to test [Trello RESTful APIs](https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-group-actions)**
- Covered APIs :
  - Board 
  - Lists on Board
  
**Practises applied in this Suite**
- TestNG's assertions, and Hamcrest matchers
- Deserialize a JSON response using Rest Assured , Jackson and POJO Model.
- POJO Model
- API OOP (Abstraction , Server Class )
- POM = API object Model
- Run Tests using maven command line
- Run Tests in Parallel Execution using maven surefire
- Build our CI/CD to Run tests on pipeline (GitHubAction)
  - Build job using Yaml file 
  - Run the job when push the code to the master


### Pre-requests
- Apache Maven 
- Allure Framework Setup

### How to run Test Suite
> mvn clean test

>  allure serve allure-results



### Maven Dependencies 
  - [Rest Assured](https://rest-assured.io/)
  - [TestNG Maven](https://mvnrepository.com/artifact/org.testng/testng)
  - [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
  - [Allure TestNG](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng)
  - [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html)
