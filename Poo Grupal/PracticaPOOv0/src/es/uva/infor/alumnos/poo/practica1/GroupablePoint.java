/**
 * Paquete utilizado.
 * @author Pamarti
 * @author Manmend 
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase java.time.LocalDate con el fin de utilizarla en la fecha límite.
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 */	
import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.LocalDate;

/**
 * Implementación de la clase {@code GroupablePoint}. Esta es una clase abstracta que hace de padre para las clases {@code PackageLocker} y {@code Kiosk}.
 * Segunda entrega de Programación Orientada a Objetos.
 * Univerisidad de Valladolid.
 * @author Pamarti
 * @author Hugprie
 * @author Manmend
 *
 */
public abstract class GroupablePoint extends PickingPoint {

	private int nLock;
	
	/**
	 * Inicialización de la clase abstracta {@code GroupablePoint}. Se inicializa indicando su identificador, el número de espacios/taquillas disponibles y sus coordenadas espaciales. Tanto el identificador como las coordenadas se utilizan en el constructor {@code super} del padre {@code PickingPoint}.
	 * @param id número entero que representa al {@code GroupablePoint}. Permite al usuario y al sistema de AmazingCo identificar el {@code GroupablePoint}.
	 * @param nTaq número entero que representa el número de espacios/taquillas del {@code GroupablePoint}. Permite comprobar si se pueden aceptar o no más paquetes en el sistema.
	 * @param g coordenadas del tipo GPSCoordiante. Representan mediante longitud y latitud la posición del {@code GroupablePoint}.
	 * @throws IllegalArgumentException cuando la capacidad del {@code GroupablePoint} es menor o igual que cero.
	 */
	public GroupablePoint(int id, int nTaq, GPSCoordinate g) {
		super(id,g);
		if(nTaq<=0) {
			throw new IllegalArgumentException("Argumento de número de espacios erróneo.");
		}
		nLock=nTaq;
	}

	/**
	 * Consulta el número de espacios/taquillas que contiene el {@code GroupablePoint}.
	 * @return Un número entero que representa los espacios libres del {@code GroupablePoint}. Garantiza que el resultado siempre es mayor o igual que cero.  		
	 */
	public int getNumTaquillas() {
		return nLock;
	}
	
	protected void setNumTaquillas(int i) {
		nLock=i;
	}
	
	/**
	 * Comprueba si existe espacio disponible dentro de la capacidad del {@code GroupablePoint}.
	 * @return Un valor booleano: {@code true} si existe al menos un espacio vacío dentro del {@code GroupablePoint} y {@code false} en caso contrario.
	 */
	@Override
	public boolean hayEspacio() {
		return getTaquillasVacias()!=0;
	}

	/**
	 * Consulta el número de espacios/taquillas vacíos del {@code GroupablePoint}.
	 * @return Número entero que indica el número de espacios/taquillas vacíos. Se garantiza que el número este comprendido entre 0 y el número total de espacios del {@code GroupablePoint}.
	 */
	@Override
	public int getTaquillasVacias() {
		return (nLock-getTaquillasLlenas());
	}
	
	/**
	 * Almacena el {@code Package} introducido por parámetro en el {@code GroupablePoint}. Si no queda espacio, se lanza una excepción.
	 * @param p objeto del tipo {@code Package}, que representa un paquete a almacenar, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @throws IllegalStateException cuando el {@code Package} es null.
	 * @throws IllegalStateException cuando no queda espacio en el {@code GroupablePoint}.
	 * @throws IllegalStateException cuando el {@code GroupablePoint} no está operativo.
	 * @throws IllegalArgumentException cuando el {@code Package} es certificado.
	 */
	
