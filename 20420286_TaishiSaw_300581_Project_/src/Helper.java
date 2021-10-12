import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Helper {
	public static ArrayList readInitialDataFromFile(String fileName) {
		try {
			File file = new File(fileName);
			ArrayList list = null;
			while (!file.exists()) {
				System.out.println("File '" + fileName
						+ "' does not exists...enter correct file name or path or type 'e' to exit: ");
				fileName = new Scanner(System.in).nextLine();
				if (fileName.equalsIgnoreCase("e"))
					System.exit(0);
				if (!fileName.contains(".txt"))
					fileName += ".txt";
				file = new File(fileName);

			} // while ended
			switch (fileName) {
			case "Services.txt":
				list = new ArrayList<Service_20420286>();
			case "Customers.txt":
				list = new ArrayList<Customer_20420286>();
				break;
			default:
				list = new ArrayList();
			}
			// reading file line by line using scanner
			Scanner readFile = new Scanner(file);
			while (readFile.hasNextLine()) {
				String currentLine = readFile.nextLine();
				String[] attributes = currentLine.split(",");
				// i.e if we are reading Customers.txt file
				if (attributes.length > 4) {
					int id = Integer.parseInt(attributes[0]);
					String surname = attributes[1];
					String firstName = attributes[2];
					String phoneNumber = attributes[3];
					String address = attributes[4];
					String suburb = attributes[5];
					String postcode = attributes[6];

					Customer_20420286 customer = new Customer_20420286(id, surname, firstName, address, suburb,
							postcode, phoneNumber);
					list.add(customer);
				}
				// i.e if we are reading Services.txt file
				else {
					int code = Integer.parseInt(attributes[0]);
					String name = attributes[1];
					String description = attributes[2];
					float price;
					try {
						price = Float.parseFloat(attributes[3]);
					} catch (Exception e) {
						price = 0;
					}

					Service_20420286 service = new Service_20420286(code, name, description, price);
					list.add(service);
				}

			}
			// return the arraylist
			return list;
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ArrayList();
		}
	}

	public static ArrayList<Booking_20420286> getBookingsList(String currentDate) {
		String fileName = "bookings-" + currentDate + ".txt";
		File file = new File(fileName);
		ArrayList<Booking_20420286> bookingsList = new ArrayList<>();
		try {
			if (file.exists()) {
				Scanner readFile = new Scanner(file);
				while (readFile.hasNextLine()) {
					String currentLine = readFile.nextLine();
					String[] attributes = currentLine.split(",");

					int bookingID = Integer.parseInt(attributes[0]);
					int customerID = Integer.parseInt(attributes[1]);
					String date = attributes[2];
					float totalFee;
					try {
						totalFee = Float.parseFloat(attributes[3]);
					} catch (Exception e) {
						totalFee = 0;
					}
					ArrayList<Integer> serviceCodes = new ArrayList<>();
					for (int i = 4; i < attributes.length; i++) {
						serviceCodes.add(Integer.parseInt(attributes[i]));
					}
					Booking_20420286 booking = new Booking_20420286(bookingID, customerID, serviceCodes, totalFee,
							date);
					bookingsList.add(booking);
				}

			} else {
				System.out.println("No bookings available for the specified date!\n");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return bookingsList;
	}

	public static Customer_20420286 getCustomerbyId(ArrayList<Customer_20420286> list, int customerId) {
		for (int i = 0; i < list.size(); i++) {
			Customer_20420286 customer = list.get(i);
			if (customer.getID() == customerId)
				return customer;
		}
		return null;
	}

	public static Service_20420286 getServicesbyCode(ArrayList<Service_20420286> list, int serviceCode) {
		for (int i = 0; i < list.size(); i++) {
			Service_20420286 service = list.get(i);
			if (service.getCode() == serviceCode)
				return service;
		}
		return null;
	}

	public static Booking_20420286 getBookingbyId(ArrayList<Booking_20420286> list, int bookingID) {
		for (int i = 0; i < list.size(); i++) {
			Booking_20420286 booking = list.get(i);
			if (booking.getBookingID() == bookingID)
				return booking;
		}
		return null;
	}

	public static void printBookingsOfDate(ArrayList<Booking_20420286> bookings,
			ArrayList<Customer_20420286> customers) {
		System.out.println("\nDate\t\t\tBooking ID\tCustomer ID\tCustomer Surname\t\tServices Code(s)");
		for (int i = 0; i < bookings.size(); i++) {
			Booking_20420286 booking = bookings.get(i);
			System.out.println(booking.getBookingDate() + "\t\t" + booking.getBookingID() + "\t\t" + booking.customerID
					+ "\t\t" + getCustomerbyId(customers, booking.getCustomerID()).getSurname() + "\t\t\t"
					+ booking.getServicesCodesAsString());
		}
	}

	public static void printFormattedBookingData(Booking_20420286 booking, ArrayList<Service_20420286> services,
			ArrayList<Customer_20420286> customers) {
		Customer_20420286 customer = getCustomerbyId(customers, booking.getCustomerID());
		String servicesCodes = booking.getServicesCodesAsString();
		String servicesNames = booking.getServicesNamesAsString(services);
		String servicesPrices = booking.getServicesPricesAsString(services);
		System.out.printf("%-12s%-15s%-15s%-20s%-30s\n", "Date", "Booking ID", "Customer ID", "Customer Surname",
				"Customer Address", "Service Code(s)");
		System.out.printf("%-12s%-15s%-15s%-20s%-30s\n\n", booking.getBookingDate(), booking.bookingID + "",
				customer.getID() + "", customer.getSurname(), customer.getStreetAddress() + " " + customer.getSuburb(),
				servicesCodes);
		System.out.printf("%-" + (servicesNames.length() + 5) + "s%-" + (servicesPrices.length() + 15) + "s%-20s\n",
				"Service Name(s)", "Services Price(s)", "Total Fee");
		System.out.printf("%-" + (servicesNames.length() + 5) + "s%-" + (servicesPrices.length() + 15) + "s%-20s\n",
				servicesNames, servicesPrices, booking.calculateTotalPrice(services) + "\n\n");

	}

	public static String getFormattedDate(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (dateString == null)
			date = new Date();
		else {
			String[] dateParts = dateString.split("/");
			int day = Integer.parseInt(dateParts[0]);
			int month = Integer.parseInt(dateParts[1]);
			int year = Integer.parseInt(dateParts[2]);
			dateString = year + "-" + month + "-" + day;
			date = dateFormat.parse(dateString);
		}
		return dateFormat.format(date);
	}

	public static void writeBookingToFile(Booking_20420286 booking, String fileName) {
		try {
			File file = new File(fileName);
			FileWriter writeToFile = new FileWriter(file, true);
			writeToFile.append(booking.getBookingID() + "," + booking.getCustomerID() + "," + booking.getBookingDate()
					+ "," + booking.totalPrice + "," + booking.getServicesCodesAsString() + "\n");

			writeToFile.close();
			System.out.println("\nBooking written to the file successfully.\n");
		} catch (Exception e) {

			System.out.println("Exception: " + e.getMessage());
		}
	}
	public static void printAllServices(ArrayList<Service_20420286> services) {
		for (int i = 0; i < services.size(); i++) {
			Service_20420286 service = services.get(i);
			System.out.println((i + 1) + ". " + service.getName());
		}
	}
	public static Booking_20420286 processBooking(String[] serviceNumbers, ArrayList<Service_20420286> services) {
		ArrayList<Integer> requiredServicesCodes = new ArrayList<>();
		ArrayList<Service_20420286> requiredServicesList = new ArrayList<>();
		for (int i = 0; i < serviceNumbers.length; i++) {
			int servicesIndexNumber = Integer.parseInt(serviceNumbers[i]) - 1;
			Service_20420286 service = services.get(servicesIndexNumber);
			int serviceCode = service.getCode();
			requiredServicesCodes.add(serviceCode);
			requiredServicesList.add(service);

		}
		Booking_20420286 booking = new Booking_20420286(new Random().nextInt(100) + 90350, 0, requiredServicesCodes, 0,
				"");
		// calculating totalPrice
		float totalPriceForBooking = booking.calculateTotalPrice(requiredServicesList);
		booking.setTotalPrice(totalPriceForBooking);
		return booking;
	}
	public static Customer_20420286 findCustomerWithPhoneNumber(String phoneNumber,
			ArrayList<Customer_20420286> customers) {
		for (int i = 0; i < customers.size(); i++) {
			Customer_20420286 customer = customers.get(i);
			if (customer.getPhoneNumber().equals(phoneNumber)) {
				return customer;
			}
		}
		return null;
	}
}
