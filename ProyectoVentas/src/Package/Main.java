package Package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//Se declaran los escaneres y arraylist por fuera de los métodos para su ejecución y trabajo en todos los metodos
	public static Scanner teclado = new Scanner(System.in);
		
	public static Scanner kb = new Scanner(System.in);
	public static Scanner kb1 = new Scanner(System.in);
	public static Scanner kb2 = new Scanner(System.in);
	public static Scanner kb3 = new Scanner(System.in);

	public static Scanner keyboard = new Scanner(System.in);
	
	public static ArrayList<String> ListaVendedores = new ArrayList<String>();
	
	public static ArrayList<String> ListaProductos = new ArrayList<String>();
	
	public static ArrayList<String> ListaVentas = new ArrayList<String>();



	public static void main(String[] args) {
		//Ejecución principal del programa se dejan comentados los métodos para pruebas de InsertarVenta()
		System.out.println("Ingrese los datos del vendedor");
		//IngresoVend();
		System.out.println("Ingrese los datos del Producto");
		//IngresoProd();
		System.out.println("venta");
		InsertarVenta();
	}
	
	//Este metodo se usa para insertar nuevos vendedores y los guarda en el documento Vendedores.csv
	public static void IngresoVend() {
		String tipoDoc, nombreVendor, apellidoVendor, continuar="si", numDoc;
			
			
		while (continuar.equals("Si") || continuar.equals("SI") 
				|| continuar.equals("si") ){ //la condicional entra al ciclo en alguna de estas opciones
			
			
			System.out.println("Digite el tipo de documento (CC, RC, TI, PE, PS): ");
			tipoDoc=teclado.nextLine();
			System.out.println("Número de documento: ");
			numDoc= teclado.nextLine();
			System.out.println("Nombres del Vendedor: ");
			nombreVendor= teclado.nextLine();
			System.out.println("Apellidos del Vendedor: ");
			apellidoVendor= teclado.nextLine();
			System.out.println("");
				
			ListaVendedores.add(tipoDoc + ";" + numDoc + ";" + nombreVendor + ";" 
			+ apellidoVendor); //adiciona lo digitado en el arraylist de vendedores
				
			//recorre el arraylist de vendedores e imprime su contenido en pantalla recorriendo el arraylist	
			System.out.println("Datos Ingresados:");
			for (int i = 0; i < ListaVendedores.size(); i++) {
				System.out.println(ListaVendedores.get(i));
			}
			//pregunta para mantener el ciclo	
			System.out.println("Desea ingresar otro Vendedor Si/No");
			continuar=teclado.nextLine();				
		} 
		//este bloque de código guarda el contenido del arraylist en el archivo Vendedores.csv	
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/ProyectoVentas/src/Archivos/Vendedores.csv", true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
						
			for (String elemento : ListaVendedores) {
				bufferWriter.write(elemento);
				bufferWriter.newLine();
			}
		
			bufferWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	//Método para ingresar productos y guardarlos en el Productos.csv
	public static void IngresoProd() {
		String idProd;
		String nomProd;
		String continuar;
		Double vrProd;
		
		//ejecuta el ciclo aunque sea una vez para garantizar el ingreso por esto se usa do
		do{
			System.out.println("Identificador del Producto:");			
			idProd=kb.nextLine(); //ingreso en consola de id del producto
				
			System.out.println("Nombre del Producto:");
			nomProd=kb1.nextLine(); //ingreso en consola el nombre del producto
				
			System.out.println("Valor Unitario del Producto:");
			vrProd=kb2.nextDouble(); //ingreso en consola del valor unitario del producto
				
			ListaProductos.add(idProd + ";" + nomProd + ";" + vrProd); //guarda en arraylist lo digitado en pantalla
			
			//recorre con un ciclo for el arraylist de productos e imprime en pantalla cada elemento
			System.out.println("Datos Ingresados:");
			for (int i = 0; i < ListaProductos.size(); i++) {
				System.out.println(ListaProductos.get(i));
			}
			//pregunta para mantener el ciclo	
			System.out.println("Desea ingresar otro Producto Si/No");
			continuar=kb3.nextLine();
			
		}while (continuar.equals("Si") || continuar.equals("SI") || continuar.equals("si"));
			
		//este bloque de código guarda el contenido del arraylist en el archivo Productos.csv			
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/ProyectoVentas/src/Archivos/Productos.csv", true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			
			/*ciclo for each o 'para cada' que permite el recorrido en el arraylist linea a linea y 
			  escribe en el documento csv la linea recorrida*/
			for (String elemento : ListaProductos) {
				bufferWriter.write(elemento);
				bufferWriter.newLine();
			}
				
			bufferWriter.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	} 
	
	
	public static void InsertarVenta() {
		
		//declaracion de variables
		File file = null;
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
 
        String linea1 = null;
		
        /*el método inicia recorriendo el documento csv de vendedores para cargar en el 
        arraylist de vendedores la información de los vendedores y listarla en pantalla esto con el objetivo 
        de que el usuario pueda digitar la cedula y seleccionar para empezar a guardar en el arraylist de ventas*/ 
		
        try {
            //Cargamos el archivo de la ruta relativa
            file = new File(System.getProperty("user.dir") + "/ProyectoVentas/src/Archivos/Vendedores.csv");
            //Cargamos el objeto FileReader
            fileReader = new FileReader(file);
            //Creamos un buffer de lectura
            bufferReader = new BufferedReader(fileReader);
 
            String[] datos1 = null;
            
            System.out.println("Selecciones un vendedor");
            System.out.println("TIPO DOC" + "\t" + "NRO DOCUMENTO" + "\t" + "NOMBRE COMPLETO");
            
            ListaVendedores.clear();
            
            //Leemos hasta que se termine el archivo
            while ((linea1 = bufferReader.readLine()) != null) {
 
                //Utilizamos el separador para los datos
                datos1 = linea1.split(";");
                //Presentamos los datos
                String list=datos1[0] + "\t" + datos1[1] + "\t" + datos1[2] + " " + datos1[3];
                String listfil=datos1[0] + ";" + datos1[1] + ";" + datos1[2] + " " + datos1[3];
                System.out.println(list);
                ListaVendedores.add(listfil); //guarda la linea recorrida en el arraylist de vendedores
            }
 
            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
	
		/*este bloque permite hacer una busqueda del documento digitado en consola y 
		 * lo guarda en array list de ventas
		 */
		System.out.println("Digite el documento del vendedor seleccionado:");
		String documentoV;
		documentoV = keyboard.nextLine();
		String resultado=null;
		
		//recorre el array de vendedores y toma lo con el contains la busqueda de vendedor digitada
		for (String cadena : ListaVendedores) {
			if (cadena.contains(documentoV)) {
				resultado=cadena;
				break;
			}
		}
		//Impresión de la busqueda realizada.
		String[] resultado_array = resultado.split(";");
		String result_final = resultado_array[0] + " " + resultado_array[1] + " " + resultado_array[2];
		System.out.println("Vendedor seleccionado: " + result_final);
		
		//Inserción en arraylist de ventas
		ListaVentas.add(result_final);
		
		//tiempo de 5segs para que muestre listado de productos
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("");
		
		//incio de venta muestra el listado 
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        String linea = null;
 
        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File(System.getProperty("user.dir") + "/ProyectoVentas/src/Archivos/Productos.csv");
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
 
            String[] datos = null;
            
            System.out.println("LISTA DE PRODUCTOS");
            System.out.println("CODIGO" + "\t" + "DESCRIPCION" + "\t" + "VALOR UNITARIO");
            
           ListaProductos.clear(); 
            
            /*lectura del archivo Productos.csv y llenado linea a linea del arraylist de productos. 
             * Leemos hasta que se termine el archivo. */
            while ((linea = br.readLine()) != null) {
 
                //Utilizamos el separador para los datos
                datos = linea.split(";");
                //Presentamos los datos
                System.out.println(datos[0] + "\t" + datos[1] + "\t" + datos[2]);
                ListaProductos.add(datos[0] + ";" + datos[1] + ";" + datos[2]);
            }
 
            //Capturamos las posibles excepciones
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
	
	}
}
