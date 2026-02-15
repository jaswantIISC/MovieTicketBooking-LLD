import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import entity.Booking;
import entity.Movie;
import entity.PremiumSeat;
import entity.RegularSeat;
import entity.Screen;
import entity.Show;
import entity.Theatre;
import entity.User;
import service.BookingService;
import service.MovieService;
import service.ScreenService;
import service.SeatService;
import service.ShowService;
import service.TheatreService;
import strategy.lockMethods.InMemoryLockManager;
import strategy.lockMethods.LockManager;
import strategy.paymentMethods.CardPayment;
import strategy.paymentMethods.InvalidCardPayment;
import strategy.paymentMethods.UPIPayment;
import strategy.pricing.RegularPriceStrategy;

public class MovieTicketBookingDemo {

    public static void main(String[] args) {

        LockManager lockManager = new InMemoryLockManager();
        BookingService bookingService = new BookingService(lockManager);
        ScreenService screenService = new ScreenService();
        SeatService seatService = new SeatService();
        TheatreService theatreService = new TheatreService(screenService, seatService);
        MovieService movieService = new MovieService();
        ShowService showService = new ShowService();

        // Create Theatre
        Theatre inoxMGF = theatreService.createTheatre("T1_inox", "INOX MGF MG ROAD", "Gurugram");
        // create Screen
        Screen audi1 = new Screen("s1", "AUDI 1");
        // add screen to theatre T1_inox
        theatreService.addScreen(inoxMGF.getId(), audi1);

        // add regular seats
        RegularSeat seatA1 = new RegularSeat("A", 1, 300);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatA1);
        RegularSeat seatA2 = new RegularSeat("A", 2, 300);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatA2);
        RegularSeat seatA3 = new RegularSeat("A", 3, 300);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatA3);
        RegularSeat seatA4 = new RegularSeat("A", 4, 300);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatA4);
        RegularSeat seatA5 = new RegularSeat("A", 5, 300);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatA5);

        // add Premium seats
        PremiumSeat seatB1 = new PremiumSeat("B", 1, 400);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatB1);
        PremiumSeat seatB2 = new PremiumSeat("B", 2, 500);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatB2);
        PremiumSeat seatB3 = new PremiumSeat("B", 3, 400);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatB3);
        PremiumSeat seatB4 = new PremiumSeat("B", 4, 400);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatB4);
        PremiumSeat seatB5 = new PremiumSeat("B", 5, 400);
        theatreService.addSeat(inoxMGF.getId(), audi1.getId(), seatB5);

        // add Movie
        Movie movie1 = movieService.createMovie("M1", "Mardani3", 180, "Hindi", "Drama");
        Movie movie2 = movieService.createMovie("M1", "Border2", 180, "Hindi", "Drama");

        // create show
        Show show1 = showService.createShow("show1", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(4),
                movie1, inoxMGF, audi1, new RegularPriceStrategy());
        Show show2 = showService.createShow("show1", LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(8),
                movie1, inoxMGF, audi1, new RegularPriceStrategy());

        // user find movie mardani in
        List<Show> showsList = showService.findAllShowsForMovie("Mardani3", "Gurugram");

        // Demo 1: search for all shows running movie Mardani3 in Gurugram
        System.out.println("****** Demo 1: search for all shows running movie Mardani3 in Gurugram *****");

        for (Show show : showsList) {
            System.out.println(show.toString());
        }
        
        System.out.println();
        // Demo 2: user try to book a seat
        System.out.println("****** Demo 2: user try to book a seat *****");
        User user1 = new User("jaswant@gmail.com", "Jaswant Meena");
    
        Booking user1booking = bookingService.reserveBooking(user1.getId(), show1, Set.of(seatB1.getId(), seatB2.getId()));
        System.out.println("user1 has reserved the seat for show = "+ user1booking.toString());
        System.out.println("user1 is confirming the booking");
        bookingService.confirmBooking(user1booking, new UPIPayment());

        System.out.println();
        // Demo 3: user try to book a seat
        System.out.println("****** Demo 3: user try to book a seat *****");
        User user2 = new User("mahi@gmail.com", "Mahi");
    
        Booking user2booking = bookingService.reserveBooking(user2.getId(), show1, Set.of(seatA1.getId(), seatA2.getId()));
        System.out.println("user2 has reserved the seat for show = "+ user2booking.toString());
        System.out.println("user2 is confirming the booking with INALID CARD ");
        bookingService.confirmBooking(user2booking, new InvalidCardPayment());

        System.out.println();

    }

}
