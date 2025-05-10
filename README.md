# isstaAutomation

Automated UI test suite for verifying the flight booking flow on [issta.co.il](https://www.issta.co.il), built with Java, Selenium WebDriver, and TestNG.

## ✅ Features Tested

- Open Flights tab
- Set departure (`ברלין`) and destination (`אמסטרדם`)
- Select travel dates
- Search available flights
- Open flight details
- Proceed to checkout
- Assert checkout URL is reached

## 🚀 Technologies

- Java + Selenium WebDriver
- TestNG
- SafariDriver
- SLF4J Logger

## ▶️ Run Tests

```bash
# Clone and navigate to the repo
git clone https://github.com/elia1993/isstaAutomation.git
cd isstaAutomation

# Run tests (example with TestNG or configured runner)
mvn test

📂 Structure
FlightsHomePage.java – handles search input and navigation

DetailFlight.java – opens flight details and proceeds to checkout

FlightOrderTest.java – main end-to-end test
