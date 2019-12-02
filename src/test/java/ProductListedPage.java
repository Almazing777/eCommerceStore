import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class ProductListedPage extends BaseTest{

    @Test
    public static void verifyCountOfElements() throws InterruptedException {

        driver.get("https://test.woahstork.com/shop?address=90020&showAll=true");

        List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class='styled__Wrapper-t3aect-0 kkSQLL']//div[@class='styled__CardOverlay-t3aect-10 dvZYdC']"));
        Assert.assertTrue(productTitles.size() > 0);

        for (int i = 0; productTitles.size() > i; i++) {
            productTitles = driver.findElements(By.cssSelector("[class='styled__Right-t3aect-5 foKhqZ'] h1"));

            String titleFromPLP = productTitles.get(0).getText();
            System.out.println(titleFromPLP);

            WebElement icon = driver.findElement(By.xpath("//div[@class='styled__Wrapper-t3aect-0 kkSQLL']//a[@class='styled__ProductLink-t3aect-3 diqkGg']"));
            icon.click();

            String titleFromPDP = driver.findElement(By.cssSelector("[class='styled__ProductSummary-sc-1ha1r03-16 hhFlzj'] div h1")).getText();
            System.out.println(titleFromPDP);

            Assert.assertTrue(titleFromPDP == titleFromPLP);

        }
    }
}
