/**
 * Paquete utilizado.
 * @author Pablo Martínez López
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Implementación de la clase PolinomioGradoDos, la cual, como su nombre indica, implementa polinomios de segundo grado y algunas de sus operaciones.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 */
public class PolinomioGradoDos {
	private int a;
	private int b;
	private int c;
	
	/**
	 * Inicialización de la clase {@code polinomioGradoDos} a través de sus argumentos representantes de los factores de x²,x y 1 en ese orden.
	 * @param a número entero que representa el factor de {@code x²} en el polinomio.
	 * @param b número entero que representa el factor de {@code x} en el polinomio.
	 * @param c número entero que representa el factor de {@code 1} en el polinomio.
	 */
	public PolinomioGradoDos(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	/**
	 * Devuelve un {@code String} que identifica al objeto {@code polinomioGradoDos}.
	 * @return cadena de caracteres que representa al polinomio de segundo grado. 
	 */
	@Override
	public String toString() {
		String aS="";
		String bS="";
		String cS="";
		if(a!=0) {
			if(a!=1) {
				aS=Integer.toString(a)+"x² + ";
			}else {
				aS="x² + ";
			}
		}
		if(b!=0) {
			if(b!=1) {
				bS=Integer.toString(b)+"x + ";
			}else {
				bS="x + ";
			}
		}
		if(c!=0) {
			cS=Integer.toString(c);
		}
		return (aS+bS+cS);
	}
	
	/**
	 * Devuelve el factor asociado al segundo término del polinomio, {@code x²}.
	 * @return número entero que representa el factor del término de grado dos del polinomio.
	 */
	public int segundoTermino() {
		return a;
	}
	
	/**
	 * Devuelve el factor asociado al primer término del polinomio, {@code x}.
	 * @return número entero que representa el factor del término de grado uno del polinomio.
	 */
	public int primerTermino() {
		return b;
	}
	
	/**
	 * Devuelve el término independiente del polinomio.
	 * @return número entero que representa el término independiente del polinomio.
	 */
	public int terminoIndependiente() {
		return c;
	}
	
	/**
	 * Suma un polinomio de grado dos al polinomio {@code this}.
	 * @param p objeto del tipo {@code polinomioGradoDos} el cual se sumará con el {@code polinomioGradoDos this}.
	 */
	public void sumaPolinomio(PolinomioGradoDos p) {
		a+=p.segundoTermino();
		b+=p.primerTermino();
		c+=p.terminoIndependiente();
	}
	
	/**
	 * Multiplica el polinomio por un factor externo.
	 * @param x número entero el cual multiplicará a cada término del polinomio.
	 * @throws IllegalArgumentException si el factor introducido es cero, pues crearía un polinomio nulo.
	 */
	public void multiplicaFactor(int x) {
		if(x==0) {
			throw new IllegalArgumentException("El factor por que multiplicar el polinomio no puede ser nulo");
		}
		a=a*x;
		b=b*x;
		c=c*x;
	}
	
	/**
	 * Calcula, si existen, las raices reales del {@code polinomioGradoDos}.
	 * @return cadena de caracteres en la que se encuentran las raíces del polinomio. En caso de no existir, la cadena lo advertirá.
	 */
	public String raicesReales() {
		double t = 4*a*c;
		double r= b*b;
		r-=t;
		if(r<0) {
			return ("No existen raíces reales.");
		}
		r=Math.sqrt(r);
		double y=(-b+r)/2;
		double z=(-b-r)/2;
		return ("Las raíces son: "+y+" y "+z+".");
	}
}
