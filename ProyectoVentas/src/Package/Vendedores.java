package Package;

import java.io.*;

public class Vendedores {
	public static void verVendedores() {
		File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        String linea = null;
 
        try {
            //Cargamos el archivo de la ruta relativa
            archivo = new File("src/Archivos/Vendedores.csv");
            //Cargamos el objeto FileReader
            fr = new FileReader(archivo);
            //Creamos un buffer de lectura
            br = new BufferedReader(fr);
 
            String[] datos = null;
 
            //Leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {
 
                //Utilizamos el separador para los datos
                datos = linea.split(";");
                //Presentamos los datos
                System.out.println(datos[0] + "\t" + datos[1] + "\t" + datos[2] + "\t" + datos[3]);
 
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
