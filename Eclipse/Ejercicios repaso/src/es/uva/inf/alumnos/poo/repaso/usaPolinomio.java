package es.uva.inf.alumnos.poo.repaso;

public class usaPolinomio {

	public static void main(String[] args) {
		PolinomioGradoDos p = new PolinomioGradoDos(1,2,3);
		System.out.println(p.toString());
		PolinomioGradoDos q = new PolinomioGradoDos(1,0,-4);
		System.out.println(q.toString());
		
		p.sumaPolinomio(q);
		System.out.println(p.toString());
		
		p.multiplicaFactor(3);
		System.out.println(p.toString());
		
		System.out.println(p.raicesReales());
		System.out.println(q.raicesReales());
		

	}

}
