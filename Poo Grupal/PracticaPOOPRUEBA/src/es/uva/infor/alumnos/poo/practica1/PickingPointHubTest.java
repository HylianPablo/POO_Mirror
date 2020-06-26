package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class PickingPointHubTest {

	@Test
	public void identificadorCorrecto() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertSame(1,pph.getID());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void identificadorIncorrecto() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		@SuppressWarnings("unused")
		PickingPointHub pph = new PickingPointHub(-1,coord1,arr);
	}
	
	@Test
	public void coordenadaCorrecta() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertEquals(coord1,pph.getCoordinate());
	}
	
	@Test
	public void arrayCorrecto() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertEquals(arr,pph.getPuntosDelSistema());
	}
	
	@Test
	public void arrayTamCorrecto() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertSame(2,pph.getSize());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void arrayTamIncorrecto() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		@SuppressWarnings("unused")
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void distintasCoordenadas() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		GPSCoordinate coord11 = new GPSCoordinate("081º59'59\"N","171º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord11);
		arr.add(k);
		@SuppressWarnings("unused")
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void distintasCoordenadasDelPPH() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		GPSCoordinate coord11 = new GPSCoordinate("081º59'59\"N","171º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		@SuppressWarnings("unused")
		PickingPointHub pph = new PickingPointHub(1,coord11,arr);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void identificadoresIguales() {
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,1,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,5,coord1);
		arr.add(k);
		@SuppressWarnings("unused")
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
	}
	
	@Test
	public void hayEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertTrue(pph.hayEspacio());
	}
	
	@Test
	public void noHayEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,1,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,1,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertFalse(pph.hayEspacio());
	}
	
	@Test
	public void encuentraGroupable() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertTrue(pph.estaGroupable(pl));
	}
	
	@Test
	public void noEstaGroupable() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		Kiosk k1 = new Kiosk(4,2,coord1);
		k1.asignaPaquete(paq);
		assertFalse(pph.estaGroupable(k1));
	}
	
	@Test
	public void addGroupable() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		Kiosk k1 = new Kiosk(4,2,coord1);
		k1.asignaPaquete(paq);
		pph.addGroupable(k1);
		assertSame(3,pph.getSize());
	}
	
	
	@Test
	public void removeGroupable() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		Kiosk k1 = new Kiosk(4,2,coord1);
		k1.asignaPaquete(paq);
		arr.add(k1);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.removeGroupable(k1);
		assertSame(2,pph.getSize());
	}
	
	@Test(expected=IllegalStateException.class)
	public void removeGroupableConMenosDeDos() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.removeGroupable(k);
		assertSame(2,pph.getSize());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void removeGroupableInexistente() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		Kiosk k1 = new Kiosk(4,2,coord1);
		k1.asignaPaquete(paq);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.removeGroupable(k1);
		assertSame(2,pph.getSize());
	}
	
	@Test
	public void cambioOperativo() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.cambioOperativo(false);
		assertFalse(pph.getOperative());
	}
	
	@Test
	public void cambioOperativoTrue() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.cambioOperativo(false);
		pph.cambioOperativo(true);
		assertTrue(pph.getOperative());
	}
	
	@Test
	public void cambioOperativoTrueTotal() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.cambioOperativoTotal(false);
		pph.cambioOperativoTotal(true);
		assertTrue(pph.getOperative());
	}
	
	@Test
	public void cambioOperativoInterior() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.cambioOperativoTotal(false);
		ArrayList<GroupablePoint> arrPrueba=pph.getPuntosDelSistema();
		GroupablePoint gppPrueba = arrPrueba.get(0);
		assertFalse(gppPrueba.getOperative());
	}
	
	@Test
	public void operativoPeroNoAlgunoDelInterior() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		pl.cambioOperativo(false);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertTrue(pph.getOperative());
	}
	
	@Test
	public void hayContrareembolso() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(3,2,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertTrue(pph.hayContraReembolso());
	}
	
	@Test
	public void noHayContrareembolso() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		PackageLocker pl2 = new PackageLocker(3,3,coord1,apertura,cierre);
		pl2.asignaPaquete(paq);
		arr.add(pl2);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertFalse(pph.hayContraReembolso());
	}
	
	@Test
	public void estaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertTrue(pph.estaPaquete("1234567895"));
	}
	
	@Test
	public void noEstaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertFalse(pph.estaPaquete("9999999991"));
	}
	
	@Test
	public void asignaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		Package paq2 = new Package("9999999991",fecha,1,false,false);
		Package paq3 = new Package("1111111119",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		pl.asignaPaquete(paq2);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		pph.asignaPaquete(paq3);
		assertSame(2,k.getTaquillasLlenas());
	}
	
	@Test
	public void buscaPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		Package paq2 = new Package("9999999991",fecha,1,false,false);
		Package paq3 = new Package("1111111119",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		pl.asignaPaquete(paq2);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq3);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertSame(2,pph.buscaPaquete(paq3));
	}
	
	@Test
	public void buscaPaqueteMal() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		Package paq2 = new Package("9999999991",fecha,1,false,false);
		Package paq3 = new Package("1111111119",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq3);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertSame(-1,pph.buscaPaquete(paq2));
	}
	
	@Test
	public void sacarPaquete() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		Package paq2 = new Package("9999999991",fecha,1,false,false);
		Package paq3 = new Package("1111111119",fecha,1,false,false);
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ArrayList<GroupablePoint> arr = new ArrayList<>();
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(2,2,coord1,apertura,cierre);
		pl.asignaPaquete(paq);
		pl.asignaPaquete(paq2);
		arr.add(pl);
		Kiosk k = new Kiosk(1,3,coord1);
		k.asignaPaquete(paq3);
		arr.add(k);
		PickingPointHub pph = new PickingPointHub(1,coord1,arr);
		assertSame(paq3,pph.sacarPaquete("1111111119"));
	}
	
}
