package az.developia.spring_mvc_project.model;

public class Book {

	private String name;
	private long price;
	private long pageCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", pageCount=" + pageCount + "]";
	}
	public Book(String name, long price, long pageCount) {
		super();
		this.name = name;
		this.price = price;
		this.pageCount = pageCount;
	}

	public Book() {
		
	}
	
	
}
