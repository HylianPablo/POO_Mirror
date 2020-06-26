import java.io.*;
public class EmployeeTest{
	public static void main(String args[]){
		Employee emp1 = new Employee();
		emp1.empName("Peter");
		 emp1.empAge(20);
		 emp1.empDesignation("CEO");
		 emp1.empSalary(100000);
		 emp1.printEmployee();
	}
}
