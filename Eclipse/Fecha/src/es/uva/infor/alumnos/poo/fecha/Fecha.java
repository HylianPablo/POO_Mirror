package es.uva.infor.alumnos.poo.fecha;
/*
 * Implementación de la clase Fecha
 * Segunda práctica de Programación Orientada a objetos creada por
 * @author Martínez López Pablo, Méndez Calvo Manuel, Prieto Hugo
 */


public class Fecha {
	private int Year;
	private int Month;
	private int Day;
	/*
	 * Inicializa la <code> Fecha <code> Con el 2 de octubre de 2018
	 * @param Year Month Day
	 */
	public Fecha() {
		Year=2018;
		Month=10;
		Day=2;
	}
	public Fecha(int y,int m,int d) {
		Year=y;
		Month=m;
		Day=d;
	}
	
	public String aCadena() {
		return(Day+"//"+Month+"//"+Year);
	}
	public int getDay() {
		return Day;
	}
	public int getMonth() {
		return Month;
	}
	public int getYear() {
		return Year;
	}
	
	public Fecha ayer() {
		Fecha nf;
		int nd=Day;
		if(nd!=1) {
			nd--;
			nf = new Fecha(Year,Month,nd);
			return(nf);
		}else {
			Fecha mes =new Fecha (Year,Month-1,Day);
			nd = mes.diasMes();
			int nm= Month;
			if(nm!=1) {
				nf = new Fecha(Year,nm-1,nd);
				return(nf);
			}else {
				nf = new Fecha(Year-1,12,31);
				return(nf);
			}
		}
		
	}
	
	public Fecha mañana() {
		Fecha nf;
		int nd=Day;
		int danger=diasMes();
		if(nd!=danger) {
			nd++;
			nf = new Fecha(Year,Month,nd);
			return(nf);
		}else {
			Fecha mes =new Fecha (Year,Month+1,Day);
			nd = mes.diasMes();
			int nm= Month;
			if(nm!=12) {
				nf = new Fecha(Year,nm+1,nd);
				return(nf);
			}else {
				nf = new Fecha(Year+1,1,1);
				return(nf);
			}
		}
		
	}
	public boolean esBisiesto() {
		if(Year/4==0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	public int diasMes() {
		int m = Month;
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12) {
			return 31;
		}else {
			if(m!=2) {
				return 30;
			}else {
				if(esBisiesto()) {
					return 29;
				}else {
					return 28;
				}
			}
		}
	}
	public int diaDelAño() {
		int dt=0;
		for (int i=1;i<Month;i++) {
			Fecha f= new Fecha(Year,Month-i,Day);
					dt +=f.diasMes();
		}
		return dt+Day;
	}
	/*
	 * 
	 */
	public int divideAño() {
		//Fecha f = new Fecha(Year,Month,Day);
		int x = Year%28;
		int y = Math.floorMod(x, 7);
		return y;
	}
	public int diaDeLaSemana () {
		int x = divideAño();
		int y = diaDelAño();
		y=Math.floorMod(y, 7);
		x=Math.floorMod(x+y, 7);
		return x;
	}
	public int semana() {
		int x= divideAño();
		int y= diaDelAño();
		int z= (x+y)/7;
		
		return z;
	}
}
