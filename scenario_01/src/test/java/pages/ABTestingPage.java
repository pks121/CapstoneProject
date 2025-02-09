package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ABTestingPage {
    WebDriver driver;

    By pageText = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOnPage() {
        return driver.findElement(pageText).getText();
    }
}
