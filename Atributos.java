package proyectoFinal;

import java.io.*;

public class Atributos implements Serializable {

	private String codigo;
	private String tipo;
	private String lote;

	public Atributos(String c, String n, String f) {

		codigo = c;
		tipo = n;
		lote = f;
	}

	public void setCodigo(String c) {
		codigo = c;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setTipo(String n) {
		tipo = n;
	}

	public String getTipo() {
		return tipo;
	}

	public void setLote(String f) {
		lote = f;
	}

	public String getLote() {
		return lote;
	}

}
