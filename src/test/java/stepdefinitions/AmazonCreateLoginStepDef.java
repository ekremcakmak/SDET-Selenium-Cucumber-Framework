package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AmazonCreateLogin;
import utilities.DriverSetup;
import utilities.ReadConfig;
import utilities.Tools;

public class AmazonCreateLoginStepDef {

    AmazonCreateLogin amazonPage = new AmazonCreateLogin();

    @Given("User should go to login page")
    public void user_should_go_to_login_page() {
        DriverSetup.getDriver().get("https://www.amazon.com");

        Tools.waitForPageToLoad(5000);
        amazonPage.linkLogin.click();

        Tools.waitForPageToLoad(5000);
        amazonPage.linkCreateAccount.click();

     System.out.println("Login Page Loaded");
        System.out.println("Link: " );
    }

    @Given("User should enter user name")
    public void user_should_enter_user_name() {
        String Username = ReadConfig.getConfig("username");
        amazonPage.inputCostumerName.sendKeys(Username);
        String RandomMail = Username + "@" + Username +".com";
        amazonPage.inputCostumerMail.sendKeys(RandomMail);
        System.out.println("User entered user name and mail");

    }

    @Given("User should enter password")
    public void user_should_enter_password() {


        String Username = ReadConfig.getConfig("password");
        amazonPage.inputCostumerPass.sendKeys(Username);
        System.out.println("User entered password");

        amazonPage.inputCostumerCheckPass.sendKeys(Username);
        System.out.println("User re-entered password");

    }

    @Then("User should click login")
    public void user_should_click_login() {
        amazonPage.linkContinue.click();
        System.out.println("User clicked login");
    }

    @Then("User should see success message")
    public void user_should_see_success_message() {

        if (Tools.isTextPresent("puzzle") || Tools.isTextPresent("check your mail")) // Check puzzle or success message!
        {
            System.out.println("User Account Created!");
        }
    }


}
