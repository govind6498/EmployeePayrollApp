package com.bridgelabz.fileioexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO,FILE_IO,DB_IO,REST_IO
	}
	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {

	}
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}
	
	private void readEmployeePayrollData(Scanner scannerObject) {
		
		System.out.println("Enter Employee Id:");
		int id = scannerObject.nextInt();
		System.out.println("Enter Employee Name:");
		String name= scannerObject.next();
		System.out.println("Enter Employee Salary:");
		double salary = scannerObject.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id,name,salary));

	}
	private void writeEmployeePayrollData() {
		System.out.println("\n Writing Payroll Roaster to Cosole\n"+employeePayrollList);
	}
	public static void main(String[] args) {
		System.out.println("-----------Welcome to Employee Payroll Services-------------");
		ArrayList<EmployeePayrollData>employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner scannerObject = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(scannerObject);
		employeePayrollService.writeEmployeePayrollData();
	}
}
