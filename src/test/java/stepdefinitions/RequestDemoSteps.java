package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.RequestDemo;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class RequestDemoSteps {
    HomePage HomePage=new HomePage();
    RequestDemo RequestDemoPage=new RequestDemo();

    @Given("user navigates to the specified URL")
    public void user_navigates_to_the_specified_url() {
        Driver.getDriver().get(ConfigReader.getProperty("onlayerUrl"));
    }
    @Given("user clicks on the Request a Demo button on the HomePage")
    public void user_clicks_on_the_request_a_demo_button_on_the_home_page() {
       Driver.clickWithJS(HomePage.requestDemo);
    }
    @Given("user moves to input field on the RequestDemo page")
    public void user_moves_to_input_field_on_the_request_demo_page() {
        Driver.wait(5);
       Driver.clickWithJS(RequestDemoPage.firstName);

    }
    @Given("user enters the First Name in the First Name textbox on the RequestDemo page")
    public void user_enters_the_first_name_in_the_first_name_textbox_on_the_request_demo_page() {
        Driver.waitAndClick(RequestDemoPage.firstName,1);
        RequestDemoPage.firstName.sendKeys(ConfigReader.getProperty("firstName"));
    }
    @Given("user enters the Last Name in the Last Name textbox on the RequestDemo page")
    public void user_enters_the_last_name_in_the_last_name_textbox_on_the_request_demo_page() {
      Driver.waitAndClick(RequestDemoPage.lastName,1);
      RequestDemoPage.lastName.sendKeys(ConfigReader.getProperty("lastName"));
    }
    @Given("user enters the Work Email in the Work Email textbox on the RequestDemo page")
    public void user_enters_the_work_email_in_the_work_email_textbox_on_the_request_demo_page() {
        RequestDemoPage.workmail.sendKeys(ConfigReader.getProperty("workMail"));
        Driver.wait(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("window.scrollBy(0, 100);");
    }

    @Given("user clicks theCountry-Region in the Country-Region textbox on the RequestDemo page")
    public void user_clicks_the_country_region_in_the_country_region_textbox_on_the_request_demo_page() {
        Driver.selectAnItemFromDropdown(RequestDemoPage.countryRegion,"Türkiye");

    }

    @Given("user clicks massage in the message textbox on the RequestDemo page")
    public void user_clicks_massage_in_the_massage_textbox_on_the_request_demo_page() {
        RequestDemoPage.message.click();

    }
    @Given("user send massage in the message textbox on the RequestDemo page")
    public void user_send_massage_in_the_massage_textbox_on_the_request_demo_page() {
        RequestDemoPage.message.sendKeys(ConfigReader.getProperty("message"));
    }
    @Given("user scroll down the Submit button on the RequestDemo page")
    public void user_scroll_down_the_submit_button_on_the_request_demo_page() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
        js.executeScript("window.scrollBy(0, 200);");
        class CookieConsentHandler {
            WebDriver driver; // WebDriver değişkeni tanımlanmalı

            @When("I handle the cookie consent if present")
            public void i_handle_the_cookie_consent_if_present() {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Yeni WebDriverWait kullanımı
                    WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-accept-button")));
                    acceptCookies.click();
                    System.out.println("Cookie banner accepted.");
                } catch (Exception e) {
                    System.out.println("No cookie banner found.");
                }
            }
        }

    }
    @Given("user clicks the Text Submit button on the RequestDemo page")
    public void user_clicks_the_text_submit_button_on_the_request_demo_page() {
        Driver.clickWithJS(RequestDemoPage.submit);
        Driver.wait(5);
    }
    @Given("user scroll up the Submit button on the RequestDemo page")
    public void user_scroll_up_the_submit_button_on_the_request_demo_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("user verify Thanks for submitting the form. One of our team members will contact you shortly.massage on the RequestDemo page")
    public void user_verify_thanks_for_submitting_the_form_one_of_our_team_members_will_contact_you_shortly_massage_on_the_request_demo_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
