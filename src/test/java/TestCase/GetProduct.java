package TestCase;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest{

    @Test(priority = 1)
    @Description("Assert price")
    public void getPrice(){
        //Test dan Assert harga smartphone Samsung S6
        WebElement phoneCat = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Phones']")));
        phoneCat.click();

        WebElement samsung = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Samsung galaxy s6']")));
        samsung.click();

        //Assert or validate price
        WebElement price = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue(price.getText().contains("$360"));
    }
    @Test(priority = 2)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.get().findElement(By.id("sign-username")).sendKeys("Tabi");
        driver.get().findElement(By.id("sign-password")).sendKeys("Tabi1234");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }

}
