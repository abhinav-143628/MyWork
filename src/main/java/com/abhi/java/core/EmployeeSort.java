package com.abhi.java.core;

import java.util.Comparator;

public class EmployeeSort implements Comparable<EmployeeSort> {

	private int id;
	private String name;
	private double Salary;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(EmployeeSort o) {
		return this.getName().compareTo(o.getName());
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public static Comparator<EmployeeSort> comparator = new Comparator<EmployeeSort>() {
		@Override
		public int compare(EmployeeSort o1, EmployeeSort o2) {
			if(o1.getSalary() > o2.getSalary())
				return-1;
			else if(o1.getSalary() < o2.getSalary())
				return 1;
			return 0;
		}
	};
}
