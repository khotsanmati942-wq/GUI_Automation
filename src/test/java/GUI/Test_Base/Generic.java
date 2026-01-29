package GUI.Test_Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
       wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void ElementToBeClickable(WebElement element) {
        wait = new WebDriverWait(getDriver(), 30);
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
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loading-wrapper")
        ));
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

}






