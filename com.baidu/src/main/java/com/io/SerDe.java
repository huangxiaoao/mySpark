package com.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.hadoop.io.Writable;

public class SerDe {
	public static void main(String[] args) throws Exception {
		//writeHadoop() ;
		writeJava();
	}

	private static void writeHadoop() throws Exception {
		// 实现Hadoop的io流
		StudentWrite studentWrite = new StudentWrite();
		studentWrite.setId(1L);
		studentWrite.setName("山鸡哥哥");
		FileOutputStream fileOutputStream = new FileOutputStream("E:/b.txt");
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		studentWrite.write(dataOutputStream);
		dataOutputStream.close();
		fileOutputStream.close();
		
	}
	
	@SuppressWarnings("resource")
	private static void writeJava() throws Exception {
		StudentJava studentJava = new StudentJava();
		studentJava.setId(1243L);
		studentJava.setName("山鸡哥哥");
		FileOutputStream fileOutputStream = new FileOutputStream("E:/a.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(studentJava);
		objectOutputStream.close();
		fileOutputStream.close();
		
		
		
	}
	
	
	
}

class StudentWrite implements Writable {
	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void write(DataOutput out) throws IOException {
		out.writeLong(id);
		out.writeUTF(name);
	}

	public void readFields(DataInput in) throws IOException {

	}

}

class StudentJava implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void write(DataOutput out) throws IOException {
		out.writeLong(this.id);
		out.writeUTF(this.name);

	}

	public void readFields(DataInput in) throws IOException {

	}
	
}




