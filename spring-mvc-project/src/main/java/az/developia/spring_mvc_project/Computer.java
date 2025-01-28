package az.developia.spring_mvc_project;

public class Computer {
	private int id;
	private String brand;
	private Long price;
	
	 //mysql - computer - table- - brand price 5 computer adi ve qiymeti elave edin
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
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	

}
