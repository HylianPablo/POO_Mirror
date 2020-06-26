/**
 * Paquete utilizado.
 * @author Pablo Martínez López
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Implementación de la clase abstracta  {@code Componente}. Representa una abstracción de las tres componentes básicas: {@code UnidadCentral}, {@code DispositivoEntrada} y {@code DispositivoSalida}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 *
 */
public abstract class Componente {
	
	private double precio;
	private String fabricante;
	private String modelo;
	
	/**
	 * Inicialización de la clase {@code Componente} a partir de su precio, nombre del fabricante y nombre del modelo.
	 * @param p Número en doble precisión flotante que representa el precio de la componente.
	 * @param f Cadena de caracteres que representa el nombre del fabricante de la componente.
	 * @param m Cadena de caracteres que representa el nombre del modelo de la componente.
	 */
	public Componente(double p, String f, String m) {
		precio=p;
		fabricante=f;
		modelo=m;
	}
	
	/**
	 * Consulta el precio de la componente.
	 * @return Número en doble precisión flotante que representa el precio de la componente.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Consulta el fabricante de la componente.
	 * @return Cadena de caracteres que representa el nombre del fabricante de la componente.
	 */
	public String getFabricante() {
		return fabricante;
	}
	
	/**
	 * Consulta el modelo de la componente.
	 * @return Cadena de caracteres que representa el modelo de la componente.
	 */
	public String getModelo() {
		return modelo;
	}

}
