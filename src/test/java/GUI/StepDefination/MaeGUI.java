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
            loginPage.launchURL();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @Then("I perform login")
    public void iPerformLogin() {
        try {
            ExtentLogger.createNode("I perform login");
            loginPage.iPerformLogin();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    @And("I change the POS using {string} and {string}")
    public void iChangeThePOSUsingAnd(String arg0, String arg1) {
        try {
            ExtentLogger.createNode("I change the POS using " + arg0 + " and " + arg1 + " ");
            homePage.ChangePOS(arg0, arg1);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on home screen")
    public void iClickOnHomeScreen() {
        try {
            ExtentLogger.createNode("I click on home screen");
            homePage.Clickonlogo();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on Reservation module")
    public void iClickOnReservationModule() {
        try {
            ExtentLogger.createNode("I click on Reservation module");
            homePage.ClickOnReservationTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on Check-in module")
    public void iClickOnCheckInModule() {
        try {
            ExtentLogger.createNode("I click on Check-in module");
            homePage.ClickOnCheckinTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on gate module")
    public void iClickOnGateModule() {
        try {
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
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }


    @And("I select the from and to city {string} and {string}")
    public void iSelectTheFromAndToCityAnd(String arg0, String arg1) {
        try {
            ExtentLogger.createNode("I select " + arg0 + " and " + arg1 + " ");
            reservationPage.Selectitenary(arg0, arg1);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }


    @And("I enter Start Date {string} for one way booking")
    public void iEnterStartDateForOneWayBooking(String arg0) {
        try {
            ExtentLogger.createNode("I select " + arg0 + "");
            reservationPage.SelectDateForOneWayBooking(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select return booking with {string}")
    public void iSelectReturnBookingWith(String arg0) {
        try {
            ExtentLogger.createNode("I select " + arg0 + "  ");
            reservationPage.SelectReturnBooking(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
        }



    @And("I click on search button")
    public void iClickOnSearchButton() {
        try{
            ExtentLogger.createNode("I click on search button");
            reservationPage.SerachButton();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
        }

    @And("I select class of service as {string}")
    public void iSelectClassOfServiceAs(String arg0) {
        try{
            ExtentLogger.createNode("I select the class of service");
            reservationPage.SelectSeatFromClass(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

        }

    @And("I Select pricing option as {string}")
    public void iSelectPricingOptionAs(String arg0) {
        try{
            ExtentLogger.createNode("I Select pricing option as "+arg0+" ");
            reservationPage.SelectPriceOption(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }


    }

    @And("I enter Passenger details")
    public void iEnterPassengerDetails() {
        try{
            ExtentLogger.createNode("I enter Passenger details");
            reservationPage.FillPassengerDetails();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }


    }

    @And("I enter Adult passenger count as {int}")
    public void iEnterAdultPassengerCountAsADT(int arg0) {
        try{
            ExtentLogger.createNode("I enter Adult passenger count as " + arg0 + " ");
            reservationPage.AdultPassengerCount(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    @And("I enter Child passenger count as {int}")
    public void iEnterChildPassengerCountAsCHD(int arg0) {
        try{
            ExtentLogger.createNode("I enter Child passenger count as " + arg0 + " ");
            reservationPage.ChildPassengerCount(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    @And("I enter INF passenger count as {int}")
    public void iEnterINFPassengerCountAsINF(int arg0) {
        try{
            ExtentLogger.createNode("I enter INF passenger count as " + arg0 + " ");
            reservationPage.INFPassengerCount(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    @And("I enter INS passenger count as {int}")
    public void iEnterINSPassengerCountAsINS(int arg0) {
        try{
            ExtentLogger.createNode("I enter INS passenger count as " + arg0 + " ");
            reservationPage.INSPassengerCount(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }
}





