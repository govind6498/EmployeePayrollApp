package com.bridgelabz.fileioexample;
import java.util.Arrays;
import org.junit.Test;

import com.bridgelabz.fileioexample.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {

	@Test
	public void given3EmployeeWhenWrittenToFileShowMatchEmployeeEbteries() {
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(1,"Govind",254268),
				new EmployeePayrollData(2,"Himanshu",458446),
				new EmployeePayrollData(3,"Avinash",125485)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);

	}
}

