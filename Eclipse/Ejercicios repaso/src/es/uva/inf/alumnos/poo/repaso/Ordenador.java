/**
 * Paquete utilizado.
 * @author Pablo Martínez López
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Se importa la clase ArrayList con el fin de almacenar las componentes que forman el ordenador.
 */
import java.util.ArrayList;

/**
 * Implementación de la clase {@code Ordenador}. Esta clase está formada por componentes entre las cuales debe haber como mínimo una {@code UnidadCentral}, un {@code DispositivoEntrada} y un {@code DispositivoSalida}.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public class Ordenador {
	private ArrayList<Componente> caja;
	
	/**
	 * Inicialización de la clase {@code Componente} a partir de una lista de componentes.
	 * @param c ArrayList de objetos tipo {@code Componente} entre los cuales debe haber por lo menos una {@code UnidadCentral}, un {@code DispositivoEntrada} y un {@code DispositivoSalida}.
	 * @throws IllegalAlgumentException cuando no existe al menos una {@code UnidadCentral}.
	 * @throws IllegalArgumentException cuando no existe al menos un {@code DispositivoEntrada}.
	 * @throws IllegalArgumentException cuando no existe al menos un {@code DispositivoSalida}.
	 */
	public Ordenador(ArrayList<Componente> c) {
		if(!alMenosUnaUnidadCentral(c)) {
			throw new IllegalArgumentException("Debe existir al menos una Unidad Central");
		}
		if(!alMenosUnDispositivoEntrada(c)) {
			throw new IllegalArgumentException("Debe existir al menos un Dispositivo de Entrada");
		}
		if(!alMenosUnDispositivoSalida(c)) {
			throw new IllegalArgumentException("Debe existir al menos un Dispositivo de Salida");
		}
		caja=c;
	}
	
	/**
	 * Comprueba si existe al menos una {@code UnidadCentral} entre las componentes iniciales.
	 * @param c ArrayList de {@code Componentes} a comprobar.
	 * @return Valor booleano en función de si existe al menos una {@code UnidadCentral}.
	 */
	public boolean alMenosUnaUnidadCentral(ArrayList<Componente> c) { 
		for(int i=0;i<c.size();i++) {
			if(c.get(i).getClass().equals(UnidadCentral.class)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si existe al menos un {@code DispositivoEntrada} entre las componentes iniciales.
	 * @param c ArrayList de {@code Componentes} a comprobar.
	 * @return Valor booleano en función de si existe al menos un {@code DispositivoEntrada}.
	 */
	public boolean alMenosUnDispositivoEntrada(ArrayList<Componente> c) { 
		for(int i=0;i<c.size();i++) {
			if(c.get(i).getClass().equals(DispositivoEntrada.class)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si existe al menos un {@code DispositivoSalida} entre las componentes iniciales.
	 * @param c ArrayList de {@code Componentes} a comprobar.
	 * @return Valor booleano en función de si existe al menos un {@code DispositivoSalida}.
	 */
	public boolean alMenosUnDispositivoSalida(ArrayList<Componente> c) { 
		for(int i=0;i<c.size();i++) {
			if(c.get(i).getClass().equals(DispositivoSalida.class)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Consulta el precio total del ordenador mediante la suma del precio de sus componentes.
	 * @return Valor en doble precisión flotante que representa el precio del ordenador.
	 */
	public double getPrecio() {
		double total=0;
		for(int i=0;i<caja.size();i++) {
			total+=caja.get(i).getPrecio();
		}
		return total;
	}
	
	/**
	 * Agrega una componente al ordenador.
	 * @param c {@code Componente} a agregar al ordenador.
	 */
	public void addComponente(Componente c) {
		caja.add(c);
	}
	
	/**
	 * Comprueba si una {@code Componente} se encuentra dentro del {@code Ordenador}.
	 * @param c {@code Componente} a comprobar si se encuentra o no en el {@code Ordenador}.
	 * @return Valor booleano en función de si la {@code Componente} se encuentra o no.
	 */
	public boolean estaComponente(Componente c) {
		for (int i=0; i<caja.size();i++) {
			if(caja.get(i).equals(c)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Elimina una {@code Componente} del total del {@code Ordenador}.
	 * @param c {@code Componente} a eliminar del {@code Ordenador}.
	 * @throws IllegalArgumentException cuando la {@code Componente} no se encuentra en el {@code Ordenador}.
	 */
	public void removeComponente(Componente c) {
		if(!estaComponente(c)) {
			throw new IllegalArgumentException("La componente no se encuentra o no existe.");
		}
		for(int i=0;i<caja.size();i++) {
			if(caja.get(i).equals(c)) {
				caja.remove(i);
			}
		}
	}
	
	/**
	 * Intercambia dos {@code Componentes} dentro del {@code Ordenador}.
	 * @param c {@code Componente} antigua que está dentro del {@code Ordenador} y pasará a ser reemplazada.
	 * @param d {@code Componente} nueva que reemplazará a la anterior.
	 * @throws IllegalArgumentException si la {@code Componente} a reemplazar no se encuentra en el {@code Ordenador}.
	 * @throws IllegalArgumentException si las {@code Componentes} introducidas no tienen el mismo tipo.
	 */
	public void intercambiaComponente(Componente c, Componente d) {
		if(!estaComponente(c)) {
			throw new IllegalArgumentException("La componente no se encuentra o no existe.");
		}
		if(!c.getClass().equals(d.getClass())) {
			throw new IllegalArgumentException("Las componentes deben ser del mismo tipo");
		}
		removeComponente(c);
		addComponente(d);
	}

}
