package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.PassengerData;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Native_Shares extends TestBase {
    Native_Shares.Native_shares_object nativeSharesObject;
    Generic gl;
    Reservation_Page.ReservationPageObject reservationPageObject;

    public Native_Shares(){
        nativeSharesObject = new Native_shares_object();
        gl = new Generic();
        reservationPageObject = new Reservation_Page.ReservationPageObject();
        PageFactory.initElements(getDriver(), nativeSharesObject);
        PageFactory.initElements(getDriver(), reservationPageObject);

    }


    public class Native_shares_object{

        @FindBy(xpath = "//i[@class='icon-tools']")
        public WebElement TOOL_MENU;

        @FindBy(xpath = "//div[normalize-space()='Native SHARES']")
        public WebElement NATIVE_SHARES;

        @FindBy(xpath = "//textarea")
        public WebElement INPUT_TEXT_AREA;

        @FindBy(xpath = "//button[normalize-space()='Submit']")
        public WebElement SUBMIT_BUTTON;

        @FindBy(xpath = "//button[normalize-space()='Clear All']")
        public WebElement CLEAR_ALL;

        @FindBy(xpath = "//button[normalize-space()='Cancel']")
        public WebElement CANCEL_BUTTON;

        @FindBy(xpath = "//pre[contains(@class,'ng-binding')]")
        public List<WebElement> AVAILABITY_DISPLAY;

        @FindBy(xpath = "(//pre)[2]")
        public WebElement NATIVESHARES_PNR;

        @FindBy(xpath = "(//input[contains(@form-validate,'GLOBAL-SEARCH-PATTERNS')])[2]")
        public WebElement SEARCH_ORDER;

        @FindBy(xpath = "//button[contains(@ng-click,'itinerary.stateChange')]")
        public  WebElement SEARCH_BUTTON;
    }

     public void ClickOnToolMenu() {
         try {
             ExtentLogger.pass("I click on tool menu");
             gl.WaitForProfileLoad();
             nativeSharesObject.TOOL_MENU.click();
             gl.WaitForProfileLoad();
             ExtentLogger.attachScreenshotBase64();
         } catch (Exception e) {
             ExtentLogger.fail("Step failed", e);
         }

     }

     public void ClickOnNativeShares(){
        try{
            ExtentLogger.pass("I Click on native shares");
            gl.WaitForProfileLoad();
            nativeSharesObject.NATIVE_SHARES.click();
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }

     }

    public void CreatePNRInNativeShares(String origin, String destination, String date) {
        try {
            ExtentLogger.pass("I create a PNR in Native Shares");
            gl.WaitForProfileLoad();
            int days = Integer.parseInt(date.replaceAll("\\D", ""));
            LocalDate travelDate = LocalDate.now().plusDays(days);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMM", Locale.ENGLISH);
            String formattedDate = travelDate.format(formatter).toUpperCase();
            String availabilityEntry = "A " + origin + destination + " " + formattedDate + " ";
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys(availabilityEntry);
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            ExtentLogger.attachScreenshotBase64();

        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

    public void CreateItinaryinShares(int passengerCount, String cos) {

        int counter = 0;

        for (WebElement row : nativeSharesObject.AVAILABITY_DISPLAY) {

            String input = row.getText();

            // 1️⃣ First position must be numeric
            if (input == null || input.isEmpty() || !Character.isDigit(input.charAt(0))) {
                continue;
            }

            // 2️⃣ Carrier code check
            String carrierCode = input.substring(1, 3);
            if (!(carrierCode.equals("CM") ||
                    carrierCode.equals("UA") ||
                    carrierCode.equals("AA"))) {
                continue;
            }

            // 3️⃣ Check class of service availability
            Pattern pattern = Pattern.compile(cos + "(\\d+)");
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                continue; // COS not present → next row
            }

            int availableSeats = Integer.parseInt(matcher.group(1));

            // 4️⃣ Availability vs passenger count
            if (availableSeats > passengerCount) {
                counter++;   // valid row found
                break;       // stop at first valid row
            }
        }

        // 5️⃣ Build final command
        if (counter == 0) {
            throw new RuntimeException("No valid availability found");
        }

       String itinaryEntry = "N" + passengerCount + cos + counter;

        nativeSharesObject.INPUT_TEXT_AREA.sendKeys(itinaryEntry);
        gl.WaitForProfileLoad();
        ExtentLogger.attachScreenshotBase64();
        gl.WaitForProfileLoad();
        nativeSharesObject.SUBMIT_BUTTON.click();
        gl.waitForLoaderToDisappear();
        ExtentLogger.attachScreenshotBase64();

    }

    public void CreatePNRInNativeSharesUsingPassengerDetails(){
        try{
            ExtentLogger.pass("I Create a PNR in Native Shares Using Passenger Details");
            String passengerName = gl.getRandomPassengerName();
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys(passengerName);
            gl.WaitForProfileLoad();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys("9PTY123456789/H");
            gl.WaitForProfileLoad();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys("6P");
            gl.WaitForProfileLoad();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys("7T/");
            gl.WaitForProfileLoad();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            nativeSharesObject.CLEAR_ALL.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            nativeSharesObject.INPUT_TEXT_AREA.sendKeys("ER");
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();
            nativeSharesObject.SUBMIT_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            String pnr = nativeSharesObject.NATIVESHARES_PNR.getText();
            if (pnr == null || pnr.isEmpty()) {
                throw new RuntimeException("Order Number is NULL or EMPTY. Cannot search in Check-in.");
            }
            passenger.set(PassengerData.PassengerKey.NATIVE_SHARES_PNR, pnr);
            gl.WaitForProfileLoad();
            nativeSharesObject.CANCEL_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();

    } catch (Exception e) {
        ExtentLogger.fail("Step failed", e);
    }
    }

    public void NativePNRInGUI() {
        try {
            ExtentLogger.pass("I retrive a PNR From Native shares in GUI");
            gl.WaitForProfileLoad();
            nativeSharesObject.SEARCH_ORDER.sendKeys(passenger.getString(PassengerData.PassengerKey.NATIVE_SHARES_PNR));
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();
            nativeSharesObject.SEARCH_BUTTON.click();
            gl.waitForLoaderToDisappear();
            gl.WaitForProfileLoad();
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();

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

        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
    }

}


