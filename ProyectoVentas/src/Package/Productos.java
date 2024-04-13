package Package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Productos {
	private static int idProducto;
	private static String nomProducto;
	private static Double vrProducto;

	public static void IngresoProd() {
		try(Scanner kb0 = new Scanner(System.in);
				Scanner kb1 = new Scanner(System.in);
				Scanner kb2 = new Scanner(System.in);
				Scanner kb3 = new Scanner(System.in)){
			String Continuar="si";
			vrProducto = 0.0;
			
			ArrayList<String> ListaProductos = new ArrayList<String>();
			
			do {
				System.out.println("Id del Producto:");
				idProducto=kb0.nextInt();
				System.out.println("Nombre del Producto:");
				nomProducto=kb1.nextLine();
				System.out.println("Valor Unitario del Producto:");
				vrProducto=kb2.nextDouble();
				
				ListaProductos.add(idProducto + ";" + nomProducto + ";" + vrProducto);
				
				System.out.println("Datos Ingresados:");
				for (int i = 0; i < ListaProductos.size(); i++) {
					System.out.println(ListaProductos.get(i));
				}
				
				System.out.println("Desea ingresar otro Vendedor Si/No");
				Continuar=kb3.nextLine();
			} while (Continuar.equals("Si") || Continuar.equals("SI") 
					|| Continuar.equals("si") );
			
			kb0.close();
			kb1.close();
			kb2.close();
			kb3.close();
			
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
}
