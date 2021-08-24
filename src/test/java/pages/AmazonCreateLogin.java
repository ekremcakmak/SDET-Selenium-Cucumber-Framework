package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverSetup;

public class AmazonCreateLogin {

    public AmazonCreateLogin()

    {
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id='nav-link-accountList-nav-line-1']")
    public WebElement linkLogin;

    @FindBy (xpath = "/html//a[@id='createAccountSubmit']")
    public WebElement linkCreateAccount;

    @FindBy (id = "ap_customer_name")
    public WebElement inputCostumerName;

    @FindBy (id = "ap_email")
    public WebElement inputCostumerMail;

    @FindBy (xpath = "/html//input[@id='ap_password']")
    public WebElement inputCostumerPass;

    @FindBy (id = "ap_password_check")
    public WebElement inputCostumerCheckPass;

    @FindBy (id = "continue")
    public WebElement linkContinue;

}
