/**
 * Paquete utilizado
 * @author Pamarti Manmend Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importan las clases Calendar y GregorianCalendar con el fin de implementar las fechas necesarias.
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 * Se importa la clase OffsetTime con el fin de implementar las horas para el horario del {@code PackageLocker}
 */	
import es.uva.inf.poo.maps.GPSCoordinate;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.time.OffsetTime;

/**
  * Implementación de la clase Package Locker. La clase {@code PackageLocker} representa un grupo de taquillas de autoservicio de AmazingCo, situadas en un punto, donde los clientes pueden recoger sus paquetes a partir del código asociado a cada taquilla.
 * Primera entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti, Manmend y Hugprie.
 */
public class PackageLocker {
	private int nLock; 
	private Taquilla[] taq;
	private boolean operative;
	private int identifier;
	private GPSCoordinate gps;
	
	private OffsetTime horaApertura;
	private OffsetTime horaCierre;
	
	/**
	 * Inicialización de la clase {@code PackageLocker}, indicando su número total de taquillas, su identificador y sus coordenadas GPS.
	 * @param totalTaq número entero que reprensenta el número de taquillas que conforma el {@code PackageLocker} instanciado.
	 * @param id número entero que representa al {@code PackageLocker}. Permite al usuario y al sistema de AmazingCo identificar el Package Locker.
	 * @param g coordenadas del tipo GPSCoordiante. Representan mediante longitud y latitud la posición del {@code PackageLocker}.
	 * @param apertura hora del tipo OffsetTime. Representa la hora de apertura del {@code PackageLocker}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 * @param cierre hora del tipo OffsetTime. Representa la hora de cierre del {@code PackageLocker}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 * @throws IllegalArgumentException - cuando el número total de taquillas del {@code PackageLocker} introducido no es válido, es decir, menor que cero.
	 */
	public PackageLocker(int totalTaq,int id, GPSCoordinate g, OffsetTime apertura, OffsetTime cierre){
		
		if(totalTaq<=0) {
			throw new IllegalArgumentException("Argumento de número de taquillas erróneo");
		}
		
		if((apertura.getHour()*60+apertura.getMinute())>(cierre.getHour()*60+cierre.getMinute())) {
			throw new IllegalArgumentException("La hora de apertura no puede ser mayor que la de cierre");
		}
		
		nLock = totalTaq;
		taq=new Taquilla[nLock];
		operative=true;
		identifier=id;
		gps=g;
		
		horaApertura=apertura;
		horaCierre=cierre;
		
		for(int i=0;i<nLock;i++) {
			Taquilla t= new Taquilla();
			taq[i]=t;
		}
	
	}
	/**
	 * Consulta la hora de apertura del {@code PackageLocker}. La hora viene dada con el formato hh:mm.
	 * @return cadena con la de apertura en formato String.
	 */
	public String horaApertura() {
		return (horaApertura.getHour()+":"+horaApertura.getMinute());
	}
	
	/**
	 * Consulta la hora de cierre del {@code PackageLocker}. La hora viene dada con el formato hh:mm.
	 * @return cadena con la de cierre en formato String.
	 */
	public String horaCierre() {
		return (horaCierre.getHour()+":"+horaCierre.getMinute());
	}
	
	/**
	* Establece la hora de apertura del {@code PackageLocker} a partir de su parámetro.
	 * @param apert Hora de apertura del tipo OffsetTime. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 */
	public void cambiaApertura(OffsetTime apert) {
		if((apert.getHour()*60+apert.getMinute())>(horaCierre.getHour()*60+horaCierre.getMinute())) {
			throw new IllegalArgumentException("La hora de apertura no puede ser mayor que la de cierre");
		}
		horaApertura=apert;
	}
	
	/**
	 * Establece la hora de cierre del {@code PackageLocker} a partir de su parámetro.
	 * @param cierr Hora de cierre del tipo OffsetTime. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 */
	public void cambiaCierre(OffsetTime cierr) {
		horaCierre=cierr;
	}
	
