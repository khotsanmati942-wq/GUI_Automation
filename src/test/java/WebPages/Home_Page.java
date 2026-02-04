package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Home_Page extends TestBase {
    Home_Page.HomePageObjects homePageObjects;
   Generic gl;

    public Home_Page(){
        homePageObjects = new HomePageObjects();
        PageFactory.initElements(getDriver(), homePageObjects);
        gl = new Generic();
    }

    public static class HomePageObjects{

        @FindBy(xpath = "//div[@class='icn-logo pssgui-link']")
        public WebElement COPAAIRLINE_LOGO;

        @FindBy(xpath = "//div[normalize-space()='Reservations']")
        public WebElement RESRVATION_LINK;

        @FindBy(xpath = "//div[normalize-space()='Check-In']")
        public  WebElement CHECKIN_LINK;

        @FindBy(xpath = "//div[normalize-space()='Gate']")
        public WebElement GATE_LINK;

        @FindBy(xpath = "//i[contains(@class,'icon-edit-sales-office')]")
        public WebElement POS_BUTTON;

        @FindBy(xpath = "(//md-select-value//span[contains(@class,'md-select-icon')])[1]")
        public WebElement CHANGE_SALES_OFFICE_DROPDOWN;

        @FindBy(xpath = "//md-option//div")
        public List<WebElement> POS_NAMES;

        @FindBy(xpath = "//md-select[@ng-model='salesOffice.currency']")
        public WebElement CHANGE_CURRENCY_DROPDOWN;

        @FindBy(xpath = "//md-select-menu//md-option//div")
        public List<WebElement> CURRENCY_NAMES;

        @FindBy(xpath = "//button[translate(normalize-space(.),'ok','OK')='OK']")
        public WebElement OK_BUTTON;

        @FindBy(css = ".md-dialog-container")
        public List<WebElement> SALES_REPORT_LOGIN_REMINDR;

        @FindBy(xpath = "//button[normalize-space()='Reservations']//i[@class='icon-sort-descending']")
        public WebElement RESERVATION_TAB;

        @FindBy(xpath = "//button[normalize-space()='Sales Reporting']")
        public WebElement SALES_REPORT_TAB;

        @FindBy(xpath = "//button[contains(text(),'Agent Sales Report')]")
        public WebElement AGENT_SALES_REPORT;

        @FindBy(xpath = "//span[@role='button'][normalize-space()='Total Transaction Amount']")
        public WebElement TOTAL_TRANSACTION_AMOUNT;

        @FindBy(xpath = "//button[normalize-space()='Close Report']")
        public WebElement CLOSE_REPORT_BUTTON;

        @FindBy(xpath = "//button[@ng-click='closeReportPopup.stateChange(closeReportPopup.popupAction)']")
        public WebElement CLOSE_REPORT_BUTTON_NEW;
    }

    public void Clickonlogo(){
        gl.ElementToBeClickable(homePageObjects.COPAAIRLINE_LOGO);
        gl.WaitForProfileLoad();
        homePageObjects.COPAAIRLINE_LOGO.click();
        gl.WaitForProfileLoad();
    }

    public void ClickOnReservationTab() {
        closeMdDialogIfPresent();
        gl.waitForLoaderToDisappear();
        ExtentLogger.pass("I click on Reservation Tab");
      gl.ElementToBeClickable(homePageObjects.RESRVATION_LINK);
        homePageObjects.RESRVATION_LINK.click();
        ExtentLogger.attachScreenshotBase64();
        gl.waitForLoaderToDisappear();
    }


    public void ClickOnCheckinTab(){
        ExtentLogger.pass("I click on check-in Tab");
        homePageObjects.CHECKIN_LINK.click();
        ExtentLogger.attachScreenshotBase64();
        gl.waitForLoaderToDisappear();
    }

    public void ClickOnGateTab(){
        ExtentLogger.pass("I click on Gate Tab");
        homePageObjects.GATE_LINK.click();
        ExtentLogger.attachScreenshotBase64();
        gl.waitForLoaderToDisappear();
    }

    private void selectMdOptionByText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        By option = By.xpath("//md-option//div[normalize-space()='" + text + "']");

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(option)
        );

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    private void waitForMdOptionsToClose() {

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//md-option")
                ));
    }

    public void ChangePOS(String POS, String currency) {
        try {
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            ExtentLogger.pass("I Change the POS and Currency");
           gl.ElementToBeClickable(homePageObjects.POS_BUTTON);
           homePageObjects.POS_BUTTON.click();

            gl.WaitForProfileLoad();

            homePageObjects.CHANGE_SALES_OFFICE_DROPDOWN.click();
            selectMdOptionByText(POS);
            waitForMdOptionsToClose();

            gl.WaitForProfileLoad();

            homePageObjects.CHANGE_CURRENCY_DROPDOWN.click();
            selectMdOptionByText(currency);
            waitForMdOptionsToClose();

           gl.ElementToBeClickable(homePageObjects.OK_BUTTON);
            homePageObjects.OK_BUTTON.click();
            gl.waitForLoaderToDisappear();
            closeMdDialogIfPresent();
            ExtentLogger.attachScreenshotBase64();

        } catch (Exception e) {
            ExtentLogger.fail("Change POS step failed", e);
            throw e;
        }
    }


    public void closeMdDialogIfPresent() {
        if (!homePageObjects.SALES_REPORT_LOGIN_REMINDR.isEmpty()) {
            homePageObjects.OK_BUTTON.click();
            // Wait till dialog is truly gone / detached
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.stalenessOf(homePageObjects.SALES_REPORT_LOGIN_REMINDR.get(0)));
            gl.WaitForProfileLoad();
            homePageObjects.RESERVATION_TAB.click();
            gl.WaitForProfileLoad();
            homePageObjects.SALES_REPORT_TAB.click();
            gl.WaitForProfileLoad();
            homePageObjects.AGENT_SALES_REPORT.click();
            gl.waitForLoaderToDisappear();
            homePageObjects.TOTAL_TRANSACTION_AMOUNT.click();
            gl.waitForLoaderToDisappear();
            homePageObjects.CLOSE_REPORT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            homePageObjects.CLOSE_REPORT_BUTTON_NEW.click();
            gl.WaitForProfileLoad();
            homePageObjects.COPAAIRLINE_LOGO.click();
            gl.WaitForProfileLoad();

        }
    }

}

