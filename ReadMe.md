# API Test Automation Framework

This is a Java-based API test automation framework using **Rest-Assured**, **TestNG**, and **data-driven testing** with CSV files. It tests the public API [JSONPlaceholder](https://jsonplaceholder.typicode.com/guide/).

---

## 📦 Tech Stack

- **Java**
- **Rest-Assured** – for API testing
- **TestNG** – test runner and assertions
- **Apache Commons CSV** – for reading test data from CSV
- **Maven** – project and dependency management
- *(Optional)* ExtentReports – for HTML reporting

---

## 📁 Project Structure

api-testing-framework/
├── pom.xml # Maven dependencies
├── README.md # Project overview
├── testng.xml # TestNG suite config
├── testData/testData.csv # Input test data
├── src/
│ ├── main/
│ │ └── java/
│ │ └── utilities/
│ │ └── CSVReaderUtil.java # CSV parser utility
│ └── test/
│ └── java/
│ ├── BaseTest/
│ │ └── BaseTestClass.java # Setup base URI and request config
│ ├── ApiTests/
│ │ └── APITests.java # Data-driven test class
│ 

## Build With Maven
mvn clean install

## Run the Test Suite
mvn test
mvn test -DsuiteXmlFile=testng.xml

🧪 Test Coverage
✅ GET and POST methods
✅ Status code validation
✅ Key-value assertion
✅ Data-driven test execution
✅ Easy CSV extensibility
