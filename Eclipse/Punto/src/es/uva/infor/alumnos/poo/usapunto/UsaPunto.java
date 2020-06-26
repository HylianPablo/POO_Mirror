package es.uva.infor.alumnos.poo.usapunto;
import es.uva.infor.alumnos.poo.punto.Punto;

import javax.swing.*;

public class UsaPunto {

	public static void main(String[] args) {
		Punto p1,p2;
		p1=new Punto();
		p2=new Punto();
		
		p1.traslada(3,4);
		System.out.println(p1.x()+" , "+p1.y());
		
		double d = p1.distancia(p2);
		System.out.println(d);
		
		/*JTextArea texto = new JTextArea();
		texto.setText("Otro tipo de interfaz: \n"+p1.x()+" , "+p1.y()+" \n");
		JFrame ventana = new JFrame("Mi ventana");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ventana.add(texto);
		ventana.pack();
		ventana.setVisible(true);
		*/
		System.out.println(p1.cartesianasACadena());
		p2.traslada(Math.sqrt(2)/2, Math.sqrt(2)/2);
		System.out.println(p2.cartesianasACadena());
		
		Punto p3 = new Punto(4,6);
		System.out.println(p3.polaresACadena());
		p3.rota(Math.PI);
		System.out.println(p3.cartesianasACadena());
		System.out.println(p3.polaresACadena());
	}
}