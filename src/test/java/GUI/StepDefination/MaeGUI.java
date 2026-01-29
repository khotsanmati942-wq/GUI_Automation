package GUI.StepDefination;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.TestBase;
import WebPages.Login_Page;
import WebPages.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class MaeGUI extends StepManager {

    public MaeGUI(PageManager pom) {
        super(pom);
    }

    @Given("I navigate to the URL")
    public void i_navigate_to_the_url() {
        try {
            ExtentLogger.createNode("I navigate to the URL");
            TestBase.setup();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @Then("I perform login")
    public void iPerformLogin() {
        try{
        ExtentLogger.createNode("I perform login");
        loginPage.iPerformLogin();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }
    @And("I change the POS using {string} and {string}")
    public void iChangeThePOSUsingAnd(String arg0, String arg1) {
        try{
        ExtentLogger.createNode("I change the POS using "+arg0+" and "+arg1+" ");
        homePage.ChangePOS(arg0, arg1);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on home screen")
    public void iClickOnHomeScreen() {
        try{
        ExtentLogger.createNode("I click on home screen");
        homePage.Clickonlogo();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on Reservation module")
    public void iClickOnReservationModule() {
        try{
        ExtentLogger.createNode("I click on Reservation module");
        homePage.ClickOnReservationTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on Check-in module")
    public void iClickOnCheckInModule() {
        try{
        ExtentLogger.createNode("I click on Check-in module");
        homePage.ClickOnCheckinTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on gate module")
    public void iClickOnGateModule() {
        try{
        ExtentLogger.createNode("I click on gate module");
        homePage.ClickOnGateTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on New Order tab to create a PNR")
    public void iClickOnNewOrderTabToCreateAPNR() {
        try {
            ExtentLogger.createNode("I click on new Order tab to create a PNR");
            reservationPage.ClickOnNewOrderTab();
        }catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select {string} and {string} and date of journey as {string}")
    public void iSelectAndAndDateOfJourneyAs(String arg0, String arg1, String arg2) {
        try{
        ExtentLogger.createNode("I select "+arg0+" and "+arg1+" and date of journey as "+arg2+" ");
        reservationPage.Selectitenary(arg0, arg1, arg2 );
        }catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }
}


