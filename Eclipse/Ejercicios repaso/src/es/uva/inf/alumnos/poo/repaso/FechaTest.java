package es.uva.inf.alumnos.poo.repaso;

import static org.junit.Assert.*;

import org.junit.Test;

public class FechaTest {

	@Test
	public void FechaCorrecta() {
		Fecha f = new Fecha(1,1,1);
		assertEquals(1,f.getDay());
	}
	
	@Test(expected=AssertionError.class)
	public void FechaIncorrecta() {
		@SuppressWarnings("unused")
		Fecha f= new Fecha(0,1,1);
		
	}

}
