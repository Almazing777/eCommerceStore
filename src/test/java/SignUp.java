import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignUp extends BaseTest{


    @Test
    public static void signUpSuccess() {
        driver.findElement(By.xpath("//div[@class='styled__Wrapper-sc-5elvgs-0 gTjIWz']/div/div[3]")).click();

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("almazing" + randomInt + "@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("testingPassword");
        driver.findElement(By.cssSelector("[placeholder='Confirm Password']")).sendKeys("testingPassword");
        driver.findElement(By.cssSelector("[placeholder='Zipcode']")).sendKeys("testing");

        WebElement checkBoxOne = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cjrWjQ'] [class*='ws-checkbox']")));
        checkBoxOne.click();

        WebElement checkBoxTwo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cIPcIz'] [class*='ws-checkbox']")));
        checkBoxTwo.click();

        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();

        WebElement phoneNumber = driver.findElement(By.cssSelector("[content='Confirm Phone Number']"));
        Assert.assertTrue(phoneNumber.isDisplayed());
    }

    @Test
    public static void signUpWrongEmail() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='styled__Wrapper-sc-5elvgs-0 gTjIWz']/div/div[3]")).click();

        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("testingPassword");
        driver.findElement(By.cssSelector("[placeholder='Confirm Password']")).sendKeys("testingPassword");
        driver.findElement(By.cssSelector("[placeholder='Zipcode']")).sendKeys("90020");

        WebElement checkBoxOne = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cjrWjQ'] [class*='ws-checkbox']")));
        checkBoxOne.click();

        WebElement checkBoxTwo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cIPcIz'] [class*='ws-checkbox']")));
        checkBoxTwo.click();

        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();

        WebElement errorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[content='Oops!']")));
        Assert.assertTrue(errorAlert.isDisplayed());
    }

    @Test
    public static void signUpEmptyCredentials(){
        driver.findElement(By.xpath("//div[@class='styled__Wrapper-sc-5elvgs-0 gTjIWz']/div/div[3]")).click();

        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("");
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("");
        driver.findElement(By.cssSelector("[placeholder='Confirm Password']")).sendKeys("");
        driver.findElement(By.cssSelector("[placeholder='Zipcode']")).sendKeys("");

        WebElement checkBoxOne = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cjrWjQ'] [class*='ws-checkbox']")));
        checkBoxOne.click();

        WebElement checkBoxTwo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cIPcIz'] [class*='ws-checkbox']")));
        checkBoxTwo.click();

        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        Assert.assertFalse(signUpButton.isEnabled());

    }
}
