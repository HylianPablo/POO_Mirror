/**
 * Paquete utilizado
 * @author Pamarti Manmend Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Implementación de la clase {@code Taquilla}. La clase {@code Taquilla} representa un cajón de los que conforman el {@code PackageLocker} y que tiene espacio para almacenar un paquete. Viene identificada por su posicion en el {@code PackageLocker}.
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie.
 * */
public class Taquilla{
	private boolean vacia;
	private Package paq;
	
/**
 * Inicialización de la clase {@code Taquilla}, empleada en el constructor de {@code PackageLocker}, que crea las taquillas por defecto vacias.
 */
	
	public Taquilla() {
		vacia=true;
		paq=null;
	}
	
/**
 * Consulta si la {@code Taquilla} esta vacía o no. Dos posibles valores: true, esta vacía, y false, no esta vacía.
 * @return vacia - valor booleano que indica si la taquilla vacía o no.
 */		
	public boolean getVacia() {
		return vacia;
	}
	
/**
 * Consulta que {@code Package} esta almacenado en la {@code Taquilla}. Si no hay ningún paquete en la {@code Taquilla} el paquete devuelto sera {@code null}. Permite al cliente y al sistema de AmazingCo operar con un {@code Package} de una {@code Taquilla}.
 * @return paq - objeto del tipo {@code Package} que representa el paquete almacenada en dicha {@code Taquilla}.
 */			
	public Package getPaq() {
		return paq;
	}
	
/**
 * Asigna a la {@code Taquilla} un {@Package} a almacenar indicado por parámetro.
 * @param p - objeto del tipo {@code Package}, que representa un paquete a almacenar, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
 */		
	public void setPaq(Package p) {
		if(paq!=null) {
			throw new IllegalStateException();
		}
		paq=p;
		vacia=false;
	}
	
/**
 * Establece si la {@code Taquilla} esta vacía o no en función del parámetro.
 * @param b valor booleano que establece si la {@code Taquilla} está vacía o no. Si es true, establece la {@code Taquilla} vacía, y si es false, establece la {code Taquilla} llena.
 */		
	public void cambiaVacia() {
		paq=null;
		vacia=true;
	}
}
