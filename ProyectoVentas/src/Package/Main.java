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
		System.out.println("Ingrese los datos del vendedor");
		//IngresoVend();
		System.out.println("Ingrese los datos del Producto");
		//IngresoProd();
		System.out.println("venta");
		InsertarVenta();
	}
	
	public static void IngresoVend() {
		String TipoDoc, NombreVendor, ApellidoVendor, Continuar="si", NumDoc;
			
			
		while (Continuar.equals("Si") || Continuar.equals("SI") 
				|| Continuar.equals("si") ){
			
			
			System.out.println("Digite el tipo de documento (CC, RC, TI, PE, PS): ");
			TipoDoc=teclado.nextLine();
			System.out.println("Número de documento: ");
			NumDoc= teclado.nextLine();
			System.out.println("Nombres del Vendedor: ");
			NombreVendor= teclado.nextLine();
			System.out.println("Apellidos del Vendedor: ");
			ApellidoVendor= teclado.nextLine();
			System.out.println("");
				
			ListaVendedores.add(TipoDoc + ";" + NumDoc + ";" + NombreVendor + ";" 
			+ ApellidoVendor);
				
				
			System.out.println("Datos Ingresados:");
			for (int i = 0; i < ListaVendedores.size(); i++) {
				System.out.println(ListaVendedores.get(i));
			}
				
			System.out.println("Desea ingresar otro Vendedor Si/No");
			Continuar=teclado.nextLine();				
		} 
			
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
	
	public static void IngresoProd() {
		String idProd;
		String nomProd;
		String Continuar;
		Double vrProd;
								
		do{
			
			
			System.out.println("Identificador del Producto:");			
			idProd=kb.nextLine();
				
			System.out.println("Nombre del Producto:");
			nomProd=kb1.nextLine();
				
			System.out.println("Valor Unitario del Producto:");
			vrProd=kb2.nextDouble();
				
			ListaProductos.add(idProd + ";" + nomProd + ";" + vrProd);
				
			System.out.println("Datos Ingresados:");
			for (int i = 0; i < ListaProductos.size(); i++) {
				System.out.println(ListaProductos.get(i));
			}
				
			System.out.println("Desea ingresar otro Producto Si/No");
			Continuar=kb3.nextLine();
			
		}while (Continuar.equals("Si") || Continuar.equals("SI") || Continuar.equals("si"));
			
					
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/ProyectoVentas/src/Archivos/Productos.csv", true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
				
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
		
		//Parte que selecciona el vendedor
		File file = null;
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
 
        String linea1 = null;
		
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
                ListaVendedores.add(listfil);
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
	
		
		System.out.println("Digite el documento del vendedor seleccionado:");
		String documentoV;
		documentoV = keyboard.nextLine();
		String resultado=null;
		
		for (String cadena : ListaVendedores) {
			if (cadena.contains(documentoV)) {
				resultado=cadena;
				break;
			}
		}
		String[] resultado_array = resultado.split(";");
		String result_final = resultado_array[0] + " " + resultado_array[1] + " " + resultado_array[2];
		System.out.println("Vendedor seleccionado: " + result_final);
		
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
            
            //Leemos hasta que se termine el archivo
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
