
//TO-DO Cambiar los contratos de Assert a Cofoja
//Hacer en papel tabla de clases de equivalencia

/**
 * Paquete utilizado.
 * @author Pablo Martínez López
 */
package es.uva.inf.alumnos.poo.repaso;

/**
 * Implementación de la clase Fecha, la cual permitirá conocer la fecha actual, conocer cuantos dias faltan hasta otra fecha y cuantos días han pasado desde una fecha anterior.
 * Programación Orientada a Objetos.
 * Universidad de Valladolid.
 * @author Pablo Martínez López.
 *
 */
public class Fecha {
	private int day;
	private int month;
	private int year;
	private int[] vector;
	
	/**
	 * Inicialización de la clase Fecha a partir de día,mes y año, los cuales se indican como argumento.
	 * @param d Número entero que representa el día del mes.
	 * @param m Número entero que representa el mes.
	 * @param y Número entero que representa el año.
	 * @assert.pre y>0
	 * @assert.pre m>0 && m<13
	 * @assert.pre diaCorrecto(d,m)
	 * @throws AssertonError con monitorización de asertos en ejecución.
	 */
	public Fecha(int d,int m,int y) {
		assert y>0 : "El año debe ser mayor que cero.";
		assert m>0 && m<13 : "El mes se debe encontrar en [1,12]";
		assert diaCorrecto(d,m) : "El día debe ser acorde al mes y siempre mantenerse en [1,31]";
		day=d;
		month=m;
		year=y;
		vector=new int[12];
		vector[0]=0;
		vector[1]=31;
		vector[2]=59;
		vector[3]=90;
		vector[4]=120;
		vector[5]=151;
		vector[6]=181;
		vector[7]=213;
		vector[8]=243;
		vector[9]=273;
		vector[10]=304;
		vector[11]=334;
	}
	
	private boolean diaCorrecto(int d,int m) {
		if(d<1 || d>31) {
			return false;
		}
		if(m==2) {
			if(esBisiesto(year)) {
				if (d>29) {
					return false;
				}
			}else {
				if(d>28) {
					return false;
				}
			}
		}if(m==4 || m==6 || m==8 || m==9 || m==11) {
			if(d>30) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Comprueba si el año introducido es bisiesto.
	 * @return true si el año es bisiesto y false en caso contrario.
	 */
	public boolean esBisiesto(int year) {
		if(year%4!=0) {
			return false;
		}
		return (!(year%100==0 && year%400!=0));
	}
	
	/**
	 * Consulta el día actual de la fecha.
	 * @return Número entero que representa el día del mes de la fecha actual.
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Consulta el mes actual de la fecha.
	 * @return Número entero que representa el mes de la fecha actual.
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Consulta el año actual de la fecha.
	 * @return Número entero que representa el año de la fecha actual.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Consulta cual es la fecha actual, con los tres parámetros.
	 * @return Cadena de caracteres que representa la fecha actual.
	 */
	public String getFecha() {
		return Integer.toString(getDay())+"//"+Integer.toString(getMonth())+"//"+Integer.toString(getYear());
	}
	
	/**
	 * Consulta cuantos días faltan hasta una fecha.
	 * @param f referencia a la fecha a comparar, la cual no puede ser null.
	 * @return Número entero que representa el número total de días entre las dos fechas.
	 * @assert.pre f!=null
	 * @throws AssertionError con monitorización de asertos en ejecución.
	 */
	public int diasHastaFecha(Fecha f) {
		assert f!=null : "La fecha no puede ser null";
		int diferenciaA=f.getYear()-getYear();
		int total=Math.abs(diferenciaA*365);
		int bis=0;
		int yy=Math.min(year, f.getYear());
		for(int i=1;i<diferenciaA;i++) {
			if(esBisiesto(yy+i)) {
				bis++;
			}
		}
		total+=bis;
		int a=diasHastaHoyAnual();
		int b=f.diasHastaHoyAnual();
		a=Math.abs(a-b);
		return total+a;
	}
	
	private int diasHastaHoyAnual() {
		int total=vector[month-1];
		total+=day;
		return total;
	}

}
