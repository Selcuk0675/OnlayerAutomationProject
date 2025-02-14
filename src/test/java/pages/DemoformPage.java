package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoformPage {
    public WebDriver driver;
    public WebDriverWait wait;

    // Locators
    public By demoButton = By.xpath("(//*[@class='elementor-button-text'])[6]");
    public By acceptAllButton = By.xpath("//button[contains(@class, 'cky-btn-accept')]");
    public By nameField = By.xpath("//*[@id=\"firstname-f7849172-a1a6-495a-94b5-7e1704c96080\"]");
    public By lastNameField = By.xpath("//*[@id=\"lastname-f7849172-a1a6-495a-94b5-7e1704c96080\"]");
    public By workEmailField = By.xpath("//*[@id=\"email-f7849172-a1a6-495a-94b5-7e1704c96080\"]");
    public By messageField = By.xpath("//*[@id=\"message-f7849172-a1a6-495a-94b5-7e1704c96080\"]");
    public By countryDropdown = By.xpath("//*[@id=\"country-f7849172-a1a6-495a-94b5-7e1704c96080\"]");
    public By submitButton = By.xpath("//*[@id=\"hsForm_f7849172-a1a6-495a-94b5-7e1704c96080\"]/div[2]/div[2]/input");
    public By successMessage = By.xpath("//*[@id=\"hbspt-form-d0e1cb0a-a8eb-4db5-b3ea-8f5e17c9702b\"]/div/text()");//*[@id="hbspt-form-d0e1cb0a-a8eb-4db5-b3ea-8f5e17c9702b"]/div/text()

    public DemoformPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public void clickDemoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(demoButton)).click();
    }

    public void acceptPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllButton)).click();
    }

    public void fillForm(String name, String lastName, String email, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(workEmailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public void selectCountry(String country) {
        Select dropdown = new Select(driver.findElement(countryDropdown));
        dropdown.selectByVisibleText(country);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
