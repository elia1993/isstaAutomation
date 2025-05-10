isstaAutomation

isstaAutomation is a test automation framework developed using Java, incorporating tools like Selenium WebDriver for browser automation.
This project aims to streamline the testing process by automating repetitive tasks, ensuring consistency, and improving efficiency.

Features

Automated browser testing using Selenium WebDriver
Integration with ChromeDriver for executing tests on the Chrome browser
Build management using Gradle and Maven
Modular test structure for scalability and maintainability

Prerequisites

Before setting up the project, ensure you have the following installed:
Java Development Kit (JDK) 8 or higher
Gradle
Maven
Chrome browser
ChromeDriver compatible with your Chrome browser version

Installation
Clone the repository:
  git clone https://github.com/elia1993/isstaAutomation.git
  cd isstaAutomation

Set up ChromeDriver:
  Ensure that the chromedriver_mac64.zip is extracted, and the chromedriver executable is placed in a directory that's included in your system's PATH.  

Build the project:
  Using Gradle:
    gradle build

Using Maven:
  mvn clean install
  
Usage
To execute the automated tests:
  Using Gradle:   gradle test
  Using Maven:    mvn test
