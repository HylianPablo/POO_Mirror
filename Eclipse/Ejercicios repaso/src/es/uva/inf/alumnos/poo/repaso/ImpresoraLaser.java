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
 * Implementación de la clase {@code ImpresoraLaser}, la cual hereda de {@code Impresora}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public class ImpresoraLaser extends Impresora {
	private int paginasImpresas;
	
	/**
	 * Inicialización de la clase {@code ImpresoraLaser} a partir de su precio, información de fabricante, modelo de la componente, puertos asociados y tipo de cartucho utilizado.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el fabricante de la componente.
	 * @param m Cadena de caracteres que representa el modelo de la componente.
	 * @param caja Lista de números enteros que representa los puertos a los que puede estar asignado la componente.
	 * @param c Cadena de caracteres que representa el tipo de cartucho de tinta que utiliza la componente.
	 */
	public ImpresoraLaser(double p, String f, String m, ArrayList<Integer> caja, String c) {
		super(p,f,m,caja,c);
		paginasImpresas=0;
	}
	
	/**
	 * Aumenta el número de páginas impresas desde el último recambio de tóner de la componente.
	 * @param n Número entero que representa el número de páginas a aumentar.
	 * @throws IllegalArgumentException cuando el número de páginas a aumentar es menor o igual a cero.
	 */
	public void addPaginas(int n) {
		if(n<=0) {
			throw new IllegalArgumentException("Las páginas impresas no pueden ser menores o iguales a cero.");
		}
		paginasImpresas+=n;
	}
	
	/**
	 * Resetea el número de páginas impresas cuando se cambia el tóner de la impresora.
	 */
	public void resetPaginas() {
		paginasImpresas=0;
	}
	
	/**
	 * Consulta el número de páginas impresas desde el último cambio de tóner de la impresora.
	 * @return Número entero que representa el número de páginas impresas desde el último cambio de tóner.
	 */
	public int getPaginasImpresas() {
		return paginasImpresas;
	}

}
