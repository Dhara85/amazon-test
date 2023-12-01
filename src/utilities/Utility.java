package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {
    /**
     * This method will mouse Hover on Element
     */
    public void mouseHoverToElementAndClick(By by){
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).click().perform();
    }
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){   // Locator return type is By and by is variable
        driver.findElement(by).click();
    }
}