	/**
	 * Consulta el numero de taquillas que contiene el {@code PackageLocker}.
	 * @return Un número entero de taquillas. Garantiza que el resultado siempre es mayor o igual que cero.  		
	 */
	public int getNumTaquillas() {
		return nLock;
	}
	
	/**
	* Consulta si el {@code PackageLocker} está abierto a una determinada hora, introducida como parámetro, comprobando si se encuentra en el rango [Hora de apertura, Hora de cierre]. Dos posibles valores: true, Package Locker está en horario de apertura, o false, Package Locker no está en horario de apertura.
	 * @param c Fecha del tipo GregorianCalendar.
	 * @return Un valor booleano que indica si el {@code PackageLocker} se encuentra en horario de apertura o no.	
	 */	
	public boolean abiertoHorario(GregorianCalendar c) {
		int hora=c.get(Calendar.HOUR_OF_DAY);
		hora=hora*60;
		int minuto=c.get(Calendar.MINUTE);
		minuto+=hora;
		if(minuto<(horaApertura.getHour()*60+horaApertura.getMinute()) || minuto >(horaCierre.getHour()*60+horaCierre.getMinute())) {//6am y 10pm en milisegundos
			return false;
		}else {
			return true;
		}
	}
	/**
	 * Consulta el identificador del {@code PackageLocker}.
	 * @return Una cadena de caracteres que representa al {@code PackageLocker}. Esta cadena permite al cliente y al sistema de administración de AmazingCo identificar al {@code PackageLocker}. Se garantiza que no es nula.
	 */	
	public int getID() {
		return identifier;
	}
	
	/**
	* Consulta las coordenas GPS del {@code PackageLocker}. Localizan su posición en toda la Tierra. La localización se realiza caracterizando la latitud y la longitud de la posición.
	 * @return Coordenadas de {@code PackageLocker} del tipo GPSCoordinate. Estas coordenadas vienen representadas por longitud y latitud en Grados ,º, Minutos ,', y Segundos,".
	 */	
	public GPSCoordinate getCoordinate() {
		return (gps);
	}
	
	/**
	* Consulta el número de taquillas vacías del {@code PackageLocker}.
	 * @return Número entero que indica el número de taquillas vacías. Se garantiza que el número este comprendido entre 0 y el número total de taquillas del {@code PackageLocker}.
	 */	
	public int getTaquillasVacias() {
		int contador=0;
		for(int i=0;i<nLock;i++) {
			if(taq[i].getVacia()==true) {
				contador ++;
			}
		}
		return contador;
	}
	
	/**
	 * Consulta el número de taquillas llenas del {@code PackageLocker}.
	 * @return Número entero que indica el número de taquillas llenas. Se garantiza que el número este comprendido entre 0 y el número total de taquillas del {@code PackageLocker}.
	 */	
	public int getTaquillasLlenas() {
		return (nLock-getTaquillasVacias());
	}
	
	/**
	* Consulta si el {@code PackageLocker} está operativo o no. Dos posibles valores: true, {@code PackageLocker} operativo, y false, {@code PackageLocker} no operativo.
	 * @return Valor booleano que indica si está operativo o no.
	 */	
	public boolean getOperative() {
		return operative;
	}
	
	/**
	* Establece si el {@code PackageLocker} está operativo o no a partir del parámetro. Dos posibles valores: true, {@code PackageLocker} operativo, y false, {@code PackageLocker} no operativo.
	 * @param b Valor booleano que establece si está operativo o no.
	 */	
	public void cambioOperativo(boolean b) {
		operative=b;
	}
	/**
	 * Asigna a la primera taquilla vacía del {@code PackageLocker} un paquete a almacenar. Si todas las taquillas están llenas lanza una excepción.
	 * @param p objeto del tipo {@code Package}, que representa un paquete a almacenar, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @throws IllegalStateException cuando todas las taquillas están llenas.
	 * @throws IllegalStateException cuando el PackageLocker no está operativo.
	 */		

