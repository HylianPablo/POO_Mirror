package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
//import java.util.GregorianCalendar;
import java.time.LocalDate;

import org.junit.Test;

import es.uva.inf.poo.maps.GPSCoordinate;

public class PickingPointsSystemTest {
	
	@Test
	public void seleccionEntraAlRadio() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("044º59'59\"N", "104º59'59\"E");
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord3 = new GPSCoordinate("086º00'00\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1=new PackageLocker(5,1,coord3,apertura,cierre);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
		ArrayList<PickingPoint> radPaq=p.pickingPointsEnRadio(coord2, 10000);
		ArrayList<PickingPoint> prueba = new ArrayList<>();
		prueba.add(pl1);
		assertEquals(prueba,radPaq);
		
	}
	
	@Test
	public void seleccionEntraAlRadioConEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("084º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord3 = new GPSCoordinate("086º00'00\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1=new PackageLocker(5,1,coord3,apertura,cierre);
		pl.asignaPaquete(paq);
		pl1.asignaPaquete(paq);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
		ArrayList<PickingPoint> radPaq=p.pickingPointsEnRadioLibres(coord2, 10000000);
		ArrayList<PickingPoint> prueba = new ArrayList<>();
		prueba.add(pl);
		prueba.add(pl1);
		assertEquals(prueba,radPaq);
		
	}
	
	@Test
	public void seleccionNoEntraAlRadioConEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("004º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord3 = new GPSCoordinate("006º00'00\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1=new PackageLocker(5,1,coord3,apertura,cierre);
		pl.asignaPaquete(paq);
		pl1.asignaPaquete(paq);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
		ArrayList<PickingPoint> radPaq=p.pickingPointsEnRadioLibres(coord2, 100);
		ArrayList<PickingPoint> prueba = new ArrayList<>();
		assertEquals(prueba,radPaq);
		
	}
	
	@Test
	public void seleccionEntraAlRadioSinEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("084º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord3 = new GPSCoordinate("086º00'00\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		PackageLocker pl1=new PackageLocker(1,1,coord3,apertura,cierre);
		pl.asignaPaquete(paq);
		pl1.asignaPaquete(paq);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
		ArrayList<PickingPoint> radPaq=p.pickingPointsEnRadioLibres(coord2, 10000000);
		ArrayList<PickingPoint> prueba = new ArrayList<>();
		assertEquals(prueba,radPaq);
		
	}
	
