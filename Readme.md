Focus was on designing the framework, which has following features-
•	Separating the business test logic from the technical functions and structuring in adequate packages
•	Singleton driver to make sure all the instances refer to the same driver
•	Configuring the URL, username, password and browser from properties file that is customizable
•	Listeners to configure what should be done onStart, onFinish and for each test (must be added to testNg.xml)
•	Extent reporting to see the results of our execution
•	TestNg to configure which specific test cases we need to run 
•	Ability to take the project online and to collaborate with team using version control system – Git
•	We don't need to add any BrowserDriver (chromeDriver, FirefoxDriver or other to our project as same will be taken care of automatically by WebDriverManager dependency
•	driver variable is already initialized for you to run the selenium commands access this and this will give you the driver instance
•	To get the extent report test already started for you in listeners, use -> extent = ExtentTestManager.getTest();


