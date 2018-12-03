package com.abhi.java.Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializableReader {

	public static void main(String[] args) {
		EmployeeSerilizable obj = new EmployeeSerilizable();
		try(FileInputStream fi = new FileInputStream("D:\\Abhinav D\\java_objs.ser")) {
			ObjectInputStream is = new ObjectInputStream(fi);
			obj = (EmployeeSerilizable) is.readObject();
			is.close();
			System.out.println(obj.employeeDetails());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		EmployeeExternalizable obj1 = new EmployeeExternalizable();
		try(FileInputStream fi = new FileInputStream("D:\\Abhinav D\\java_objExternal.ser")) {
			ObjectInputStream is = new ObjectInputStream(fi);
			obj1 = (EmployeeExternalizable) is.readObject();
			is.close();
			System.out.println(obj1.employeeDetails());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
