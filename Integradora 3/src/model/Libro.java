package model;


public class Libro extends Product {

    private String review;
    private Genre genre;
    private int unitsSold;

    public Libro(String id, String name, int numPages, double price, String publicationDate, String review, Genre genre, String url,int unitsSold, Double readPages) {
        super(id, name, price, numPages, publicationDate, url, readPages);

        this.review = review;
        this.genre = genre;
        this.unitsSold = unitsSold;


    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    @Override
    public String readProduct() {

        return "Hola";

    }
    
    
    
    
}
