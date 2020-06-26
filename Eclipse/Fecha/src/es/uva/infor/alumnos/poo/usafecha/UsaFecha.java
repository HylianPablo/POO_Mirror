package es.uva.infor.alumnos.poo.usafecha;

import es.uva.infor.alumnos.poo.fecha.Fecha;

public class UsaFecha {

	public static void main(String[] args) {
		Fecha f1 = new Fecha(2000,1,4);
		System.out.println(f1.aCadena());
		
		Fecha f2= f1.ayer();
		System.out.println(f2.aCadena());
		
		Fecha f3 = f1.mañana();
		System.out.println(f3.aCadena());

	}

}
