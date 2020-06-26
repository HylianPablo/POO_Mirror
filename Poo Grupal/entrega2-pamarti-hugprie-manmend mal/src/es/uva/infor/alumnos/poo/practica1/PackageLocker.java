/**
 * Paquete utilizado.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie
 */
package es.uva.infor.alumnos.poo.practica1;

/**
 * Se importa la clase java.time.LocalDate con el fin de implementar las fechas necesarias.
 * Se importa la clase GPSCoordinate para usar las coordenadas representadas mediante latitud y longitud.
 * Se importa la clase java.time.OffsetTime con el fin de implementar las horas para el horario del {@code PackageLocker}
 */	
import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.OffsetTime;
import java.time.LocalDate;

/**
 * Implementación de la clase {@code PackageLocker}. La clase {@code PackageLocker} representa un grupo de espacios/taquillas de autoservicio de AmazingCo, situadas en un punto, donde los clientes pueden recoger sus paquetes a partir del código asociado a cada espacio/taquilla.
 * Segunda entrega de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pamarti 
 * @author Manmend 
 * @author Hugprie.
 */
public class PackageLocker extends GroupablePoint {
	private OffsetTime horaApertura;
	private OffsetTime horaCierre;
	
	/**
	 * Inicialización de la clase {@code PackageLocker}, indicando su número total de espacios/taquillas, su identificador y sus coordenadas GPS.
	 * @param totalTaq número entero que reprensenta el número de espacios/taquillas que conforma el {@code PackageLocker} instanciado.
	 * @param id número entero que representa al {@code PackageLocker}. Permite al usuario y al sistema de AmazingCo identificar el {@code PackageLocker}.
	 * @param g coordenadas del tipo {@code GPSCoordiante}. Representan mediante longitud y latitud la posición del {@code PackageLocker}.
	 * @param apertura hora del tipo {@code OffsetTime}. Representa la hora de apertura del {@code PackageLocker}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 * @param cierre hora del tipo {@code OffsetTime}. Representa la hora de cierre del {@code PackageLocker}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 * @throws IllegalArgumentException cuando el número total de espacios del {@code PackageLocker} introducido no es válido, es decir, menor que cero.
	 */
	public PackageLocker(int totalTaq,int id, GPSCoordinate g, OffsetTime apertura, OffsetTime cierre){
		super(id,totalTaq,g);
		if((apertura.getHour()*60+apertura.getMinute())>(cierre.getHour()*60+cierre.getMinute())) {
			throw new IllegalArgumentException("La hora de apertura no puede ser mayor que la de cierre.");
		}
		horaApertura=apertura;
		horaCierre=cierre;
	}
	
	/**
	 * Consulta la hora de apertura del {@code PackageLocker}. La hora viene dada con el formato HH:MM.
	 * @return cadena con la hora de apertura en formato {@code String}.
	 */
	public String horaApertura() {
		return (horaApertura.getHour()+":"+horaApertura.getMinute());
	}
	
	/**
	 * Consulta la hora de cierre del {@code PackageLocker}. La hora viene dada con el formato HH:MM.
	 * @return cadena con la hora de cierre en formato {@code String}.
	 */
	public String horaCierre() {
		return (horaCierre.getHour()+":"+horaCierre.getMinute());
	}
	
	/**
	* Establece la hora de apertura del {@code PackageLocker} a partir de su parámetro.
	* @param apert Hora de apertura del tipo {@code OffsetTime}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	*/
	public void cambiaApertura(OffsetTime apert) {
		if((apert.getHour()*60+apert.getMinute())>(horaCierre.getHour()*60+horaCierre.getMinute())) {
			throw new IllegalArgumentException("La hora de apertura no puede ser mayor que la de cierre.");
		}
		horaApertura=apert;
	}
	
	/**
	 * Establece la hora de cierre del {@code PackageLocker} a partir de su parámetro.
	 * @param cierr Hora de cierre del tipo {@code OffsetTime}. El formato es horas, minutos, segundos, milisegundos y zona horaria.
	 */
	public void cambiaCierre(OffsetTime cierr) {
		horaCierre=cierr;
	}
	
	/**
	* Consulta si el {@code PackageLocker} está abierto a una determinada hora, introducida como parámetro, comprobando si se encuentra en el rango [Hora de apertura, Hora de cierre]. Dos posibles valores: true, {@code PackageLocker} está en horario de apertura, o false, {@code PackageLocker} no está en horario de apertura.
	 * @param c Tiempo horario del tipo {@code OffsetTime}.
	 * @return Un valor booleano que indica si el {@code PackageLocker} se encuentra en horario de apertura o no.	
	 */	
	public boolean abiertoHorario(OffsetTime c) {
		int hora=c.getHour();
		hora=hora*60;
		int minuto=c.getMinute();
		minuto+=hora;
		return (minuto<(horaApertura.getHour()*60+horaApertura.getMinute()) || minuto >(horaCierre.getHour()*60+horaCierre.getMinute())); //6am y 10pm en milisegundos
	}
	
	/**
	 * Extrae el {@code Package} introducido como parámetro del {@code PackageLocker}. Se lanza una excepción si se intenta extraer en horario no operativo del {@code PackageLocker}. Dependiendo de la fecha, se marca el {@code Package} como recogido o devuelto.
	 * @param id entero que representa al identificador del {@code PackageLocker}.
	 * @param fecha fecha del tipo {@code LocalDate} que representa la fecha del día actual.
	 * @param ot hora del tipo {@code OffsetTime} que representa la hora actual.
	 * @return El paquete que ocupa la posicion 'i' en el almacenamiento de {@code Packages} de {@code PackageLocker}.
	 * @throws NullPointerException cuando el paquete no existe o no se encuentra en el {@code PackageLocker}.
	 * @throws IllegalStateException cuando el {@code PackageLocker} no está operativo.
	 * @throws IllegalStateException cuando el {@code PackageLocker} no se encuentra en horario operativo.
	 */
	public Package sacarPaquete(String id,LocalDate fecha, OffsetTime ot) {
		if(!this.getOperative()) {
			throw new IllegalStateException("El PackageLocker no se encuentra operativo, no se puede realizar la operación.");
		}
		if(!this.estaPaquete(id)) {
			throw new NullPointerException("El paquete no existe o no se encuentra en el PackageLocker.");
		}
		if(!this.abiertoHorario(ot)) {
			throw new IllegalStateException("El PackageLocker no se encuentra en horario operativo.");
		}
		
		Package paq =null;
		for(int i=0;i<getNumTaquillas();i++) {
			if(getFromTaq(i).getID().equals(id)) {
				paq=getFromTaq(i);
				if(paq.pasadoDeadline(fecha)) {
					paq.changeDevuelto(true);
				}else {
					paq.changeRecogido(true);
				}
				removeFromTaq(i);
			}
		}
		return paq;
	}
	
}