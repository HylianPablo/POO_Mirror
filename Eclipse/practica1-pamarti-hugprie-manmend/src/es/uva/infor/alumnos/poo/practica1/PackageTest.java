package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class PackageTest {

	@Test
	public void algoritmoBien(){
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		String iden="1234567895";
		assertEquals(p.getID(),iden);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void identificadorNull() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		@SuppressWarnings("unused")
		Package p = new Package(null,fecha);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void algoritmoMal() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		@SuppressWarnings("unused")
		Package p = new Package("1234567899",fecha);
	}
	
	@Test
	public void deadlineMenor() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		GregorianCalendar prueba = new GregorianCalendar(2000,10,19,0,0);
		assertTrue(p.pasadoDeadline(prueba)==false);
	}
	
	@Test
	public void deadlineIgual() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		GregorianCalendar prueba = new GregorianCalendar(2000,10,20,0,0);
		assertTrue(p.pasadoDeadline(prueba)==false);
	}
	
	@Test
	public void deadlineMayor() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		GregorianCalendar prueba = new GregorianCalendar(2000,10,21,0,0);
		assertTrue(p.pasadoDeadline(prueba)==true);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void algoritmoNegativo() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		@SuppressWarnings("unused")
		Package p = new Package("-1",fecha);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void algoritmoMenosDigitos() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		@SuppressWarnings("unused")
		Package p = new Package("123456789",fecha);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void algoritmoMasDigitos() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		@SuppressWarnings("unused")
		Package p = new Package("12345678959",fecha);
	}
	@Test
	public void fechaCorrecta() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		assertEquals(p.getDate(),fecha);
	}
	
	@Test
	public void cambioRecogido() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		p.changeRecogido(true);
		assertSame(p.getRecogido(),true);
	}
	
	@Test
	public void cambioDevuelto() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		p.changeDevuelto(true);
		assertSame(p.getDevuelto(),true);
	}
	
	@Test
	public void getIdentificador() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		String n="1234567895";
		Package p = new Package(n,fecha);
		assertEquals(p.getID(),n); 
		
	}
	
	@Test
	public void getRecodigo() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		assertSame(p.getRecogido(),false);
	}
	
	@Test
	public void getDevuelto() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		assertSame(p.getDevuelto(),false);
	}
	
	@Test
	public void getDeadline() {
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		Package p = new Package("1234567895",fecha);
		assertEquals(fecha,p.getDate());
	}
	
}
