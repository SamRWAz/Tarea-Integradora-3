package model;


public class Revista extends Product{

    private String peridiocity;
    private int subscriptions;
    private RevistaCat category;

    public Revista(String id, String name, int numPages,  String publicationDate, double price, RevistaCat category , String url, String peridiocity) {
        super(id, name, price, numPages, publicationDate, url);

        this.peridiocity = peridiocity;
        this.subscriptions = 0;
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

    
    
    
}
