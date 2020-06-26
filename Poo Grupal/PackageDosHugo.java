/**
 * Paquete utilizado
 * @author Pamarti
 * @author Manmend
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica2;

/**
 * Se importa la clase GregorianCalendar con el fin de utilizarla en la fecha límite.
 * Se importa la clase java.util.ArrayList para usar el TAD ArrayList.
 */	
import java.util.GregorianCalendar;
import java.util.ArrayList;


/**
 * Implementación de la clase {@code Package}. La clase {@code Package} representa un paquete que se encuentra en el sistema de {@code PackageLocker}. 
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie
 */
public class Package {
	private String id;
	private double precio;
	private GregorianCalendar deadline;
	private boolean recogido;
	private boolean devuelto;
	private boolean pagado;
	private ArrayList <String> DNIs;
	
	
	/**
	 * Inicialización de la clase {@code Package}, para los paquetes no certificados, indicando su identificador, su fecha de fin de almacenaje, precio y si ha sido pagado o no.
	 * @param identifier cadena de texto que representa al identificador del paquete. Se comprobará que sigue el algoritmo a través de el método {@link #algoritmo (int) algoritmo}.
	 * @param f fecha límite de recogida del paquete del tipo GregorianCalendar.
	 * @param pre precio del producto.
	 * @param pag indicación de si el paquete ha sido pagado ya o no.
	 * @throws java.lang.IllegalArgumentException cuando identifier es incorrecto, (String nulo o longitud distinta de 10 caracteres).
	 */
	public Package(String identifier, GregorianCalendar f, double pre, boolean pag) {
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
		precio = pre;
		pagado = pag;
	}
	
	
	/**
	 * Inicialización de la clase {@code Package}, para los paquetes certificados, indicando su identificador, su fecha de fin de almacenaje, precio, si ha sido pagado o no y el DNI de la persona autorizada.
	 * @param identifier cadena de texto que representa al identificador del paquete. Se comprobará que sigue el algoritmo a través de el método {@link #algoritmo (int) algoritmo}.
	 * @param f fecha límite de recogida del paquete del tipo GregorianCalendar.
	 * @param pre precio del producto.
	 * @param pag indicación de si el paquete ha sido pagado ya o no.
	 * @dni identificación de la persona autorizada para recoger un el paquete certificado
	 * @throws java.lang.IllegalArgumentException cuando identifier es incorrecto, (String nulo o longitud distinta de 10 caracteres).
	 */
	public Package(String identifier, GregorianCalendar f, double pre, boolean pag, String dni) {
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
		precio = pre;
		pagado = pag;
		DNIs.add(dni); //No estoy seguro si vale como inicialización
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
	
	/**
	 * Consulta el precio del {@code Package} this.
	 * @return Una cantidad de tipo doble.
	 */
	
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * Consulta si el {@code Package} ha sido pagado o no. Un {@code Package} no pagado solo podrá ser entregado en un punto donde se permita contrareembolso.
	 * @return Valor booleano que indica si el {@code Package} ha sido pagado o no.
	 */
		
	public boolean getPagado() {
		return pagado;
	}
	
	/**
	 * Consulta que personas están autorizadas a recoger el {@code Package} certificado. Esta función solo se puede emplear para paquetes certificados.
	 * @return Una lista de cadenas que indican los DNIs de aquellos autorizados a recoger el {@code Package} this.
	 * @throws IllegalStateException - cuando el paquete no tiene DNIs de personas autorizadas, es decir, no es certificado.
	 */
		
	public ArrayList <String> getPersonasAutorizadas() { //Cuando se llame a este get comprobar empty
		if (DNIs.isEmpty()==true) {
			throw new IllegalStateException("Este paquete no es un paquete certificado");
		}
			return DNIs;
	}
	
	
	//NECESARIO UN SET PRECIO?????
	
	/**
	 * Establece si el {@code Package} ha sido pagado o no, en función del parámetro introducido. Si este es true, el paquete quedará en estado pagado, y si este es false, quedará en estado no pagado. Indica si el {@code Package} debe ser pagado o no por el cliente.
	 * @param p valor booleano que indica si el {@code Package} ha sido pagado o no.
	 */
	public void changePagado(boolean p) {
		pagado=p;
		
	}
	
	/**
	 * Añade un nuevo DNI a la lista de personas autorizadas a recoger el {@code Package} certificado this, introducido por parámetro al sistema. Es requisito que el paquete sea certificado.
	 * @param dni cadena que representa la identificación de la persona que va a pasar a estar autorizada para la recogida.
	 * @throws IllegalArgumentException - cuando se pretende añadir a la lista un DNI no válido (DNI vacío).
	 */
	public void addDNI(String dni) {
		if(dni==null) {
			throw new IllegalArgumentException("El DNI no es válido");
		}
		if (DNIs.isEmpty()==true) { //Si un paquete es no certificado, puede convertirse a certificado mas tarde???
			System.out.println("No puedes añadir un DNI a un paquete no certificado");
		}else {
			DNIs.add(dni);
		}
	}
	
}
