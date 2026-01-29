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
    }


    public void ClickOnNewOrderTab() {
        gl.waitForLoaderToDisappear();
        reservationPageObject.NEW_ORDER_TAB.click();
        gl.WaitForProfileLoad();
    }

    public void Selectitenary(String origin, String destination, String date){
        ExtentLogger.pass("I am entering origin, destination and date");
        try{
            reservationPageObject.FROM_CITY.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.FROM_CITY.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.FROM_CITY.sendKeys(origin);
            reservationPageObject.FROM_CITY.sendKeys(Keys.ENTER);
            gl.WaitForProfileLoad();
            reservationPageObject.TO_CITY.sendKeys(destination);
            reservationPageObject.TO_CITY.sendKeys(Keys.ENTER);
            gl.WaitForProfileLoad();
            reservationPageObject.DATE_FIELD.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.DATE_FIELD.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            String newdate = gl.getDateFromOffset(date);
            gl.WaitForProfileLoad();
            reservationPageObject.DATE_FIELD.sendKeys(newdate);
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

}
