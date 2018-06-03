package proyectoFinal;

import java.util.*;
import java.io.*;

public class Metodos {

	private final String ruta = "C:/Users/hugoz/Desktop/Ejemplo2/datos.dat";

	Hashtable<String, Atributos> tabla;

	public Metodos() throws IOException, ClassNotFoundException {

		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {

			fi = new FileInputStream(ruta);
			oi = new ObjectInputStream(fi);
			tabla = (Hashtable) oi.readObject();

			oi.close();

		} catch (FileNotFoundException e) {

			tabla = new Hashtable<String, Atributos>();
		}

	}

	public boolean agregar(String c, String n, String f) {

		if (!tabla.containsKey(c)) {
			Atributos p = new Atributos(c, n, f);
			tabla.put(c, p);
			return true;

		} else {
			return false;
		}
	}

	public boolean eliminar(String c) {

		if (tabla.containsKey(c)) {
			tabla.remove(c);

			return true;
		} else {
			return false;
		}
	}

	public Atributos recuperar(String c) {
		if (tabla.containsKey(c)) {

			return tabla.get(c);

		} else {
			return null;
		}
	}

	public Enumeration total() {
		return tabla.keys();
	}

	public void guardar() throws IOException {

		FileOutputStream fo = new FileOutputStream(ruta);
		ObjectOutputStream os = new ObjectOutputStream(fo);

		try {
			os.writeObject(tabla);
			os.close();

		} catch (FileNotFoundException e) {

		}
	}
	
}
