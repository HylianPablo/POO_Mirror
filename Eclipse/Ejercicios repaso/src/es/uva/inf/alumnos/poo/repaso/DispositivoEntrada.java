/**
 * Paquete utilizado.
 * @author Pablo Martínez López.
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Se importa la clase ArrayList con el fin de almacenar los puertos válidos de la clase.
 */
import java.util.ArrayList;

/**
 * Implementación de la clase abstracta {@code DispositivoEntrada}, la cual hereda de {@Componente}. La abstracción representará a las clases {@code Teclado} y {@code Raton}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public abstract class DispositivoEntrada extends Componente {
	private String conector;
	private ArrayList<Integer> puertos;
	
	/**
	 * Inicialización de la clase {@code DispositivoEntrada} a partir de su precio, información de fabricante, modelo de la componente, tipo de conector y puertos asociados.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el fabricante de la componente.
	 * @param m Cadena de caracteres que representa el modelo de la componente.
	 * @param c Cadena de caracteres que representa el tipo de conector de la componente.
	 * @param caja Lista de números enteros que representa los puertos a los que puede estar asignado la componente.
	 */
	public DispositivoEntrada(double p, String f, String m, String c, ArrayList<Integer> caja) {
		super(p,f,m);
		conector=c;
		puertos=caja;
	}
	
	/**
	 * Consulta el tipo de conector asociado a la componente.
	 * @return Cadena de caracteres que representa el tipo de conector de la componente.
	 */
	public String getConector() {
		return conector;
	}
	
	/**
	 * Consulta los puertos a los que puede estar asociada la componente.
	 * @return {@code ArrayList} de números enteros que contiene los puertos a los que puede estar asociada la componente.
	 */
	public ArrayList<Integer> getPuertos(){
		return puertos;
	}

}
