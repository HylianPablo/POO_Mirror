/**
 * Paquete utilizado.
 * @author Pablo, Hugo ,Manu
 *
 */
package es.uva.infor.alumnos.poo.punto;
/**
 * Implementación del punto en el plano. 
 * Primera práctica del grupo de la asignatura de Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo M, Manuel M, Hugo P
 *
 */
public class Punto {
	private double CoorX;
	private double CoorY;
	
	/**
	 * Inicializa el <code> Punto </code> en cero, cero cartesianas.
	 */
	public Punto() {
		CoorX=0;
		CoorY=0;
	}
	/**
	 * Inicializa el <code> Punto </code> con los parámetros dados.
	 * @param x Double que representa la coordenada cartesiana abcisa.
	 * @param y Double que representa la coordenada cartesiana ordenada.
	 */
	public Punto(double x,double y){
		CoorX=x;
		CoorY=y;
	}
	/**
	 * Coordenada x.
	 * @return Valor de la primera coordenada cartesiana.
	 */
	public double x() {
		return CoorX;
	}
	/**
	 * Coordenada y.
	 * @return Valor de la segunda coordenada cartesiana.
	 */
	public double y() {
		return CoorY;
	}
	/**
	 * Desplaza el objeto <code> Punto </code>
	 * @param Aumento primera coordenada cartesiana.
	 * @param Aumento de la segunda coordenada cartesiana.
	 */
	public void traslada(double x, double y) {
		CoorX=CoorX+x;
		CoorY=CoorY+y;
	}
	/**
	 * Distancia de un punto a otro.
	 * @param Objeto <code> Punto </code> con el que comparar.
	 * @return Distancia en unidades lineales entre dos puntos cartesianos
	 */
	public double distancia(Punto q) {
		double rest1=Math.abs(CoorX-q.x());
		double rest2=Math.abs(CoorY-q.y());
		double r= (Math.pow(rest1,2.0)+Math.pow(rest2,2.0));
		return (Math.sqrt((r)));
	}
	/**
	 * Coordenada polar rho.
	 * @param p Punto del que tomamos su coordenada polar rho. Distancia respecto al origen.
	 * @return Coordenada polar rho.
	 */
	public double getRho() {
		Punto o = new Punto(0,0);
		return (this.distancia(o));
		
	}
	
	public void rota(double ang) {
	  double CoorT=getTheta();
	  CoorT+=ang;
		
	  CoorX = getRho()*Math.cos(CoorT);
	  CoorY = getRho()*Math.sin(CoorT);
		
	}
	/**
	 * Coordenada polar theta.
	 * @param p Punto del que tomamos su coordenada polar theta. Ángulo respecto al semieje positivo de abcisas.
	 * @return Coordenada polar theta.
	 */
	public double getTheta() {
		return Math.atan2(CoorY, CoorX);
	}
	/**
	 * Cartesianas a cadena.
	 * @return Imprime directamente ambas coordenadas cartesianas.
	 */
	public String cartesianasACadena() {
		return (CoorX + " , " + CoorY);
		
	}
	/**
	 * Polares a cadena.
	 * @return Imprime directamente ambas coordenadas polares.
	 */
	
	public String polaresACadena() {
		return(this.getRho()+" , "+this.getTheta());
	}
	/**
	 * Multiplica por un escalar el vector.
	 * @param d Escalar del vector.
	 */
	public void escala(double d) {
		CoorX*=d;
		CoorY*=d;
	}

		
	/*public void rota(Punto p,double ang) {
		double dis = distancia(p);
		double x =p.x();
		double y = p.y();
		CoorX-=x;
		CoorY-=y;
		
		double r = this.getRho();
		double t = this.getTheta();
		
		rota(r);
		CoorX= this.getRho()*Math.cos(this.getTheta());
		CoorY=this.getRho()*Math.sin(this.getTheta());
		CoorX+=x;
		CoorY+=y;
		
	}*/
	
	//TO-DO
	//Set de ambas variables polares
	//Rota: 
	//Escala:
}