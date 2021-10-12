import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author
 *
 */
public class Main_20420286 {

	public static void main(String[] args) throws ParseException {
		// processing files and storing related data in respective array lists
		ArrayList<Customer_20420286> customers = Helper.readInitialDataFromFile("Customers.txt");
		ArrayList<Service_20420286> services = Helper.readInitialDataFromFile("Services.txt");
		Scanner input = new Scanner(System.in);
		int choice = 0;
		// if choice becomes 3 but not from main menu
		boolean isMainMenuDisplayed = false;

		while (choice != 3 || !isMainMenuDisplayed) {
			System.out.println("1. Display Bookings");
			System.out.println("2. Make a Bookings");
			System.out.println("3. Exit program");
			System.out.print("Your input: ");
			choice = input.nextInt();

			switch (choice) {
			case 1:

				ArrayList<Booking_20420286> bookings = Helper.getBookingsList(Helper.getFormattedDate(null));
				outer: while (choice != 4) {
					Helper.printBookingsOfDate(bookings, customers);
					System.out.println("\n1. Display Booking Detail");
					System.out.println("2. Change Display Day");
					System.out.println("3. Set Fee");
					System.out.println("4. Exit Sub-Menu");
					System.out.print("Your input: ");
					choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.print("Enter Chosen booking ID: ");
						int bookingID = input.nextInt();
						Booking_20420286 booking = Helper.getBookingbyId(bookings, bookingID);
						if (booking != null) {
							Helper.printFormattedBookingData(booking, services, customers);
						} else {
							System.out.println("No any booking with this id!.. try again");
						}
						break;
					case 2:
						System.out.print("Enter the new date(dd/MM/YYYY): ");
						String newDate = input.next();
						bookings = Helper.getBookingsList(Helper.getFormattedDate(newDate));
						break;
					case 3:
						System.out.print("Enter Chosen booking ID: ");
						bookingID = input.nextInt();
						booking = Helper.getBookingbyId(bookings, bookingID);

						System.out.print("Enter fee to set for booking: ");
						float bookingFee = input.nextFloat();
						float totalFee = booking.calculateTotalPrice(services);
						// 10% discount
						float discountedPrice = (float) (totalFee - (totalFee * 0.1));
						if (bookingFee <= discountedPrice) {
							booking.setTotalPrice(bookingFee);
							Helper.writeBookingToFile(booking,
									"bookings-" + Helper.getFormattedDate(booking.getBookingDate()) + ".txt");
						} else {
							System.out.println("\nBooking fee is invalid!");
						}
						break;
					case 4:
						// exiting from sub-menu
						System.out.println("\n");
						break outer;
					default:
						System.out.println("Invalid choice!\n");
						break;
					}
				}

				break;
			case 2:
				outer: while (choice != 3) {
					System.out.println("\n1. By Phone Number");
					System.out.println("2. By Surname");
					System.out.println("3. Exit Sub-Menu");
					System.out.print("Your input: ");
					choice = input.nextInt();

					switch (choice) {
					case 1:
						// by phone number
						System.out.print("\nEnter customer phone number: ");
						String phoneNumber = input.next();
						Customer_20420286 matchingCustomer = Helper.findCustomerWithPhoneNumber(phoneNumber, customers);
						// if some one matched with phone number inputted
						if (matchingCustomer != null) {
							bookings = processBooking(services, matchingCustomer);
						} else {
							System.out.println("No customer with this phone number!\n");
						}
						break;
					case 2:
						// by surname
						System.out.print("Enter customer surname: ");
						String surname = input.next();
						ArrayList<Customer_20420286> customersFound = new ArrayList<>();
						for (int i = 0; i < customers.size(); i++) {
							Customer_20420286 customer = customers.get(i);
							if (customer.getSurname().equalsIgnoreCase(surname)) {
								customersFound.add(customer);
							}
						}
						if (customersFound.size() > 0) {
							int totalCustomersFound = customersFound.size();
							Customer_20420286 chosenCustomer = null;
							// if more than one customers with same surname name then select any one
							if (customersFound.size() > 1) {
								for (int i = 0; i < totalCustomersFound; i++) {
									Customer_20420286 customer = customersFound.get(i);
									System.out.println((i + 1) + ". " + customer.customerOnSingleLine());
								}
								System.out.print("Your input(1-" + totalCustomersFound + "): ");
								choice = input.nextInt();
								if (choice <= totalCustomersFound)
									chosenCustomer = customersFound.get(choice - 1);
							}
							// customer chosen will be null when user input was incorrect while selecting
							// choice from list of customers found
							if (chosenCustomer != null) {
								/*
								 * process further booking operations i.e checking bookings,generating new
								 * booking storing booking in arraylist,writing to the file etc
								 */
								bookings = processBooking(services, chosenCustomer);

							} else {
								System.out.println("Invalid choice!\n");
							}

						} else {
							System.out.println("No customer found with this surname!\n");
						}
						break;
					case 3:
						// exiting from sub-menu
						System.out.println("\n");
						break outer;

					default:
						System.out.println("Invalid choice!\n");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Program terminated...THANK YOU for using our services.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!.. try again\n");
				break;
			}
		}

	}

	public static ArrayList<Booking_20420286> processBooking(ArrayList<Service_20420286> services,
			Customer_20420286 chosenCustomer) throws ParseException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the date(dd/MM/YYYY) for making a booking: ");
		String date = input.next();
		ArrayList<Booking_20420286> bookings = Helper.getBookingsList(Helper.getFormattedDate(date)); // if bookings are
		// available
		if (!bookings.isEmpty()) {
			Helper.printAllServices(services);
			System.out.println("Which services are required?(1-" + services.size() + ") use comma separated list:");
			String requiredServices = input.next();
			String[] serviceNumbers = requiredServices.split(",");

			Booking_20420286 booking = Helper.processBooking(serviceNumbers, services);
			booking.setCustomerID(chosenCustomer.getID());
			booking.setBookingDate(date);

			Helper.writeBookingToFile(booking,
					"bookings-" + Helper.getFormattedDate(booking.getBookingDate()) + ".txt");
		}
		return bookings;

	}

}
