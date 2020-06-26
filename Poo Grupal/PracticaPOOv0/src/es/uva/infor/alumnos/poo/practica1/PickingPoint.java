/**
 * Paquete utilizado.
 * @author Pamarti
 * @author Manmend 
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 * Se importa la clase java.util.ArrayList para usar el TAD ArrayList.
 */
import java.util.ArrayList;

import es.uva.inf.poo.maps.GPSCoordinate;

/**
 * Implementación de la clase abstracta {@code PickingPoint}. Representa una abstracción de los 4 tipos de puntos de recogida: {@code Kiosk}, {@code PostOffice}, {@code PickingPointHub} y {@code PackageLocker}. 
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
 */
public abstract class PickingPoint {

	private int identifier;
	private GPSCoordinate gps;
	private ArrayList<Package> taq=new ArrayList<>();
	private boolean operative;
	
	/**
	 * Inicialización de la clase abstracta {@code PickingPoint}, indicando su identificador y su posición geográfica, a través de las coordenas del tipo GPSCoordinate.
	 * @param id entero que representa al identificador del {@code PickingPoint}. Se requiere que sea mayor o igual que cero.
	 * @param g coordenadas del tipo GPSCoordinate que representan la posición del {@code PickingPoint}.
	 * @throws IllegalArgumentException cuando identifier es incorrecto, es decir, cuando es negativo.
	 */
	public PickingPoint(int id, GPSCoordinate g) {
		if(id<0) {
			throw new IllegalArgumentException("El identificador no puede ser menor que cero");
		}
		identifier=id;
		gps=g;
		operative=true;
	}
	
	/**
	* Consulta si el {@code PickingPoint} está operativo o no. Dos posibles valores: true, {@code PickingPoint} operativo, y false, {@code PickingPoint} no operativo.
	 * @return Valor booleano que indica si está operativo o no.
	 */
	public boolean getOperative() {
		return operative;
	}

	/**
	* Establece si el {@code PickingPoint} está operativo o no a partir del parámetro. Dos posibles valores: true, {@code PickingPoint} operativo, y false, {@code PickingPoint} no operativo.
	 * @param b Valor booleano que establece si está operativo o no.
	 */
	public void cambioOperativo(boolean b) {
		operative=b;
	}
	
	protected void addToTaq(Package p) {
		taq.add(p);
	}
	
	protected Package getFromTaq(int i) {
		return taq.get(i);
	}
	
	protected void removeFromTaq(int i) {
		taq.remove(i);
	}
	
	/**
	 * Devuelve el número de espacios ocupados en el {@code PickingPoint} por {@code Packages}.
	 * @return número entero que representa el número de {@code Packages} que almacena el {@code PickingPoint}.
	 */
	public int getTaquillasLlenas() {
		return taq.size();
	}
	
	/**
	 * Devuelve el número de espacios disponibles en el {@code PickingPoint} para almacenar {@code Packages}.
	 * @return número entero que representa el espacio disponible. Al ser este ilimitado, se devuelve infinito positivo.
	 */
	public int getTaquillasVacias() {
		return (int)Double.POSITIVE_INFINITY;
	}
	
	/**
	 * Comprueba si existe espacio disponible dentro de la capacidad del {@code PickingPoint}, es decir comprueba si existen taquillas vacías. Al ser la capacidad ilimitada, siempre hay espacio.
	 * @return Booleano {@code true} al existir siempre espacio en el {@code PickingPoint}.
	 */
	public boolean hayEspacio() {
		return true;
	}

	/**
	* Consulta las coordenadas GPS del {@code PickingPoint}. Localizan su posición en toda la Tierra. La localización se realiza caracterizando la latitud y la longitud de la posición.
	 * @return Coordenadas de {@code PickingPoint} del tipo GPSCoordinate. Estas coordenadas vienen representadas por longitud y latitud en Grados ,º, Minutos ,', y Segundos,".
	 */
	public GPSCoordinate getCoordinate() {
		return (gps);
	}
	
