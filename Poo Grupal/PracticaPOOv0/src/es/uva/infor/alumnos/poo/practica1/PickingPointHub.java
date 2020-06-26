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
import java.util.ArrayList;
import es.uva.inf.poo.maps.GPSCoordinate;


/**
* Implementación de la clase {@code PickingPointHub}. La clase {@code PickingPointHub} representa una agrupación de {@code GroupablePoints}. Deberá ser inicializado con al menos dos elementos. 
* Segunda entrega de Programación Orientada a Objetos.
* Universidad de Valladolid.
* @author Pamarti 
* @author Manmend 
* @author Hugprie
*/
public class PickingPointHub extends PickingPoint{
	
	private ArrayList<GroupablePoint> arrGPP;
	
	/**
	 * Inicializador de la clase {@code PickingPointHub} indicando su identificador, sus coordenadas espaciales y el conjunto inical de {@code GroupablePoints}.
	 * @param id número entero que representa al {@code PickingPointHub}. Permite al usuario y al sistema de AmazingCo identificar el {@code PickingPointHub}.
	 * @param g coordenadas del tipo GPSCoordinate. Representan mediante longitud y latitud la posición del {@code PickingPointHub}.
	 * @param arrGr objeto de tipo {@code ArrayList} que almacena {@code GroupablePoints}. Almacena las distintas componentes del agrupador.
	 * @throws IllegalArgumentException cuando se introduce un ArrayList con menos de dos elementos.
	 * @throws IllegalArgumentException cuando los elementos del ArrayList tienen coordenadas distintas.
	 */
	public PickingPointHub (int id, GPSCoordinate g,ArrayList<GroupablePoint> arrGr) {
		super(id,g);
		if(arrGr.size()<2) {
			throw new IllegalArgumentException("El tamaño del array no puede ser menor que dos.");
		}
		if(!identificadoresIguales(arrGr)) {
			throw new IllegalArgumentException("Los elementos no pueden tener el mismo identificador");
		}
		if(!coorIguales(arrGr,g)) {
			throw new IllegalArgumentException("Los elementos deben tener la misma localización.");
		}
		arrGPP=arrGr;
	}
	
	/**
	 * Devuelve el número de elementos que componen el {@code PickingPointHub}.
	 * @return un entero que es equivalente al número de elementos agrupados.
	 */
	public int getSize() {
		return arrGPP.size();
	}
	
	/**
	 * Comprueba si todos los {@code GroupablePoint} del {@code PickingPointHub} tienen las mismas coordenadas en longitud y latitud.
	 * @param arrGr ArrayList de {@code GroupablePoints} que pasarán a comprobarse.
	 * @param g coordenadas del tipo GPSCoordinate que representan la posición del {@code PickingPointHub}. 
	 * @return Valor booleano {@code true} si todas las coordenadas de los elementos son iguales y {@code false} en caso contrario.
	 */
	public boolean coorIguales(ArrayList<GroupablePoint> arrGr,GPSCoordinate g) {
		GPSCoordinate a=arrGr.get(0).getCoordinate();
		for(int i=1;i<arrGr.size();i++) {
			GPSCoordinate b=arrGr.get(i).getCoordinate();
			if(!a.equals(b)) {
				return false;
			}
			a=b;
		}
		return a.equals(g);
	}
	
	/**
	 * Comprueba si todos los {@code GroupablePoint} del {@code PickingPointHub} no tienen el mismo identificador.
	 * @param arrGr ArrayList de {@code GroupablePoints} que pasarán a comprobarse. 
	 * @return Valor booleano {@code true} si todos los identificadores de los elementos son iguales y {@code false} en caso contrario.
	 */
	public boolean identificadoresIguales(ArrayList<GroupablePoint> arrGr) {
		int a=arrGr.get(0).getID();
		for(int i=1;i<arrGr.size();i++) {
			int b=arrGr.get(i).getID();
			if(a==b) {
				return false;
			}
			a=b;
		}
		return true;
	}
	
	/**
	 * Añade un elemento más a la agrupación {@code PickingPointHub}.
	 * @param gpp objeto del tipo {@code GroupablePoint} que se añadirá a la agrupación.
	 */
	public void addGroupable(GroupablePoint gpp) {
		arrGPP.add(gpp);
	}
	
	/**
	 * Devuelve los puntos que forman el concentrador.
	 * @return Objeto tipo {@code ArrayList} que contiene los {@code GroupablePoints} que forman el {@code PickingPointHub}.
	 */
	public ArrayList<GroupablePoint> getPuntosDelSistema(){
		return arrGPP;
	}
	
