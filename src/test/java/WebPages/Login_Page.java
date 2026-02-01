package WebPages;

import GUI.ReportSection.ExtentLogger;
import GUI.Test_Base.Generic;
import GUI.Test_Base.Global_Constant;
import GUI.Test_Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_Page extends TestBase {

    Login_Page.LoginPageObjects loginPageObjects;
    Generic gl;
    Home_Page.HomePageObjects homePageObjects;
    Home_Page homePage;

    public Login_Page() {
        loginPageObjects = new LoginPageObjects();
        gl = new Generic();
        homePageObjects = new Home_Page.HomePageObjects();
        homePage = new Home_Page();
        PageFactory.initElements(getDriver(), loginPageObjects);
        PageFactory.initElements(getDriver(), homePageObjects);
    }

    static class LoginPageObjects {

        @FindBy(xpath = "//input[@placeholder='User ID']")
        public WebElement User_ID;

        @FindBy(xpath = "//input[@placeholder='Password']")
        public WebElement Password;

        @FindBy(xpath = "//input[@name='submit']")
        public WebElement Login;


    }

    public void launchURL() {
        getDriver().get(Global_Constant.URL);
    }

    public void iPerformLogin() {
        try {
            ExtentLogger.pass("I am entering user Id");
            loginPageObjects.User_ID.sendKeys(Global_Constant.USER_ID);
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();
            ExtentLogger.pass("I enter user and password");
            loginPageObjects.Password.sendKeys(Global_Constant.PASSWORD);
            ExtentLogger.attachScreenshotBase64();
            gl.WaitForProfileLoad();
            gl.ClickElement(loginPageObjects.Login);
            gl.WaitForProfileLoad();


        } catch (Exception e) {
            ExtentLogger.fail("Step failed", e);
        }
}
}
