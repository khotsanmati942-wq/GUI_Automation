package GUI.Test_Base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generic extends TestBase {

    WebDriverWait wait;

    public void WaitForProfileLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void ElementToBeClickable(By locator) {
       wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void ElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void ClickElement(WebElement element){
        element.click();
    }

    public void waitForLoaderToDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(120));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".loading-wrapper")
            ));
        } catch (TimeoutException e) {
            System.out.println("Loader did not disappear within timeout, continuing...");
        }
    }

    public static String getDateFromOffset(String offset) {
        String numericValue = offset.replaceAll("[^0-9]", "");
        if (numericValue.isEmpty()) {
            throw new IllegalArgumentException("Invalid date offset: " + offset);
        }
        int days = Integer.parseInt(numericValue);
        LocalDate targetDate = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return targetDate.format(formatter);
    }


    public static String getRandomName() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(chars.charAt((int) (Math.random() * chars.length())));
        }
        name.append(" ");
        for (int i = 0; i < 5; i++) {
            name.append(chars.charAt((int) (Math.random() * chars.length())));
        }
        return name.toString();
    }

    public static String getDOB(String passengerType) {

        if (passengerType == null) {
            throw new IllegalArgumentException("Passenger type cannot be null");
        }

        LocalDate dob;
        LocalDate today = LocalDate.now();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        switch (passengerType.trim().toUpperCase()) {

            case "ADULT":
                // 25–60 years
                dob = today.minusYears(random.nextInt(25, 60))
                        .minusDays(random.nextInt(1, 365));
                break;

            case "CHILD":
                // 2–11 years
                dob = today.minusYears(random.nextInt(2, 12))
                        .minusDays(random.nextInt(1, 365));
                break;

            case "INFANT":
                // 0–23 months
                dob = today.minusMonths(random.nextInt(1, 24))
                        .minusDays(random.nextInt(0, 28));
                break;

            case "INS":
                // 12–23 months
                dob = today.minusMonths(random.nextInt(12, 24))
                        .minusDays(random.nextInt(0, 28));
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported passenger type: " + passengerType
                );
        }

        return dob.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
    }

    public static Map<String, String> generatePassenger(
            int countIndex, String passengerType) {
        Map<String, String> passenger = new HashMap<>();
        String[] name = getRandomName().split(" ");
        passenger.put("FIRST_NAME", name[0]);
        passenger.put("LAST_NAME", name[1]);
        passenger.put("DOB", getDOB(passengerType));
        String gender;
        switch (passengerType.trim().toUpperCase()) {
            case "ADULT":
                case "CHILD":
                    gender = Math.random() < 0.5 ? "Male" : "Female";
                    break;

            case "INFANT":
                gender = "Male";
                break;

            case "INS":
                gender = "Female";
                break;

            default:

                throw new IllegalArgumentException("Invalid passenger type");

        }
        passenger.put("GENDER", gender);
        passenger.put("TYPE", passengerType.toUpperCase());
        passenger.put("INDEX", String.valueOf(countIndex));
        return passenger;

    }


    public String getRandomPassengerName() {
        String lastName = getRandomString(3);
        String firstName = getRandomString(4);
        return "-"+ lastName + "/" + firstName;
    }

    private static String getRandomString(int length) {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(alphabets.charAt(random.nextInt(alphabets.length())));
        }
        return sb.toString();
    }

}









