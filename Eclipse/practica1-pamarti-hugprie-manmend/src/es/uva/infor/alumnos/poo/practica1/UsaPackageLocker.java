package es.uva.infor.alumnos.poo.practica1;

import java.util.GregorianCalendar;
import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class UsaPackageLocker {

	public static void main(String[] args) {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,19);
		GregorianCalendar c=new GregorianCalendar(2018,11,11,14,0,0);
		
		Package paq = new Package("1234567895",fecha);
		
		if(p.getOperative()) {
			System.out.println("El PackageLocker está operativo.");
			
			System.out.println("Se procede a introducir un paquete.");
			p.asignaPaquete(paq);
			
			System.out.println("Número de taquillas del PackageLocker: "+p.getNumTaquillas());
			System.out.println("Número de taquillas llenas: "+p.getTaquillasLlenas());
			System.out.println("Número de taquillas vacías: "+p.getTaquillasVacias());
			
			System.out.println("El paquete se encuentra en la taquilla nº: "+p.buscaPaquete(paq));
			
			System.out.println("El PackageLocker se encuentra en la ubicación: "+p.getCoordinate());
			
			System.out.print("El PackageLocker se encuentra en horario: ");
			if(p.abiertoHorario(c)) {
				System.out.println("abierto.");
			}else {
				System.out.println("cerrado");
			}
			String identificadorPaq = paq.getID();
			System.out.println("Se procede a sacar el paquete introducido");
			Package ret = p.sacarPaquete(identificadorPaq,fechaHoy);
			System.out.println("Su código es: "+ret.getID());
			
		}else {
			System.out.println("El PackageLocker no está operativo.");
		}
		
	}
}
