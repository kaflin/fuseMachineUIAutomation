package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TC_SearchAndVerify_001 extends BaseClass {
    String text = "Sneaker";

    @Test(priority = 1)
    public void searchProduct() throws IOException {
        logger.info("amazon.com is opened");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        element.sendKeys(text);
        WebElement searchClick = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        action.moveToElement(searchClick).perform();
        searchClick.click();
        captureScreen(driver, "SearchProductTestPassed");
        verifySearchResult();
    }

    private void verifySearchResult() {
        String actualText;
        for (int i = 2; i <= 7; i++) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                if (i > 4) {
                    i = i + 1;
                    WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[" + i + "]"));
                    actualText = element.getText();
                } else {
                    WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[" + i + "]"));
                    actualText = element.getText();
                }
                if (actualText.contains(text)) {
                    System.out.println("Search Result Matched with Search Text");
                    logger.info("Search Result Matched with Search Text");
                } else {
                    System.out.println("Search Result doesnot  Matched with Search Text");
                    logger.info("Search Result doesnot Matched with Search Text");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

