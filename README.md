# NYTimes BDD Test Framework

This is a Cucumber BDD test framework for the New York Times website built using Java and Selenium.

## Features

- Automated testing of the New York Times website
- Data-driven testing capability using an external CSV file
- Cross-browser testing support (Chrome, Firefox, Safari, Edge)
- Command line execution via Maven

## Test Cases

1. **Home Page Load**: Verifies that the homepage loads successfully.
2. **Search Functionality**: Tests the search functionality of the website.
3. **Article Page Navigation**: Checks if an article page displays the title correctly.
4. **Footer Links**: Validates that footer links redirect to the correct pages.

## Project Structure

- `src/test/resources/features/`: Contains Cucumber feature files.
- `src/test/java/stepdefinitions/`: Contains step definition files.
- `src/test/java/runners/`: Contains the test runner class.
- `src/test/resources/testdata/`: Contains test data files.

## Setup Instructions

1. Clone the repository.
2. Navigate to the project directory.
3. Ensure you have Java and Maven installed.
4. Open the terminal and run:
   ```bash
   mvn clean test
