package WebPages;

public class PageManager {

    Login_Page loginPage;
    Home_Page homePage;
    Reservation_Page reservationPage;
    Chcekin_Page chcekinPage;
    Gate_Page gatePage;
    Native_Shares nativeShares;

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

        public Chcekin_Page getChcekinPage(){
        if (chcekinPage == null){
            chcekinPage = new Chcekin_Page();
        }
        return chcekinPage;
        }


    public Gate_Page getGatePage(){
        if (gatePage == null){
            gatePage = new Gate_Page();
        }
        return gatePage;
    }

    public Native_Shares getNativePage(){
        if(nativeShares == null) {
            nativeShares = new Native_Shares();
        }
        return nativeShares;
        }
    }