	/**
	 * Comprueba si existe espacio en alguno de los elementos {@code GroupablePoint} del {@code PickingPointHub}.
	 * @return Valor booleano {@code true} si existe espacio en alguno de los elementos y {@code false} en caso contrario. 
	 */
	@Override
	public boolean hayEspacio(){
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).hayEspacio()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Consulta si existe algún elemento {@code GroupablePoint} en el {@code PickingPointHub} con capacidad de pago por contrareembolso.
	 * @return Valor booleano {@code true} si existe al menos un {@code Kiosk} y {@code false} en caso contrario.
	 */
	public boolean hayContraReembolso() {
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).esKiosk()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cambia el estado operativo del {@code PickingPointHub}. En caso de que deje de estar operativo, todos los elementos agrupados pasarán también a no estarlo.
	 * @param b Valor booleano que define el nuevo estado operativo del {@code PickingPointHub}.
	 */
	public void cambioOperativoTotal(boolean b) {
		cambioOperativo(b);
		if(!b) {
			for(int i=0;i<arrGPP.size();i++) {
				arrGPP.get(i).cambioOperativo(false);
			}
		}
	}
	
	/**
	 * Elimina un {@code GroupablePoint} del {@code PickingPointHub} respetando en íntegro momento que haya al menos dos elementos en el concentrador.
	 * @param gpp {@code GroupablePoint} que se desea eliminar.
	 * @throws IllegalStateException cuando se intenta eliminar un elemento que haría que tuviesen menos de dos elementos en total dentro del concentrador.
	 * @throws IllegalArgumentException cuando el {@code GroupablePoint} introducido para eliminar no se encuentra dentro del {@code PickingPointHub}. 
	 */
	public void removeGroupable(GroupablePoint gpp) {
		if(!estaGroupable(gpp)) {
			throw new IllegalArgumentException("El conjunto agrupable no existe o no se encuentra.");
		}
		if(arrGPP.size()==2) {
			throw new IllegalStateException("El tamaño del array no puede ser menor que dos.");
		}
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).getID()==gpp.getID()) {
				arrGPP.remove(i);
			}
		}
	}
	
	/**
	 * Comprueba si un objeto del tipo {@code GroupablePoint} se encuentra en el {@code PickingPointHub}.
	 * @param gpp {@code GroupablePoint} que se comprobará su existencia dentro del agrupador.
	 * @return Valor booleano {@code true} si se encuentra el {@code GroupablePoint}, y {@code false} en caso contrario.
	 */
	public boolean estaGroupable(GroupablePoint gpp) {
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).getID()==gpp.getID()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si un {@code Package} se encuentra dentro de cualquiera de los elementos interiores del {@code PickingPointHub}.
	 * @param id identifier cadena de texto que representa al identificador del paquete.
	 * @return Valor booleano {@code true} en caso de que se encuentre el paquete y {@code false} en caso contrario.
	 */
	@Override
	public boolean estaPaquete(String id) {
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).estaPaquete(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Asigna un {@code Package} al {@code PickingPointHub} si hay espacio disponible en alguno de sus elementos interiores.
	 * @param p {@code Package} que se pretende asignar.
	 */
	@Override
	public void asignaPaquete(Package p) {
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).hayEspacio()) {
				arrGPP.get(i).asignaPaquete(p);
			}
		}
	}
	
	/**
	 * Busca el {@code Package} introducido como parámetro dentro de los diversos {@code GroupablePoint} almacenados en el {@code PickingPointHub}. Se consideran los espacios/taquillas como un array unidimensional, poniendo el primer espacio/taquilla de el {@code GroupablePoint} 'n+1' después del último espacio/taquilla del {@code GroupablePoint} 'n'.
	 * @param p {@code Package} que se pretende buscar en el {@code PickingPointHub}.
	 * @return número entero que representa el espacio en que se encuentra el {@code PickingPointHub}. Retorna el valor '-1' en caso de no encontrar el {@code Package}.
	 */
	@Override
	public int buscaPaquete(Package p) {
		int resultado;
		for(int i=0;i<arrGPP.size();i++) {
			resultado=arrGPP.get(i).buscaPaquete(p);
			if (resultado!=-1) {
				int anteriores=0;
				for(int w=0;w<i;w++) {
					anteriores+=arrGPP.get(w).getNumTaquillas();
				}
				resultado+=anteriores;
				return resultado;
			}	
		}
		resultado=-1;
		return resultado;
	}
	
	/**
	 * Extrae el {@code Package} representado por el identificador tomado por parámetro del {@code PickingPointHub}. Se comprueban todos los elementos que componen el {@code PickingPointHub} hasta encontrar el paquete.
	 *@param id cadena de texto que representa al identificador del paquete.
	 *@return {@code Package} que se corresponde con el identificador introducido como parámetro.
	 */
	@Override
	public Package sacarPaquete(String id) {
		Package p=null;
		for(int i=0;i<arrGPP.size();i++) {
			if(arrGPP.get(i).estaPaquete(id)) {
				p=arrGPP.get(i).sacarPaquete(id);
			}
		}
		return p;
	}
}
