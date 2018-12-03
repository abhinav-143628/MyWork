package com.abhi.java.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWriter {
	public static void main(String[] args) {
		EmployeeSerilizable empObj = new EmployeeSerilizable();
		empObj.setEmployeeName("Raxon");
		empObj.setAge(35);
		// if don't uncomment this line then during deserialzation default value
		// will be set
		// and we will get id = 0
		
		// empObj.setEmployeID(100);

		try (FileOutputStream fo = new FileOutputStream("D:\\Abhinav D\\java_objs.ser")) {
			ObjectOutputStream oStream = new ObjectOutputStream(fo);
			oStream.writeObject(empObj);
			oStream.flush();
			oStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		EmployeeExternalizable empObj1 = new EmployeeExternalizable();
		empObj1.setEmployeeName("Raxon");
		empObj1.setAge(35);
		empObj1.setEmployeID(12321);
		
		try (FileOutputStream fo = new FileOutputStream("D:\\Abhinav D\\java_objExternal.ser")) {
			ObjectOutputStream oStream = new ObjectOutputStream(fo);
			oStream.writeObject(empObj1);
			oStream.flush();
			oStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
