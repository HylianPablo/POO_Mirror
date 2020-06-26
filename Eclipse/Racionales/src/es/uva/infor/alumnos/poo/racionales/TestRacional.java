package es.uva.infor.alumnos.poo.racionales;

import java.lang.AssertionError;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRacional {

	//@Test
	/*public void test() {
		fail("Not yet implemented");
		
	}*/
	
	@Test
	public  void sumaCero(){
		Racional r1 = new Racional(1,2);
		Racional r2 = new Racional(0,1);
		
		Racional rac= r1.suma(r2);
		assertEquals("El número más cero es él mismo.",r1.getNum(),rac.getNum());
		assertEquals("El número más cero es él mismo.",r1.getDen(),rac.getDen());
		
	}
	@Test
	//Mirar esto
	public void multiplicaCero() {
		Racional r1 = new Racional(1,2);
		Racional r2 = new Racional(0,1);
		
		Racional rac = r1.multiplica(r2);
		
		assertEquals("El número por cero es cero.",rac.getNum(),0);
		assertEquals("El número por cero es cero.",rac.getDen(),1);
		
	}
}
