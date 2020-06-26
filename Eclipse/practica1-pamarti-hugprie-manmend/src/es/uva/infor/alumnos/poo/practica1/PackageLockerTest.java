package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class PackageLockerTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void NoHayTaquillas() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		@SuppressWarnings("unused")
		PackageLocker p = new PackageLocker(0,1,g,apertura,cierre);
	}
	
	@Test
	public void getID() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		assertSame(1,p.getID());
	}
	
	@Test
	public void getCoordinate() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		assertSame(g,p.getCoordinate());
	}
	
	@Test
	public void operativoTest() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		assertSame(p.getOperative(),true);
	}
	
	@Test
	public void cambioOperativo() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		p.cambioOperativo(false);
		assertSame(p.getOperative(),false);
	}
	@Test
	public void vaciasTest() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		assertEquals(p.getTaquillasVacias(),5);
	}
	
	@Test
	public void llenasTest() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		
		p.asignaPaquete(paq);
		assertEquals(p.getTaquillasLlenas(),1);
	}
	@Test
	public void buscaPaqueteBien() { //Por cadena, también comprueba asignaPaquete()
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		
		p.asignaPaquete(paq);
		int prueba=p.buscaPaquete(paq);
		assertEquals(prueba,0);
	}
	
	@Test
	public void buscaPaqueteNull() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		Package paq =null;
		int prueba =p.buscaPaquete(paq);
		assertSame(prueba,-1);
	}
	
	@Test
	public void paquetesNoCoinciden() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		Package paqPrueba = new Package("9999999991",fecha);
		p.asignaPaquete(paq);
		int prueba=p.buscaPaquete(paqPrueba);
		assertSame(prueba,-1);
	}
	
	@Test
	public void buscaPaqueteMal() { //Por cadena, también comprueba asignaPaquete()
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		@SuppressWarnings("unused")
		int prueba=p.buscaPaquete(paq);
		assertSame(prueba,-1);
		
	}
	
	@Test
	public void sacaPaqueteBien(){
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,19,10,0);
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
		String identificadorPaq=paq.getID();
		Package devuelto = p.sacarPaquete(identificadorPaq,fechaHoy);
		assertEquals(paq,devuelto);
	}
	
	@Test
	public void sacaPaqueteNull() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,19,10,0);
		Package paq = new Package("1234567895",fecha);
		Package paqPrueba = new Package("9999999991",fecha);
		p.asignaPaquete(paq);
		p.asignaPaquete(paqPrueba);
		Package devuelto =p.sacarPaquete(paqPrueba.getID(), fechaHoy);
		assertEquals(devuelto,paqPrueba);
	}
	
	@Test
	public void sacaPaqueteBienYRecogido(){
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,19,10,0);
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
		String identificadorPaq=paq.getID();
		Package recogido = p.sacarPaquete(identificadorPaq,fechaHoy);
		assertSame(recogido.getRecogido(),true);
	}
	
	@Test
	public void sacaPaqueteBienYDevuelto(){
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,21,10,0);
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
		String identificadorPaq=paq.getID();
		Package recogido = p.sacarPaquete(identificadorPaq,fechaHoy);
		assertSame(recogido.getDevuelto(),true);
	}
	
	@Test(expected=IllegalStateException.class)
	public void sacaPaqueteFueraDelHorario() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,0,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,21,5,0);
		Package paq = new Package("1234567895",fecha);
		String identificadorPaq=paq.getID();
		p.asignaPaquete(paq);
		@SuppressWarnings("unused")
		Package recogido = p.sacarPaquete(identificadorPaq, fechaHoy);
	}
	
	@Test(expected=NullPointerException.class)
	public void sacaPaqueteMal() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(5,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaHoy = new GregorianCalendar(2000,10,19,10,0);
		Package paq = new Package("1234567895",fecha);
		String identificador=paq.getID();
		@SuppressWarnings("unused")
		Package devuelto=p.sacarPaquete(identificador,fechaHoy);
			
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void todasTaquillasOcupadasTest() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		Package paq1 = new Package("1234567895",fecha);
		
		p.asignaPaquete(paq);
		p.asignaPaquete(paq1); 
	}
	
	@Test(expected=IllegalStateException.class)
	public void asignaYNoOperativo() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(2,1,g,apertura,cierre);
		p.cambioOperativo(false);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		@SuppressWarnings("unused")
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
	}
	
	@Test(expected=IllegalStateException.class)
	public void buscaYNoOperativo() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(2,1,g,apertura,cierre);
		
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
		p.cambioOperativo(false);
		@SuppressWarnings("unused")
		int buscado = p.buscaPaquete(paq);
	}
	
	@Test(expected=IllegalStateException.class)
	public void sacaYNoOperativo() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(2,1,g,apertura,cierre);
		
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fecha1 = new GregorianCalendar(2000,10,19,10,0);
		
		Package paq = new Package("1234567895",fecha);
		p.asignaPaquete(paq);
		p.cambioOperativo(false);
		@SuppressWarnings("unused")
		Package buscado = p.sacarPaquete("1234567895", fecha1);
	}
	
	@Test
	public void paqueteEnUltimaTaquilla() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(2,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		GregorianCalendar fechaPrueba = new GregorianCalendar(2000,10,19,10,0);
		Package paq = new Package("1234567895",fecha);
		Package paq1 = new Package("9999999991",fecha);
		p.asignaPaquete(paq);
		p.asignaPaquete(paq1);
		assertEquals(p.sacarPaquete("9999999991", fechaPrueba),paq1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aperturaMayorQueCierreInicio(){
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime aperturaCambia = OffsetTime.of(23,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		@SuppressWarnings("unused")
		PackageLocker p = new PackageLocker(2,1,g,aperturaCambia,cierre);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void aperturaMayorQueCierreCambio() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime aperturaCambia = OffsetTime.of(23,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(2,1,g,apertura,cierre);
		p.cambiaApertura(aperturaCambia);
	}
	
	@Test
	public void dentroDelHorario() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,12,0);
		assertSame(p.abiertoHorario(fecha),true);
	}
	@Test
	public void fueraDelHorarioPronto() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,5,59);
		assertSame(p.abiertoHorario(fecha),false);
	}
	@Test
	public void fueraDelHorarioTarde() {
		GPSCoordinate g=new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,22,1);
		assertSame(p.abiertoHorario(fecha),false);
	}
	
	
	@Test
	public void cambioHoraAperturaCorrecto() {
		GPSCoordinate g = new GPSCoordinate("089º00'00\"N","179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		OffsetTime aperturaCambio = OffsetTime.of(7,30,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		p.cambiaApertura(aperturaCambio);
		assertEquals("7:30",p.horaApertura());
	}
	
	@Test
	public void cambiaHoraCierreCorrecto() {
		GPSCoordinate g = new GPSCoordinate("089º00'00\"N","179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		OffsetTime cierreCambio = OffsetTime.of(23,30,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		p.cambiaCierre(cierreCambio);
		assertEquals("23:30",p.horaCierre());
	}
	
		
	@Test
	public void horaAperturaString() {
		GPSCoordinate g = new GPSCoordinate("089º00'00\"N","179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		String cad = "6:0";
		assertEquals(cad,p.horaApertura());
		
	}
	
	@Test
	public void horaCierreString() {
		GPSCoordinate g = new GPSCoordinate("089º00'00\"N","179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		String cad = "22:0";
		assertEquals(cad,p.horaCierre());
	}
	
	@Test
	public void numeroTaquillasCorrecto() {
		GPSCoordinate g = new GPSCoordinate("089º00'00\"N","179º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker p = new PackageLocker(1,1,g,apertura,cierre);
		assertSame(1,p.getNumTaquillas());
	}
}
