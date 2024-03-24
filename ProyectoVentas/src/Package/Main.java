package Package;

public class Main {

	public static void main(String[] args) {
		Vendedores vendorsMethod = new Vendedores();
		Ventas salesMethod = new Ventas();
		Productos productsMethod = new Productos();
		
		System.out.println("Contenido archivo Vendedores separado por tabulaciones");
		vendorsMethod.verVendedores();
		System.out.println("");
		System.out.println("Contenido archivo Ventas separado por tabulaciones");
		salesMethod.verVentas("CC", "80156677");
		System.out.println("");
		System.out.println("Contenido archivo Productos separado por tabulaciones");
		productsMethod.verProductos();
		

	}

}
