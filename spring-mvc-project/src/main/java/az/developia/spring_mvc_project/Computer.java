package az.developia.spring_mvc_project;

public class Computer {
	
	private String brand;
	private Long price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	

}
