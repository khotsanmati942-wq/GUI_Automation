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

    @Given("I navigate to the application URL")
    public void i_navigate_to_the_url() {
        try {
            ExtentLogger.createNode("I navigate to the application URL");
            loginPage.launchURL();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @Then("I log in to the application")
    public void iPerformLogin() {
        try {
            ExtentLogger.createNode("I log in to the application");
            loginPage.iPerformLogin();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I change the POS using {string} and {string}")
    public void iChangeThePOSUsingAnd(String arg0, String arg1) {
        try {
            ExtentLogger.createNode("I change the POS using " + arg0 + " and " + arg1);
            homePage.ChangePOS(arg0, arg1);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I am on the Home screen")
    public void iClickOnHomeScreen() {
        try {
            ExtentLogger.createNode("I am on the Home screen");
            homePage.Clickonlogo();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on the Reservation module")
    public void iClickOnReservationModule() {
        try {
            ExtentLogger.createNode("I click on the Reservation module");
            homePage.ClickOnReservationTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on the Check-in module")
    public void iClickOnCheckInModule() {
        try {
            ExtentLogger.createNode("I click on the Check-in module");
            homePage.ClickOnCheckinTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on the Gate module")
    public void iClickOnGateModule() {
        try {
            ExtentLogger.createNode("I click on the Gate module");
            homePage.ClickOnGateTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on the New Order tab to create a PNR")
    public void iClickOnNewOrderTabToCreateAPNR() {
        try {
            ExtentLogger.createNode("I click on the New Order tab to create a PNR");
            reservationPage.ClickOnNewOrderTab();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select the From and To cities {string} and {string}")
    public void iSelectTheFromAndToCityAnd(String arg0, String arg1) {
        try {
            ExtentLogger.createNode("I select " + arg0 + " and " + arg1);
            reservationPage.Selectitenary(arg0, arg1);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I enter the Start Date {string} for a one-way booking")
    public void iEnterStartDateForOneWayBooking(String arg0) {
        try {
            ExtentLogger.createNode("I enter the Start Date " + arg0);
            reservationPage.SelectDateForOneWayBooking(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select a return booking with start date {string}")
    public void iSelectReturnBookingWith(String arg0) {
        try {
            ExtentLogger.createNode("I select a return booking with start date " + arg0);
            reservationPage.SelectReturnBooking(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I click on the Search button")
    public void iClickOnSearchButton() {
        try {
            ExtentLogger.createNode("I click on the Search button");
            reservationPage.SerachButton();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select the class of service as {string}")
    public void iSelectClassOfServiceAs(String arg0) {
        try {
            ExtentLogger.createNode("I select the class of service");
            reservationPage.SelectSeatFromClass(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I select the pricing option as {string}")
    public void iSelectPricingOptionAs(String arg0) {
        try {
            ExtentLogger.createNode("I select the pricing option as " + arg0);
            reservationPage.SelectPriceOption(arg0);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I enter the passenger details")
    public void iEnterPassengerDetails() {
        try {
            ExtentLogger.createNode("I enter the passenger details");
            reservationPage.FillPassengerDetails();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I enter the Adult passenger count as {int}")
    public void iEnterAdultPassengerCountAsADT(int arg0) {
        reservationPage.AdultPassengerCount(arg0);
    }

    @And("I enter the Child passenger count as {int}")
    public void iEnterChildPassengerCountAsCHD(int arg0) {
        reservationPage.ChildPassengerCount(arg0);
    }

    @And("I enter the Infant passenger count as {int}")
    public void iEnterINFPassengerCountAsINF(int arg0) {
        reservationPage.INFPassengerCount(arg0);
    }

    @And("I enter the INS passenger count as {int}")
    public void iEnterINSPassengerCountAsINS(int arg0) {
        reservationPage.INSPassengerCount(arg0);
    }

    @And("I perform payment using {string}")
    public void iPerformPaymentUsing(String arg0) {
        reservationPage.PerformPayment(arg0);
    }

    @And("I search for the Order number on the Check-in page")
    public void iSearchTheOrderNumberInCheckinPage() {
        chcekinPage.SerachOrderNumberInCheckin();
    }

    @And("I search for the flight details on the Check-in page")
    public void iSearchTheFlightDetailsInCheckinPage() {
        chcekinPage.SerachFlightDetailInCheckin();
    }

    @And("I search for the flight details on the Gate page")
    public void iSearchTheFlightDetailsInGatePage() {
        gatePage.SerachFlightDetailInGate();
    }


    @And("I click on the Tools menu")
    public void iClickOnTheToolsMenu() {
        try {
            ExtentLogger.createNode("I click on the Tool menu");
            nativeShares.ClickOnToolMenu();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    @And("I click on Native Shares")
    public void iClickOnNativeShares() {
        try {
            ExtentLogger.createNode("I click on Native Shares");
            nativeShares.ClickOnNativeShares();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

//
//    @And("I retrive a PNR created from Native shares in GUI")
//    public void iRetriveAPNRCreatedFromNativeSharesInGUI() {
//        try{
//            ExtentLogger.createNode("I retrive a PNR created from Native shares in GUI");
//            nativeShares.RetriveAPNRCreatedFromShares();
//        } catch (Exception e) {
//            ExtentLogger.fail("Step failed", e);
//        }
//    }

    @And("I Create a PNR in Native Shares using {string} and {string} and {string}")
    public void iCreateAPNRInNativeSharesUsingAndAnd(String arg0, String arg1, String arg2) {
        try {
            ExtentLogger.createNode("I Create a PNR in Native Shares");
            nativeShares.CreatePNRInNativeShares(arg0, arg1, arg2);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("^I enter the Adult passenger count as (\\d+) and Class of service (\\w+) in Native Shares$")
    public void i_enter_the_adult_passenger_count_and_class_of_service_in_native_shares(
            int adt, String cos) {
        try {
            ExtentLogger.createNode("I enter the Adult Passenger count and COS in Native Shares");
            nativeShares.CreateItinaryinShares(adt, cos);
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }


    @And("I Create a PNR in Native Shares Using Passenger details")
    public void iCreateAPNRInNativeSharesUsingPassengerDetails() {
        try{
            ExtentLogger.createNode("I create a PNR in Native Shares Using Passenger details");
            nativeShares.CreatePNRInNativeSharesUsingPassengerDetails();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    @And("I retrive a PNR created from Native shares in GUI")
    public void iRetriveAPNRCreatedFromNativeSharesInGUI() {
        try{
            ExtentLogger.pass("I retrive a PNR from Native shares in GUI");
            nativeShares.NativePNRInGUI();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }
}