	@Test
	public void seleccionNoEntraAlRadioSinEspacio() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,20000.0,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("084º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		GPSCoordinate coord3 = new GPSCoordinate("086º00'00\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		PackageLocker pl1=new PackageLocker(1,1,coord3,apertura,cierre);
		pl.asignaPaquete(paq);
		pl1.asignaPaquete(paq);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
		ArrayList<PickingPoint> radPaq=p.pickingPointsEnRadioLibres(coord2, 100);
		ArrayList<PickingPoint> prueba = new ArrayList<>();
		assertEquals(prueba,radPaq);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addPackageNull() {
		PickingPointsSystem p = new PickingPointsSystem();
		PackageLocker pl=null;
		p.addPickingPoint(pl);
	}
	
	@Test
	public void coordenadaIgualAPackageLockerGMS() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord2,apertura,cierre);
		p.addPickingPoint(pl);
		
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 10000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void coordenadaMenorAPackageLockerGMS() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate("080º59'59\"N", "170º59'59\"E");
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 100000000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void coordenadaMayorAPackageLockerGMS() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate("089º59'59\"N", "179º59'59\"E");
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 100000000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void coordenadaIgualAPackageLockerGD() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate(-89.9999,-179.9999);
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord2,apertura,cierre);
		p.addPickingPoint(pl);
		
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 10000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void coordenadaMenorAPackageLockerGD() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate(80.9999,170.9999);
		GPSCoordinate coord1 = new GPSCoordinate(85.9999,175.9999);
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 100000000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void coordenadaMayorAPackageLockerGD() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate(89.9999,179.9999);
		GPSCoordinate coord1 = new GPSCoordinate(85.9999,175.9999);
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		ArrayList<PickingPoint> arr = p.pickingPointsEnRadio(coord2, 100000000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void CeroPickingPoints() {
		PickingPointsSystem p = new PickingPointsSystem();
		ArrayList<PickingPoint> prueba = p.pickingPointsOperativos();
		assertSame(0,prueba.size());
	}
	
	@Test
	public void CeroPickingPointsV2() {
		PickingPointsSystem p = new PickingPointsSystem();
		assertSame(0,p.getNumPickingPoints());
	}
	
	@Test
	public void hayPickingPoints() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,2,coord1);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		PostOffice po = new PostOffice(3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		p.addPickingPoint(po);
		assertSame(4,p.getNumPickingPoints());
	}
	
	@Test
	public void verPickingPoint() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		PickingPoint prueba=p.getPickingPoint(0);
		assertEquals(pl,prueba);
	}
	
	@Test(expected=NullPointerException.class)
	public void noHayPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		@SuppressWarnings("unused")
		PickingPoint prueba=p.getPickingPoint(0);
	}
	
	@Test
	public void eliminaPickingPoint() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		Kiosk k = new Kiosk(1,3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.removePickingPoint(1);
		assertSame(1,p.getNumPickingPoints());
	}
	@Test(expected=NullPointerException.class)
	public void eliminaPickingPointInexistente() {
		PickingPointsSystem p = new PickingPointsSystem();
		p.removePickingPoint(0);
	}
	
	@Test(expected=NullPointerException.class)
	public void eliminaPickingPointInexistenteV2() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,99,coord1,apertura,cierre);
		Kiosk k = new Kiosk(11,3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.removePickingPoint(1);
	}
	
	
	@Test
	public void pruebaOperativos() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,2,coord1);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		PostOffice po = new PostOffice(3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		p.addPickingPoint(po);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		caja.add(pl);
		caja.add(k);
		caja.add(pph);
		caja.add(po);
		assertEquals(p.pickingPointsOperativos(),caja);
	}
	
	@Test
	public void operativosNoTotal() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,2,coord1);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		PostOffice po = new PostOffice(3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		p.addPickingPoint(po);
		pph.cambioOperativoTotal(false);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		caja.add(po);
		assertEquals(caja,p.pickingPointsOperativos());
		
	}
	
	@Test
	public void fueraDeServicio() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,2,coord1);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		PostOffice po = new PostOffice(3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		p.addPickingPoint(po);
		pph.cambioOperativoTotal(false);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		caja.add(pl);
		caja.add(k);
		caja.add(pph);
		assertEquals(caja,p.pickingPointsFueraServicio());
	}
	
	@Test
	public void algunaVacia() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,1,coord1);
		pl.asignaPaquete(paq);
		k.asignaPaquete(paq);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		PostOffice po = new PostOffice(3,coord1);
		po.asignaPaquete(paq);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		p.addPickingPoint(po);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		caja.add(po);
		assertEquals(caja,p.pickingPointsConEspacio());
	}
	@Test
	public void todasTaquillasLLenas() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		Kiosk k= new Kiosk(1,1,coord1);
		pl.asignaPaquete(paq);
		k.asignaPaquete(paq);
		ArrayList<GroupablePoint> arrgpp = new ArrayList<>();
		arrgpp.add(pl);
		arrgpp.add(k);
		PickingPointHub pph=new PickingPointHub(2,coord1,arrgpp);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
		p.addPickingPoint(pph);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		assertEquals(caja,p.pickingPointsConEspacio());
	}
	
	@Test
	public void llenarPostOffice() {
		LocalDate fecha = LocalDate.of(2000,10,20);
		Package paq = new Package("1234567895",fecha,1,false,false);
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		PostOffice po = new PostOffice(1,coord1);
		po.asignaPaquete(paq);
		p.addPickingPoint(po);
		ArrayList<PickingPoint> caja=new ArrayList<>();
		caja.add(po);
		assertEquals(caja,p.pickingPointsConEspacio());
	}
	
	
	@Test
	public void sacarPaqueteEnPosicionNoPrimeraPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(1,1,coord1,apertura,cierre);
		p.addPickingPoint(pl1);
		p.addPickingPoint(pl);
		assertEquals(p.getPickingPoint(2),pl);
	}
	
	@Test
	public void getPickingPointEnPosicionNoPrimeraKiosk() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k1 = new Kiosk(0,2,coord1);
		Kiosk k2 = new Kiosk(1,2,coord1);
		p.addPickingPoint(k1);
		p.addPickingPoint(k2);
		assertEquals(k2,p.getPickingPoint(1));
	}
	
	@Test
	public void sacarPickingPointEnPosicionNoPrimeraPickingPointHub() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(1,1,coord1,apertura,cierre);
		Kiosk k1 = new Kiosk(0,2,coord1);
		Kiosk k2 = new Kiosk(3,2,coord1);
		ArrayList<GroupablePoint> caja1 = new ArrayList<>();
		caja1.add(pl);
		caja1.add(k1);
		ArrayList<GroupablePoint> caja2 = new ArrayList<>();
		caja2.add(pl1);
		caja2.add(k2);
		PickingPointHub pph1 = new PickingPointHub(0,coord1,caja1);
		PickingPointHub pph2= new PickingPointHub(1,coord1,caja2);
		p.addPickingPoint(pph1);
		p.addPickingPoint(pph2);
		assertEquals(pph2,p.getPickingPoint(1));
	}
	
	@Test
	public void getPickingPointEnPosicionNoPrimeraPostOffice() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		PostOffice po1 = new PostOffice(0,coord1);
		PostOffice po2 = new PostOffice(1,coord1);
		p.addPickingPoint(po1);
		p.addPickingPoint(po2);
		assertEquals(po2,p.getPickingPoint(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dosPackageLockerIDIguales() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,1,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(1,1,coord1,apertura,cierre);
		p.addPickingPoint(pl);
		p.addPickingPoint(pl1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dosKioskIDIguales() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		Kiosk k1 = new Kiosk(0,2,coord1);
		Kiosk k2 = new Kiosk(0,2,coord1);
		p.addPickingPoint(k1);
		p.addPickingPoint(k2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dosPickingPointHubIDIguales() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		Kiosk k1 = new Kiosk(1,2,coord1);
		Kiosk k2 = new Kiosk(2,2,coord1);
		ArrayList<GroupablePoint> caja1 = new ArrayList<>();
		caja1.add(pl);
		caja1.add(k1);
		ArrayList<GroupablePoint> caja2 = new ArrayList<>();
		caja2.add(pl);
		caja2.add(k2);
		PickingPointHub pph1 = new PickingPointHub(0,coord1,caja1);
		PickingPointHub pph2 = new PickingPointHub(0,coord1,caja2);
		p.addPickingPoint(pph1);
		p.addPickingPoint(pph2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dosPostOfficeIDIguales() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		PostOffice po1 = new PostOffice(0,coord1);
		PostOffice po2 = new PostOffice(0,coord1);
		p.addPickingPoint(po1);
		p.addPickingPoint(po2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dosPickingPointIDIguales() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,1,coord1,apertura,cierre);
		Kiosk k = new Kiosk (1,3,coord1);
		p.addPickingPoint(pl);
		p.addPickingPoint(k);
	}
}
