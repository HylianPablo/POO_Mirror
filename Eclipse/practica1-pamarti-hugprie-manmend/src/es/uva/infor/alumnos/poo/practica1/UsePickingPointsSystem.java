package es.uva.infor.alumnos.poo.practica1;

import es.uva.inf.poo.maps.GPSCoordinate;

import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;


public class UsePickingPointsSystem {

	public static void main(String[] args) {
		PickingPointsSystem p = new PickingPointsSystem();
		
		//GregorianCalendar fecha = new GregorianCalendar(2000,10,20);
		//Package paq = new Package(123456789,fecha);
		GPSCoordinate coord1 = new GPSCoordinate("080º59'59\"N", "170º59'59\"E"); 
		ZoneOffset zonaH=ZoneOffset.of("+01:00");
		OffsetTime apertura = OffsetTime.of(6,0,0,0,zonaH);
		OffsetTime cierre=OffsetTime.of(22,0,0,0,zonaH);
		PackageLocker pl=new PackageLocker(5,5,coord1,apertura,cierre);
		PackageLocker pl2=new PackageLocker(5,5,coord1,apertura,cierre);
		p.addPackageLocker(pl2);
		p.addPackageLocker(pl);
		
		System.out.println("Existen un total de "+p.getNumPackageLockers()+ " PackageLockers.");
		
		ArrayList<PackageLocker> operative=p.packageLockersOperativos();
		System.out.println("Existen "+operative.size()+" PackageLockers operativos.");
		
		ArrayList<PackageLocker> fueraServ = p.packageLockersFueraServicio();
		System.out.println("Existen "+fueraServ.size()+ " PackageLockers fuera de servicio.");
		
		ArrayList<PackageLocker> algunaVacia = p.packageLockersConTaquillaVacia();
		System.out.println("Existen "+algunaVacia.size()+ " PackageLockers con alguna taquilla vacía.");
		
		System.out.println("Se procede a añadir un nuevo PackageLocker al sistema");
		p.addPackageLocker(pl);
		ArrayList<PackageLocker> operativeP=p.packageLockersOperativos();
		System.out.println("Existen "+operativeP.size()+" PackageLockers operativos.");
		
		System.out.println("Se procede a eliminar el anterior PackageLocker del sistema");
		System.out.println(p.getNumPackageLockers());
		p.removePackageLocker(5);
		ArrayList<PackageLocker> operativePP=p.packageLockersOperativos();
		System.out.println("Existen "+operativePP.size()+" PackageLockers operativos.");
		
		System.out.println("Se comprobarán los PackageLocker alrededor de un radio de 500000 km");
		System.out.println("El punto desde el cual se comprobará es: "+coord1); 
		ArrayList <PackageLocker> caja = p.packageLockersEnRadio(coord1,500000000.0);
		for(int i=0;i<caja.size();i++) {
			PackageLocker pCaja= caja.get(i);
			System.out.println("El Package Locker de indentificador "+pCaja.getID()+" se encuentra dentro del radio");
		}
	}
}
