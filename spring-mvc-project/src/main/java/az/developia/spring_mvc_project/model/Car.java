package az.developia.spring_mvc_project.model;

public class Car {

	String brand;
	int model;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + "]";
	}
	
	
	
	

}
