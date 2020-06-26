package es.uva.infor.alumnos.poo.practica1;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class UsaPackage {
	
	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		GregorianCalendar fechaPrueba = new GregorianCalendar(2000,10,10);
		Package p = new Package("1234567895",fecha);
		
		System.out.println("El código del paquete es: "+p.getID());
		System.out.println("La fecha en que expira es: "+p.getDate().get(Calendar.YEAR)+" - "+p.getDate().get(Calendar.MONTH)+" - "+p.getDate().get(Calendar.DAY_OF_MONTH));
		
		if(p.getRecogido()) {
			System.out.println("El paquete ha sido recogido.");
		}else {
			System.out.println("El paquete no ha sido recogido.");
		}
		
		if(p.getDevuelto()) {
			System.out.println("El paquete ha sido devuelto.");
		}else {
			System.out.println("El paquete no ha sido devuelto");
		}
		
		System.out.print("Hoy estamos a: "+fecha.get(Calendar.YEAR)+" - "+fecha.get(Calendar.MONTH)+" - "+fecha.get(Calendar.DAY_OF_MONTH)+", por lo tanto: ");
		if(!p.pasadoDeadline(fechaPrueba)) {
			System.out.println("Aún queda tiempo.");
		}else {
			System.out.println("Se ha pasado la fecha límite");
		}
	}

}
