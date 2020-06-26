package es.uva.infor.alumnos.poo.class2;

public class PackageLocker {
	private int nLock; //Número de taquillas
	private Taquilla[] taq;
	private boolean operative;
	//private GPS a implementar
	
	public PackageLocker(int totalTaq){
		nLock = totalTaq;
		taq=new Taquilla[nLock];
		operative=false;
		for(int i=0;i<nLock;i++) {
			Taquilla t= new Taquilla(true,-1);
			taq[i]=t;
		}
		//Implementar GPS
	}
	public int getVacias() {
		int contador=0;
		for(int i=0;i<nLock;i++) {
			if(taq[i].getVacia()==true) {
				contador ++;
			}
		}
		return contador;
	}
	
	public int getLlenas() {
		return (nLock-getVacias());
	}
	
	public void cambioOperativo(boolean b) {
		operative=b;
	}
	
	public void asignaPaquete(int cod) {
		int flag =0;
		for(int i=0;i<nLock;i++) {
			if(taq[i].getVacia()==true) {
				taq[i].cambiaCodigo(cod);
				taq[i].cambiaVacia(false);
				flag++;
				break;
			}
		}
		if(flag==0) {
			System.out.println("No quedan taquillas");
		}
	}
	
	public int buscaPaquete(int cod) {
		for(int i=0;i<nLock;i++) {
			if(taq[i].getCodigo()==cod) {
				return (i+1);	
			}
		}
		//Si es 0, en el usa PackageLocker cambiar mensaje
		return 0;
		
	}
	
	public int sacarPaquete(int cod) {
		for(int i=0;i<nLock;i++) {
			if(taq[i].getCodigo()==cod) {
				return taq[i].getCodigo();	
			}
		}
		//Si es 0, en el usa PackageLocker cambiar mensaje
		return -1;
	}
	
	
	

}

class Taquilla{
	private boolean vacia;
	private int codigo;
	
	public Taquilla(boolean v,int i) {
		vacia=v;
		codigo=i;
	}
	public boolean getVacia() {
		return vacia;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public void cambiaCodigo(int c) {
		codigo=c;
	}
	public void cambiaVacia(boolean b) {
		vacia=b;
	}
	
}
