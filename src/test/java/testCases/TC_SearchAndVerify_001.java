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
import pages.AddProductToCart;
import pages.ChangeAddress;
import pages.SearchProduct;
import pages.VerifySearchResult;
import testData.Constants;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_SearchAndVerify_001 extends BaseClass {

    SearchProduct search_product;
    VerifySearchResult verify_search_result;
    AddProductToCart add_Product_To_Cart;
    ChangeAddress change_address;

    @Test(priority = 1)
    public void searchProduct() throws IOException, InterruptedException {
        search_product = new SearchProduct(driver);
        change_address=new ChangeAddress(driver);
        change_address.changeAddress();
        search_product.enterForSearch();
        search_product.clickOnSearchButton();
        captureScreen(driver, "SearchProductTestPassed");
        verifySearchResult();
        Thread.sleep(10000);
    }

    private void verifySearchResult() {
        verify_search_result = new VerifySearchResult(driver);
        String result = verify_search_result.searchForResultText();
        if (result.equals("RESULTS")) {
            verify_search_result.searchForTopFiveProducts();
        }
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        add_Product_To_Cart = new AddProductToCart(driver);

        add_Product_To_Cart.clickFirstProduct();
        String productText = add_Product_To_Cart.getProductTitle();
        logger.info(productText);

        add_Product_To_Cart.selectDropDown();

        add_Product_To_Cart.clickToCartButton();

        add_Product_To_Cart.clickGoToCartButton();

        String cartProductTitle = add_Product_To_Cart.getCartProductTitle();
        logger.info(cartProductTitle);
        try {
            if (cartProductTitle.toUpperCase().contains(productText.toUpperCase())) {
                Assert.assertTrue(true);
                logger.info("Product is same as we selected after searching");
            } else {
                Assert.assertFalse(false);
                logger.info("Product is not same as we selected after searching");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

