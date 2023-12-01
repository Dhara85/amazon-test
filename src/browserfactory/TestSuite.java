package browserfactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void automateAmazon() {
        //2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");
        //  Click on the Search icon
        mouseHoverToElementAndClick(By.id("nav-search-submit-button"));
        // 3. Click on the checkbox brand Dell on the left side.
        mouseHoverToElementAndClick(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]"));
        // 4.Verify that the  30(May be different) products are displayed on the page.
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
        int count = allOptions.size();
        System.out.println("Number of allOptions displayed " + count);
        //5.5. Print all product names in the console.
        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement names : productNames) {
            System.out.println("Names of product : " + names.getText());
        }
            //6. Click on the product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
            driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[12]")).click();
            //7. Verify the Product name 'Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NV...
            //Dell XPS 15 9530 15.6" OLED 3.5K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver

            String expectedText = "Dell XPS 15 9530 15.6\" OLED 3.5 K 400-Nit Touchscreen Laptop, 13th Gen Intel EVO i7-13700H Processor, 16GB RAM, 1TB SSD, NVIDIA RTX 4060, Windows 11, Silver";
            WebElement actualTextElement = driver.findElement(By.xpath("//span[@id='productTitle']"));
            String actualText = actualTextElement.getText();
            Assert.assertEquals("The user can see the name of the product displayed ", expectedText, actualText);
        }
        @After
        public void tearDown() {
            closeBrowser();
        }
    }



