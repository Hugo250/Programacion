package proyectoFinal;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class Programa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		BufferedReader bf;

		int op;
		Metodos ag;

		bf = new BufferedReader(new InputStreamReader(System.in));

		ag = new Metodos();
		String c;
		String n, f;

		do {

			System.out.println("\n**  ACEROS DEL MONTE  **\n");
			System.out.println("     ===   MENU  ===   \n");
			System.out.println("1......   Agregar");
			System.out.println("2......   Buscar");
			System.out.println("3......   Eliminar");
			System.out.println("4......   Modificar");
			System.out.println("5......   Listar");
			System.out.println("6......   Guardar");
			System.out.println("7......   Salir");
			op = Integer.parseInt(bf.readLine());

			switch (op) {

			case 1:

				
				Enumeration az= ag.total();

				int agregar;
				agregar = 0;
				
				while (az.hasMoreElements()) {
					c = (String) az.nextElement();
					Atributos per = ag.recuperar(c);
				agregar ++;
					
				}

				System.out.println("El total de elementos es" + agregar);
                agregar = agregar +1;				
				String cadenas = " ";
				cadenas= Integer.toString(agregar);
				
				
				
								
				System.out.println("**INTRODUCE DATOS DEL PRODUCTO**\n");
				System.out.println("Tipo:  ");
				n = bf.readLine();
				System.out.println("Lote:   ");
				f = bf.readLine();

				if (ag.agregar(cadenas, n, f)) {
					System.out.println("El producto se ha anadido con exito");

				} else {
					System.out.println("El numero de codigo ya existe, " + " No pudo ser anadido el Producto");
				}
					
				break;
				
				
			case 2:
                			
				System.out.println("Introduce codigo del producto: ");
				c = bf.readLine();
				Atributos p = ag.recuperar(c);
				if (p != null) {
					System.out.println("\nLos datos del Producto :");
					System.out.println("============================================");
					System.out.println("Codigo   Tipo   Lote");
					System.out.println("============================================");
					System.out.println(p.getCodigo() + "\t" + p.getTipo() + "\t" + p.getLote());
					System.out.println("____________________________________________");

				}
				break;

				
				
				
			case 3:

				int contador;
				contador = 0;
				
				Enumeration et = ag.total();

				
				while (et.hasMoreElements()) {
					c = (String) et.nextElement();
					Atributos per = ag.recuperar(c);
				contador ++;
					
				}

				
				String cadena = " ";
				cadena= Integer.toString(contador);
				
				
				if (ag.eliminar(cadena)) {
					System.out.println("\nEl Producto ha sido eliminado con exito");
					
					break;
				} else {
					System.out.println("\nEl codigo del producto no existe");

					break;
	
				}

				
			case 4:

				String sigue = " ";
				System.out.println("\nIntroduce codigo del producto");
				c = bf.readLine();
				if (ag.eliminar(c)) {
					System.out.println("**INTRODUCE DATOS DEL PRODUCTO**\n");
					//System.out.println("Codigo:  ");
					sigue = c;
					//c = bf.readLine();
					System.out.println("Tipo:  ");
					n = bf.readLine();
					System.out.println("Lote:   ");
					f = bf.readLine();

					if (ag.agregar(sigue, n, f)) {
						System.out.println("El producto se ha modificado con exito");

					} else {
						System.out.println(
								"El producto no puedo ser modificado intente de nuevo con otro numero de codigo");
					}
				}

				break;

			case 5:

				Enumeration e = ag.total();

				System.out.println("\nLos Datos del Producto :");
				System.out.println("============================================");
				System.out.println("Codigo   Tipo   Lote");
				System.out.println("============================================");

				while (e.hasMoreElements()) {
					c = (String) e.nextElement();
					Atributos per = ag.recuperar(c);
					System.out.println(per.getCodigo() + "\t" + per.getTipo() + "\t" + per.getLote());

				}
				System.out.println("____________________________________________");

				break;

			case 6:

				System.out.println("Los datos se han guadado con exito...  ");
				ag.guardar();

			}

		} while (op != 7);

	}

}
