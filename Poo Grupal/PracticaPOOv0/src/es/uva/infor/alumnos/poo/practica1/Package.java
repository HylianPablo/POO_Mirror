/**
 * Paquete utilizado.
 * @author Pamarti
 * @author Manmend 
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase java.time.LocalDate con el fin de utilizarla en la fecha límite.
 * Se importa la clase java.util.ArrayList para usar el TAD ArrayList.
 * Se importa la clase java.util.Objects con el fin de redefinir el hashCode de {@code Package}.
 */	

import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDate;

/**
 * Implementación de la clase {@code Package}. La clase {@code Package} representa un paquete que se encuentra en el sistema de {@code PickingPoint}. 
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
 */
public class Package {
	private String id;
	private LocalDate deadline; 
	private boolean recogido;
	private boolean devuelto;
	private double precio;
	private boolean pagado;
	private ArrayList<String> arrID;
	private boolean certificado;
	
	
	/**
	 * Inicialización de la clase {@code Package}, indicando su identificador, su fecha de fin de almacenaje, su precio, un booleano que indica si está pagado y un booleano que indica si es certificado.
	 * @param identifier cadena de texto que representa al identificador del paquete. Se comprobará que sigue el algoritmo a través de el método {@link #algoritmo (int) algoritmo}.
	 * @param f fecha límite de recogida del paquete del tipo {@code LocalDate}.
	 * @param prize precio del {@code Package}.
	 * @param paid booleano que indica si el {@code Package} está pagado.
	 * @param c booleano que indica si el {code Package} es certificado.
	 * @throws IllegalArgumentException cuando identifier es incorrecto, (String nulo o longitud distinta de 10 caracteres).
	 */
	public Package(String identifier, LocalDate f,double prize,boolean paid, boolean c) {
		if(identifier==null || identifier.length()!=10) {
			throw new IllegalArgumentException("Identificador del paquete erróneo.");
		}
		id=identifier;
		long idComp=Long.parseLong(identifier);
		long idCompAlg=algoritmo(idComp/10);
		if(idCompAlg!=idComp) {
			throw new IllegalArgumentException();
		}
		
		if(prize<=0) {
			throw new IllegalArgumentException("El precio debe ser superior a cero.");
		}
		
		deadline = f;
		recogido=false;
		devuelto=false;
		precio=prize;
		pagado=paid;
		certificado=c;
		arrID=null;
	}
	
	
	/**
	 * Inicialización de la clase {@code Package}, indicando su identificador, su fecha de fin de almacenaje, su precio, un booleano que indica si está pagado, un booleano que indica si es certificado y un {@code ArrayList} con los identificadores de las personas asociadas.
	 * @param identifier cadena de texto que representa al identificador del paquete. Se comprobará que sigue el algoritmo a través de el método {@link #algoritmo (int) algoritmo}.
	 * @param f fecha límite de recogida del paquete del tipo {@code LocalDate}.
	 * @param prize precio del {@code Package}.
	 * @param paid booleano que indica si el {@code Package} está pagado.
	 * @param c booleano que indica si el {code Package} es certificado.
	 * @param arr ArrayList de Strings que contiene los DNIs asociados al paquete.
	 * @throws IllegalArgumentException si el paquete no es certificado.
	 * @throws IllegalArgumentException cuando identifier es incorrecto, (String nulo o longitud distinta de 10 caracteres).
	 * @throws IllegalArgumentException cuando el identificador es sintácticamente erróneo. (El último número no coincide.)
	 * @throws IllegalArgumentException cuando el tamaño de la lista es igual o menor que cero.
	 * @throws IllegalArgumentException cuando se introduce un DNI {@code null} en la lista.
	 */
	public Package(String identifier, LocalDate f, double prize, boolean paid, ArrayList<String> arr, boolean c) {
		if(!c) {
			throw new IllegalArgumentException("El paquete debe ser certificado.");
		}
		if(identifier==null || identifier.length()!=10) {
			throw new IllegalArgumentException("Identificador del paquete erróneo.");
		}
		id=identifier;
		long idComp=Long.parseLong(identifier);
		long idCompAlg=algoritmo(idComp/10);
		if(idCompAlg!=idComp) {
			throw new IllegalArgumentException("El identificador es incorrecto.");
		}
		if(arr.isEmpty()) {
			throw new IllegalArgumentException("La lista debe contener al menos un DNI.");
		}
		
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)==null) {
				throw new IllegalArgumentException("Se ha introducido un DNI incorrecto.");
			}
		}
		
		if(prize<0) {
			throw new IllegalArgumentException("El precio debe ser positivo.");
		}
		
		deadline = f;
		recogido=false;
		devuelto=false;
		precio=prize;
		pagado=paid;
		certificado=c;
		arrID=arr;
	}
	
	protected void setDate(LocalDate gc) {
		deadline=gc;
	}
	
	/**
	 * Devuelve un String que identifica al objeto {@code Package}.
	 * @return Una cadena de caracteres compuesta por el identificador del paquete, su fecha asociada de vencimiento ,su precio y si es (o no) certificado.
	 */
	@Override
	public String toString() {
		String c;
		if(certificado()) {
			c="certificado";
		}else {
			c="no certificado";
		}
		return id+", "+deadline+", "+Double.toString(precio)+", "+c+".";
	}
	
	/**
	 * Consulta si los paquetes son iguales.
	 * @param o {@code Object} a comparar con {@code this}. El objeto se instanciará como {@code Package}.
	 * @return {@code true} si el {@code Object} es igual a {@code this}.
	 */
	@Override
	public boolean equals(Object o) {
		if(o ==null) {
			return false;
		}
		if(o==this) {
			return true;
		}
		if(!(o instanceof Package)) {
			return false;
		}
		Package p = (Package) o;
		if(!id.equals(p.getID())) {
			return false;
		}
		if(!deadline.equals(p.getDate())) {
			return false;
		}
		if(!arrID.equals(p.getArrID())) {
			return false;
		}
		if(precio!=(p.getPrecio())) {
			return false;
		}
		return certificado!=p.certificado(); 
	}
	
	/**
	 * Calcula la función hash del objeto {@code Package}.
	 * @return valor entero que representa al objeto {@code Package}, calculado a partir de sus atributos.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id,deadline,precio);
	}
	
	
	/**
	 * Obtiene el {@code ArrayList} con los DNIs de las personas asociadas al {code Package}.
	 * @return {@code ArrayList} de {@code Strings} que son DNIs asociados. 
	 * @throws IllegalStateException - cuando se intenta introducir un DNI cuando el {@code Package} no es certificado.
	 */
	public ArrayList<String> getArrID() {
		if(!certificado) {
			throw new IllegalStateException("El paquete no está certificado.");
		}
		return arrID;
	}
	
	/**
	 * Añade un nuevo DNI a la lista de personas autorizadas a recoger el {@code Package} certificado this, introducido por parámetro al sistema. Es requisito que el paquete sea certificado.
	 * @param dni cadena que representa la identificación de la persona que va a pasar a estar autorizada para la recogida.
	 * @throws IllegalStateException - cuando se intenta introducir un DNI cuando el {@code Package} no es certificado.
	 * @throws IllegalArgumentException - cuando se introduce un DNI nulo.
	 */
	public void addID(String dni) {
		if(!certificado) {
			throw new IllegalStateException("El paquete no está certificado.");
		}
		if(dni == null) {
			throw new IllegalArgumentException("El DNI no es válido.");
		}
		arrID.add(dni);
	}
	
	/**
	 * Comprueba si el paquete es certificado o no.
	 * @return booleano {@code true} si el paquete es certificado. En caso contrario, {@code false}.
	 */
	public boolean certificado() {
		return certificado;
	}
	
	/**
	 * Consulta si el {@code Package} está pagado. Un {@code Package} no pagado sólo podrá ser entregado en un punto donde se permita contrareembolso.
	 * @return {@code true} si está pagado y {@code false} si no lo está.
	 */
	public boolean pagado() {
		return pagado;
	}
	
	/**
	 * Establece si el {@code Package} ha sido pagado o no, en función del parámetro introducido. Si este es true, el paquete quedará en estado pagado, y si este es false, quedará en estado no pagado. Indica si el {@code Package} debe ser pagado o no por el cliente.
	 * @param b valor booleano que indica si el {@code Package} ha sido pagado o no.
	 */
	public void cambiaPagado(boolean b) {
		pagado=b;
	}
	
	/**
	 * Consulta el precio del {@code Package this}.
	 * @return Una cantidad de tipo {@code double}.
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * Consulta el identificador del {@code Package}. El identificador es un código cadena de caracteres de 10 dígitos que permite realizar consultas sobre el paquete que representa y realizar diversos trámites, como asignarle una taquilla.
	 * @return Una cadena de caracteres 'id' de 10 dígitos, obtenido en {@link #algoritmo(int) algoritmo}. 		
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Consulta si el {@code Package} ha sido recogido o no por el cliente. Dos posibles valores: {@code true}, ha sido recogido o {@code false}, no ha sido recogido.
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
	 * @return Una fecha del tipo {@code GregorianCalendar}.
	 */
	public LocalDate getDate() {
		return deadline;
	}
	
	/**
	 * Establece si ha pasado la fecha de fin de almacenaje. Dos posibles valores: {@code true}, si ha pasado la fecha, y {@code false}, si no ha pasado. Si el paquete ha excedido el límite de tiempo y no ha sido recogido, deberá devolverse a central.
	 * @param c fecha límite de recogida del paquete del tipo {@code LocalDate}.
	 * @return Valor booleano que indica si ha pasado la fecha de fin de almacenaje.
	*/
	public boolean pasadoDeadline(LocalDate c) {
		return deadline.compareTo(c)<0;
	}	
}