import java.io.*;
public class Employee{
	String name;
	int age;
	String designation;
	double salary;

	public Employee(){
	}
	public void empName(String name){
		this.name=name;
	}
	public void empAge(int empAge){ // Private vs Public
		age = empAge;
	}
	public void empDesignation(String empDesig){
		designation=empDesig;
	}
	public void empSalary(double empSalary){
		salary = empSalary;
	}
	public void printEmployee(){
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Designation: "+designation);
		System.out.println("Salary: "+salary);
	}
}
