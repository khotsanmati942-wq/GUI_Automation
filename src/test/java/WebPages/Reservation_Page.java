package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.PassengerData;
import GUI.Test_Base.TestBase;
import org.checkerframework.checker.fenum.qual.FenumUnqualified;
import org.checkerframework.checker.initialization.qual.FBCBottom;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import static GUI.Test_Base.Generic.generatePassenger;

public class Reservation_Page extends TestBase {
    Reservation_Page.ReservationPageObject reservationPageObject;
    Generic gl;
    Home_Page.HomePageObjects homePageObjects;

    public Reservation_Page() {

        reservationPageObject = new ReservationPageObject();
        gl = new Generic();
        homePageObjects = new Home_Page.HomePageObjects();
        PageFactory.initElements(getDriver(), reservationPageObject);
        PageFactory.initElements(getDriver(), homePageObjects);
    }


    public static class ReservationPageObject {

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

        @FindBy(xpath = "(//md-datepicker[contains(@class,'_md-datepicker')]//input)[2]")
        public WebElement RETURN_DATE;

        @FindBy(xpath = "(//input[contains(@aria-label,'seat count')])[1]")
        public WebElement ADULT_COUNT;

        @FindBy(xpath = "(//input[contains(@aria-label,'seat count')])[2]")
        public WebElement CHILD_COUNT;

        @FindBy(xpath = "(//input[contains(@aria-label,'seat count')])[3]")
        public WebElement INF_COUNT;

        @FindBy(xpath = "(//input[contains(@aria-label,'seat count')])[4]")
        public WebElement INS_COUNT;

        @FindBy(xpath = "//button[normalize-space()='Search']")
        public WebElement SERACH_BUTTON;

        @FindBy(xpath = "//div[@ng-repeat='flight in segment.Legs']//span[@role='button']")
        public List<WebElement> FLIGHT_AVAILABILTY;

        @FindBy(xpath = "//button[normalize-space()='Price Quote']")
        public WebElement PRICE_QUOTE;

        @FindBy(xpath = "//md-dialog//md-select")
        public WebElement PRICING_OPTION_DROPDOWN;

        @FindBy(xpath = "//button[normalize-space()='Next']")
        public WebElement NEXT_BUTTON;

        @FindBy(xpath = "//input[@name='surname']")
        public WebElement SUR_NAME;

        @FindBy(xpath = "//input[@name='firstName']")
        public WebElement FIRST_NAME;

        @FindBy(xpath = "//input[@class='md-datepicker-input']")
        public WebElement BIRTH_DATE;

        @FindBy(xpath = "//md-input-container[contains(@ng-repeat,'email in activePassenger.Emails')]//input")
        public WebElement EMAIL_ID;

        @FindBy(xpath = "(//md-select[contains(@ng-model,'personalInfo.model.Type')])[1]")
        public WebElement PHONE_TYPE;

        @FindBy(xpath = "//md-option[contains(@ng-value,'phoneType.Value')]/div[contains(@class,'md-text ng-binding')]")
        public List<WebElement> TPYE_OF_PHONES;

        @FindBy(xpath = "(//input[@name='countryCode'])[1]")
        public WebElement COUNTRY_CODE;

        @FindBy(xpath = "(//input[@name='Phone Number'])[1]")
        public WebElement PHONE_NUMBER;

        @FindBy(xpath = "//div[contains(@class,'ng-binding') and starts-with(normalize-space(),'(')]")
        public List<WebElement> PASSENGER_TYPE_IDENTIFICATION;

        @FindBy(xpath = "(//md-select[@aria-label='drop down'])[2]")
        public WebElement GENDER_DROP_DOWN;

        @FindBy(xpath = "//div[@ng-repeat='menuValue in menuCtrl.menuLabels']")
        public List<WebElement> GENDER_OPTION;

        @FindBy(xpath = "//button[normalize-space()='Book & File Fare']")
        public WebElement BOOK_FILEFARE_BUTTON;

        @FindBy(xpath = "//md-select[@ng-model='activePassenger.travelsWith']")
        public WebElement TRAVEL_WITH;

        @FindBy(xpath = "//md-option[contains(@ng-value,'adultPassenger.paxIndex')]")
        public List<WebElement> TRAVEL_WITH_OPTION;

        @FindBy(xpath = "//md-select[@aria-label='drop down']")
        public WebElement GENDER_OPTION_INF;

        @FindBy(xpath = "//button[normalize-space()='Check Out']")
        public WebElement CHECK_OUT_BUTTON;

