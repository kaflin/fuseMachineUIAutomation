package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testData.Constants;

import java.util.concurrent.TimeUnit;

public class VerifySearchResult {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(VerifySearchResult.class.getName());

    @FindBy(xpath = "//span/div/div/span[contains(text(),'RESULTS')]")
    WebElement textResult;

    public VerifySearchResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void scrollToDown() {
        // scroll down by 350 pixels with Javascript Executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,350)");
    }

    public String searchForResultText() {
        log.info("Searching for Result text");
        return textResult.getText();
    }

    public void searchForTopFiveProducts() {
        String actualText;
        scrollToDown();
        for (int i = 2; i <= 6; i++) { //Top 5 product starting from index 2
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                if (i > 4) {
                    int a = i + 1;
                    WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[" + a + "]"));
                    actualText = element.getText();
                } else {
                    WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[" + i + "]"));
                    actualText = element.getText();
                }
                if (actualText.toUpperCase().contains(Constants.TEXT.toUpperCase())) {
                    Assert.assertTrue(true);
                    log.info("Search Result Matched with Search Text");
                } else {
                    Assert.assertFalse(false);
                    log.info("Search Result doesnot Matched with Search Text");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
