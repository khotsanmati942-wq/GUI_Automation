package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.PassengerData;
import GUI.Test_Base.TestBase;
import net.bytebuddy.description.type.TypeList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Chcekin_Page extends TestBase {
    Chcekin_Page.checkin_page_object checkinPageObject;
    Generic gl;

    public Chcekin_Page(){
       checkinPageObject = new checkin_page_object();
        gl = new Generic();
        PageFactory.initElements(getDriver(), checkinPageObject);
    }

    public class checkin_page_object{

        @FindBy(xpath = "//button[normalize-space()='Proceed to Check In']")
        public WebElement PROCEED_TO_CHECKIN;

        @FindBy(xpath = "//input[contains(@aria-label,'Order Number')]")
        public WebElement ORDER_NUMBER;

        @FindBy(xpath = "(//input[contains(@name,'Flight')])[1]")
        public WebElement FLIGHT_NUMBER;

        @FindBy(xpath = "(//input[contains(@name,'origin')])[1]")
        public WebElement FROM_CITY;

        @FindBy(xpath = "(//input[contains(@class,'md-datepicker-input')])[1]")
        public WebElement DATE_OF_JOURNEY;

        @FindBy(xpath = "(//button[@ng-disabled='flightSearch.form.$invalid'])")
        public WebElement SEARCH_BUTTON;


    }
     public void SerachOrderNumberInCheckin(){
        try {
            ExtentLogger.pass("I search order number in check-in page");
            gl.WaitForProfileLoad();
            checkinPageObject.ORDER_NUMBER.sendKeys(passenger.getString(PassengerData.PassengerKey.PNR));
            gl.WaitForProfileLoad();
            ((org.openqa.selenium.JavascriptExecutor) getDriver())
                    .executeScript("document.body.style.zoom='75%'");
            ExtentLogger.attachScreenshotBase64();
            checkinPageObject.PROCEED_TO_CHECKIN.click();
            gl.waitForLoaderToDisappear();
            ((org.openqa.selenium.JavascriptExecutor) getDriver())
                    .executeScript("document.body.style.zoom='100%'");
            gl.WaitForProfileLoad();

        }
        catch (Exception e) {
        ExtentLogger.fail("Step failed", e);
        throw e;
    }

     }

     public void SerachFlightDetailInCheckin(){
        try{
            ExtentLogger.pass("I Search Flight Details in Check-in");
            gl.WaitForProfileLoad();
            checkinPageObject.FLIGHT_NUMBER.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_NUMBER));
            gl.WaitForProfileLoad();
            checkinPageObject.FROM_CITY.clear();
            gl.WaitForProfileLoad();
            checkinPageObject.FROM_CITY.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_ORIGIN_CITY));
            gl.WaitForProfileLoad();
            checkinPageObject.FROM_CITY.sendKeys(Keys.ENTER);
            gl.WaitForProfileLoad();
            checkinPageObject.DATE_OF_JOURNEY.clear();
            gl.WaitForProfileLoad();
            checkinPageObject.DATE_OF_JOURNEY.sendKeys(passenger.getString(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_DATE));
            gl.WaitForProfileLoad();
            checkinPageObject.SEARCH_BUTTON.click();
            ExtentLogger.attachScreenshotBase64();
            gl.waitForLoaderToDisappear();

        }
        catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
            throw e;
        }
     }


}
