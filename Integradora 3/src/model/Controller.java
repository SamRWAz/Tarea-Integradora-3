package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<Product> products;
	private ArrayList<User> users;
	private Regular regular;
	private Premium premium;

	public Controller() {

		this.users = new ArrayList<User>();
		this.products = new ArrayList<Product>();
		testCases();

	}

	public void testCases() {

		users.add(new Regular("1234", "John Smith", "Smithy", "04/03/2021"));
		users.add(new Regular("5678", "Pocahontas", "Pocah", "05/02/2022"));
		products.add(new Libro("4AF", "A Game of Thrones", 694, 19.19,"01/08/1996","Join adventurers across the seven kingdoms", Genre.FANTASIA, "AGOT.png", 12314, 141241234.0));
		products.add(new Revista("4AZ", "Vogue", 40,"01/08/1996",4, RevistaCat.VARIEDADES, "LMV2021.jpg","Mensual", 122867, 7531341.0));

	}

	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.size(); i++) {

				msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();

		}

		return msg;

	}

	public String registerUser(String id, String name, String nickname, int option, int option2) {

		Category categoryOption = null;

		Date fechaActual = new Date();
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		String fechaChange = formatoFecha.format(fechaActual);

		switch(option2){
			case 1:
				categoryOption = Category.PLATA;
				break;
			case 2:
				categoryOption = Category.ORO;
				break;
			case 3:
				categoryOption = Category.DIAMANTE;
				break;
		}

                if(option == 1){
                    users.add(new Regular(id, name, nickname, fechaChange));
                    return "Se ha registrado el usuario Regular";
                }
                else if(option == 2){
                    users.add(new Premium(id, name, nickname, fechaChange, categoryOption));
                    return "Se ha registrado el usuario Premium";
           		}

		return "No se ha podido registrar el usuario";
	}

	public boolean editProduct(String consult, int posicionproducto,  String modificacion, int atributo) {

		if(consult.equals("L")){

			switch(atributo){

				case 1:
					products.get(posicionproducto).setId(modificacion);
					return true;
				case 2:
					products.get(posicionproducto).setName(modificacion);
					return true;
				case 3:
					int valorE = Integer.parseInt(modificacion);
					products.get(posicionproducto).setNumPages(valorE);
					return true;
				case 4:
					double price1 = Double.parseDouble(modificacion);
					products.get(posicionproducto).setPrice(price1);
					return true;
				case 5:
					products.get(posicionproducto).setPublicationDate(modificacion);
					return true;
				case 6:
					((Libro)(products.get(posicionproducto))).setReview(modificacion);
					return true;
				case 7:
					
					Genre genre1 = null;
					switch (modificacion) {
					case "CIENCIA FICCION":
						genre1 = Genre.CIENCIAFICCION;
						break;
					case "FANTASIA":
						genre1 = Genre.FANTASIA;
						break;
					case "NOVELA HISTORICA":
						genre1 = Genre.NOVELAHISTORICA;
						break;
					}

					((Libro)(products.get(posicionproducto))).setGenre(genre1);
					return true;
				case 8:
					products.get(posicionproducto).setUrl(modificacion);
					return true;
	
			}

		}
		if(consult.equals("R")){

			switch(atributo){

				case 1:
					products.get(posicionproducto).setId(modificacion);
					return true;
				case 2:
					products.get(posicionproducto).setName(modificacion);
					return true;
				case 3:
					int valorE = Integer.parseInt(modificacion);
					products.get(posicionproducto).setNumPages(valorE);
					return true;
				case 4:
					products.get(posicionproducto).setPublicationDate(modificacion);
					return true;
				case 5:
					double price1 = Double.parseDouble(modificacion);
					products.get(posicionproducto).setPrice(price1);
					return true;
				case 6:

					RevistaCat revistaCat = null;
					switch (modificacion) {
					case "VARIEDADES":
						revistaCat = RevistaCat.VARIEDADES;
						break;
					case "DISEÑO":
						revistaCat = RevistaCat.DISEÑO;
						break;
					case "CIENTIFICA":
						revistaCat = RevistaCat.CIENTIFICA;
						break;
					}
					((Revista)(products.get(posicionproducto))).setCategory(revistaCat);
					return true;
				case 7: 
					products.get(posicionproducto).setUrl(modificacion);
					return true;
				case 8:
					((Revista)(products.get(posicionproducto))).setPeridiocity(modificacion);
					return true;
	
				
			}

		}
	

        return false;
    }
	

	public String deleteProduct(int productPosition) {

		String msg = "";

		products.remove(productPosition);

		msg = "Usuario borrado exitosamente";

		return msg;
	}

	public String getUserInfo(int option) {

		String msg = "";

		msg += "\nId: " + users.get(option).getId() + "\nName: " + users.get(option).getName() + "\nNickname: " + users.get(option).getNickname() + "\nSign Up Date: " + users.get(option).getSignUpDate();
		
		if(users.get(option) instanceof Premium){
			msg+= "\nCategory: " + ((Premium)(users.get(option))).getCategory();
		}

		return msg;
	}

	public String getAllUserInfo() {

		String msg = "";

		int premiumUsers = 0;
		int regularUsers = 0;
		int silver = 0;
		int gold = 0;
		int diamond = 0;
		Category provisional;

		for(int i = 0 ; i< users.size(); i++){

            if(users.get(i) instanceof Regular){
				regularUsers += 1;
			}

			if(users.get(i) instanceof Premium){
				
				provisional = ((Premium)(users.get(i))).getCategory();

				if(provisional == Category.PLATA){
					silver += 1;
				}else if(provisional == Category.ORO){
					gold += 1;
				}else if(provisional == Category.DIAMANTE){
					diamond += 1;
				}

				premiumUsers += 1;
			}
        }

		msg += "Cantidad de usuarios regular: " + regularUsers 
		+ "\nCantidad de usuarios premium: " + premiumUsers
		+ "\nCantidad de usuarios premium categoria plata: " + silver 
		+ "\nCantidad de usuarios premium categoria oro: " + gold 
		+ "\nCantidad de usuarios premium categoria diamante: " + diamond;

		return msg;
	}

	public String getUserType(int option) {

		String msg = "";

                if(users.get(option) instanceof Regular){
                    msg+="R";
                }

                if(users.get(option) instanceof Premium){
                    msg+="P";
                }

		return msg;

	}

	public String getProductType(int option) {

		String msg = "";

                if(products.get(option) instanceof Libro){
                    msg+="L";
                }

                if(products.get(option) instanceof Revista){
                    msg+="R";
                }

		return msg;

	}

	public boolean registerBook(int optionP, String id, String name, int numPages, int category, String review, int genre, String url, double price, String periodicity, int subscriptions, int ventas, double readPages, int diaInicio, int mesInicio, int anInicio ) {

		

		Calendar fechaProvisional = new GregorianCalendar(diaInicio, mesInicio-1, anInicio);

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		String fechaChange = formatoFecha.format(fechaProvisional.getTime());


		Genre genreType = Genre.CIENCIAFICCION;

        if (genre == 1){

            genreType = Genre.CIENCIAFICCION;

        }else if (genre == 2){

            genreType = Genre.FANTASIA;

        }else{

			genreType = Genre.NOVELAHISTORICA;

		}

		RevistaCat cat = RevistaCat.CIENTIFICA;

		if (category == 1){

			cat = RevistaCat.VARIEDADES;

		}else if (category == 2){

			cat = RevistaCat.DISEÑO;

		}else{

			cat = RevistaCat.CIENTIFICA;

		}

			if(optionP == 1){
				products.add(new Libro(id, name, numPages, price, fechaChange, review, genreType, url, ventas, readPages));
				return true;
			}else if(optionP == 2){
				products.add(new Revista(id, name, numPages, fechaChange, price, cat, url, periodicity, subscriptions, readPages));
				return true;
			}
		
		return false;
    
	}

	public String getBookList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

		}
		
		return msg;

	}

	public String getOnlyBookList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Libro){

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();

			}
		}
		
		return msg;

	}

	public String getOnlyRevistaList() {

		String msg = "";

		for (int i = 0; i < products.size(); i++) {

			if(products.get(i) instanceof Revista){

				msg += "\n" + (i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice();
				
			}
		}
		
		return msg;

	}


	public String sellBook(int t, int i) {

		String msg = "";

		Calendar fechaActual = new GregorianCalendar();

		double precio = products.get(i).getPrice();

		String name = products.get(i).getName();

		int valor = (((Libro)(products.get(i))).getUnitsSold()) + 1;

		((Libro)(products.get(i))).setUnitsSold(valor);

		int producto = 1;

		if(users.get(t) instanceof Premium){

			String id = products.get(i).getId();
			String name1 = products.get(i).getName();
			int numPages = products.get(i).getNumPages();
			Double price = products.get(i).getPrice();
			String publicationDate = products.get(i).getPublicationDate();
			String review = ((Libro)(products.get(i))).getReview();
			Genre genre = ((Libro)(products.get(i))).getGenre();
			String url = products.get(i).getUrl();
			RevistaCat revistaCat = ((Revista)(products.get(i))).getCategory();
			String peridiocity = ((Revista)(products.get(i))).getPeridiocity();
			Double readPages = products.get(i).getReadPages();
			int unitsSold = ((Libro)(products.get(i))).getUnitsSold();
			int subscriptions = ((Revista)(products.get(i))).getSubscriptions();

			premium.buyBooksOrSubscribe(producto, id, name1, numPages, price, publicationDate, review, genre, url,revistaCat, peridiocity, readPages, unitsSold, subscriptions);

		}
		if(users.get(t) instanceof Regular){

			String id = products.get(i).getId();
			String name1 = products.get(i).getName();
			int numPages = products.get(i).getNumPages();
			Double price = products.get(i).getPrice();
			String publicationDate = products.get(i).getPublicationDate();
			String review = ((Libro)(products.get(i))).getReview();
			Genre genre = ((Libro)(products.get(i))).getGenre();
			String url = products.get(i).getUrl();
			RevistaCat revistaCat = ((Revista)(products.get(i))).getCategory();
			String peridiocity = ((Revista)(products.get(i))).getPeridiocity();
			Double readPages = products.get(i).getReadPages();
			int unitsSold = ((Libro)(products.get(i))).getUnitsSold();
			int subscriptions = ((Revista)(products.get(i))).getSubscriptions();

			regular.buyBooksOrSubscribe(producto, id, name1, numPages, price, publicationDate, review, genre, url,revistaCat, peridiocity,readPages, unitsSold, subscriptions);

		}
		

		msg += "\nEste es su recibo" + "\nFecha de compra: " + fechaActual + "\nPrecio de la compra: " + precio + "\nLibro comprado: " + name;

		return msg;
	}

	public String subscribeMagazine(int t, int i) {

		String msg = "";

		Calendar fechaActual = new GregorianCalendar();

		double precio = products.get(i).getPrice();

		String name = products.get(i).getName();

		int valor = (((Libro)(products.get(i))).getUnitsSold()) + 1;

		((Libro)(products.get(i))).setUnitsSold(valor);

		int producto = 2;

		if(users.get(t) instanceof Premium){

			String id = products.get(i).getId();
			String name1 = products.get(i).getName();
			int numPages = products.get(i).getNumPages();
			Double price = products.get(i).getPrice();
			String publicationDate = products.get(i).getPublicationDate();
			String review = ((Libro)(products.get(i))).getReview();
			Genre genre = ((Libro)(products.get(i))).getGenre();
			String url = products.get(i).getUrl();
			RevistaCat revistaCat = ((Revista)(products.get(i))).getCategory();
			String peridiocity = ((Revista)(products.get(i))).getPeridiocity();
			Double readPages = products.get(i).getReadPages();
			int unitsSold = ((Libro)(products.get(i))).getUnitsSold();
			int subscriptions = ((Revista)(products.get(i))).getSubscriptions();

			premium.buyBooksOrSubscribe(producto, id, name1, numPages, price, publicationDate, review, genre, url,revistaCat, peridiocity, readPages, unitsSold, subscriptions);

		}
		if(users.get(t) instanceof Regular){

			String id = products.get(i).getId();
			String name1 = products.get(i).getName();
			int numPages = products.get(i).getNumPages();
			Double price = products.get(i).getPrice();
			String publicationDate = products.get(i).getPublicationDate();
			String review = ((Libro)(products.get(i))).getReview();
			Genre genre = ((Libro)(products.get(i))).getGenre();
			String url = products.get(i).getUrl();
			RevistaCat revistaCat = ((Revista)(products.get(i))).getCategory();
			String peridiocity = ((Revista)(products.get(i))).getPeridiocity();
			Double readPages = products.get(i).getReadPages();
			int unitsSold = ((Libro)(products.get(i))).getUnitsSold();
			int subscriptions = ((Revista)(products.get(i))).getSubscriptions();

			regular.buyBooksOrSubscribe(producto, id, name1, numPages, price, publicationDate, review, genre, url,revistaCat, peridiocity, readPages, unitsSold, subscriptions);

		}
		

		msg += "\nEste es su recibo" + "\nFecha de compra: " + fechaActual + "\nPrecio de la compra: " + precio + "\nLibro comprado: " + name;

		return msg;
	}

	public String unsubscribeMagazine(){

		String msg = "";

		return msg;

	}


	public String getAllKBookInfo() {

		String msg = "";
		
		double ventasTotales = 0;

		for (int i = 0; i < products.size(); i++) {
				
				//obtener las ventas totales del libro
				if(products.get(i) instanceof Revista){

					ventasTotales = (products.get(i).getPrice())*((Revista)(products.get(i))).getSubscriptions();

					msg += "\n" + (i + 1) + ". " + products.get(i).getBookInfo() + "Ganancias por suscripciones totales: " + ventasTotales;

				}

				if(products.get(i) instanceof Libro){

					ventasTotales = (products.get(i).getPrice())*((Libro)(products.get(i))).getUnitsSold();

					msg += "\n" + (i + 1) + ". " + products.get(i).getBookInfo() + "Ventas totales: " + ventasTotales;

				}
				

		}

		return msg;
	}

	public boolean validaIdentificador(String id){        
		boolean valido = true;
		if(!id.substring(0, 1).matches("[A-F]*")){
			valido = false;
		}
		if(!id.substring(1, 2).matches("[0-9]*")){
			valido = false;
		}
		if(!id.substring(2, 3).matches("[A-F]*")){
			valido = false;
		}
		return valido;
	 }

	 public boolean validaIdentificador2(String id){        
		boolean valido = true;
		if(!id.substring(0, 1).matches("[A-Z]*")){
			valido = false;
		}
		if(!id.substring(1, 2).matches("[0-9]*")){
			valido = false;
		}
		if(!id.substring(2, 3).matches("[A-Z]*")){
			valido = false;
		}
		return valido;
	 }

}
