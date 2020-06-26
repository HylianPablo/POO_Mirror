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
 * Implementación de la clase {@code Impresora}, la cual hereda de {@code DispositivoSalida}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public class Impresora extends DispositivoSalida{
	private String tipoCartucho;
	
	/**
	 * Inicialización de la clase {@code Impresora} a partir de su precio, información de fabricante, modelo de la componente, puertos asociados y tipo de cartucho utilizado.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el fabricante de la componente.
	 * @param m Cadena de caracteres que representa el modelo de la componente.
	 * @param caja Lista de números enteros que representa los puertos a los que puede estar asignado la componente.
	 * @param c Cadena de caracteres que representa el tipo de cartucho de tinta que utiliza la componente.
	 */
	public Impresora(double p,String f, String m,ArrayList<Integer> caja, String c) {
		super(p,f,m,caja);
		tipoCartucho=c;
	}
	
	/**
	 * Consulta el tipo de cartucho de tinta o tóner que utiliza la componente.
	 * @return Cadena de caracteres que representa el tipo de cartucha que utiliza la componente.
	 */
	public String getTipoCartucho() {
		return tipoCartucho;
	}

}
