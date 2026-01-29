package GUI.StepDefination;

import WebPages.Home_Page;
import WebPages.Login_Page;
import WebPages.PageManager;
import WebPages.Reservation_Page;

public class StepManager {


   protected Login_Page loginPage;
  protected  Home_Page homePage;
  protected Reservation_Page reservationPage;

    public StepManager(PageManager pom) {
        this.loginPage = pom.getLoginPage();
        this.homePage = pom.getHomePage();
        this.reservationPage = pom.getReservationPage();

    }
}
