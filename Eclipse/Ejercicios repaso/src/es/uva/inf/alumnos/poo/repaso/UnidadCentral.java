/**
 * Paquete utilizado.
 * @author Pablo Martínez López
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Implementación de la clase {@code UnidadCentral}, la cual hereda de la clase {@code Componente}. Representa a la componente base de un ordenador.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public class UnidadCentral extends Componente {
	private int watios;
	
	/**
	 * Inicialización de la clase {@code UnidadCentral} a partir de su precio, información del fabricante, modelo y watios.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el fabricante de la componente.
	 * @param m Cadena de caracteres que representa el modelo de la componente.
	 * @param w Número entero que representa los watios que necesita la componente para funcionar.
	 */
	public UnidadCentral(double p, String f, String m, int w) {
		super(p,f,m);
		watios=w;
	}
	
	/**
	 * Consulta el número de watios que necesita la {@code UnidadCentral} para funcionar.
	 * @return Número entero que representa los watios que necesita la componente para funcionar.
	 */
	public int getWatios() {
		return watios;
	}

}
