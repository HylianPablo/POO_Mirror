/**
 * Paquete utilizado
 * @author Pamarti Manmend Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;
/**
 * Implementacion de la clase Taquilla. La clase taquilla representa un cajón de los que conforman el Package Locker y que tiene espacio para almacenar un paquete. Viene identificada por su posicion en el package locker.
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie.
 * */
class Taquilla{
	private boolean vacia;
	private Package paq;
	
/**
 * Inicializacion de la clase 'Taquilla', empleada en el constructor de package locker, que crea las taquillas por defecto vacias, pasando como parametro vacia igual a true.
 * @param v - valor booleano que establece si la taquilla esta vacia o no. Por defecto, v siempre es true.
 */
	
	public Taquilla(boolean v) {
		vacia=v;
		paq=null;
	}
	
/**
 * Consulta si la taquilla esta vacia o no. Dos posibles valores: true, esta vacia, y false, no esta vacia.
 * @return vacia - valor booleano que indica si la taquilla vacia o no.
 */		
	public boolean getVacia() {
		return vacia;
	}
	
/**
 * Consulta que paquete esta almacenado en la taquilla. Si no hay ningun paquete en la taquilla el paquete devuelto sera null. Permirte al cliente y al sistema de AmazingCo operar con un paquete de una taquilla.
 * @return paq - objeto del tipo Package que representa el paquete almacenada en icha taquilla.
 */			
	public Package getPaq() {
		return paq;
	}
	
/**
 * Asigna a la taquilla un paquete a almacenar indicado por parametro.
 * @param p - objeto del tipo Package, que representa un paquete a almacenar, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
 */		
	public void setPaq(Package p) {
		paq=p;
	}
	
/**
 * Establece si la taquilla esta vacia o no en funcion del parametro.
 * @param b valor booleano que establece si la taquilla esta vacia o no. Si es true, establece la taquilla vacia, y si es false, establece la taquilla llena.
 */		
	public void cambiaVacia(boolean b) {
		vacia=b;
	}
	
}
