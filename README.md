# trello-api-test-automation
**Testing suite to test [Trello RESTful APIs](https://developer.atlassian.com/cloud/trello/rest/api-group-actions/#api-group-actions)**
- APIs :
  - Board 
  - Lists on Board 

**Using** :

- Maven Project and add the dependencies 
  - [Rest Assured](https://rest-assured.io/)
  - [TestNG Maven](https://mvnrepository.com/artifact/org.testng/testng)
  - [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
  - [Allure TestNG](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng)
  - [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html)
- TestNG's assertions, and Hamcrest matchers
- Deserialize a JSON response using Rest Assured , Jackson and POJO Model.
- POJO Model
- API OOP (Abstraction , Server Class )
- POM = API object Model
- Run Tests using maven command line 
- Run Tests in Parallel Execution using maven surefire
- Build our CI/CD to Run tests on pipeline (GitHubAction) 
  - Build job
  - Run the job when push the code to the master 

