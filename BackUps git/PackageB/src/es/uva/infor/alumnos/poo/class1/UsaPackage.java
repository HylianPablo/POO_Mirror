package es.uva.infor.alumnos.poo.class1;

import java.util.*;

public class UsaPackage {

	public static void main(String[] args) {
		Date fecha = new Date(2000,10,20);
		Package p = new Package(123456789,fecha,false,false);
		System.out.println(p.getID());

	}

}
