package Package;

import java.io.BufferedWriter;
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


	public static void main(String[] args) {
		System.out.println("Ingrese los datos del vendedor");
		IngresoVend();
		System.out.println("Ingrese los datos del Producto");
		IngresoProd();
	}
	
	public static void IngresoVend() {
		String TipoDoc, NombreVendor, ApellidoVendor, Continuar="si", NumDoc;
			
		ArrayList<String> ListaVendedores = new ArrayList<String>();
			
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
					
		ArrayList<String> ListaProductos = new ArrayList<String>();
			
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

}
