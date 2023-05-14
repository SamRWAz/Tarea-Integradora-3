package model;

import java.util.ArrayList;

public class Premium extends User {

    private Category category;
    private ArrayList<Libro> libros;
	private ArrayList<Revista> revistas;

    public Premium(String id, String name, String nickname, String signUpDate, Category category) {
        super(id, name, nickname, signUpDate);

        this.category = category;
        this.libros = new ArrayList<Libro>();
		this.revistas = new ArrayList<Revista>();
    }

    public boolean buyBooksOrSubscribe(int optionP, String id, String name1, int numPages, double price, String publicationDate, String review, Genre genre, String url, RevistaCat category, String peridiocity){

        if(optionP == 1){

            for(int j = 0; j < libros.size(); j++){
                
                        libros.add(new Libro(id, name1, numPages, price, publicationDate, review, genre, url));
                        return true;  
                
            }
        }

        if(optionP == 2){

            for(int j = 0; j < revistas.size(); j++){

                    revistas.add(new Revista(id, name1, numPages, publicationDate, price, review, category, url, peridiocity));
                    return true;
            }    
            
        }


        return false;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
