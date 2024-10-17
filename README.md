## Project Overview
This project contains automated UI tests for the New York Times website using a BDD (Behavior-Driven Development) approach. 
The tests are designed to ensure that key functionalities of the website work as expected across various scenarios. 
The framework is built on Cucumber, utilizing Selenium for browser automation, and is implemented in Core Java.

## Technologies Used
**Cucumber BDD:** For defining test scenarios in a readable format.
**Selenium:** For automating browser interactions.
**Core Java:** The primary programming language used for implementation.
**Maven:** Build automation tool to manage project dependencies and run tests.

## Setup Instructions
# Prerequisites:

JDK (Java Development Kit) installed (version 8 or higher).
Maven installed (version 3.6.0 or higher).
An IDE (like IntelliJ IDEA or Eclipse) for code development.
Browser drivers (e.g., ChromeDriver for Google Chrome) should be installed and added to your system's PATH.
**Clone the Repository:**
bash
Copy code
git clone https://github.com/vinunagarro/NY-QA.git
cd NY-QA

**Install Dependencies:** Run the following command to install the required dependencies:

bash
Copy code
mvn clean install
**Configure Browser Driver:** Ensure the appropriate browser driver executable is accessible in your PATH.

Running Tests
To execute the UI tests, run the following command from the project root directory:

bash
Copy code
mvn test
Test Reporting
After running the tests, Cucumber will generate a report in the target/cucumber-reports directory. You can view detailed results in the index.html file.

Test Scenarios
The automated tests cover a range of scenarios, including but not limited to:

**Homepage Validation:** Verify that the homepage loads correctly and displays expected elements.
**Article Navigation:** Test the navigation of articles from the homepage to ensure links work.
**Search Functionality:** Validate the search feature by entering keywords and checking results.
**Footer Links:** Check that the Footer Links appears and behaves correctly.
 Each scenario is defined in .feature files located in the src/test/resources/features directory.


## Contributing
We welcome contributions to improve this project. Please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Make your changes and ensure tests are passing.
Submit a pull request with a clear description of your changes.

## Execution of code using cmd
mvn clean test