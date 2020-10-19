package com.rohan.employeepayrollservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFile {
	public static String PAYROLL_FILE_NAME = "payroll.txt";

	public void writeData(List<EmployeePayrollData> list) {
		StringBuffer employeeBuffer = new StringBuffer();
		list.forEach(employee -> {
			String empString = employee.toString().concat("\n");
			employeeBuffer.append(empString);
		});

		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long totalEntries = 0;
		try {
			totalEntries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalEntries;

	}
}
