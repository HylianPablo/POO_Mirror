package es.uva.infor.alumnos.poo.practica1;

import static org.junit.Assert.*;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
		p.addPackageLocker(pl);
		p.addPackageLocker(pl1);
		ArrayList<PackageLocker> radPaq=p.packageLockersEnRadio(coord2, 10000);
		ArrayList<PackageLocker> prueba = new ArrayList<PackageLocker>();
		prueba.add(pl1);
		assertEquals(prueba,radPaq);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addPackageNull() {
		PickingPointsSystem p = new PickingPointsSystem();
		PackageLocker pl=null;
		p.addPackageLocker(pl);
	}
	
	@Test
	public void coordenadaIgualAPackageLockerGMS() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord2 = new GPSCoordinate("085º59'59\"N", "175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord2,apertura,cierre);
		p.addPackageLocker(pl);
		
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 10000);
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
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 100000000);
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
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 100000000);
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
		p.addPackageLocker(pl);
		
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 10000);
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
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 100000000);
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
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		ArrayList<PackageLocker> arr = p.packageLockersEnRadio(coord2, 100000000);
		assertEquals(prueba,arr);
	}
	
	@Test
	public void CeroPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		ArrayList<PackageLocker> prueba = p.packageLockersOperativos();
		assertSame(prueba.size(),0);
	}
	
	@Test
	public void CeroPackageLockerV2() {
		PickingPointsSystem p = new PickingPointsSystem();
		assertSame(p.getNumPackageLockers(),0);
	}
	
	@Test
	public void hayPackageLockers() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		assertSame(p.getNumPackageLockers(),1);
	}
	
	@Test
	public void verPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		PackageLocker prueba=p.getPackageLocker(0);
		assertEquals(pl,prueba);
	}
	
	@Test(expected=NullPointerException.class)
	public void noHayPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		@SuppressWarnings("unused")
		PackageLocker prueba=p.getPackageLocker(0);
	}
	
	@Test
	public void eliminaPackageLocker() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(5,1,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		p.addPackageLocker(pl1);
		p.removePackageLocker(1);
		assertSame(p.getNumPackageLockers(),1);
	}
	@Test(expected=NullPointerException.class)
	public void eliminaPackageLockerInexistente() {
		PickingPointsSystem p = new PickingPointsSystem();
		p.removePackageLocker(0);
	}
	
	
	@Test
	public void pruebaOperativos() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		caja.add(pl);
		assertEquals(p.packageLockersOperativos(),caja);
	}
	
	@Test
	public void operativosNoTotal() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(5,1,coord1,apertura,cierre);
		pl1.cambioOperativo(false);
		p.addPackageLocker(pl);
		p.addPackageLocker(pl1);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		caja.add(pl);
		assertEquals(p.packageLockersOperativos(),caja);
		
	}
	
	@Test
	public void fueraDeServicio() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		pl.cambioOperativo(false);
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		caja.add(pl);
		assertEquals(p.packageLockersFueraServicio(),caja);
	}
	
	@Test
	public void fueraDeServicioNoTotal() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(5,1,coord1,apertura,cierre);
		pl1.cambioOperativo(false);
		p.addPackageLocker(pl);
		p.addPackageLocker(pl1);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		caja.add(pl1);
		assertEquals(p.packageLockersFueraServicio(),caja);
		
	}
	
	@Test
	public void algunaVacia() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(5,0,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		caja.add(pl);
		assertEquals(p.packageLockersConTaquillaVacia(),caja);
	}
	@Test
	public void todasTaquillasLLenas() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,0,coord1,apertura,cierre);
		p.addPackageLocker(pl);
		GregorianCalendar fecha = new GregorianCalendar(2000,10,20,10,0);
		Package paq = new Package("1234567895",fecha);
		pl.asignaPaquete(paq);
		ArrayList<PackageLocker> caja=new ArrayList<PackageLocker>();
		assertEquals(p.packageLockersConTaquillaVacia(),caja);
	}
	
	@Test
	public void sacarPaqueteEnPosicionNoPrimera() {
		PickingPointsSystem p = new PickingPointsSystem();
		GPSCoordinate coord1 = new GPSCoordinate("085º59'59\"N","175º59'59\"E");
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl = new PackageLocker(1,2,coord1,apertura,cierre);
		PackageLocker pl1 = new PackageLocker(1,1,coord1,apertura,cierre);
		p.addPackageLocker(pl1);
		p.addPackageLocker(pl);
		assertEquals(p.getPackageLocker(2),pl);
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
		p.addPackageLocker(pl);
		p.addPackageLocker(pl1);
	}
}
