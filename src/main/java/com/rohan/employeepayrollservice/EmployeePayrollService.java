package com.rohan.employeepayrollservice;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	public ArrayList<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner scanner = new Scanner(System.in);
		employeePayrollService.readEmployeeData(scanner);
		employeePayrollService.writeEmployeePayrollData();
	}

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

	public void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
	}
}
