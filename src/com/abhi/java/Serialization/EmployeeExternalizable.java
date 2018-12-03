package com.abhi.java.Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EmployeeExternalizable implements Externalizable {

	// private static final long serialVersionUID = 1L;
	private int employeID;
	private String employeeName;
	// transient has no effect in Externalizable as in Externalizable default
	// serialization does not happen
	// whatever we chose to serialze gets serialize
	transient public int age;
	transient private String password = "abc";
	transient private int test1 = 1;
	transient private int test2 = 2;

	public int getEmployeID() {
		return employeID;
	}

	public void setEmployeID(int employeID) {
		this.employeID = employeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String employeeDetails() {
		StringBuffer empBuffer = new StringBuffer();
		empBuffer.append(getEmployeeName()).append(" has ID ").append(getEmployeID()).append(" age ").append(getAge());
		return empBuffer.toString();
	}

	public Object readResolve() {
		System.out.println("inside read resolve");
		return this;
	}

	public Object writeReplace() throws Exception {
		System.out.println("inside write replace");
		return this;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("inside read external");
		EmployeeExternalizable obj = new EmployeeExternalizable();
		// In externalizable while deserialzation, JVM creates an object for us
		// and on that object JVM call this (readExternal) method. So we
		// directly assign variables like below
		this.age = in.readInt();
		this.employeID = in.readInt();
		this.employeeName = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("inside write external");
		// as compared to writeObject in Serializable, we don;t make call to
		// default method because JVM doesn't do any default serialization
		out.writeInt(this.age);
		out.writeInt(this.employeID);
		out.writeObject(this.employeeName);
	}
}