	@Override
	public void asignaPaquete(Package p) {
		if(p==null) {
			throw new IllegalArgumentException("El paquete no puede ser nulo.");
		}
		if(getTaquillasLlenas()>=getNumTaquillas()) {
			throw new IllegalStateException("Todas las taquillas están ocupadas.");
		}
		if(!this.getOperative()) {
			throw new IllegalStateException("El GroupablePoint no se encuentra operativo, imposible puede realizar la operación.");
		}
		if(p.certificado()) {
			throw new IllegalArgumentException("Los paquetes certificados sólo podrán recogerse en oficinas PostOffice.");
		}
		addToTaq(p);
	}
	
	/**
	 * Comprueba si el paquete introducido como parámetro se encuentra en el {@code GroupablePoint}.
	 * @param id entero que representa el identificador del {@code Package} que queremos comprobar si se encuentra en el {@code GroupablePoint}.
	 * @return Un valor booleano: {@code true} si el paquete se encuentra en el {@code GroupablePoint} o {@code false} si no se encuentra.
	 */
	@Override
	public boolean estaPaquete(String id) {
	
		for(int i=0;i<getTaquillasLlenas();i++) {
			if(getFromTaq(i).getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Consulta que espacio/taquilla del {@code GroupablePoint} contiene el {@code Package} introducido como párametro. En caso de que no esté contenido, se devolverá '-1'.
	 * @param p objeto del tipo {@code Package}, que representa el paquete del cual queremos averiguar su índice en el {@code ArrayList} el que se encuentra, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @return i Número entero que representa el índice en el {@code ArrayList} de {@code Packages} del {@code Package} introducido por parámetro. Si no se encuentra retorna el valor '-1'.
	 * @throws IllegalStateException cuando el {@code GroupablePoint} no está operativo.
	 * @throws IllegalStateException cuando el {@code Package} es null.
	 */
	@Override
	public int buscaPaquete(Package p) {
		if(p==null) {
			throw new IllegalArgumentException("El paquete no puede ser nulo.");
		}
		if(!this.getOperative()) {
			throw new IllegalStateException("El GroupablePoint no se encuentra operativo, no se puede realizar la operación.");
		}
		for(int i=0;i<getTaquillasLlenas();i++) {
			if(getFromTaq(i).equals(p)) {
				return (i); 	
			}
		}
		return -1;
		
	}
	
	/**
	 * Extrae el paquete introducido como parámetro del {@code GroupablePoint}. Si el {@code Package} no está se lanza una excepción.
	 * @param id entero que representa al identificador del {@code GroupablePoint}.
	 * @param fecha fecha del tipo {@code LocalDate} que representa la fecha del día actual.
	 * @return El paquete que ocupa la posicion 'i' en el array de {@code Packages} del {@code GroupablePoint}.
	 * @throws NullPointerException cuando el paquete no existe o no se encuentra en el {@code GroupablePoint}.
	 * @throws IllegalStateException cuando el {@code GroupablePoint} no está operativo.
	 */
	public Package sacarPaquete(String id, LocalDate fecha) {
		if(id==null) {
			throw new IllegalArgumentException("El identificador del paquete no puede ser nulo.");
		}
		if(fecha==null) {
			throw new IllegalArgumentException("La fecha no puede ser nula.");
		}
		if(!this.getOperative()) {
			throw new IllegalStateException("El GroupablePoint no se encuentra operativo, no se puede realizar la operación.");
		}
		if(!this.estaPaquete(id)) {
			throw new NullPointerException("El paquete no existe o no se encuentra en el GroupablePoint.");
		}
		Package paq=null;
		for(int i=0;i<nLock;i++) {
			if(getFromTaq(i).getID().equals(id)) {
				paq=getFromTaq(i);
				if(paq.pasadoDeadline(fecha)) {
					paq.changeDevuelto(true);
				}else {
					paq.changeRecogido(true);
				}
				removeFromTaq(i);
			}
		}
		return paq;	
		
	}
	
	/**
	 * Consulta si el tipo del objeto es de tipo {@code Kiosk}.
	 * @return booleano {@code false}, al no ser de tipo {@code Kiosk}.
	 */
	public boolean esKiosk() {
		return false;
	}

}