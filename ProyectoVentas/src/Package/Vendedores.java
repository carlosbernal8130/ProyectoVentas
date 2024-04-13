package Package;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendedores {
	public static void IngresoVend() {
		try (Scanner teclado = new Scanner(System.in);
				Scanner teclado1 = new Scanner(System.in);
				Scanner teclado2 = new Scanner(System.in);
				Scanner teclado3 = new Scanner(System.in);
				Scanner teclado4 = new Scanner(System.in)) {
			String TipoDoc, NombreVendor, ApellidoVendor, Continuar, NumDoc;
			
			ArrayList<String> ListaVendedores = new ArrayList<String>();
			
			do{
				System.out.println("Digite el tipo de documento (CC, RC, TI, PE, PS): ");
				TipoDoc=teclado.nextLine();
				System.out.println("Número de documento: ");
				NumDoc= teclado1.nextLine();
				System.out.println("Nombres del Vendedor: ");
				NombreVendor= teclado2.nextLine();
				System.out.println("Apellidos del Vendedor: ");
				ApellidoVendor= teclado3.nextLine();
				System.out.println("");
				
				ListaVendedores.add(TipoDoc + ";" + NumDoc + ";" + NombreVendor + ";" 
				+ ApellidoVendor);
				
				
				System.out.println("Datos Ingresados:");
				for (int i = 0; i < ListaVendedores.size(); i++) {
					System.out.println(ListaVendedores.get(i));
				}
				
				
				System.out.println("Desea ingresar otro Vendedor Si/No");
				Continuar=teclado4.nextLine();
			} while (Continuar.equals("Si") || Continuar.equals("SI") 
					|| Continuar.equals("si") ); 
			
			teclado.close();
			teclado1.close();
			teclado2.close();
			teclado3.close();
			teclado4.close();
			
			try {
				FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "/src/Archivos/Vendedores.csv", true);
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
	}
	
}
