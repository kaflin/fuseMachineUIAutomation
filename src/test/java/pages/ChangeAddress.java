package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChangeAddress {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(ChangeAddress.class.getName());

    @FindBy(xpath = "//*[@id=\"glow-ingress-block\"]")
    WebElement clickOnLocationElement;

    @FindBy(xpath = "//*[@id=\"GLUXCountryList\"]")
    WebElement selectCountryList;

    @FindBy(xpath = "//*[@name=\"glowDoneButton\"]")
    WebElement selectCountry;

    public ChangeAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeAddress() throws InterruptedException {
        clickOnLocationElement.click();
        Thread.sleep(10000L);
        selectAnotherCountry();
        Thread.sleep(5000L);
    }
    public void selectAnotherCountry() throws InterruptedException {
        log.info("Selecting United kingdom from Select option");
        Select drpCountry = new Select(selectCountryList);
        drpCountry.selectByVisibleText("United Kingdom");
        selectCountry.click();
        Thread.sleep(5000L);
    }

}
