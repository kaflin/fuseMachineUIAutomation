package pages;

import base.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.Constants;

public class SearchProduct {

    WebDriver driver;
    public static final Logger log = Logger.getLogger(SearchProduct.class.getName());


    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    WebElement searchTextBox;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    WebElement searchButton;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterForSearch() throws InterruptedException {
        log.info("Entering Search Item in Search box");
        searchTextBox.sendKeys(Constants.TEXT);
        Thread.sleep(2000L);
    }

    public void clickOnSearchButton() throws InterruptedException {
        log.info("Clicking on Search button.");
        searchButton.click();
        Thread.sleep(8000L);
    }
}