	public void asignaPaquete(Package p) {
		
		
		if(this.getTaquillasVacias()==0) {
			throw new IllegalStateException("Todas las taquillas están ocupadas.");
		}
		
		if(this.getOperative()==false) {
			throw new IllegalStateException("El PackageLocker no se encuentra operativo, no se puede realizar la operación");
		}
		
		int flag=0;
		for(int i=0;i<nLock;i++) {
			
			if(flag==0 && taq[i].getVacia()==true) {
				taq[i].setPaq(p);
				flag++;
				 
			}
		}
	}

	/**
	 * Consulta que taquilla del {@code PackageLocker} contiene el paquete introducido como párametro. El estado de la taquilla pasa a ser llena. En caso, de que ninguna taquilla lo contenga lanzará una excepción.
	 * @param p objeto del tipo {@code Package}, que representa el paquete del cual queremos averiguar el número de taquilla en el que se encuentra, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @return i Número entero que representa la taquilla. Permite identificar al cliente y al sistema de AmazingCo la taquilla que contiene el paquete. Si no se encuentra retorna el valor '-1'.
	 * @throws IllegalStateException cuando el PackageLocker no está operativo.
	 */		
	public int buscaPaquete(Package p) {
		if(this.getOperative()==false) {
			throw new IllegalStateException("El PackageLocker no se encuentra operativo, no se puede realizar la operación");
		}
		for(int i=0;i<nLock;i++) {
			if(taq[i].getPaq()!=null && taq[i].getPaq().equals(p)) {
				return (i); 	
			}
		}
		return -1;
		
	}
	
	/**
	 * Desasigna el paquete introducido como parámetro de la taquilla del {@code PackageLocker} que lo contiene. El estado de la taquilla pasa a ser vacía. Si ninguna taquilla lo contiene lanza una excepción.
	 * @param p objeto del tipo {@code Package}, que representa un paquete a sacar del {@code PackageLocker}, que viene caracterizado por su identificador y su fecha de fin de almacenaje.
	 * @return El paquete que ocupa la posicion 'i' en el array de Taquillas, 'taq'.
	 * @throws NullPointerException cuando el paquete no existe o no se encuentra en el {@code PackageLocker}.
	 * @throws IllegalStateException cuando el PackageLocker no está operativo.
	 */	
	

	public Package sacarPaquete(String id, GregorianCalendar fecha) {
		
		if(this.getOperative()==false) {
			throw new IllegalStateException("El PackageLocker no se encuentra operativo, no se puede realizar la operación");
		}
		
		if(!this.estaPaquete(id)) {
			throw new NullPointerException("El paquete no existe o no se encuentra en el PackageLocker.");
		}
		
		else if(!this.abiertoHorario(fecha)) {
			throw new IllegalStateException();
		}
		
		else {
			Package paq=null;
			for(int i=0;i<nLock;i++) {
				if(taq[i].getPaq()!=null && taq[i].getPaq().getID().equals(id)) {
					paq=taq[i].getPaq();
					if(paq.pasadoDeadline(fecha)) {
						paq.changeDevuelto(true);
					}else {
						paq.changeRecogido(true);
					}
					taq[i].cambiaVacia();
				}
			}
			return paq;	
		}
	}
	/**
	 * Comprueba si el paquete introducido como parámetro se encuentra en el array de taquillas de {@code PackageLocker}
	 * @param id - identificador del paquete que queremos comprobar si se encuentra en el array de taquillas.
	 * @return Valor booleano true si el paquete se encuentra en el array de taquillas o valor booleano false si no se encuentra.
	 */
	public boolean estaPaquete(String id) {
		int flag=0;
		for(int i=0;i<nLock;i++) {
			if(taq[i].getPaq()!=null && taq[i].getPaq().getID().equals(id)) {
				flag++;
			}
		}
		if(flag==0) {
			return false;
		}else {
			return true;
		}
	}
}