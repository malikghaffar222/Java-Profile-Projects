/**
 * 
 */

/**
 * @author 20420286
 *
 */
class Service_20420286 {
	int code;
	String name;
	String description;
	float price;

	public Service_20420286() {
	}

	public Service_20420286(int code, String name, String description, float price) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "Service Code: " + code + "\nName: " + name + "\nDescription: " + description + "\nPrice: " + price
				+ "\n";
	}

}
