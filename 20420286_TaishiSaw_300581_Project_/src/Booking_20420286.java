import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */

/**
 * @author
 *
 */
public class Booking_20420286 {
	int bookingID;
	int customerID;
	ArrayList<Integer> serviceCodes;
	float totalPrice;
	String bookingDate;

	public Booking_20420286() {
	}

	public Booking_20420286(int bookingID, int customerID, ArrayList<Integer> serviceCodesList, float totalPrice,
			String bookingDate) {
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.serviceCodes = serviceCodesList;
		this.totalPrice = totalPrice;
		this.bookingDate = bookingDate;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int identificationNumber) {
		this.bookingID = identificationNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public ArrayList<Integer> getServiceCodesList() {
		return serviceCodes;
	}

	public void setServiceCodesList(ArrayList<Integer> serviceCodesList) {
		this.serviceCodes = serviceCodesList;
	}

	public float calculateTotalPrice(ArrayList<Service_20420286> services) {
		if (totalPrice == 0) {
			totalPrice = calculatePrice(services);
		}
		return totalPrice;
	}

	private float calculatePrice(ArrayList<Service_20420286> services) {
		float totalFee = 0;
		for (int i = 0; i < serviceCodes.size(); i++) {
			int serviceCode = serviceCodes.get(i);
			for (int j = 0; j < services.size(); j++) {
				Service_20420286 service = services.get(j);
				if (serviceCode == service.getCode()) {
					totalFee += service.getPrice();
					break;
				}
			}
		}
		return totalFee;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getFomattedDate() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(bookingDate);
	}

	@Override
	public String toString() {
		return bookingDate + "\t\t" + bookingID + "\t\t" + customerID + "\t\t" + totalPrice + "\t\t"
				+ getServicesCodesAsString() + "\n";
	}

	public String getServicesCodesAsString() {
		String serviceCode = "" + serviceCodes.get(0);

		for (int i = 1; i < serviceCodes.size(); i++) {
			serviceCode += "," + serviceCodes.get(i);
		}
		return serviceCode;
	}

	public String getServicesNamesAsString(ArrayList<Service_20420286> services) {
		String servicesName = "";
		for (int i = 0; i < serviceCodes.size(); i++) {
			int serviceCode = serviceCodes.get(i);
			for (int j = 0; j < services.size(); j++) {
				Service_20420286 service = services.get(j);
				if (serviceCode == service.getCode()) {
					servicesName += service.getName() + ",";
					break;
				}
			}
		}
		if (servicesName.contains(","))
			servicesName = servicesName.substring(0, servicesName.lastIndexOf(','));
		return servicesName;
	}

	public String getServicesPricesAsString(ArrayList<Service_20420286> services) {
		String servicesPrices = "";
		for (int i = 0; i < serviceCodes.size(); i++) {
			int serviceCode = serviceCodes.get(i);
			for (int j = 0; j < services.size(); j++) {
				Service_20420286 service = services.get(j);
				if (serviceCode == service.getCode()) {
					servicesPrices += service.getPrice() + ",";
					break;
				}
			}
		}
		if (servicesPrices.contains(","))
			servicesPrices = servicesPrices.substring(0, servicesPrices.lastIndexOf(','));
		return servicesPrices;
	}
}
