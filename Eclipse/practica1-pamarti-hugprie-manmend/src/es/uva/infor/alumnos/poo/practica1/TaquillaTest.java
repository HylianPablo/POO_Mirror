package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class TaquillaTest {

	@Test
	public void taquillaVacia() {
		Taquilla t=new Taquilla();
		assertSame(t.getVacia(),true);
	}
	
	@Test
	public void taquillaLlena() {
		Taquilla t = new Taquilla();
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		Package p = new Package("1234567895",fecha);
		t.setPaq(p);
		assertSame(t.getVacia(),false);
	}
	
	@Test(expected=IllegalStateException.class)
	public void taquillaLlenaDos() {
		Taquilla t = new Taquilla();
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		Package p = new Package("1234567895",fecha);
		t.setPaq(p);
		Package p1 = new Package("1234567895",fecha);
		t.setPaq(p1);
		
	}
	
	@Test
	public void getTaquillaVacia() {
		Taquilla t = new Taquilla();
		Package p = t.getPaq();
		assertEquals(p,null);
	}
	
	@Test
	public void cambiarAVacia() {
		Taquilla t = new Taquilla();
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		Package p = new Package("1234567895",fecha);
		t.setPaq(p);
		@SuppressWarnings("unused")
		Package prueba = t.getPaq();
		t.cambiaVacia();
		assertEquals(t.getPaq(),null);
	}

}
