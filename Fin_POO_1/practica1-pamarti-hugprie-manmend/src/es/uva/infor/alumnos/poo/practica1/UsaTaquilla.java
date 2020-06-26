package es.uva.infor.alumnos.poo.practica1;

import java.util.GregorianCalendar;

public class UsaTaquilla {
	
	public static void main(String[] args) {
		Taquilla taq = new Taquilla();
		
		System.out.println("Taquilla creada por defecto vacia.");
		System.out.println("La taquilla esta vacia: "+ taq.getVacia());
		System.out.println("Como esta vacia, en su interior se encuentra el paquete: "+ taq.getPaq());
		
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		Package p = new Package("1234567895", fecha);
		
		System.out.println("Se almacena un paquete en la taquilla.");
		taq.setPaq(p);
		//taq.cambiaVacia(false);
		
		System.out.println("La taquilla se encuentra vacia: "+taq.getVacia());
		System.out.println("El paquete que se encuentra en la taquilla es: "+taq.getPaq().getID());
		
	}
}
