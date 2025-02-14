package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DemoformPage;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DemoformSteps {
    private WebDriver driver;
    private DemoformPage demoformPage;
    private Properties properties = new Properties();

    public DemoformSteps() {
        try {
            InputStream file = getClass().getClassLoader().getResourceAsStream("configuration.properties");
            if (file != null) {
                properties.load(file);
            } else {
                throw new IOException("configuration.properties file not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("I navigate to the homepage")
    public void iNavigateToTheHomepage() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-compatibility-check");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        if (demoformPage == null) {
            demoformPage = new DemoformPage(driver);
        }

        String url = properties.getProperty("D_url", "https://default-url.com");
        demoformPage.navigateToHomePage(url);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String button) {
        if (button.equalsIgnoreCase("Demo")) {
            demoformPage.clickDemoButton();
        } else if (button.equalsIgnoreCase("Submit")) {
            demoformPage.clickSubmitButton();
        } else {
            throw new IllegalArgumentException("Invalid button name: " + button);
        }
    }

    @And("I wait for the page to load")
    public void iWaitForThePageToLoad() {
        demoformPage.wait.until(ExpectedConditions.visibilityOfElementLocated(demoformPage.demoButton));
    }

    @And("I accept the popup by clicking the {string} button")
    public void iAcceptThePopupByClickingTheButton(String button) {
        if (button.equals("Accept All")) {
            demoformPage.acceptPopup();

            // Sayfayı -250 piksel kaydır
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 600)");

            // 3 saniye bekleme (WebDriverWait kullanarak)
            demoformPage.wait.withTimeout(Duration.ofSeconds(3));
        }
    }

    @And("I fill in the form fields with data from the properties file:")
    public void iFillInTheFormFieldsWithDataFromThePropertiesFile(DataTable dataTable) {
        List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);

        if (!formData.isEmpty()) {
            Map<String, String> data = formData.get(0);
            String name = data.getOrDefault("D_Name", "Default Name");
            String lastName = data.getOrDefault("D_Last Name", "Default Lastname");
            String workEmail = data.getOrDefault("D_Work Email", "test@example.com");
            String message = data.getOrDefault("D_Message", "Default Message");

            demoformPage.fillForm(name, lastName, workEmail, message);
        }
    }

    @And("I select {string} from the country dropdown")
    public void iSelectFromTheCountryDropdown(String country) {
        demoformPage.selectCountry(country);

        // Sayfayı -250 piksel kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");

        // 3 saniye bekleme (WebDriverWait kullanarak)
        demoformPage.wait.withTimeout(Duration.ofSeconds(3));

    }

    @And("I wait for the submission to process")
    public void iWaitForTheSubmissionToProcess() {

        // Sayfayı -250 piksel kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -600)");

        //demoformPage.wait.until(ExpectedConditions.visibilityOfElementLocated(demoformPage.successMessage));
        demoformPage.wait.withTimeout(Duration.ofSeconds(10));

    }

    @Then("I should see the message {string} at the top of the page")
    public void iShouldSeeTheMessageAtTheTopOfThePage(String expectedMessage) {
        Assert.assertTrue(demoformPage.isSuccessMessageDisplayed());
        driver.quit();
        driver = null; // Driver'ı sıfırla
    }
}
