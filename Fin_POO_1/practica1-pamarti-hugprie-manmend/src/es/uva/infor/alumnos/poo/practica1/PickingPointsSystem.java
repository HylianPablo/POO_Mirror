/**
 * Paquete utilizado
 * @author Pamarti Manmend Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase java.util.ArrayList para usar el TAD ArrayList.
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 */	
import es.uva.inf.poo.maps.GPSCoordinate;
import java.util.ArrayList;

/**
 * Implementación de la clase PickingPointsSystem.
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie.
 */
public class PickingPointsSystem {
	private ArrayList <PackageLocker> sistema;
	private int totalLocker;
	
	/**
	 * Inicialización de la clase {@code PickingPointsSystem}. Por defecto se crea con 0 cero Package Lockers en el sistema.
	 */	
	public PickingPointsSystem(){
		totalLocker=0;
		sistema=new ArrayList<PackageLocker>();
	}
	
	/**
	 * Consulta el número total de {@code PackageLocker} del sistema. Se garantiza que sea mayor o igual que 0.
	 * @return Número entero que representa la cantidad de {@code PackageLocker} en el sistema. 	
	 */
	public int getNumPackageLockers() {
		return totalLocker;
	}
	
	/**
	 * Consulta el {@code PackageLocker} asociado a un identificador introducido como parámetro. Si no se encuentra el {@code PackageLocker} se lanza una excepción. Permite al sistema administrar y realizar diversas operaciones sobre los {@code PackageLocker}
	 * @return {@code PackageLocker} asociado al identificador.
	 */
	public PackageLocker getPackageLocker(int id) {
		PackageLocker p =null;
		if(!this.estaPackageLocker(id)) {
			throw new NullPointerException();
		}
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getID()==id) {
				p= sistema.get(i);
			}
		}
		return p;
	}
	
	/**
	* Consulta si el {@code PackageLocker} identificado por el número introducido como parámetro está o no en el {@code PackageLocker}. Dos posibles valores: true, el {@code Package} está, o false, el {@code Package} no está.
	* @param id número entero que representa al {@code PackageLocker} en el sistema. 
	* @return Valor booleano true si el {@code Package} está en la taquilla o code false si no lo está.
	*/
	public boolean estaPackageLocker(int id) {
		int flag=0;
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getID()==id) {
				flag++; 
			}
		}
		if(flag==0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Añade un nuevo {@code PackageLocker} introducido por parámetro al sistema. 
	 * @param p objeto del tipo {@code PackageLocker}, que representa el armario que se va añadir al sistema de Amazing Co.
	 * @throws IllegalArgumentException - cuando se pretende añadir al sistema un {@code PackageLocker} con un identificador ya asignado a un {@code PackageLocker} del sistema.
	 */
	public void addPackageLocker(PackageLocker p) {
		if(p==null) {
			throw new IllegalArgumentException("El PackageLocker no puede ser nulo");
		}
		if(sistema.size()!=0) {
			for(int i=0;i<sistema.size();i++) {
				if( sistema.get(i).getID()==p.getID()) {
					throw new IllegalArgumentException("No pueden existir dos PackageLockers con el mismo identificador.");
				}
			}
		}
		sistema.add(p);
		totalLocker++;
	}
	
	/**
	 * Consulta que {@code PackageLockers} se encuentran a una distacia menor que la introducida como parámetro de las coordenadas, del tipo GPSCoordinate, también introducidas por parámetros. Se compara la localización de cada {@code PackageLocker} del {@code ArrayList} con unas coordenadas y si la distancia introducida abarca las coordenadas introducidas, se añade el {@code PackageLocker} a un {@code Arraylist} en el que entrarán todos los {@code PackageLocker} que cumplen la condición.
	 * @param rad Radio de la distancia a la redonda en el que buscar {@code PackageLockers}. Introducido en metros.
	 * @param gps Coordenadas del tipo GPSCoordinate representadas mediante latitud y longitud.
	 * @return Una {@code ArrayList} donde están todos los {@code PackageLocker} dentro del círculo de centro y radio parámetros de la función.
	 */
	public ArrayList<PackageLocker> packageLockersEnRadio(GPSCoordinate gps, double rad) {
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		rad=rad/1000; 
		for(int i=0;i<sistema.size();i++){
			PackageLocker pl=sistema.get(i);
			GPSCoordinate coor  = pl.getCoordinate();
			double dis=gps.getDistanceTo(coor);
			if(dis<=rad) {
				caja.add(pl);
			}
		}
		return caja;	
	}
	
	/**
	* Elimina el {@code PackageLocker} representado por el identificador introducido como parámetro del sistema. Si no se encuentra el {@code PackageLocker} en el sistema se lanza una excepción.
	 * @param id número entero que representa el identificador de un {@code PackageLocker} dentro del sistema. 
	 * @throws NullPointerException cuando el {@code PackageLocker} no existe o no se ha podido encontrar.
	 */
	public void removePackageLocker(int id) {
		if(!this.estaPackageLocker(id)) {
			throw new NullPointerException("El paquete no existe o no se ha podido encontrar y borrar.");
		}
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getID()==id) {
				sistema.remove(i);
				totalLocker--; 
			}
		}
	}
	
	/**
	 * Consulta que {@code PackageLockers} se encuentran operativos del sistema.
	 * @return Una lista con todos los {@code PackageLocker} operativos.
	 */
	public ArrayList<PackageLocker> packageLockersOperativos() {
		ArrayList<PackageLocker> caja = new ArrayList<PackageLocker>();
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getOperative()==true) {
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
	
	/**
	 * Consulta que {@code PackageLockers} se encuentran fuera de servicio del sistema.
	 * @return Una lista con todos los {@code PackageLocker} no operativos.
	 */
	public ArrayList<PackageLocker> packageLockersFueraServicio() {
		ArrayList<PackageLocker> caja = new ArrayList<PackageLocker>();
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getOperative()==false){
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
	
	/**
	 * Consulta que {@code Package Lockers} tienen taquillas vacías.
	 * @return Devuelve una lista con los {@code PackageLockers}  que tienen taquillas vacías.
	 */
	public ArrayList<PackageLocker> packageLockersConTaquillaVacia() {
		ArrayList<PackageLocker> caja = new ArrayList<PackageLocker>();
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getTaquillasVacias()!=0) {
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
}