package TestCase;


import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest {
    @Test(priority = 1)
    @Description("Add to cart laptop")
    public void getLaptopCategory(){
        //Test category laptop and select macbook Air
        WebElement laptopCategory = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Laptops')]")));
        laptopCategory.click();

        WebElement macbookAir = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'MacBook air')]")));
        macbookAir.click();

        //Assert to direct page
        WebElement laptopName = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));
        Assert.assertTrue(laptopName.getText().contains("MacBook air"));

        // add to cart
        WebElement addTocart = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-success btn-lg']")));
        addTocart.click();

        //Alert Message
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added"));
        alert.accept();

        //Go to cart page
        driver.get().findElement(By.xpath("//a[contains(text(),'Cart')]")).click();

        // pastikan laptop yang baru diadd ada dicart
        WebElement cartTable = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'MacBook air')]")));
        Assert.assertTrue(cartTable.getText().contains("MacBook air"));
    }

}
