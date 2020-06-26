/**
 * Paquete utilizado.
 * @author Pamarti
 * @author Hugprie
 * @author Manmend
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase java.time.LocalDate con el fin de implementar las fechas necesarias.
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 * Se importa la clase java.util.ArrayList para usar el TAD ArrayList.
 */
import java.time.LocalDate;
import es.uva.inf.poo.maps.GPSCoordinate;
import java.util.ArrayList;

/**
 * Implementación de la clase {@code PostOffice}. Esta clase es descendiente de {@code PickingPoint} y otorga espacio ilimitado para el almacenaje. Permite realizar entregas de paquetes certificados a través de cobros contra reembolso, donde el dinero se irá acumulando hasta que se vacíe.
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti
 * @author Hugprie
 * @author ManMend
 *
 */
public class PostOffice extends PickingPoint implements IdentificationRegistry {
	private double totalDinero;
	private ArrayList<Package> registro;
	
	
	/**
	 * Inicialización de la clase {@code PostOffice} indicando su identificador y sus coordenadas.
	 * @param id número entero que representa al {@code PostOffice}. Permite al usuario y al sistema de AmazingCo identificar el {@code PostOffice}.
	 * @param g coordenadas del tipo GPSCoordinate. Representan mediante longitud y latitud la posición del {@code PostOffice}.
	 */
	public PostOffice(int id, GPSCoordinate g) {
		super(id,g);
	}
	
	public boolean isPackagePickupRegistered(String packageCode) {
		for(int i=0;i<getTaquillasLlenas();i++) {
			if(getFromTaq(i).getID().equals(packageCode)) {
				return true;
			}
		}
		return false;
	}
	
	public Package getPackageRegistered(String packageCode) {
		Package p=null;
		if(!isPackagePickupRegistered(packageCode)) {
			throw new IllegalArgumentException("El paquete no existe o no se encuentra disponible.");
		}
		for(int i=0;i<registro.size();i++) {
			if(registro.get(i).getID().equals(packageCode)) {
				p=registro.get(i);
			}			
		}
		return p;
	}
	
	public String getRegisteredIdFor(String packageCode) {
		String dni =null;
		if(!isPackagePickupRegistered(packageCode)) {
			throw new IllegalArgumentException("El paquete no existe o no se encuentra.");
		}
		dni = getPackageRegistered(packageCode).getArrID().get(0);
		return dni;
	}
	
	public LocalDate getPickupDateFor(String packageCode) {
		LocalDate ld =null;
		if(!isPackagePickupRegistered(packageCode)) {
			throw new IllegalArgumentException("El paquete no existe o no se encuentra.");
		}
		
		ld = getPackageRegistered(packageCode).getDate();
		
		return ld;
	}
	
	
	public void registerCertifiedPackagePickup(Package p, String dni, LocalDate pickupDate) {
		if(p==null) {
			throw new IllegalArgumentException("El paquete no puede ser nulo.");
		}
		if(isPackagePickupRegistered(p.getID())) {
			throw new IllegalArgumentException("El paquete ya ha sido registrado.");
		}
		if(p.getArrID()==null) {
			throw new IllegalArgumentException("El paquete debe tener asignado un DNI.");
		}
		if(pickupDate==null) {
			throw new IllegalArgumentException("La fecha no puede ser nula.");
		}
		
		String identifier = p.getID();
		LocalDate f = pickupDate;
		Double prize = p.getPrecio();
		boolean paid = p.pagado();
		ArrayList<String> arr = new ArrayList<>();
		arr.add(dni);
		boolean c = p.certificado();
		boolean rec = p.getRecogido();
		boolean dev = p.getDevuelto();
		
		Package paq = new Package(identifier, f, prize, paid, arr, c);
		
		paq.changeRecogido(rec);
		paq.changeDevuelto(dev);
		
		registro.add(paq);
		
	}
	
	/**
	 * Consulta el dinero total almacenado en el {@code PostOffice}.
	 * @return {@code Double} representativo del dinero total almacenado.
	 */
	public double getDinero() {
		return totalDinero;
	}
	
	/**
	 * Vacía el dinero total acumulado del {@code PostOffice}.
	 */
	public void vaciaDinero() {
		totalDinero=0;
	}
	
	/**
	 * Actualiza la cantidad de dinero recaudada por el {@code PostOffice} debido al servicio de pago a contrarrembolso. Suma a la cantidad actual, el precio del último paquete pagado.
	 * @param precio cantidad de tipo doble que representa el precio de un paquete pagado a contrarrembolso en el {@code PostOffice}.
	 * @throws IllegalArgumentException si el precio es negativo. Se contempla la posibilidad de que el paquete sea gratis.
	 */
	public void sumaDinero(double precio) {
		if(precio<0) {
			throw new IllegalArgumentException("El precio no puede ser menor que cero.");
		}
		totalDinero+=precio;
	}
}
