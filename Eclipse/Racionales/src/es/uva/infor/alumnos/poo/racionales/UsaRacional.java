package es.uva.infor.alumnos.poo.racionales;

public class UsaRacional {

	public static void main(String[] args) {
		Racional r1 = new Racional(7,12);
		Racional r2 = new Racional (2,12);
		System.out.println(r1.aCadena());
		System.out.println(r2.aCadena());
		Racional s;
		s=r1.suma(r2);
		System.out.println(s.aCadena());
		
		Racional m =r1.multiplica(r2);
		System.out.println(m.aCadena());
		
		Racional d =r1.divide(r2);
		System.out.println(d.aCadena());

	}

}
