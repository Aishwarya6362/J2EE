//Deserialization: process of taking object from Hard disk to RAM.
package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


class Cricketer implements Serializable{
	private static final long serialVersionUID=1L;
	String name;
	transient int runs;//selective serialization
	float average;
	
	public Cricketer(String name,int runs,float average) {
		super();
		this.name=name;
		this.runs=runs;
		this.average=average;
	}
	void display() {
		System.out.println(name);
		System.out.println(runs);
		System.out.println(average);
	}
	
}

public class LaunchCricketerDeserialization {
	public static void main(String [] args) throws Exception{
		String path="c://ioprg//input.txt";
		FileInputStream fis=new FileInputStream(path);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Cricketer c=(Cricketer) ois.readObject();
		c.display();
	}
}
