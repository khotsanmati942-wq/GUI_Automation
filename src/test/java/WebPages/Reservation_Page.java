package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reservation_Page extends TestBase {
    Reservation_Page.ReservationPageObject reservationPageObject;
    Generic gl;

    public Reservation_Page(){

        reservationPageObject = new ReservationPageObject();
        PageFactory.initElements(getDriver(), reservationPageObject);
        gl = new Generic();
    }

    public class ReservationPageObject{

        @FindBy(xpath = "//div[@class='ng-scope'][normalize-space()='New Order']")
        public WebElement NEW_ORDER_TAB;

        @FindBy(xpath = "//input[contains(@name,'origin')]")
        public WebElement FROM_CITY;

        @FindBy(xpath = "//input[contains(@name,'destination')]")
        public WebElement TO_CITY;

        @FindBy(xpath = "//input[@class='md-datepicker-input']")
        public WebElement DATE_FIELD;

        @FindBy(xpath = "//md-checkbox[@name='flightReturn']//div[@class='md-container md-ink-ripple']")
        public WebElement RETURN_FLIGHT;

        @FindBy(xpath = "//md-datepicker[contains(@class,'_md-datepicker')]")
        public WebElement RETURN_DATE;
    }


    public void ClickOnNewOrderTab() {
        gl.waitForLoaderToDisappear();
        reservationPageObject.NEW_ORDER_TAB.click();
        gl.WaitForProfileLoad();
    }

    public void Selectitenary(String origin, String destination) {
        ExtentLogger.pass("I am entering origin, destination");
        try {
            reservationPageObject.FROM_CITY.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.FROM_CITY.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.FROM_CITY.sendKeys(origin);
            reservationPageObject.FROM_CITY.sendKeys(Keys.ENTER);
            gl.WaitForProfileLoad();
            reservationPageObject.TO_CITY.sendKeys(destination);
            reservationPageObject.TO_CITY.sendKeys(Keys.ENTER);
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }
    public void SelectDateForOneWayBooking(String date) {
        ExtentLogger.pass("I am entering date for one way booking");
        try {
            gl.WaitForProfileLoad();
            reservationPageObject.DATE_FIELD.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.DATE_FIELD.sendKeys(Keys.DELETE);
            String newdate = gl.getDateFromOffset(date);
            gl.WaitForProfileLoad();
            reservationPageObject.DATE_FIELD.sendKeys(newdate);
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void SelectReturnBooking(String date){
        ExtentLogger.pass("I select the return flight date");
        try{
            gl.WaitForProfileLoad();
            reservationPageObject.RETURN_FLIGHT.click();
            gl.WaitForProfileLoad();
            reservationPageObject.RETURN_DATE.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.RETURN_DATE.sendKeys(Keys.DELETE);
            String newdate = gl.getDateFromOffset(date);
            gl.WaitForProfileLoad();
            gl.ElementToBeClickable(reservationPageObject.RETURN_DATE);
            reservationPageObject.RETURN_DATE.sendKeys(newdate);
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }
}
