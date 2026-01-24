package stepdefinitions;

import Test_Base.Global_Constant;
import Test_Base.TestBase;
import io.cucumber.java.en.Given;

public class GUI_Stepdefination  extends TestBase {

    @Given("I navigate to the URL")
    public void i_navigate_to_the_url() {
        getDriver().get(Global_Constant.URL);
    }
}
