# AutoTraderSeleniumTest
The main purpose of test automation project is to enhance my test automation skill using Selenium Java Framework with Page Object Design Model.  Practice make perfect!  Initial test scenario is to basic search for vehicles in the area based on auto maker, auto model, max price range, and location using postal code.  Example: Make:BMW, Model:3 Series, Max Price: 15000, Location: V5K 0A1 (Postal Code)
Based on Data Driven Test Design Model, this program search for 4 different make, model, max price range, and location of vehicles .  4 different search input data is stored as csv file (AutoSearchData.csv).  Using TestNG Data Provider, application system read 4 different search input from the csv file and feed into the system.  Make sure a user is able to get the correct search results.

## Getting Started
### Prerequisites
#### Things Need To Install
Java 8 - JDK <br/>
Maven <br/>
Eclipse: TestNG Plug-In<br/> . 

### How to Run
Go to the selenium-search directory where pom.xml file is located.<br/>
type **mvn clean test**

### Author: Chong S. Lee & Reviewer(s): Alex S.

### Code Structure:
#### main folder: Framework and Pages info . 
#### test folder: Business Logics and test scenarios including assertion.

