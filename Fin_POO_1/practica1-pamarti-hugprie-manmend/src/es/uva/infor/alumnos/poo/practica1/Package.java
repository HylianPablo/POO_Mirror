/**
 * Paquete utilizado
 * @author Pamarti Manmend Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase GregorianCalendar con el fin de utilizarla en la fecha límite.
 */	
import java.util.GregorianCalendar;

/**
  * Implementación de la clase {@code Package}. La clase {@code Package} representa un paquete que se encuentra en el sistema de {@code PackageLocker}. 
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie
 */
public class Package {
	private String id;
	private GregorianCalendar deadline; 
	private boolean recogido;
	private boolean devuelto;
	
	
	/**
	 * Inicialización de la clase {@code Package}, indicando su identificador y su fecha de fin de almacenaje.
	 * @param identifier cadena de texto que representa al identificador del paquete. Se comprobará que sigue el algoritmo a través de el método {@link #algoritmo (int) algoritmo}.
	 * @param f fecha límite de recogida del paquete del tipo GregorianCalendar.
	 * @throws java.lang.IllegalArgumentException cuando identifier es incorrecto, (String nulo o longitud distinta de 10 caracteres).
	 */
	public Package(String identifier, GregorianCalendar f) {
		if(identifier==null || identifier.length()!=10) {
			throw new IllegalArgumentException("Identificador del paquete erróneo.");
		}
		id=identifier;
		long idComp=Long.parseLong(identifier);
		long idCompAlg=algoritmo(idComp/10);
		if(idCompAlg!=idComp) {
			throw new IllegalArgumentException();
		}
		
		deadline = f;
		recogido=false;
		devuelto=false;
	}
	
	/**
	 * Consulta el identificador del {@code Package}. El identificador es un código cadena de caracteres de 10 dígitos que permite realizar consultas sobre el paquete que representa y realizar diversos trámites, como asignarle una taquilla.
	 * @return Una cadena de caracteres 'id' de 10 dígitos, obtenido en {@link #algoritmo(int) algoritmo}. 		
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Consulta si el {@code Package} ha sido recogido o no por el cliente. Dos posibles valores: true, ha sido recogido o false, no ha sido recogido.
	 * @return Valor booleano que indica si el paquete ha sido recogido por el cliente.
	 */
	public boolean getRecogido(){
		return recogido;
	}
	
	/**
	 * Consulta si el {@code Package} ha sido devuelto o no a central. Un {@code Package} que se encuentre en una taquilla más tiempo que el indicado por la fecha de fin de almacenaje será devuelto a central.
	 * @return Valor booleano que indica si el {@code Package} ha sido devuelto a central.
	 */
		
	public boolean getDevuelto() {
		return devuelto;
	}
	
	/** 
	 * Calcula el identificador que representara a un {@code Package}. El código del {@code Package} tiene diez caracteres, de los cuales los primeros nueve son los dígitos del parámetro y el décimo es un dígito resultante del resto de la división entre 10 de la suma de los 9 primeros.
	 * @param parteID número entero largo de 9 dígitos, parte del identificador del {@code Package}.
	 * @return Número entero de 10 dígitos que representa a un {@code Package}.	
	 */
	public long algoritmo(long parteID) {
		int suma =0;
		long tmp = parteID;
		for(int i=0;i<9;i++) {
			suma+=parteID%10;
			parteID=parteID/10;
		}
		long resto= suma%10;
		tmp=tmp*10;
		return tmp+resto;	
	}
	
	/**
	 * Establece si el {@code Package} ha sido recogido o no, en función del parámetro introducido. Si este es true, el paquete quedará en estado recogido, y si este es false, quedará en estado no recogido. Indica si el {@code Package} debe ser recogido o no por el cliente.
	 * @param r valor booleano que indica si el {@code Package} ha sido recogido o no.
	 */
	public void changeRecogido(boolean r) {
		recogido=r;
		
	}
	/**
	 * Establece si el {@code Package} ha sido devuelto a central no, en función del parámetro introducido. Si este es true, el {@code Package} quedará en estado devuelto, y si este es false, quedará en estado no devuelto. Indica si el {@code Package} debe ser recogido o no por el cliente en central.
	 * @param d valor booleano que indica si el {@code Package} ha sido recogido o no.
	 */
	public void changeDevuelto(boolean d) {
		devuelto=d;
		
	}
	
	/**
	* Consulta la fecha de fin de almacenaje del {@code Package} this.
	 * @return Una fecha del tipo GregorianCalendar.
	 */
	public GregorianCalendar getDate() {
		return deadline;
	}
	
	/**
	   * Establece si ha pasado la fecha de fin de almacenaje. Dos posibles valores: true, si ha pasado la fecha, y false, si no ha pasado. Si el paquete ha excedido el límite de tiempo y no ha sido recogido, deberá devolverse a central.
	 * @param c fecha límite de recogida del paquete del tipo GregorianCalendar.
	 * @return Valor booleano que indica si ha pasado la fecha de fin de almacenaje.
	*/
	public boolean pasadoDeadline(GregorianCalendar c) {
		if(deadline.compareTo(c)<0) {
			return true;
		}
		else {
			return false;
		}
	}	
}