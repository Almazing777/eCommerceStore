import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdvancedTechniques extends BaseTest{

    @Test
    public void mouseHover(){

        driver.get("https://learn.woahstork.com/");
        Actions builder = new Actions(driver);

        //MOUSE HOVER OVER AND SELECT
        WebElement disordersTab = driver.findElement(By.xpath("//li[@id='menu-item-2616']//a[contains(text(),'Disorders')]"));
        builder
                .moveToElement(disordersTab)
                .build()
                .perform();

        WebElement selectEpilepsy = driver.findElement(By.xpath("//li[@id='menu-item-2798']//a[contains(text(),'Epilepsy')]"));
        builder
                .moveToElement(selectEpilepsy)
                .click()
                .build()
                .perform();
    }

    @Test
    public void scrollDownAndType(){
        driver.get("https://learn.woahstork.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        Actions builder = new Actions(driver);
        WebElement inputBox = driver.findElement(By.cssSelector("[type='email']"));
        builder
                .moveToElement(inputBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("testing@gmail" + "." + "com")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
    }

}
