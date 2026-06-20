🚀 Selenium Java Automation Framework
This is a robust test automation framework built to automate end-to-end testing for web applications. It was developed using Java, Selenium WebDriver, and TestNG, following industry-standard design patterns.

🛠️ Tech Stack & Tools
Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Design Pattern: Page Object Model (POM)
Reporting: Extent Reports
Build Tool: Maven
Data-Driven Testing: Apache POI (Excel integration)
✨ Key Features
Page Object Model (POM): Clean separation between test scripts and page locators for easy maintenance.
Cross-Site Testing: Includes automated flows for multiple websites (Amazon, Wuzzuf, IKEA, Macqueen).
End-to-End Booking Flow: Full automation of Registration -> Login -> Search -> Checkout -> Payment -> Confirmation.
Detailed Reporting: Generates interactive Extent Reports with screenshots attached automatically on test failure.
Data-Driven Testing: Test data is fed externally to run the same test with multiple datasets.
📂 Project Structure
src/main/java/pages: Contains all Page Object classes (Web elements and their methods).
src/test/java/tests: Contains the actual TestNG test cases.
src/test/java/base: Contains base setup and configuration (WebDriver initialization).
src/test/java/utils: Utility classes (Screenshots, Excel readers, Extent Report setup).
▶️ How to Run
Clone the repository: git clone [REPO_URL]
Open the project in IntelliJ IDEA or Eclipse.
Ensure you have the correct WebDriver setup (or use WebDriverManager).
Run the testng.xml file.
Check the test-output folder for the generated Extent Report.
