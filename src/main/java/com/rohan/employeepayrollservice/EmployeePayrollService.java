package com.rohan.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	};

	public List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public EmployeePayrollService() {
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner scanner = new Scanner(System.in);
		employeePayrollService.readEmployeeData(scanner);
		employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
	}

	/**
	 * Takes employee input from user through console
	 * 
	 * @param scanner
	 */
	public void readEmployeeData(Scanner scanner) {
		System.out.println("Enter Employee ID : ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Employee Name : ");
		String name = scanner.nextLine();
		System.out.println("Enter Employee Salary : ");
		double salary = scanner.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	/**
	 * Writes data to console or file
	 * 
	 * @param ioService
	 */
	public void writeEmployeeData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFile().writeData(employeePayrollList);
		}
	}

	/**
	 * Prints data from file to console
	 * 
	 * @param ioService
	 */
	public void printData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFile().printData();
		}
	}

	public long countEntries(IOService fileIo) {
		long entries = 0;
		if (fileIo.equals(IOService.FILE_IO)) {
			entries = new EmployeePayrollFile().countEntries();
		}
		return entries;
	}
}
