package GUI.StepDefination;

import WebPages.*;

public class StepManager {


   protected Login_Page loginPage;
  protected  Home_Page homePage;
  protected Reservation_Page reservationPage;
  protected Chcekin_Page chcekinPage;
  protected Gate_Page gatePage;
  protected Native_Shares nativeShares;

    public StepManager(PageManager pom) {
        this.loginPage = pom.getLoginPage();
        this.homePage = pom.getHomePage();
        this.reservationPage = pom.getReservationPage();
        this.chcekinPage = pom.getChcekinPage();
        this.gatePage = pom.getGatePage();
        this.nativeShares = pom.getNativePage();

    }
}
