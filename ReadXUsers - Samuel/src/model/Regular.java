package model;

public class Regular extends User {

    private Libro[] libros;
    private Revista[] revistas;


    public Regular(String id, String name, String nickname, String signUpDate) {
        super(id, name, nickname, signUpDate);

       libros = new Libro[5];
       revistas = new Revista[2];

    }

    public boolean buyBooksOrSubscribe(int optionP, String id, String name1, int numPages, double price, String publicationDate, String review, Genre genre, String url, RevistaCat category, String peridiocity){

        if(optionP == 1){

            for(int j = 0; j < libros.length; j++){
                
                    if(libros[j] == null){
                        libros[j] = new Libro(id, name1, numPages, price, publicationDate, review, genre, url);
                        return true;  
                    }
                
            }
        }

        if(optionP == 2){

            for(int j = 0; j < revistas.length; j++){

  
                if(libros[j] == null){
                    revistas[j] = new Revista(id, name1, numPages, publicationDate, price, review, category, url, peridiocity);
                    return true;
                }
            }    
            
        }


        return false;

    }
    
}