        @FindBy(xpath = "//md-select[@id='paymentIndex.paymentType']")
        public WebElement PAYMENT_DROPDOWN;

        @FindBy(xpath = "(//md-option[contains(@class,'ng-scope md-ink-ripple')])//div")
        public List<WebElement> TYPE_OF_PAYMENT;

        @FindBy(xpath = "//button[normalize-space()='Pay']")
        public WebElement PAY_BUTTON;

        @FindBy(xpath = "//md-select[contains(@aria-label,'drop down')]")
        public WebElement LANGUAGE_DROPDOWN;

        @FindBy(xpath = "//md-option[contains(@class,'hpe-pssgui-menu-option ng-scope')]//div")
        public List<WebElement> LANGUAGE_TYPES;

        @FindBy(xpath = "//button[normalize-space()='Email']")
        public WebElement EMAIL_BUTTON;

        @FindBy(xpath = "//button[normalize-space()='Done']")
        public WebElement DONE_BUTTON;


        @FindBy(xpath = "//div[@class='pssgui-design-sub-heading-2 ng-binding']")
        public WebElement PNR;

        @FindBy(xpath = "//td[@class='flight-name']//span")
        public WebElement FLIGHT_NUMBER;

        @FindBy(xpath = "//span[contains(@ng-click,'flightResult.enableInlineEdit')]")
        public WebElement DATE_OF_JOURNEY;

        @FindBy(xpath = "//div[contains(@airport-code,'originDestination.origin')]")
        public WebElement ORIGIN_CITY;




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

