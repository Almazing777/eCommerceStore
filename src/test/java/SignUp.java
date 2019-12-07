import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.Random;

public class SignUp extends BaseTest{


    @Test
    public static void signUpSuccess() {
        getPage();
        setEmailField(getRandomEmail());
        setPassword("incorrectPassword");
        setConfirmPassword("incorrectPassword");
        setZipCode("90020");
        clickCheckboxTermsAndConditions();
        clickCheckboxHIPAA();
        clickToSignUp();

        WebElement phoneNumber = driver.findElement(By.cssSelector("[content='Confirm Phone Number']"));
        Assert.assertTrue(phoneNumber.isDisplayed());
    }

    @Test
    public static void signUpWrongEmail() {
        getPage();
        setEmailField("gmail.com");
        setPassword("incorrectPassword");
        setConfirmPassword("setConfirmPassword");
        setZipCode("90020");
        clickCheckboxTermsAndConditions();
        clickCheckboxHIPAA();
        clickToSignUp();

        WebElement errorAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[content='Oops!']")));
        Assert.assertTrue(errorAlert.isDisplayed());
    }

    @Test
    public static void signUpEmptyCredentials(){
        getPage();
        setEmailField("");
        setPassword("");
        setConfirmPassword("");
        setZipCode("");

        clickCheckboxTermsAndConditions();
        clickCheckboxHIPAA();

        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        Assert.assertFalse(signUpButton.isEnabled());

    }

    public static void getPage(){
        driver.findElement(By.xpath("//div[@class='styled__Wrapper-sc-5elvgs-0 gTjIWz']/div/div[3]")).click();
    }

    public static String getRandomEmail() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime() + "@gmail.com";
    }

    public static void setEmailField(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[placeholder='Email']"));
        emailField.sendKeys(email);
    }

    public static void setWrongEmailField(String email){
        WebElement emailField = driver.findElement(By.cssSelector("[placeholder='Email']"));
        emailField.sendKeys(email);
    }

    public static void setPassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("[placeholder='Password']"));
        passwordField.sendKeys(password);
    }

    public static void setConfirmPassword(String password){
        WebElement passwordConfirm = driver.findElement(By.cssSelector("[placeholder='Confirm Password']"));
        passwordConfirm.sendKeys(password);
    }

    public static void setZipCode(String zipCode){
        WebElement zip = driver.findElement(By.cssSelector("[placeholder='Zipcode']"));
        zip.sendKeys(zipCode);
    }

    public static void clickCheckboxTermsAndConditions(){
        WebElement checkBoxOne = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cjrWjQ'] [class*='ws-checkbox']")));
        checkBoxOne.click();
    }

    public static void clickCheckboxHIPAA(){
        WebElement checkBoxTwo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='styled__CheckboxWrapper-sc-1x07d2p-2 cIPcIz'] [class*='ws-checkbox']")));
        checkBoxTwo.click();
    }

    public static void clickToSignUp(){
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        button.click();
    }
}
