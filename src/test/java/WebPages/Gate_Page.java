package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.PassengerData;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gate_Page extends TestBase {
    Gate_Page.gate_page_object gatePageObject;
    Generic gl;

    public Gate_Page(){
        gatePageObject = new Gate_Page.gate_page_object();
        gl = new Generic();
        PageFactory.initElements(getDriver(), gatePageObject);
    }

    public class gate_page_object{


        @FindBy(xpath = "(//input[contains(@name,'Flight')])[1]")
        public WebElement FLIGHT_NUMBER;

        @FindBy(xpath = "(//input[contains(@name,'origin')])[1]")
        public WebElement FROM_CITY;

        @FindBy(xpath = "(//input[contains(@class,'md-datepicker-input')])[1]")
        public WebElement DATE_OF_JOURNEY;

        @FindBy(xpath = "(//button[@ng-disabled='flightSearch.form.$invalid'])")
        public WebElement SEARCH_BUTTON;

    }

    public void SerachFlightDetailInGate(){
        try{
            ExtentLogger.pass("I Search Flight Details in Check-in");
            gl.WaitForProfileLoad();
            gatePageObject.FLIGHT_NUMBER.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_NUMBER));
            gl.WaitForProfileLoad();
            gatePageObject.FROM_CITY.clear();
            gl.WaitForProfileLoad();
            gatePageObject.FROM_CITY.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_ORIGIN_CITY));
            gl.WaitForProfileLoad();
            gatePageObject.FROM_CITY.sendKeys(Keys.ENTER);
            gl.WaitForProfileLoad();
            gatePageObject.DATE_OF_JOURNEY.clear();
            gl.WaitForProfileLoad();
            gatePageObject.DATE_OF_JOURNEY.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_DATE));
            gl.WaitForProfileLoad();
            gatePageObject.SEARCH_BUTTON.click();
            ExtentLogger.attachScreenshotBase64();
            gl.waitForLoaderToDisappear();

        }
        catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
            throw e;
        }
    }

}
