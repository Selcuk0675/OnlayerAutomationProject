package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RequestDemo {
      public RequestDemo(){
          PageFactory.initElements(Driver.getDriver(),this);
      }
    @FindBy(xpath = "//input[@id='firstname-f7849172-a1a6-495a-94b5-7e1704c96080']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname-f7849172-a1a6-495a-94b5-7e1704c96080']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@id='email-f7849172-a1a6-495a-94b5-7e1704c96080']")
    public WebElement workmail;
    @FindBy(xpath = "//select[@id='country-f7849172-a1a6-495a-94b5-7e1704c96080']")
    public WebElement countryRegion;
    @FindBy(xpath = "//textarea[@id='message-f7849172-a1a6-495a-94b5-7e1704c96080']")
    public WebElement message;
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submit;
}
