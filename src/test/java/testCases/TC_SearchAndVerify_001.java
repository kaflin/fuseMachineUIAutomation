package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TC_SearchAndVerify_001 extends BaseClass {

    @Test(priority = 1)
    public void searchProduct() throws IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        element.sendKeys(Constants.TEXT);
        WebElement searchClick = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        action.moveToElement(searchClick).perform();
        searchClick.click();
        captureScreen(driver, "SearchProductTestPassed");
        verifySearchResult();
    }

    private void verifySearchResult() {
        String actualText;
        WebElement text_result = driver.findElement(By.xpath("//span/div/div/span[contains( text(),'RESULTS')]"));
        String result = text_result.getText();
        if (result.equals("RESULTS")) {
            // scroll down by 300 pixels with Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,300)");
            for (int i = 2; i <= 6; i++) {
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
                        logger.info("Search Result Matched with Search Text");
                    } else {
                        logger.info("Search Result doesnot Matched with Search Text");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(priority = 2)
    public void addProductToCart() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]"));
        element.click();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement elementText= driver.findElement(By.xpath("//*[@id=\"productTitle\"]"));
        String actualText = elementText.getText();
        logger.info(actualText);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Select drpSize = new Select(driver.findElement(By.xpath("//*[@name=\"dropdown_selected_size_name\"]")));
        drpSize.selectByVisibleText("7");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"addToCart_feature_div\"]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span")).click();
        WebElement elemenText =driver.findElement(By.xpath("//span/span/span[@class=\"a-truncate-cut\"]"));
        String shoeText = elemenText.getText();
        System.out.println(shoeText);
        if(actualText.equalsIgnoreCase(shoeText)){
            logger.info("Product is same as we selected after searching");
        }else{
            logger.info("Product is not same as we selected after searching");
        }


    }
}

