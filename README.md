SauceDemo Automation Project

This automation testing project for the SauceDemo demo e-commerce application is based on the manual testing project available here : https://github.com/AlexandraFelecan/Proiect_testare. It is built using Selenium WebDriver, TestNG, and Java, automating end-to-end testing of critical user flows.

Description

The project automates and verifies essential user interactions, including:

- User login and authentication with valid credentials
- Adding and removing products from the cart
- Navigating between product pages and the cart
- Validating product prices and error messages
- Completing or canceling the checkout process

Project Structure
The project is organized into the following packages:

- config – Contains WebDriver setup, base classes, and configuration readers
- managers – Handles page-specific actions via page manager classes
- tests – TestNG test classes organized by page functionality, including login, cart, checkout, and product pages
- utils – Utility classes for data providers, driver handling, and wait operations

Usage
Clone the repository:
git clone https://github.com/AlexandraFelecan/Proiect_testare.git

Open the project in IntelliJ IDEA or your preferred Java IDE
Ensure Maven dependencies are downloaded by running:
mvn install
Run TestNG tests from the tests package

Expected Results

Tests verify that:

- Users are redirected correctly to product and main pages
- Product prices are displayed accurately
- Cart functionality works as expected (add, remove, continue shopping)
- Checkout forms validate inputs and handle errors correctly
