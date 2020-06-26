/**
 * Paquete utilizado
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
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
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie.
 */
public class PickingPointsSystem {
	private ArrayList <PickingPoint> sistema;
	private int totalLocker;
	
	/**
	 * Inicialización de la clase {@code PickingPointsSystem}. Por defecto se crea con 0 cero {@code PickingPoints} en el sistema.
	 */	
	public PickingPointsSystem(){
		totalLocker=0;
		sistema=new ArrayList<>();
	}
	
	/**
	 * Consulta el número total de {@code PickingPoints} del sistema. Se garantiza que sea mayor o igual que 0.
	 * @return Número entero que representa la cantidad de {@code PickingPoints} en el sistema. 	
	 */
	public int getNumPickingPoints() {
		return totalLocker;
	}
	
	/**
	 * Consulta el {@code PickingPoint} asociado a un identificador introducido como parámetro. Si no se encuentra el {@code PickingPoint} se lanza una excepción. Permite al sistema administrar y realizar diversas operaciones sobre los {@code PickingPoints}.
	 * @return {@code PickingPoint} asociado al identificador.
	 * @throws NullPointerException cuando el {@code PickingPoint} no se encuentra en el sistema.
	 */
	public PickingPoint getPickingPoint(int id) {
		PickingPoint p =null;
		if(!this.estaPickingPoint(id)) {
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
	* Consulta si el {@code PickingPoint} identificado por el número introducido como parámetro está o no en el {@code PickingPoint}. Dos posibles valores: true, el {@code Package} está, o false, el {@code Package} no está.
	* @param id número entero que representa al {@code PickingPoint} en el sistema. 
	* @return Valor booleano true si el {@code Package} está en la taquilla o code false si no lo está.
	*/
	public boolean estaPickingPoint(int id) {
		int flag=0;
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getID()==id) {
				flag++; 
			}
		}
		return (flag!=0); 
	}
	
	/**
	 * Añade un nuevo {@code PickingPoint} introducido por parámetro al sistema. 
	 * @param p objeto del tipo {@code PickingPoint}, que representa el armario que se va añadir al sistema de Amazing Co.
	 * @throws IllegalArgumentException - cuando el {@code PickingPoint} introducido es nulo.
	 * @throws IllegalArgumentException - cuando se pretende añadir al sistema un {@code PickingPoint} con un identificador ya asignado a un {@code PickingPoint} del sistema.
	 */
	public void addPickingPoint(PickingPoint p) {
		if(p==null) {
			throw new IllegalArgumentException("El PickingPoint no puede ser nulo");
		}
		if(!sistema.isEmpty()) {
			for(int i=0;i<sistema.size();i++) {
				if( sistema.get(i).getID()==p.getID()) {
					throw new IllegalArgumentException("No pueden existir dos PickingPoints con el mismo identificador.");
				}
			}
		}
		sistema.add(p);
		totalLocker++;
	}
	
	/**
	 * Consulta que {@code PickingPoints} se encuentran a una distacia menor que la introducida como parámetro de las coordenadas, del tipo GPSCoordinate, también introducidas por parámetros. Se compara la localización de cada {@code PickingPoint} del {@code ArrayList} con unas coordenadas y si la distancia introducida abarca las coordenadas introducidas, se añade el {@code PickingPoint} a un {@code Arraylist} en el que entrarán todos los {@code PickingPoints} que cumplen la condición.
	 * @param rad Radio de la distancia a la redonda en el que buscar {@code PickingPoints}. Introducido en metros.
	 * @param gps Coordenadas del tipo GPSCoordinate representadas mediante latitud y longitud.
	 * @return Un {@code ArrayList} donde están todos los {@code PickingPoints} dentro del círculo de centro y radio parámetros de la función.
	 */
	public ArrayList<PickingPoint> pickingPointsEnRadio(GPSCoordinate gps, double rad) {
		ArrayList<PickingPoint> caja=new ArrayList<>();
		rad=rad/1000; 
		for(int i=0;i<sistema.size();i++){
			PickingPoint pl=sistema.get(i);
			GPSCoordinate coor  = pl.getCoordinate();
			double dis=gps.getDistanceTo(coor);
			if(dis<=rad) {
				caja.add(pl);
			}
		}
		return caja;	
	}
	
	/**
	* Elimina el {@code PickingPoint} representado por el identificador introducido como parámetro del sistema. Si no se encuentra el {@code PickingPoint} en el sistema se lanza una excepción.
	 * @param id número entero que representa el identificador de un {@code PickingPoint} dentro del sistema. 
	 * @throws NullPointerException cuando el {@code PickingPoint} no existe o no se ha podido encontrar.
	 */
	public void removePickingPoint(int id) {
		if(!this.estaPickingPoint(id)) {
			throw new NullPointerException("El PickingPoint no existe o no se ha podido encontrar y borrar.");
		}
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getID()==id) {
				sistema.remove(i);
				totalLocker--; 
			}
		}
	}
	
	/**
	 * Consulta que {@code PickingPoints} se encuentran operativos del sistema.
	 * @return Una lista con todos los {@code PickingPoints} operativos.
	 */
	public ArrayList<PickingPoint> pickingPointsOperativos() {
		ArrayList<PickingPoint> caja = new ArrayList<>();
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).getOperative()) {
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
	
	/**
	 * Consulta que {@code PickingPoints} se encuentran fuera de servicio del sistema.
	 * @return Una lista con todos los {@code PickingPoints} no operativos.
	 */
	public ArrayList<PickingPoint> pickingPointsFueraServicio() {
		ArrayList<PickingPoint> caja = new ArrayList<>();
		for(int i=0;i<sistema.size();i++) {
			if(!sistema.get(i).getOperative()){
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
	
	/**
	 * Consulta que {@code PickingPoints} tienen taquillas vacías.
	 * @return Devuelve una lista con los {@code PickingPoints}  que tienen taquillas vacías.
	 */
	public ArrayList<PickingPoint> pickingPointsConEspacio() {
		ArrayList<PickingPoint> caja = new ArrayList<>();
		for(int i=0;i<sistema.size();i++) {
			if(sistema.get(i).hayEspacio()) {
				caja.add(sistema.get(i));
			}
		}
		return caja;
	}
	
	
	/**
	 * Consulta que {@code PickingPoints} tienen espacio disponible y se encuentran a una distacia menor que la introducida como parámetro de las coordenadas, del tipo GPSCoordinate, también introducidas por parámetros. Se compara la localización de cada {@code PickingPoint} del {@code ArrayList} con unas coordenadas y si la distancia introducida abarca las coordenadas introducidas, se añade el {@code PickingPoint} a un {@code Arraylist} en el que entrarán todos los {@code PickingPoints} que cumplen las condiciones.
	 * @param rad Radio de la distancia a la redonda en el que buscar {@code PickingPoints}. Introducido en metros.
	 * @param gps Coordenadas del tipo GPSCoordinate representadas mediante latitud y longitud.
	 * @return Un {@code ArrayList} donde están todos los {@code PickingPoints} con espacio disponible dentro del círculo de centro y radio parámetros de la función.
	 */
	public ArrayList<PickingPoint> pickingPointsEnRadioLibres(GPSCoordinate gps, double rad) {
		ArrayList<PickingPoint> caja=new ArrayList<>();
		rad=rad/1000; 
		for(int i=0;i<sistema.size();i++){
			PickingPoint pl=sistema.get(i);
			GPSCoordinate coor  = pl.getCoordinate();
			double dis=gps.getDistanceTo(coor);
			if(dis<=rad && pl.hayEspacio()) {
				caja.add(pl);
			}
		}
		return caja;	
	}
}