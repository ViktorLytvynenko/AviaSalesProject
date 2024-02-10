package org.aviasales;

import org.aviasales.Controllers.BookingsController;
import org.aviasales.Controllers.FlightsController;
import org.aviasales.Services.FlightsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OnlinePanelOperations {
    public static void chooseMenu() throws ParseException {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        BookingsController bookingsController = new BookingsController();
        flightsController.setAllFlights(FileManager.loadFlightsData());
        bookingsController.setAllBookings(FileManager.loadBookingsData());
//        RandomGenerator randomGenerator = new RandomGenerator();
//        FileManager.writeData(randomGenerator.randomGenerator());

        while (true) {
            OnlinePanel.showOnlinePanel();
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    flightsController.displayAllFlightsFor24Hours();
                    OnlinePanelOperations.chooseMenu();
                    break;
                case "2":
                    System.out.println("Enter please flight ID");
                    int menuItem2 = in.nextInt();
                    in.nextLine();
                    System.out.println(flightsController.getFlightById(menuItem2));
                    break;
                case "3":
                    System.out.println("Write please departure city");
                    String pointA = in.nextLine();
                    System.out.println("Write please destination city");
                    String pointB = in.nextLine();
                    System.out.println("Write please date");
                    System.out.println("Write please day");
                    String day = in.nextLine();
                    System.out.println("Write please month");
                    String month = in.nextLine();
                    System.out.println("Write please year");
                    String year = in.nextLine();
                    String date = day + "/" + month + "/" + year;
                    System.out.println("Write please passengers quantity");
                    int passengers = in.nextInt();
                    in.nextLine();
                    boolean flightsFound = flightsController.findReqFlights(pointA, pointB, date, passengers);
                    if (flightsFound) {
                        System.out.println("Please enter the flight ID or enter '0' to return to the previous menu");
                        int choice = in.nextInt();
                        in.nextLine();
                        if (choice == 0) {
                            break;
                        } else {
                            System.out.println("Loading information for flight ID " + choice);

                            System.out.println(flightsController.getFlightById(choice));
                            System.out.println("Would you like to make a reservation? Yes/No");
                            String reservation = in.nextLine().toLowerCase();
                            if (reservation.equals("yes")) {
                                Set<Human> humans = new LinkedHashSet<>();
                                int counter = 0;
                                while (!(passengers == 0)) {
                                    counter++;
                                    System.out.println("Write please information about passenger №" + counter);
                                    System.out.println("Write please Name");
                                    String name = in.nextLine();
                                    System.out.println("Write please Surname");
                                    String surname = in.nextLine();
                                    System.out.println("Write please Gender. Man/Woman");
                                    String gender = in.nextLine().toLowerCase();
                                    while (!(gender.equals("man") || gender.equals("woman"))) {
                                        System.out.println("Write please Gender. Man/Woman");
                                        gender = in.nextLine().toLowerCase();
                                    }

                                    Human human = new Human(name, surname, gender);
                                    humans.add(human);

                                    passengers--;
                                }
                                Booking booking = new Booking(bookingsController.generateID(), flightsController.getFlightById(choice), humans);
                                bookingsController.saveBooking(booking);
                                System.out.println("You have successfully booked tickets");
                                break;

                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("No flights for request params");
                        break;
                    }
                case "4":
                case "5":
                case "6":
                case "exit":
                    FileManager.writeFlightsData(flightsController.getAllFlights());
                    FileManager.writeBookingsData(bookingsController.getAllBookings());
                    System.out.println("Thanks for choosing us!");
                    return;

                default:
            }
        }
    }
}
