package WebPages;

public class PageManager {

    Login_Page loginPage;
    Home_Page homePage;
    Reservation_Page reservationPage;

    public Login_Page getLoginPage() {
        if (loginPage == null) {
            loginPage = new Login_Page();
        }
            return loginPage;
        }

        public  Home_Page getHomePage() {
            if (homePage == null) {
                homePage = new Home_Page();
            }
            return  homePage;

        }
        public Reservation_Page getReservationPage(){
        if (reservationPage ==null) {
            reservationPage = new Reservation_Page();
        }
        return reservationPage;
        }
        }


