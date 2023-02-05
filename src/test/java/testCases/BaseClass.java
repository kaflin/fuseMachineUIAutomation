package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public static WebDriver driver;
    public static Logger logger;
    Actions action;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String br) throws InterruptedException {
        logger = Logger.getLogger("Amazon");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver =new ChromeDriver(options);
        }
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}
