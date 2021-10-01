package com.bridgelabz.fileioexample;

public class EmployeePayrollData {
	public int employeeId;
	public String EmployeeName;
	public double EmployeeSalary;
	public EmployeePayrollData(int employeeId, String EmployeeName,double EmployeeSalary) {
		this.employeeId = employeeId;
		this.EmployeeName = EmployeeName;
		this.EmployeeSalary = EmployeeSalary;
	}
	public String toString() {
		return "Employee id: "+employeeId+", EmployeeName: "+EmployeeName+", EmployeeSalary: "+EmployeeSalary;
	}
}
