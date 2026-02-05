# QACart Todo Application Project Using Selenium

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red.svg)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)

A hands-on test automation project for the QACart Todo Application, showcasing real-world testing scenarios, frameworks, and best practices developed during the QACart learning journey.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [CI/CD Integration](#cicd-integration)
- [Best Practices](#best-practices)
- [Contributing](#contributing)

---

## Overview

This repository demonstrates professional test automation practices for the QACart Todo Application. Built with Selenium WebDriver, TestNG, and Maven, the framework follows industry-standard design patterns and testing methodologies to ensure maintainable, scalable, and reliable test automation.

The project tests the QACart Todo Application at [https://todo.qacart.com](https://todo.qacart.com), covering user authentication, todo item management, and end-to-end workflows.

---

## Features

- ✅ **Selenium WebDriver 4** - Latest web automation framework
- ✅ **TestNG Framework** - Powerful testing framework with annotations and assertions
- ✅ **Maven Build Tool** - Dependency management and build automation
- ✅ **Page Object Model** - Maintainable and reusable page classes
- ✅ **Test Data Management** - Structured test data handling
- ✅ **Cross-Browser Support** - Chrome, Firefox, Edge compatibility
- ✅ **Parallel Execution** - Run tests concurrently for faster feedback
- ✅ **Detailed Reports** - Comprehensive TestNG HTML reports
- ✅ **GitHub Actions CI** - Automated testing on code changes
- ✅ **WebDriverManager** - Automatic browser driver management

---

## Technology Stack

| Technology | Purpose |
|-----------|---------|
| **Java 11+** | Programming Language |
| **Selenium WebDriver 4.x** | Browser Automation |
| **TestNG 7.x** | Testing Framework |
| **Maven 3.x** | Build Management |
| **WebDriverManager** | Driver Management |
| **GitHub Actions** | CI/CD Pipeline |

---

## Project Structure

```
QAcartTodoApplicationProjectUsingSelenium/
│
├── .github/
│   └── workflows/           # GitHub Actions CI/CD workflows
│
├── .idea/                   # IntelliJ IDEA project settings
│
├── SeleniumFrameworkDesign-Project/
│   └── src/
│       └── test/
│           └── java/
│               └── com/qacart/todo/
│                   ├── base/        # Base test classes
│                   ├── pages/       # Page Object Model classes
│                   ├── tests/       # Test classes
│                   ├── utils/       # Utility classes
│                   └── config/      # Configuration classes
│
├── pom.xml                  # Maven dependencies and plugins
├── testng.xml              # TestNG suite configuration
└── README.md               # Project documentation
```

---

## Prerequisites

### Software Requirements

- **Java JDK 11** or higher
- **Maven 3.6+** or higher
- **IDE** (IntelliJ IDEA recommended / Eclipse / VS Code)
- **Git** for version control

### Browser Requirements

- Google Chrome (latest version)
- Or Mozilla Firefox (latest version)
- Or Microsoft Edge (latest version)

### Verify Installation

Check Java version:
```bash
java -version
```

Check Maven version:
```bash
mvn -version
```

---

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/asmaanewigy32/QAcartTodoApplicationProjectUsingSelenium.git
cd QAcartTodoApplicationProjectUsingSelenium
```

### 2. Install Dependencies

```bash
mvn clean install
```

This command will:
- Download all Maven dependencies
- Compile the project
- Run initial setup

### 3. Import into IDE

#### IntelliJ IDEA:
1. Open IntelliJ IDEA
2. File → Open → Select the project folder
3. Wait for Maven to import dependencies

#### Eclipse:
1. File → Import → Maven → Existing Maven Projects
2. Select the project folder
3. Finish

---

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Class

```bash
mvn clean test -Dtest=LoginTest
```

### Run Specific Test Method

```bash
mvn clean test -Dtest=LoginTest#testValidLogin
```

### Run with TestNG XML Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run Tests in Parallel

Configure in `testng.xml`:
```xml
<suite name="Todo Test Suite" parallel="methods" thread-count="3"> </suite>
```

Then run:
```bash
mvn clean test
```

### Run Tests with Specific Browser

If configured, you can specify browser:
```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

### Run Tests in Headless Mode

If configured:
```bash
mvn clean test -Dheadless=true
```

---

## Test Reports

### TestNG HTML Reports

After test execution, reports are automatically generated in:

```
test-output/
├── index.html              # Main test report
├── emailable-report.html   # Email-friendly summary
└── testng-results.xml      # XML results for CI/CD
```

To view the report:
1. Navigate to `test-output/` folder
2. Open `index.html` in a web browser
3. Review test results, passed/failed tests, and execution details

### Screenshots

If configured, failed test screenshots are saved in:
```
screenshots/
└── [TestName]_[Timestamp].png
```

---

## CI/CD Integration

### GitHub Actions

The project includes a GitHub Actions workflow for continuous integration.

**Location**: `.github/workflows/maven.yml`

**Triggers**:
- Push to `main` branch
- Pull requests to `main` branch

**Workflow Steps**:
1. Checkout code
2. Set up Java 11
3. Cache Maven dependencies
4. Run tests with Maven
5. Upload test reports as artifacts

To view CI results:
1. Go to the GitHub repository
2. Click on "Actions" tab
3. View workflow runs and test results

---

## Test Scenarios

### Authentication Tests
- User registration
- User login with valid credentials
- User login with invalid credentials
- User logout

### Todo Management Tests
- Create new todo item
- View todo list
- Mark todo as completed
- Delete todo item
- Edit todo details

### End-to-End Tests
- Complete user flow (Register → Login → Create Todo → Logout)
- Multiple todo operations
- Session persistence

---

## Best Practices Implemented

### Code Organization
- ✅ Separation of concerns with Page Object Model
- ✅ Reusable base classes for common functionality
- ✅ Utility classes for shared operations
- ✅ Clear package structure

### Test Design
- ✅ Independent and isolated tests
- ✅ Descriptive test method names
- ✅ Proper assertions with meaningful messages
- ✅ Setup and teardown methods
- ✅ Data-driven testing approach

### Locator Strategy
- ✅ Prefer stable locators (ID, name, CSS)
- ✅ Avoid brittle XPath expressions
- ✅ Centralized element definitions in page classes
- ✅ Use of explicit waits for dynamic elements

### Reporting
- ✅ Comprehensive TestNG reports
- ✅ Test execution statistics
- ✅ Failed test documentation
- ✅ CI/CD integration

---

## Configuration

### Maven Configuration (pom.xml)

Key dependencies include:
- Selenium WebDriver
- TestNG
- WebDriverManager
- Maven Surefire Plugin

### TestNG Configuration (testng.xml)

Configure test suites, parallel execution, and test groups.

Example configuration:
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="QACart Todo Test Suite" parallel="methods" thread-count="3">
    <test name="Todo Application Tests">
        <classes>
            <class name="com.qacart.todo.tests.LoginTest"/>
            <class name="com.qacart.todo.tests.TodoTest"/>
            <class name="com.qacart.todo.tests.RegisterTest"/>
        </classes>
    </test>
</suite>
```

---

## Troubleshooting

### Common Issues

**Issue**: Tests failing with "WebDriver not found"
- **Solution**: Run `mvn clean install` to download WebDriverManager dependencies

**Issue**: Browser not launching
- **Solution**: Ensure the latest browser version is installed
- **Solution**: Check WebDriverManager configuration

**Issue**: Element not found exceptions
- **Solution**: Add explicit waits for dynamic elements
- **Solution**: Verify locator strategies are correct

**Issue**: Tests passing locally but failing in CI
- **Solution**: Use headless mode for CI environment
- **Solution**: Check browser versions in CI configuration

---

## Contributing

We welcome contributions! Please follow these steps:

### How to Contribute

1. Fork the repository
2. Create a feature branch
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make your changes and commit
   ```bash
   git commit -m "Add your feature description"
   ```
4. Push to your branch
   ```bash
   git push origin feature/your-feature-name
   ```
5. Create a Pull Request

### Contribution Guidelines

- Follow existing code structure and naming conventions
- Write clear commit messages
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

---

## Learning Resources

### QACart Resources
- [QACart Website](https://qacart.com)
- [QACart Todo Application](https://todo.qacart.com)
- QACart Selenium Courses

### Additional Resources
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Java Documentation](https://docs.oracle.com/en/java/)

---

## Acknowledgments

- **QACart Academy** - For providing excellent training materials and the Todo application
- **Selenium Community** - For the robust automation framework
- **TestNG Team** - For the powerful testing framework
- All contributors and learners in the test automation community

---

## Contact & Support

- **Repository**: [GitHub Repository](https://github.com/asmaanewigy32/QAcartTodoApplicationProjectUsingSelenium)
- **Issues**: [Report Issues](https://github.com/asmaanewigy32/QAcartTodoApplicationProjectUsingSelenium/issues)
- **QACart**: [https://qacart.com](https://qacart.com)

---

## Project Status

🟢 **Active** - This project is actively maintained and updated with improvements.

---

## Tags

`selenium` `java` `test-automation` `testng` `maven` `page-object-model` `qacart` `todo-app` `web-automation` `ci-cd` `github-actions`

---

**Happy Testing! 🚀**
