package ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import model.Controller;
import java.util.GregorianCalendar;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Bienvenido a ReaderX!");
		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Registrar un producto bibliografico");
			System.out.println("3. Modificar Producto");
			System.out.println("4. Borrar Producto");
			System.out.println("5. Vender Libro");
			System.out.println("6. Suscribirse a Revista");
			System.out.println("7. Desuscribirse a Revista");
			System.out.println("8. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				modifyProduct();
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				sellBook();
				break;
			case 6:
				subscribeMagazine();
				break;
			case 7:
				unsubscribeMagazine();
				break;
			case 8:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;

			}

		}

	}

	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		System.out.println("Digite el tipo de usuario que desea crear \n1) Regular \n2) Premium");
		int option = reader.nextInt();

		int option2 = 0;

		if(option == 2){

			System.out.println("El usuario a crear será premium, por favor digite su categoria \n1)Plata \n2)Oro \n3)Diamante");
			option2 = reader.nextInt();
		}

		System.out.println(rXSystem.registerUser(id, name, nickname, option, option2)); 

			
	}

	private void modifyProduct() {

		String query = rXSystem.getBookList();

		if (query.equals("")) {

			System.out.println("No hay productos registrados");
		} else {

			System.out.println("\nEste es el listado de productos registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el producto a editar");

			int option = reader.nextInt();

			String consult = rXSystem.getProductType(option-1);

			int option3 = 0;
			String modificacion = "";
			String fechaChange = "";

			if(consult.equals("L")){

				System.out.println("El producto es un libro, que desea modificar?");
				System.out.println("1. Id");
				System.out.println("2. Nombre");
				System.out.println("3. Numero de pagina");
				System.out.println("4. Precio");
				System.out.println("5. Fecha de publicacion");
				System.out.println("6. Reseña");
				System.out.println("7. Genero (Por favor escriba una de las siguientes en mayusculas CIENCIA FICCION, FANTASIA, NOVELA HISTORICA)");
				System.out.println("8. Url");

				option3 = reader.nextInt();

				if(option3 == 5){

					System.out.println("Por favor digita la fecha de publicación en dias, meses y año");

					System.out.println("Digite el dia de publicacion");
					int diaInicio = reader.nextInt();

					System.out.println("Digite el mes de publicacion");
					int mesInicio = reader.nextInt();

					System.out.println("Digite el año de publicacion");
					int anInicio = reader.nextInt();
		

					Calendar fechaProvisional = new GregorianCalendar(diaInicio, mesInicio-1, anInicio);

					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
					fechaChange = formatoFecha.format(fechaProvisional.getTime());

					modificacion = fechaChange;

				}else{

					reader.nextLine();

					System.out.println("Digite el nuevo valor");
					modificacion = reader.nextLine();

				}


			}else if(consult.equals("R")){

				System.out.println("El producto es un libro, que desea modificar?");
				System.out.println("1. Id");
				System.out.println("2. Nombre");
				System.out.println("3. Numero de pagina");
				System.out.println("4. Fecha de publicacion");
				System.out.println("5. Precio");
				System.out.println("6. Categoria (Por favor escriba una de las siguientes en mayusculas VARIEDADES, DISEÑO, CIENTIFICA)");
				System.out.println("7. Url");
				System.out.println("8. Periodicidad");

				option3 = reader.nextInt();

				reader.nextLine();

				if(option3 == 4){

					System.out.println("Por favor digita la fecha de publicación en dias, meses y año");

					System.out.println("Digite el dia de publicacion");
					int diaInicio = reader.nextInt();

					System.out.println("Digite el mes de publicacion");
					int mesInicio = reader.nextInt();

					System.out.println("Digite el año de publicacion");
					int anInicio = reader.nextInt();
		

					Calendar fechaProvisional = new GregorianCalendar(diaInicio, mesInicio-1, anInicio);

					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
					fechaChange = formatoFecha.format(fechaProvisional.getTime());

					modificacion = fechaChange;

				}else{

					reader.nextLine();

					System.out.println("Digite el nuevo valor");
					modificacion = reader.nextLine();

				}

				

			}

			if (rXSystem.editProduct(consult, option-1, modificacion, option3)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

	private void deleteProduct() {

		String query = rXSystem.getBookList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a borrar");

			int option = reader.nextInt();

			System.out.println(rXSystem.deleteProduct(option - 1)); 

		}

	}


	public void registerBook() {



		System.out.println("Digite a continuacion la informacion de un nuevo producto bibliografico");

		System.out.println("Digite que tipo de producto desea registrar \n1)Libro \n2)Revista");
		int optionP = reader.nextInt();

		boolean valido = false;

		String id = "";
		String name = "";
		int numPages = 0;
		String review = "";
		int genre = 0;
		String url = "";
		double price = 0;
		int category = 0;
		String peridiocity = "";
		int subscriptions = 0;
		int ventas = 0;

		if(optionP == 1){

			// Limpieza de buffer
			reader.nextLine();

			while (valido == false){

				System.out.println("Digite el identificador. Ej.: A1F (Recuerde usar caracteres hexadecimales)");
				id = reader.nextLine();

				if(valido = rXSystem.validaIdentificador(id)){
					System.out.println("Id valido");
				} else {
					System.out.println("Id ingresado no cumple lo necesitado");
				}

			}

			System.out.println("Digite el nombre");
			name = reader.nextLine();

			System.out.println("Digite el numero de paginas del libro");
			numPages = reader.nextInt();

			// Limpieza de buffer
			reader.nextLine();

			System.out.println("Digite una reseña corta del libro");
			review = reader.nextLine();

			System.out.println("Digite el URL que lleva a la portada del libro");
			url = reader.nextLine();

			System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
			genre = reader.nextInt();

			System.out.println("Digite el valor de venta");
			price = reader.nextDouble();

			System.out.println("Digite el numero de ejemplares vendidos");
			ventas = reader.nextInt();

		}

		if(optionP == 2){

			// Limpieza de buffer
			reader.nextLine();

			while (valido == false){

				System.out.println("Digite el identificador. Ej.: A1F (Recuerde usar caracteres alfanumericos)");
				id = reader.nextLine();

				if(valido = rXSystem.validaIdentificador2(id)){
					System.out.println("Id valido");
				} else {
					System.out.println("Id ingresado no cumple lo necesitado");
				}

			}


			System.out.println("Digite el nombre");
			name = reader.nextLine();

			System.out.println("Digite el numero de paginas del producto");
			numPages = reader.nextInt();

			System.out.println("Digite la categoria de la revista \n1)Variedades \n2)Diseño  \n3)Científica ");
			category = reader.nextInt();
			
			// Limpieza de buffer
			reader.nextLine();

			System.out.println("Digite el URL que lleva a la portada de la revista");
			url = reader.nextLine();

			System.out.println("Digite el valor de suscripcion");
			price = reader.nextDouble();

			// Limpieza de buffer
			reader.nextLine();

			System.out.println("Digite la periodicidad de emision");
			peridiocity = reader.nextLine();

			System.out.println("Digite el numero de suscripciones activas");
			subscriptions = reader.nextInt();

		}

		System.out.println("Digite el numero de paginas leidas");
		double readPages  = reader.nextInt();

		System.out.println("Por favor digita la fecha de publicación en dias, meses y año");

		System.out.println("Digite el dia de publicacion");
		int diaInicio = reader.nextInt();

		System.out.println("Digite el mes de publicacion");
		int mesInicio = reader.nextInt();

		System.out.println("Digite el año de publicacion");
		int anInicio = reader.nextInt();
		

		

		if (rXSystem.registerBook(optionP, id, name, numPages, category, review, genre, url, price, peridiocity, subscriptions, ventas, readPages,diaInicio, mesInicio, anInicio)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro");
		}
	}

	private void sellBook() {

		String query1 = rXSystem.getUserList();

		if (query1.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			String query = rXSystem.getOnlyBookList();

			if (query.equals("")) {

				System.out.println("No hay libros registrados");

			} else {

			System.out.println("\nEste es el listado de usuarios");

			System.out.println(query1);

			System.out.println("\nSeleccione el usuario que desea comprar un producto");

			int option1 = reader.nextInt();

			System.out.println("\nEste es el listado de libros registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el producto a vender");

			int option = reader.nextInt();

			String receipt = rXSystem.sellBook(option1-1, option - 1);

			if (receipt.equals("")) {

				System.out.println("\nError en la transaccion");

			} else {

				System.out.println(receipt);

				System.out.println("\nTransaccion realizada exitosamente");
			}

		}

		}
		

	}

	private void subscribeMagazine() {

		String query1 = rXSystem.getUserList();

		if (query1.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			String query = rXSystem.getOnlyRevistaList();

			if (query.equals("")) {

				System.out.println("No hay revistas registrados");

			} else {

				System.out.println("\nEste es el listado de usuarios");

				System.out.println(query1);

				System.out.println("\nSeleccione el usuario que desea comprar un producto");

				int option1 = reader.nextInt();

				System.out.println("\nEste es el listado de revistas registradas en el sistema");

				System.out.println(query);

				System.out.println("\nSeleccione el producto a vender");

				int option = reader.nextInt();

				String receipt = rXSystem.subscribeMagazine(option1-1, option - 1);

				if (receipt.equals("")) {

					System.out.println("\nError en la transaccion");

				} else {

					System.out.println(receipt);

					System.out.println("\nTransaccion realizada exitosamente");
				}

			}

		}
		

	}

	private void unsubscribeMagazine(){

		String query1 = rXSystem.getUserList();

		if (query1.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			String query = rXSystem.getOnlyRevistaList();

			if (query.equals("")) {

				System.out.println("No hay revistas registrados");

			} else {

				System.out.println("\nEste es el listado de usuarios");

				System.out.println(query1);

				System.out.println("\nSeleccione el usuario que desea desuscribir de una revista");

				int option1 = reader.nextInt();



				System.out.println("\nEste es el listado de revistas registradas en el sistema");

				System.out.println(query);

				System.out.println("\nSeleccione el producto a vender");

				int option = reader.nextInt();

				String receipt = rXSystem.subscribeMagazine(option1-1, option - 1);

				if (receipt.equals("")) {

					System.out.println("\nError en la transaccion");

				} else {

					System.out.println(receipt);

					System.out.println("\nTransaccion realizada exitosamente");
				}

			}

		}
	}

	/* 

	public void showAllBookInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllKBookInfo();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}


	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a consultar");

			int option = reader.nextInt();

			String query2 = rXSystem.getUserInfo(option-1);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

	private void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}
	*/


}