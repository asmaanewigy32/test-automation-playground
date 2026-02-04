# Test Automation Playground

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)

A comprehensive test automation framework developed as part of the QACart learning journey, demonstrating modern testing practices, design patterns, and industry best practices for web automation.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Design Patterns](#design-patterns)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [CI/CD Integration](#cicd-integration)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

This repository serves as a hands-on playground for implementing and practicing test automation techniques. It showcases a production-ready Selenium WebDriver framework built with Java, following the Page Object Model (POM) design pattern and incorporating modern testing practices.

The framework is designed to test the **QACart Todo Application**, providing comprehensive examples of UI automation, API integration for test setup, and hybrid testing strategies.

---

## Features

### Core Functionality

- ✅ **Comprehensive Test Coverage** - Full end-to-end test scenarios for Todo application
- ✅ **Page Object Model (POM)** - Organized, maintainable page classes
- ✅ **Hybrid Testing** - Combines UI and API testing for optimal efficiency
- ✅ **Data-Driven Testing** - Support for multiple data sets via TestNG data providers
- ✅ **Cross-Browser Testing** - Chrome, Firefox, Edge support
- ✅ **Headless Execution** - CI/CD friendly headless browser mode
- ✅ **Screenshot on Failure** - Automatic screenshot capture for failed tests
- ✅ **Detailed Reporting** - TestNG HTML reports with test execution details
- ✅ **Logging Framework** - Comprehensive logging using Log4j/SLF4J
- ✅ **Configuration Management** - Environment-based configuration (Dev, QA, Prod)
- ✅ **Retry Mechanism** - Automatic retry for flaky tests
- ✅ **Parallel Execution** - Multi-threaded test execution support
- ✅ **CI/CD Ready** - GitHub Actions workflow integration

### Advanced Features

- 🔄 **API-First Approach** - Uses API calls for test data setup to speed up UI tests
- 🔄 **Fluent Interface** - Chainable page object methods for readable tests
- 🔄 **Wait Strategies** - Explicit, implicit, and fluent wait implementations
- 🔄 **Custom Annotations** - Framework-specific annotations for enhanced functionality
- 🔄 **Test Listeners** - Custom TestNG listeners for enhanced reporting
- 🔄 **Factory Pattern** - Browser driver factory for flexible browser management
- 🔄 **Singleton Pattern** - Configuration and driver management
- 🔄 **Utilities Library** - Reusable helper methods and utilities

---

## Technology Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 11+ | Programming Language |
| **Selenium WebDriver** | 4.x | Browser Automation |
| **TestNG** | 7.x | Testing Framework |
| **Maven** | 3.x | Build & Dependency Management |
| **RestAssured** | 5.x | API Testing & Setup |
| **Log4j 2** | 2.x | Logging Framework |
| **ExtentReports** | 5.x (Optional) | Advanced Reporting |
| **WebDriverManager** | 5.x | Automatic Driver Management |
| **AssertJ** | 3.x (Optional) | Fluent Assertions |
| **Jackson/Gson** | Latest | JSON Parsing |

---

## Project Structure

```
test-automation-playground/
│
├── .github/
│   └── workflows/
│       └── maven.yml                    # GitHub Actions CI/CD pipeline
│
├── .idea/                               # IntelliJ IDEA configuration files
│
├── SeleniumFrameworkDesign-Project/
│   └── src/
│       ├── main/
│       │   └── java/
│       │       └── com/qacart/todo/
│       │           ├── api/             # API client implementations
│       │           │   ├── TodoApi.java
│       │           │   └── UserApi.java
│       │           │
│       │           ├── base/            # Base classes
│       │           │   ├── BasePage.java
│       │           │   └── BaseTest.java
│       │           │
│       │           ├── config/          # Configuration management
│       │           │   ├── ConfigReader.java
│       │           │   └── EndpointConfig.java
│       │           │
│       │           ├── driver/          # WebDriver management
│       │           │   ├── DriverFactory.java
│       │           │   └── DriverManager.java
│       │           │
│       │           ├── models/          # Data models/POJOs
│       │           │   ├── User.java
│       │           │   └── Todo.java
│       │           │
│       │           ├── pages/           # Page Object Model classes
│       │           │   ├── LoginPage.java
│       │           │   ├── RegisterPage.java
│       │           │   ├── TodoPage.java
│       │           │   └── NewTodoPage.java
│       │           │
│       │           └── utils/           # Utility classes
│       │               ├── ScreenshotUtil.java
│       │               ├── WaitUtil.java
│       │               ├── ConfigUtil.java
│       │               └── DataGenerator.java
│       │
│       └── test/
│           └── java/
│               └── com/qacart/todo/
│                   ├── tests/           # Test classes
│                   │   ├── TodoTests.java
│                   │   ├── LoginTests.java
│                   │   └── RegisterTests.java
│                   │
│                   ├── listeners/       # TestNG listeners
│                   │   ├── TestListener.java
│                   │   └── RetryAnalyzer.java
│                   │
│                   └── testdata/        # Test data providers
│                       └── TodoDataProvider.java
│
├── src/
│   └── test/
│       └── resources/
│           ├── config/
│           │   ├── config.properties    # Main configuration
│           │   ├── dev.properties       # Development environment
│           │   ├── qa.properties        # QA environment
│           │   └── prod.properties      # Production environment
│           │
│           ├── testdata/
│           │   ├── users.json           # User test data
│           │   └── todos.json           # Todo test data
│           │
│           └── log4j2.xml               # Logging configuration
│
├── test-output/                         # TestNG generated reports
├── screenshots/                         # Failed test screenshots
├── logs/                                # Application logs
│
├── pom.xml                              # Maven dependencies & plugins
├── testng.xml                           # TestNG suite configuration
├── README.md                            # Project documentation
└── .gitignore                           # Git ignore rules

```

---

## Design Patterns

### 1. Page Object Model (POM)

Encapsulates web page elements and actions into separate classes for better maintainability.

```java
public class LoginPage extends BasePage {
    
    // Locators
    @FindBy(id = "email")
    private WebElement emailInput;
    
    @FindBy(id = "password")
    private WebElement passwordInput;
    
    @FindBy(id = "submit")
    private WebElement loginButton;
    
    // Actions
    public LoginPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }
    
    public TodoPage clickLogin() {
        loginButton.click();
        return new TodoPage(driver);
    }
}
```

### 2. Factory Pattern

Used for browser driver initialization and management.

```java
public class DriverFactory {
    
    public WebDriver createDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Invalid browser: " + browserType);
        }
    }
}
```

### 3. Singleton Pattern

Ensures single instance of configuration and driver manager.

```java
public class ConfigReader {
    private static ConfigReader instance;
    private Properties properties;
    
    private ConfigReader() {
        // Load properties
    }
    
    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }
}
```

### 4. Builder Pattern

Used for constructing complex test data objects.

```java
public class UserBuilder {
    private String email;
    private String password;
    private String firstName;
    
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public User build() {
        return new User(email, password, firstName);
    }
}
```

---

## Prerequisites

### Software Requirements

- **Java JDK** 11 or higher
- **Maven** 3.6.x or higher
- **IDE** (IntelliJ IDEA / Eclipse / VS Code)
- **Git** for version control

### Browser Requirements

- Google Chrome (latest)
- Mozilla Firefox (latest)
- Microsoft Edge (latest)

---

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/asmaanewigy32/test-automation-playground.git
cd test-automation-playground
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Download Browser Drivers (Automatic)

The framework uses WebDriverManager for automatic driver management. No manual download required.

### 4. Verify Installation

```bash
mvn clean test -Dtest=SampleTest
```

---

## Configuration

### Environment Configuration

Edit `src/test/resources/config/config.properties`:

```properties
# Browser Configuration
browser=chrome
headless=false
implicit.wait=10
explicit.wait=20

# Application URLs
base.url=https://todo.qacart.com
api.base.url=https://todo.qacart.com/api/v1

# Test Configuration
retry.count=1
screenshot.on.failure=true
parallel.execution=false
thread.count=3

# Environment
environment=qa
```

### TestNG Suite Configuration

Edit `testng.xml` for test suite customization:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Todo Automation Suite" parallel="methods" thread-count="3">
    
    <test name="Todo Tests">
        <classes>
            <class name="com.qacart.todo.tests.TodoTests"/>
            <class name="com.qacart.todo.tests.LoginTests"/>
        </classes>
    </test>
    
</suite>
```

---

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Class

```bash
mvn clean test -Dtest=LoginTests
```

### Run Specific Test Method

```bash
mvn clean test -Dtest=TodoTests#shouldCreateNewTodo
```

### Run Tests in Headless Mode

```bash
mvn clean test -Dheadless=true
```

### Run Tests with Specific Browser

```bash
mvn clean test -Dbrowser=firefox
```

### Run Tests in Parallel

```bash
mvn clean test -DsuiteXmlFile=testng-parallel.xml
```

### Run Tests for Specific Environment

```bash
mvn clean test -Denvironment=prod
```

### Run with Custom System Properties

```bash
mvn clean test \
  -Dbrowser=chrome \
  -Dheadless=true \
  -Denvironment=qa \
  -DthreadCount=5
```

---

## Test Reports

### TestNG HTML Reports

After test execution, reports are generated in:

```
test-output/
├── index.html              # Main report
├── emailable-report.html   # Email-friendly report
└── testng-results.xml      # XML results
```

Open `test-output/index.html` in a browser to view detailed results.

### ExtentReports (Optional)

If ExtentReports is configured:

```
reports/
└── ExtentReport.html       # Interactive HTML report
```

### Screenshots

Failed test screenshots are saved in:

```
screenshots/
└── FailedTest_2024-02-05_14-30-45.png
```

### Logs

Application logs are generated in:

```
logs/
└── application-2024-02-05.log
```

---

## CI/CD Integration

### GitHub Actions Workflow

The repository includes a GitHub Actions workflow (`.github/workflows/maven.yml`):

```yaml
name: Test Automation CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
        
    - name: Cache Maven packages
      uses: actions/cache@v3
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
        
    - name: Run Tests
      run: mvn clean test -Dheadless=true
      
    - name: Upload Test Reports
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: test-reports
        path: test-output/
```

### Jenkins Integration

For Jenkins pipeline:

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8'
        jdk 'JDK 11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/asmaanewigy32/test-automation-playground.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test -Dheadless=true'
            }
        }
        
        stage('Reports') {
            steps {
                publishHTML([
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }
}
```

---

## Best Practices

### Code Organization

- ✅ Follow SOLID principles
- ✅ Keep page classes focused and cohesive
- ✅ Use meaningful variable and method names
- ✅ Maintain consistent code formatting
- ✅ Add JavaDoc comments for public methods

### Test Design

- ✅ Keep tests independent and isolated
- ✅ Use API for test data setup when possible
- ✅ Implement proper wait strategies
- ✅ Avoid hard-coded waits (Thread.sleep)
- ✅ Clean up test data after execution

### Locator Strategy

- ✅ Prefer ID and name attributes
- ✅ Use CSS selectors over XPath when possible
- ✅ Avoid absolute XPath
- ✅ Use Page Factory for element initialization
- ✅ Create reusable locator constants

### Error Handling

- ✅ Implement try-catch blocks appropriately
- ✅ Capture screenshots on failures
- ✅ Log meaningful error messages
- ✅ Use custom exceptions where applicable
- ✅ Implement retry mechanism for flaky tests

### Maintenance

- ✅ Regular dependency updates
- ✅ Code reviews for all changes
- ✅ Continuous refactoring
- ✅ Update documentation
- ✅ Version control best practices

---

## Key Test Scenarios

### Authentication Tests

- User registration with valid credentials
- User login with valid credentials
- Login with invalid credentials
- Logout functionality

### Todo Management Tests

- Create new todo item
- Mark todo as completed
- Delete todo item
- Edit todo item
- Bulk operations

### Data-Driven Tests

- Create multiple todos from data provider
- Boundary value testing
- Negative testing scenarios

### End-to-End Workflows

- Complete user journey (Register → Login → Create Todo → Logout)
- Multi-todo operations
- Session management

---

## Troubleshooting

### Common Issues

#### WebDriver Exceptions

```
Problem: WebDriverException - Cannot find Chrome binary
Solution: Ensure Chrome is installed or set chrome.binary path in config
```

#### Element Not Found

```
Problem: NoSuchElementException
Solution: 
- Check if element locator is correct
- Verify element is visible/present
- Add appropriate wait strategy
```

#### Tests Hanging

```
Problem: Tests not completing
Solution:
- Check for modal dialogs or alerts
- Verify network connectivity
- Increase timeout values
```

#### Parallel Execution Issues

```
Problem: Tests failing in parallel mode
Solution:
- Ensure tests are independent
- Use ThreadLocal for WebDriver
- Avoid shared mutable state
```

---

## Contributing

We welcome contributions! Please follow these guidelines:

### Steps to Contribute

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Contribution Guidelines

- Follow existing code style and conventions
- Write meaningful commit messages
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

---

## Learning Resources

### QACart Courses

- [Selenium WebDriver - Zero to Hero](https://qacart.com)
- [Complete Test Automation Framework](https://qacart.com)
- API Testing with RestAssured

### Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Guide](https://maven.apache.org/guides/)
- [Page Object Model Pattern](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

---

## Roadmap

### Planned Features

- [ ] Integration with Allure Reports
- [ ] Docker containerization
- [ ] API contract testing
- [ ] Performance testing integration
- [ ] Visual regression testing
- [ ] BDD with Cucumber
- [ ] Mobile testing support
- [ ] Database validation

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- **QACart Academy** - For providing excellent training and guidance
- **Selenium Community** - For the robust automation framework
- **TestNG Team** - For the powerful testing framework
- All contributors and learners in the automation community

---

## Contact & Support

- **Repository Issues**: [GitHub Issues](https://github.com/asmaanewigy32/test-automation-playground/issues)
- **QACart Community**: [QACart Forums](https://qacart.com)
- **Email**: Contact through GitHub profile

---

## Project Status

🟢 **Active Development** - This project is actively maintained and updated with new features and improvements.

**Last Updated**: February 2024

---

## Tags

`selenium` `java` `test-automation` `testng` `maven` `page-object-model` `webdriver` `qacart` `ci-cd` `automation-framework` `api-testing` `hybrid-framework`

---

**Happy Testing! 🚀**
