package es.uva.infor.alumnos.poo.class1;

import java.util.*;
public class Package {
	private int id;
	private Date deadline; //Implementar fecha
	private boolean recogido;
	private boolean devuelto;
	
	
	public Package(int identifier, Date f, boolean r, boolean d) {
		id=algoritmo(identifier);
		deadline = f;
		recogido=r;
		devuelto=d;
	}
	public int getID() {
		return id;
	}
	
	public int algoritmo(int parteID) {
		int suma =0;
		int tmp = parteID;
		for(int i=0;i<9;i++) {
			suma+=parteID%10;
			parteID=parteID/10;
		}
		int resto= suma%10;
		tmp=tmp*10;
		return tmp+resto;	
	}
	public void changeR(boolean r) {
		recogido=r;
		
	}
	public void changeD(boolean d) {
		devuelto=d;
		
	}
	public Date getDate() {
		return deadline;
	}
	
}
