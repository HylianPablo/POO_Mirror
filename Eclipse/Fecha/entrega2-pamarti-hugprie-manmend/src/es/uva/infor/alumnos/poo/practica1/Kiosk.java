/**
 * Paquete utilizado
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 */
import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * Implementación de la clase {@code Kiosk}. La clase {@code Kiosk} representa un negocio que ofrece el servicio de recogida y pago a contrarrembolso de AmazingCo y se encuentra en el sistema de {@code PickingPointSystem}. 
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
 */
public class Kiosk extends GroupablePoint {
	private double totalDinero=0.0;
	
	/**
	 * Inicialización de la clase {@code Kiosk}, indicando su identificador, su capacidad y su posición geográfica, a través de las coordenas del tipo GPSCoordinate.
	 * @param id entero que representa al identificador del {@code Kiosk}. Se requiere que sea menor o igual que cero.
	 * @param nTaq entero que representa la capacidad del {@code Kiosk}, es decir, el número de paquetes que puede almacenar.
	 * @param g coordenadas del tipo GPSCoordinate que representan la posición del {@code Kiosk}.
	 */
	public Kiosk(int id, int nTaq, GPSCoordinate g) {
		super(id,nTaq,g);
	}
	
	/**
	 * Consulta el dinero acumulado en el {@code Kiosk} debido al negocio de pago a contrarrembolso.
	 * @return Una cantidad de tipo {@code double}.
	 */
	public double getDinero() {
		return totalDinero;
	}
	
	/**
	 * Actualiza la cantidad de dinero recaudada por el {@code Kiosk} tras pagar a AmazingCo la recaudación por el servicio de pago a contrarrembolso. El dinero acumulado por el {@code Kiosk} pasa a ser cero.
	 */
	public void vaciaDinero() {
		totalDinero=0;
	}
	
	/**
	 * Establece la nueva capacidad de almacenaje del {@code Kiosk} indicada por parámetro.
	 * @param tam número de tipo entero que indica el número de paquetes que puede almacenar el {@code Kiosk}.
	 * @throws IllegalArgumentException cuando se intenta cambiar el número de espacios a cero o inferior.
	 * @throws IllegalArgumentException cuando se intenta cambiar el número de espacios a un número menor que el número de espacios que se están usando en el momento.
	 */
	public void changeSize(int tam) {
		if(tam<=0) {
			throw new IllegalArgumentException("El número de espacios debe ser superior a cero.");
		}
		if(tam<getTaquillasLlenas()) {
			throw new IllegalArgumentException("No se pueden borrar espacios llenos.");
		}
		setNumTaquillas(tam);
	}
	
	/**
	 * Actualiza la cantidad de dinero recaudada por el {@code Kiosk} debido al servicio de pago a contrarrembolso. Suma a la cantidad actual, el precio del último paquete pagado.
	 * @param precio cantidad de tipo doble que representa el precio de un paquete pagado a contrarrembolso en el {@code Kiosk}.
	 * @throws IllegalArgumentException si el precio es negativo. Se contempla la posibilidad de que el paquete sea gratis.
	 */
		
	public void sumaDinero(double precio) {
		if(precio<0) {
			throw new IllegalArgumentException("El precio no puede ser negativo.");
		}
		totalDinero += precio;
	}
	
	/**
	 * Consulta si el tipo del objeto es de tipo {@code Kiosk}.
	 * @return Booleano {@code true} al ser un objeto de tipo {@code Kiosk}.
	 */
	@Override
	public boolean esKiosk() {
		return true;
	}
}
