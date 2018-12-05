package com.abhi.java.Serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * Without UID
 * 
 * After serializing this obj add new field to check for errors
 * 
 * @author abhdogra1
 *
 */
public class EmployeeSerilizable implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employeID;
	String employeeName;
	public int age;
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
		empBuffer.append(getEmployeeName()).append(" has ID ").append(getEmployeID()).append(" pwd: ").append(this.password);
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

	private void readObject(ObjectInputStream ois) throws Exception {
		System.out.println("inside read object");
		// If we have default method call in writeObject and don't write below
		// default read method then we will get StreamCorruptedException.
		// Below method will do the default de-serialization of the stream
		ois.defaultReadObject();
		int test1 = ois.readInt();
		String tpwd = (String) ois.readObject();
		int test2 = ois.readInt();
		System.out.println(tpwd);
		this.password = tpwd.substring(3, tpwd.length());
	}

	private void writeObject(ObjectOutputStream oos) throws Exception {
		System.out.println("inside write object");
		// if we don't use default write object then JVM will take default value
		// for all the variable and serialize it even if our object has some
		// values in it
		oos.defaultWriteObject();
		String pwd = "123" + this.password;
		int test1 = 12+this.test1;
		int test2 = 12+this.test2;
		
		oos.writeInt(test1);
		oos.writeObject(pwd);
		oos.writeInt(test2);
	}
}
