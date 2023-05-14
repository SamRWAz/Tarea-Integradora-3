package model;


public abstract class Product {

    private String id;
	private String name;
	private double price;
	private int numPages;
	private String publicationDate;
	private int readPages;
	private String url;

	public Product(String id, String name, double price, int numPages, String publicationDate, String url) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.numPages = numPages;
		this.publicationDate = publicationDate;
		this.readPages = 0;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookInfo() {
		
		return "\nId: " + id + "\nName: " + name + "\n";
	}


	public int getReadPages() {
		return readPages;
	}

	public void setReadPages(int readPages) {
		this.readPages = readPages;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	
	
}
