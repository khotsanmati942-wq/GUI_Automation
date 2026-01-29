package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.By;
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

        @FindBy(xpath = "//i[@class='icon-edit-sales-office pssgui-design-sub-heading-2a ng-scope']")
        public WebElement POS_BUTTON;

        @FindBy(xpath = "(//md-select-value//span[contains(@class,'md-select-icon')])[1]")
        public WebElement CHANGE_SALES_OFFICE_DROPDOWN;

        @FindBy(xpath = "//md-option//div")
        public List<WebElement> POS_NAMES;

        @FindBy(xpath = "//md-select[@ng-model='salesOffice.currency']")
        public WebElement CHANGE_CURRENCY_DROPDOWN;

        @FindBy(xpath = "//md-select-menu//md-option//div")
        public List<WebElement> CURRENCY_NAMES;

        @FindBy(xpath = "//button[normalize-space()='OK']")
        public WebElement OK_BUTTON;
    }

    public void Clickonlogo(){
        gl.ElementToBeClickable(homePageObjects.COPAAIRLINE_LOGO);
        gl.WaitForProfileLoad();
        homePageObjects.COPAAIRLINE_LOGO.click();
        gl.WaitForProfileLoad();
    }

    public void ClickOnReservationTab(){
        ExtentLogger.pass("I click on reservation Tab");
        homePageObjects.RESRVATION_LINK.click();
        ExtentLogger.attachScreenshotBase64();
        gl.WaitForProfileLoad();
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

    public void ChangePOS(String POS, String currency) {
        try {
            ExtentLogger.pass("I Change the POS and Currency");
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);

            // wait for loader overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".hpe-pssgui.loading-wrapper")));

            gl.ElementToBeClickable(homePageObjects.POS_BUTTON);
            homePageObjects.POS_BUTTON.click();
            gl.WaitForProfileLoad();
            gl.ElementToBeClickable(homePageObjects.CHANGE_SALES_OFFICE_DROPDOWN);
            homePageObjects.CHANGE_SALES_OFFICE_DROPDOWN.click();
            gl.WaitForProfileLoad();
            for (WebElement pos : homePageObjects.POS_NAMES) {
                if (POS.equalsIgnoreCase(pos.getText())) {
                    pos.click();
                    break;
                }
            }
            gl.ElementToBeClickable(homePageObjects.CHANGE_CURRENCY_DROPDOWN);
            homePageObjects.CHANGE_CURRENCY_DROPDOWN.click();
            gl.WaitForProfileLoad();
            for (WebElement curncy : homePageObjects.CURRENCY_NAMES) {
                if (currency.equalsIgnoreCase(curncy.getText())) {
                    curncy.click();
                    break;
                }
            }
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            homePageObjects.OK_BUTTON.click();
            gl.waitForLoaderToDisappear();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }
    }