    public void SelectReturnBooking(String date) {
        ExtentLogger.pass("I select the return flight date");
        try {
            gl.WaitForProfileLoad();
            reservationPageObject.RETURN_FLIGHT.click();
            gl.WaitForProfileLoad();
            reservationPageObject.RETURN_DATE.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.RETURN_DATE.sendKeys(Keys.DELETE);
            String newdate1 = gl.getDateFromOffset(date);
            gl.WaitForProfileLoad();
            gl.ElementToBeClickable(reservationPageObject.RETURN_DATE);
            reservationPageObject.RETURN_DATE.sendKeys(newdate1);
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

    }

    public void AdultPassengerCount(int count) {
        try {
            passenger.set(PassengerData.PassengerKey.ADULT_COUNT, count);
            ExtentLogger.pass("I enter Adult passenger Count");
            reservationPageObject.ADULT_COUNT.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.ADULT_COUNT.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.ADULT_COUNT.sendKeys(String.valueOf(passenger.getInt(PassengerData.PassengerKey.ADULT_COUNT)
            ));

            gl.WaitForProfileLoad();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void ChildPassengerCount(int count) {
        try {
            passenger.set(PassengerData.PassengerKey.CHILD_COUNT, count);
            ExtentLogger.pass("I enter Child passenger Count");
            reservationPageObject.CHILD_COUNT.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.CHILD_COUNT.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.CHILD_COUNT.sendKeys(String.valueOf(passenger.getInt(PassengerData.PassengerKey.CHILD_COUNT)));
            gl.WaitForProfileLoad();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void INFPassengerCount(int count) {
        try {
            passenger.set(PassengerData.PassengerKey.INF_COUNT, count);
            ExtentLogger.pass("I enter INF passenger Count");
            reservationPageObject.INF_COUNT.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.INF_COUNT.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.INF_COUNT.sendKeys(String.valueOf(passenger.getInt(PassengerData.PassengerKey.INF_COUNT)));
            gl.WaitForProfileLoad();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void INSPassengerCount(int count) {
        try {
            passenger.set(PassengerData.PassengerKey.INS_COUNT, count);
            ExtentLogger.pass("I enter INS passenger Count");
            reservationPageObject.INS_COUNT.sendKeys(Keys.CONTROL + "a");
            reservationPageObject.INS_COUNT.sendKeys(Keys.DELETE);
            gl.WaitForProfileLoad();
            reservationPageObject.INS_COUNT.sendKeys(String.valueOf(passenger.getInt(PassengerData.PassengerKey.INS_COUNT)));
            gl.WaitForProfileLoad();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void SerachButton() {
        try {
            ExtentLogger.pass("I click on search button");
            ExtentLogger.attachScreenshotBase64();
            reservationPageObject.SERACH_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.ElementToBeClickable(homePageObjects.COPAAIRLINE_LOGO);
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

public void SelectSeatFromClass(String seattype) {

    try {

        ExtentLogger.pass("I select the class of service");

        WebDriver driver = TestBase.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // WAIT FOR LOADER TO DISAPPEAR
        gl.waitForLoaderToDisappear();
        gl.WaitForProfileLoad();

        // WAIT UNTIL FLIGHT AVAILABILITY LIST IS VISIBLE
        wait.until(ExpectedConditions.visibilityOfAllElements(reservationPageObject.FLIGHT_AVAILABILTY));

        int adultCount = passenger.getInt(PassengerData.PassengerKey.ADULT_COUNT);
        int childCount = passenger.getInt(PassengerData.PassengerKey.CHILD_COUNT);
        int infCount = passenger.getInt(PassengerData.PassengerKey.INF_COUNT);
        int insCount = passenger.getInt(PassengerData.PassengerKey.INS_COUNT);

        int totalPaxCount = adultCount + childCount + infCount + insCount;

        boolean seatSelected = false;

        if (seattype.equalsIgnoreCase("Business")) {

            for (WebElement seat : reservationPageObject.FLIGHT_AVAILABILTY) {

                String seatText = seat.getText();

                if (seatText.matches("^[CJDR].*")) {

                    int seatNumber = Integer.parseInt(seatText.replaceAll("\\D+", ""));

                    if (seatNumber > totalPaxCount) {

                        wait.until(ExpectedConditions.elementToBeClickable(seat));

                        seat.click();

                        ExtentLogger.attachScreenshotBase64();

                        gl.WaitForProfileLoad();

                        seatSelected = true;

                        break;
                    }
                }
            }

        } else if (seattype.equalsIgnoreCase("Economy")) {

            for (WebElement seat : reservationPageObject.FLIGHT_AVAILABILTY) {

                String seatText = seat.getText();

                if (seatText.matches("^[YBMHQKFVUSOWELT].*")) {

                    int seatNumber = Integer.parseInt(seatText.replaceAll("\\D+", ""));

                    if (seatNumber > totalPaxCount) {

                        wait.until(ExpectedConditions.elementToBeClickable(seat));

                        seat.click();

                        ExtentLogger.attachScreenshotBase64();

                        gl.WaitForProfileLoad();

                        seatSelected = true;

                        break;
                    }
                }
            }

        } else {
            Assert.fail("Invalid seat type passed: " + seattype);
        }

        if (!seatSelected) {
            Assert.fail("No seat found matching criteria for: " + seattype);
        }

        // 🔥 MOST IMPORTANT FIX – WAIT FOR PRICE QUOTE BUTTON

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("md-backdrop.md-click-catcher")));

        WebElement priceQuote = wait.until(
                ExpectedConditions.elementToBeClickable(reservationPageObject.PRICE_QUOTE)
        );

        priceQuote.click();

        gl.WaitForProfileLoad();

        ExtentLogger.attachScreenshotBase64();

    } catch (Exception e) {

        ExtentLogger.fail("Select class of service step failed", e);

        throw new RuntimeException("SelectSeatFromClass failed", e);
    }
}

    public void SelectPriceOption(String option) {
        try {
            ExtentLogger.pass("I select Pricing option");

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

            gl.waitForLoaderToDisappear();

            // Open pricing dropdown
            wait.until(ExpectedConditions.elementToBeClickable(
                    reservationPageObject.PRICING_OPTION_DROPDOWN
            )).click();

            // Select option from Angular overlay
            WebElement pricingOption = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//md-option//div[normalize-space()='" + option.trim() + "']")));
            pricingOption.click();
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            reservationPageObject.NEXT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            reservationPageObject.NEXT_BUTTON.click();
            ExtentLogger.attachScreenshotBase64();
            gl.waitForLoaderToDisappear();


        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
            throw e;
        }
    }

    public void FillPassengerDetails() {
        ExtentLogger.pass("I fill the passenger details information");

        for (WebElement passegertype : reservationPageObject.PASSENGER_TYPE_IDENTIFICATION) {
            if (passegertype.getText().contains("ADT")) {
                passegertype.click();
                gl.WaitForProfileLoad();
                int i = 1;
                Map<String, String> passenger = generatePassenger(i, "ADULT");
                reservationPageObject.SUR_NAME.sendKeys(passenger.get("LAST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.FIRST_NAME.sendKeys(passenger.get("FIRST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.BIRTH_DATE.sendKeys(passenger.get("DOB"));
                gl.WaitForProfileLoad();
                String gender = passenger.get("GENDER");
                reservationPageObject.GENDER_DROP_DOWN.click();
                for (WebElement genderone : reservationPageObject.GENDER_OPTION) {
                    if (gender.contains(genderone.getText().trim())) {
                        gl.WaitForProfileLoad();
                        genderone.click();
                        gl.WaitForProfileLoad();
                        break;
                    }
                }
                if (!reservationPageObject.BOOK_FILEFARE_BUTTON.isEnabled()) {
                    gl.WaitForProfileLoad();
                    gl.ElementToBeClickable(reservationPageObject.EMAIL_ID);
                    reservationPageObject.EMAIL_ID.sendKeys("Sanmati.khot@gmail.com");
                    gl.WaitForProfileLoad();
                    reservationPageObject.PHONE_TYPE.click();
                    gl.WaitForProfileLoad();
                    for (WebElement type : reservationPageObject.TPYE_OF_PHONES) {
                        if (type.getText().contains("Home Phone")) {
                            type.click();
                            break;
                        }
                    }
                    gl.WaitForProfileLoad();
                    reservationPageObject.COUNTRY_CODE.sendKeys("US");
                    gl.waitForLoaderToDisappear();
                    reservationPageObject.COUNTRY_CODE.sendKeys(Keys.ENTER);
                    gl.WaitForProfileLoad();
                    reservationPageObject.PHONE_NUMBER.sendKeys("1234567890");
                    gl.WaitForProfileLoad();
                    ExtentLogger.attachScreenshotBase64();
                }
            } else if (passegertype.getText().contains("CHD")) {
                passegertype.click();
                gl.WaitForProfileLoad();
                int i = 1;
                Map<String, String> passenger = generatePassenger(i, "CHILD");
                reservationPageObject.SUR_NAME.sendKeys(passenger.get("LAST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.FIRST_NAME.sendKeys(passenger.get("FIRST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.BIRTH_DATE.sendKeys(passenger.get("DOB"));
                gl.WaitForProfileLoad();
                String gender = passenger.get("GENDER");
                reservationPageObject.GENDER_DROP_DOWN.click();
                for (WebElement genderone : reservationPageObject.GENDER_OPTION) {
                    if (gender.contains(genderone.getText().trim())) {
                        gl.WaitForProfileLoad();
                        genderone.click();
                        gl.WaitForProfileLoad();
                        break;
                    }
                }
                if (!reservationPageObject.BOOK_FILEFARE_BUTTON.isEnabled()) {
                    gl.WaitForProfileLoad();
                    gl.ElementToBeClickable(reservationPageObject.EMAIL_ID);
                    reservationPageObject.EMAIL_ID.sendKeys("Sanmati.khot@gmail.com");
                    gl.WaitForProfileLoad();
                    reservationPageObject.PHONE_TYPE.click();
                    gl.WaitForProfileLoad();
                    for (WebElement type : reservationPageObject.TPYE_OF_PHONES) {
                        if (type.getText().contains("Home Phone")) {
                            type.click();
                            break;
                        }
                    }
                    gl.WaitForProfileLoad();
                    reservationPageObject.COUNTRY_CODE.sendKeys("US");
                    gl.waitForLoaderToDisappear();
                    reservationPageObject.COUNTRY_CODE.sendKeys(Keys.ENTER);
                    gl.WaitForProfileLoad();
                    reservationPageObject.PHONE_NUMBER.sendKeys("1234567890");
                    gl.WaitForProfileLoad();
                    ExtentLogger.attachScreenshotBase64();
                }
            } else if (passegertype.getText().contains("INS")) {
                passegertype.click();
                gl.WaitForProfileLoad();
                int i = 1;
                Map<String, String> passenger = generatePassenger(i, "INS");
                reservationPageObject.SUR_NAME.sendKeys(passenger.get("LAST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.FIRST_NAME.sendKeys(passenger.get("FIRST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.BIRTH_DATE.sendKeys(passenger.get("DOB"));
                gl.WaitForProfileLoad();
                String gender = passenger.get("GENDER");
                reservationPageObject.GENDER_OPTION_INF.click();
                for (WebElement genderone : reservationPageObject.GENDER_OPTION) {
                    if (gender.contains(genderone.getText().trim())) {
                        gl.WaitForProfileLoad();
                        genderone.click();
                        gl.WaitForProfileLoad();
                        break;
                    }
                }
                gl.WaitForProfileLoad();
                ExtentLogger.attachScreenshotBase64();

            } else if (passegertype.getText().contains("INF")) {
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
                passegertype.click();
                gl.WaitForProfileLoad();
                int i = 1;
                Map<String, String> passenger = generatePassenger(i, "INFANT");
                reservationPageObject.SUR_NAME.sendKeys(passenger.get("LAST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.FIRST_NAME.sendKeys(passenger.get("FIRST_NAME"));
                gl.WaitForProfileLoad();
                reservationPageObject.BIRTH_DATE.sendKeys(passenger.get("DOB"));
                gl.WaitForProfileLoad();
                String gender = passenger.get("GENDER");
                reservationPageObject.GENDER_OPTION_INF.click();
                for (WebElement genderone : reservationPageObject.GENDER_OPTION) {
                    if (gender.contains(genderone.getText().trim())) {
                        gl.WaitForProfileLoad();
                        genderone.click();
                        gl.WaitForProfileLoad();
                        break;
                    }
                }
                wait.until(ExpectedConditions.elementToBeClickable(reservationPageObject.TRAVEL_WITH));
                reservationPageObject.TRAVEL_WITH.click();

                wait.until(ExpectedConditions.visibilityOfAllElements(reservationPageObject.TRAVEL_WITH_OPTION));

                for (WebElement option : reservationPageObject.TRAVEL_WITH_OPTION) {
                    option.click();
                    break;
                }
                gl.WaitForProfileLoad();
                ExtentLogger.attachScreenshotBase64();
            }
            reservationPageObject.BOOK_FILEFARE_BUTTON.click();
            gl.waitForLoaderToDisappear();
            ExtentLogger.attachScreenshotBase64();

        }

        String pnrText = reservationPageObject.PNR.getText().trim();
        passenger.set(PassengerData.PassengerKey.PNR, pnrText);
        String flight = reservationPageObject.FLIGHT_NUMBER.getText();
        String number = flight.replaceAll("\\D", "");
        passenger.set(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_NUMBER, number);
        String output = reservationPageObject.DATE_OF_JOURNEY.getText().trim();
        String date = java.time.LocalDate
                .parse(output, java.time.format.DateTimeFormatter.ofPattern("dd-MMM-yyyy"))
                .format(java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        passenger.set(PassengerData.PassengerKey.FIRST_SEG_FLIGHT_DATE, date);
        String origin = reservationPageObject.ORIGIN_CITY.getText().trim();
        passenger.set(PassengerData.PassengerKey.FIRST_SEG_ORIGIN_CITY, origin);
    }


    public void PerformPayment(String type) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            JavascriptExecutor js = (JavascriptExecutor) getDriver();

            ExtentLogger.pass("I perform Payment");

            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            gl.ElementToBeClickable(reservationPageObject.CHECK_OUT_BUTTON);
            reservationPageObject.CHECK_OUT_BUTTON.click();

            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();

            gl.ElementToBeClickable(reservationPageObject.PAYMENT_DROPDOWN);
            reservationPageObject.PAYMENT_DROPDOWN.click();

            // Wait for Angular overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".cdk-overlay-backdrop, .md-dialog-backdrop, .mat-overlay-backdrop")));

            wait.until(ExpectedConditions.visibilityOfAllElements(reservationPageObject.TYPE_OF_PAYMENT));

            for (WebElement payment : reservationPageObject.TYPE_OF_PAYMENT) {
                if (payment.getText().trim().equalsIgnoreCase(type)) {
                    js.executeScript("arguments[0].click();", payment);
                    break;
                }
            }

            gl.waitForLoaderToDisappear();
            ExtentLogger.attachScreenshotBase64();

            gl.ElementToBeClickable(reservationPageObject.PAY_BUTTON);
            js.executeScript("arguments[0].click();", reservationPageObject.PAY_BUTTON);

            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();

            gl.ElementToBeClickable(reservationPageObject.LANGUAGE_DROPDOWN);
            reservationPageObject.LANGUAGE_DROPDOWN.click();

            wait.until(ExpectedConditions.visibilityOfAllElements(reservationPageObject.LANGUAGE_TYPES));

            for (WebElement language : reservationPageObject.LANGUAGE_TYPES) {
                if (language.getText().trim().equalsIgnoreCase("ENGLISH")) {
                    js.executeScript("arguments[0].click();", language);
                    break;
                }
            }

            gl.waitForLoaderToDisappear();

            gl.ElementToBeClickable(reservationPageObject.EMAIL_BUTTON);
            ExtentLogger.attachScreenshotBase64();
            reservationPageObject.EMAIL_BUTTON.click();
            gl.waitForLoaderToDisappear();
            ExtentLogger.attachScreenshotBase64();

            gl.ElementToBeClickable(reservationPageObject.DONE_BUTTON);
            reservationPageObject.DONE_BUTTON.click();

            gl.waitForLoaderToDisappear();

            gl.ElementToBeClickable(homePageObjects.COPAAIRLINE_LOGO);
            ExtentLogger.attachScreenshotBase64();

        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
            throw e;
        }
    }


}

