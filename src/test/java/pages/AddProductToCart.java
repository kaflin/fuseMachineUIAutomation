package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testData.Constants;

public class AddProductToCart {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(AddProductToCart.class.getName());

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]")
    WebElement firstProduct;

    @FindBy(xpath = "//span[@id=\"productTitle\"]")
    WebElement productTitle;

    @FindBy(xpath = "//*[@name=\"dropdown_selected_size_name\"]")
    WebElement selectDropDown;

    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"sw-gtc\"]/span")
    WebElement goToCartButton;

    @FindBy(xpath = "//span/span/span[@class=\"a-truncate-cut\"]")
    WebElement cartProductTitle;

    public AddProductToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstProduct() throws InterruptedException {
        log.info("Clicking on First Product");
        firstProduct.click();
        Thread.sleep(5000L);
    }

    public String getProductTitle() {
        log.info("Product Title text");
        return productTitle.getText();
    }

    public void selectDropDown() throws InterruptedException {
        log.info("Selecting DropDown of Select option");
        Select drpSize = new Select(selectDropDown);
        drpSize.selectByIndex(7);
        Thread.sleep(5000L);
    }

    public void clickToCartButton() throws InterruptedException {
        log.info("Clicking to Cart button");
        cartButton.click();
        Thread.sleep(10000L);
    }

    public void clickGoToCartButton() throws InterruptedException {
        log.info("Clicking to Go To Cart button");
        goToCartButton.click();
        Thread.sleep(5000L);
    }

    public String getCartProductTitle() {
        log.info("Cart Product Title  text");
        return cartProductTitle.getText();
    }
}
