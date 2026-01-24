package WebPages;

import Test_Base.Global_Constant;
import Test_Base.TestBase;

public class GUI_Page extends TestBase {


    public void launchURL(){
        getDriver().get(Global_Constant.URL);
    }
}
