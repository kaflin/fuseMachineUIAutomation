package testCases;
import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.Constants;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class TC_SearchAndVerify_001 extends BaseClass {

    @Test(priority = 1)
    public void searchProduct() throws IOException, InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
        element.sendKeys(Constants.TEXT);
       WebElement searchClick= driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        action.moveToElement(searchClick).perform();
        searchClick.click();
        captureScreen(driver, "SearchProductTestPassed");
        verifySearchResult();
        Thread.sleep(10000);
    }

    private void verifySearchResult() {
        String actualText;
        WebDriverWait wait3= new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement text_result = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/div/div/span[contains(text(),'RESULTS')]")));
        String result = text_result.getText();
        if (result.equals("RESULTS")) {
            // scroll down by 350 pixels with Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,350)");
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
                        logger.info("Search Result Matched with Search Text");
                    } else {
                        Assert.assertFalse(false);
                        logger.info("Search Result doesnot Matched with Search Text");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]"));
        element.click();
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofMillis(5000));
        WebElement elementText=wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"productTitle\"]")));
        String productText = elementText.getText();
        logger.info(productText);
        Select drpSize = new Select(driver.findElement(By.xpath("//*[@name=\"dropdown_selected_size_name\"]")));
        drpSize.selectByIndex(7);
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]"))).click();
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sw-gtc\"]/span"))).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement elemenText =driver.findElement(By.xpath("//span/span/span[@class=\"a-truncate-cut\"]"));
        String shoeText = elemenText.getText();
        logger.info(shoeText);
        try {
            if (shoeText.toUpperCase().contains(productText.toUpperCase())) {
                Assert.assertTrue(true);
                logger.info("Product is same as we selected after searching");
            } else {
                Assert.assertFalse(false);
                logger.info("Product is not same as we selected after searching");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

