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
 * Implementación de la clase abstracta {@code DispositivoSalida}, la cual hereda de {@code Componente}. La abstracción representará a las clases {@code Pantalla} e {@code Impresora}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public abstract class DispositivoSalida extends Componente {
	private ArrayList<Integer> puertos;
	
	/**
	 * Inicialización de la clase {@code DispositivoSalida} a partir de su precio, información de fabricante, modelo de la componente y puertos asociados.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el fabricante de la componente.
	 * @param m Cadena de caracteres que representa el modelo de la componente.
	 * @param caja Lista de números enteros que representa los puertos a los que puede estar asignado la componente.
	 */
	public DispositivoSalida(double p, String f, String m,ArrayList<Integer> caja) {
		super(p,f,m);
		puertos=caja;
	}
	
	
	/**
	 * Consulta los puertos a los que puede estar asociada la componente.
	 * @return {@code ArrayList} de números enteros que contiene los puertos a los que puede estar asociada la componente.
	 */
	public ArrayList<Integer> getPuertos(){
		return puertos;
	}

}