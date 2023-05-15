package model;


public class Revista extends Product{

    private String peridiocity;
    private int subscriptions;
    private RevistaCat category;

    public Revista(String id, String name, int numPages,  String publicationDate, double price, RevistaCat category , String url, String peridiocity, int subscriptions, Double readPages) {
        super(id, name, price, numPages, publicationDate, url, readPages);

        this.peridiocity = peridiocity;
        this.subscriptions = subscriptions;
        this.category = category;

    }

    public String getPeridiocity() {
        return peridiocity;
    }

    public void setPeridiocity(String peridiocity) {
        this.peridiocity = peridiocity;
    }

    public int getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(int subscriptions) {
        this.subscriptions = subscriptions;
    }

    public RevistaCat getCategory() {
        return category;
    }

    public void setCategory(RevistaCat category) {
        this.category = category;
    }

    @Override
    public String readProduct() {

        return "Hola";

    }

    
    
    
}
