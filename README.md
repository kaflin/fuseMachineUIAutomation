# fuse|machines Amazon UI Automation

This is fuse|machine's Assignment to Automate Amazon App UI for SearchProduct and Product Added to cart

**Tools and dependencies used to create this project as follow**:

1. Selenium With Java

2. TestNg dependency for management of test

3. log4j dependency for extracting log from project

4. extentreports dependency for Reprting

**Instalation guide**

1. Install Java Development Kit (JDK): Selenium is a Java-based framework, so you need to have JDK installed on your machine. You can download the latest 

version of JDK from the Oracle website.

2. Install IntellijIDE: Eclipse/IntellijIDE is an Integrated Development Environment (IDE) that is commonly used for Java development. You can

download the latest version of IntellijIDE from the official IntellijIDE website. You can directly create Maven project from your IntellijIDE and no need

to install maven externally and in pom.xml you can add your dependency

**Configuration**:
1. Configure the WebDriver: You need to configure the WebDriver executable in your Selenium project. This involves specifying the path to the executable in

your code. For example, if you are using ChromeDriver, you need to add the following code to your

System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

WebDriver driver = new ChromeDriver();

Note:You don't need to configure the wedriverin this project beacuse Chrome driver is already used in this project.In case chrome driver doesn't work

you can configure your own webdriver


**Usage**
1. Open IntellijIDE : Open the Intellij  IDE where you have set up your Selenium project.

2. Clone the project: Clone the present project in your system by git clone <**link of project**>

3. Import the Project: If you already have a project, you can import it into IDE. Go to File >  Open > Existing Projects into Workspace. Select the project directory and click Finish.

4. Run the Tests: To run the tests, Click on Run which is in upper section of tab > TestNg.xml Or Right click on TestNg.xml file and run TestNg.xml file. This will launch the browser and run the tests.

5. Debug the Tests: If you encounter errors or failures during the tests, you can debug the tests by setting breakpoints in your code. Right-click on the Java file containing the tests and select Debug.

6. View the Test Results: The test results will be displayed in the Testng view in Intellij. You can view the test results, including the status of each test case, and any error messages.

**Test Cases**
In this project two test case has been automated
  
1. Search Product and to verify if amazon showing correct search for result of Top 5 item
   
2. Add product to cart and to verify if added product in cart is same of what we selected after searching







