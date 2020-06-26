/**
 * Paquete utilizado.
 * @author Pablo
 */
package es.uva.infor.alumnos.poo.racionales;

/**
 * Implementación de los números racionales.
 * @author Pablo
 *
 */
public class Racional {
	private int Numerador;
	private int Denominador;
	
	public Racional() {
		Numerador = 0;
		Denominador = 1;
	}
	public Racional(int n,int d) {
		Numerador = n;
		Denominador = d;
		int m = mcd(Numerador, Denominador);
		Numerador = Numerador/m;
		Denominador=Denominador/m;
		
	}
	public String aCadena() {
		return (Numerador+" / "+Denominador);
	}
	public int getRacional() {
		return (Numerador/Denominador);
	}
	
	public int getNum() {
		return (Numerador);
	}
	public int getDen() {
		return(Denominador);
	}
	public Racional suma(Racional r) {
		Racional rac;
		int den = Denominador * r.getDen();
		int num = ((Numerador*r.getDen())+ (r.getNum()*Denominador));
		rac = new Racional(num, den);
		return rac;
	}
	public Racional multiplica(Racional r) {
		Racional rac;
		int den = Denominador * r.getDen();
		int num = Numerador * r.getNum();
		rac= new Racional(num,den);
		return rac;
	}
	public Racional divide(Racional r) {
		Racional rac;
		int num = Numerador * r.getDen();
		int den = Denominador * r.getNum();
		rac = new Racional (num,den);
		return rac;
	}
	
	static int mcd(int a, int b) {
	       if(b==0) {
	           return a;
	       }else {
	           return mcd(b, a % b);
	       }
	} 
	
	public void simplificar() {
		
	}
	
}
