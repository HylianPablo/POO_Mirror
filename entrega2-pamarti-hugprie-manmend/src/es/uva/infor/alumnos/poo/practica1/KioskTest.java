package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;

public class KioskTest {

	@Test
	public void identificadorCorrecto() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertSame(1,k.getID());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void identificadorIncorrecto() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(-1,3,coord1);
		k.asignaPaquete(paq);
	}
	
	@Test
	public void numTaqCorrecto() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertSame(3,k.getNumTaquillas());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void numTaqIncorrecto() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,0,coord1);
		k.asignaPaquete(paq);
	}
	
	@Test
	public void coordenadaCorrecta() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertEquals(coord1,k.getCoordinate());
	}
	
	@Test
	public void sumaDinero() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		double d = 20000.0;
		k.sumaDinero(d);
		assertEquals(d,k.getDinero(),0.0000001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sumaDineroMal() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		double d = -20000.0;
		k.sumaDinero(d);
	}
	
	@Test
	public void vaciaDinero() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		double d = 20000.0;
		k.sumaDinero(d);
		k.vaciaDinero();
		assertEquals(0,k.getDinero(),0.0000001);
	}
	
	@Test
	public void aumentaSize() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.changeSize(4);
		assertSame(4,k.getNumTaquillas());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sizeACero() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.changeSize(0);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void sizeMenorQueTaquillas() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		Package paq1 = new Package("9999999991",fecha,1,false,false);
		Package paq2 = new Package("1111111119",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.asignaPaquete(paq1);
		k.asignaPaquete(paq2);
		k.changeSize(2);
	}
	
	@Test
	public void esKiosk() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertTrue(k.esKiosk());
	}
	
	@Test
	public void sacarPaqueteBien() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertEquals(paq,k.sacarPaquete("1234567895"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void sacarPaqueteMalOperativo() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.cambioOperativo(false);
		k.sacarPaquete("1234567895",fecha);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sacarPaqueteIdNull() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.cambioOperativo(false);
		k.sacarPaquete(null,fecha);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void sacarPaqueteFechaNull() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.cambioOperativo(false);
		k.sacarPaquete("1234567895",null);
	}
	
	
	
	@Test
	public void sacarPaqueteBienPrecio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		k.sumaDinero(paq.getPrecio());
		assertEquals(20000.0,k.getDinero(),0.0000001);
	}
	
	@Test
	public void siHayEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		assertTrue(k.hayEspacio());
	}
	
	@Test
	public void noHayEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		Package paq1 = new Package("9999999991",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		k.asignaPaquete(paq1);
		assertFalse(k.hayEspacio());
	}
	
	@Test
	public void taquillasVacias() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertSame(1,k.getTaquillasVacias());
	}
	
	@Test
	public void taquillasLlenas() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertSame(1,k.getTaquillasLlenas());
	}
	
	@Test
	public void operativoInicial() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertTrue(k.getOperative());
	}
	
	@Test
	public void cambiaOperativo() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		k.cambioOperativo(false);
		assertFalse(k.getOperative());
	}
	
	@Test
	public void estaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertTrue(k.estaPaquete("1234567895"));
	}
	
	@Test
	public void noEstaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertFalse(k.estaPaquete("9999999991"));
	}
	
	@Test
	public void buscaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertSame(0,k.buscaPaquete(paq));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void buscaPaqueteNull() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.buscaPaquete(null);
	}
	
	@Test
	public void getCoordenada() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		assertEquals(coord1,k.getCoordinate());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void paqueteCertificado() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,true);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(paq);
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void asignaKioskNoOperativo() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.cambioOperativo(false);
		k.asignaPaquete(paq);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void asignaKioskNull() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		k.asignaPaquete(null);
		
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void addKioskMasDeNLock() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k = new Kiosk(1,2,coord1);
		for(int i=0;i<3;i++) {
			k.asignaPaquete(paq);
		}
	}
	
	
}
