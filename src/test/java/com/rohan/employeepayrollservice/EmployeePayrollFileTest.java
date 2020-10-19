package com.rohan.employeepayrollservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeePayrollFileTest {
	public static EmployeePayrollService employeeService;

	@BeforeAll
	public static void createNewFileAndWriteData() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Jeff Bezos", 100000),
				new EmployeePayrollData(2, "Bill Gates", 200000),
				new EmployeePayrollData(3, "Mark Zuckerberg", 300000) };
		employeeService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeeService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);
	}

	/**
	 * checking if employees are added to file
	 */
	@Test
	public void given3Employee_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		long entries = employeeService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		employeeService.printData(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, entries);
	}

	/**
	 * checking if counting number of entries correctly or not
	 */
	@Test
	public void given3Employee_WhenWrittenToFile_ShouldReturnEmployeeEntries() {
		employeeService.printData(EmployeePayrollService.IOService.FILE_IO);
		long result = employeeService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, result);

	}

	/**
	 * checking if read method is reading from file or not
	 */
	@Test
	public void givenFileOnReadingFile_shouldMatch_EmployeeCount() {
		employeeService.readEmployeeData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeeService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, entries);
	}
}
