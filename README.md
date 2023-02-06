# fuseMachineUIAutomation

This is fuse|machine's Assignment to Automate Amazon App UI for SearchProduct and Product Added to cart

** Tools and dependencies used to create this project as follow:

1.Selenium With Java

2.TestNg dependency for management of test

3.log4j dependency for extracting log from project

4.extentreports dependency for Reprting

**Instalation guide

1.Install Java Development Kit (JDK): Selenium is a Java-based framework, so you need to have JDK installed on your machine. You can download the latest 

version of JDK from the Oracle website.

2.Install IntellijIDE: Eclipse/IntellijIDE is an Integrated Development Environment (IDE) that is commonly used for Java development. You can

download the latest version of IntellijIDE from the official IntellijIDE website. You can directly create Maven project from your IntellijIDE and no need

to install maven externally and in pom.xml you can add your dependency

**Configuration:
1.Configure the WebDriver: You need to configure the WebDriver executable in your Selenium project. This involves specifying the path to the executable in

your code. For example, if you are using ChromeDriver, you need to add the following code to your

System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

WebDriver driver = new ChromeDriver();

Note:You don't need to configure the wedriverin this project beacuse Chrome driver is already used in this project.In case chrome driver doesn't work you

can configure your own webdriver