	/**
	 * Consulta el identificador del {@code PickingPoint}.
	 * @return Una cadena de caracteres que representa al {@code PickingPoint}. Esta cadena permite al cliente y al sistema de administración de AmazingCo identificar al {@code PickingPoint}. Se garantiza que no es nula.
	 */
	public int getID() {
		return identifier;
	}

	/**
	 * Almacena el {@code Package} indicado por parámetro en el {@code PickingPoint}.
	 * @param p objeto del tipo {@code Package}, que representa un paquete a almacenar, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @throws IllegalStateException cuando el {@code PickingPoint} no está operativo.
	 * @throws IllegalArgumentException cuando el {@code Package} ya ha sido almacenado anteriormente.
	 */
	public void asignaPaquete(Package p) {
		if(!this.getOperative()) {
			throw new IllegalStateException("El PickingPoint no se encuentra operativo, imposible realizar la operación.");
		}
		if(estaPaquete(p.getID())) {
			throw new IllegalArgumentException("El paquete ya se encuentra almacenado.");
		}
		taq.add(p);
	}

	/**
	 * Consulta que posición del {@code PickingPoint} ocupa el {@code Package} introducido como párametro. En caso, de que ninguna taquilla lo contenga devolverá la posición -1.
	 * @param p objeto del tipo {@code Package}, que representa el paquete del cual queremos averiguar la posición que ocupa en el sistema del {@code PickingPoint}, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @return i Número entero que representa la posición. Permite al sistema de AmazingCo obtener el índice para acceder al {@code Package} en el sistema. Si no se encuentra retorna el valor '-1'.
	 * @throws IllegalStateException cuando el {@code PickingPoint} no está operativo.
	 */
	public int buscaPaquete(Package p) {
		if(!this.getOperative()) {
			throw new IllegalStateException("El PickingPoint no se encuentra operativo, no se puede realizar la operación");
		}
		for(int i=0;i<taq.size();i++) {
			if(taq.get(i)!=null && taq.get(i).equals(p)) {
				return (i); 	
			}
		}
		return -1;
		
	}

	/**
	 * Extrae el paquete introducido como parámetro del {@code PickingPoint}.Si el {@code PickingPoint} no lo contiene se lanza una excepción.
	 * @param id cadena de texto que representa al identificador del paquete.
	 * @return El paquete que ocupa la posicion 'i' en el almacenamiento del {@code PickingPoint}.
	 * @throws IllegalStateException cuando el {@code PickingPoint} no está operativo.
	 * @throws NullPointerException cuando el paquete no existe o no se encuentra en el {@code PickingPoint}.
	 */
	public Package sacarPaquete(String id) {
		if(!this.getOperative()) {
			throw new IllegalStateException("El PickingPoint no se encuentra operativo, no se puede realizar la operación.");
		}
		if(!this.estaPaquete(id)) {
			throw new NullPointerException("El paquete no existe o no se encuentra en el PickingPoint.");
		}
		Package paq=null;
		for(int i=0;i<taq.size();i++) {
			if(taq.get(i)!=null && taq.get(i).getID().equals(id)) {
				paq=taq.get(i);
				taq.remove(i);
			}
		}
		return paq;	
	}

	/**
	 * Comprueba si el paquete introducido como parámetro se encuentra en el {@code PickingPoint}.
	 * @param id - identificador del paquete que queremos comprobar si se encuentra en el {@code PickingPoint}.
	 * @return Valor booleano: {@code true} si el paquete se encuentra en el {@code PickingPoint} o false si no se encuentra.
	 */
	public boolean estaPaquete(String id) {
		for(int i=0;i<taq.size();i++) {
			if(taq.get(i)!=null && taq.get(i).getID().equals(id)) {
				return true;
			}
		}
		return false;
	}

}