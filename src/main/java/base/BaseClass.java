package base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseClass.class.getName());
    public Actions action;
    public String baseDirectory = System.getProperty("user.dir");

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("chrome") String br) throws InterruptedException {
        logger.info("Opening amazon.com");
        String log4jConfPath = baseDirectory + "\\src\\main\\resources\\config\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        if (br.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", baseDirectory + readConfig.getChromePath());
            driver = new ChromeDriver(options);
        }
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
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
