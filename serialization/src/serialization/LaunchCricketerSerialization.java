//Serialization: refers to process of converting a non persistent object into a persistent object.
//process of taking object from RAM to Hard disk.

package serialization;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

class Cricketer implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	transient int runs;//selective serialization: selecting which should not show the value
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
public class LaunchCricketerSerialization {
	public static void main(String[] args) throws Exception{
		Cricketer c=new Cricketer("Dhoni",20000,45.5f);
		c.display();
		String path="c://ioprg//input.txt";
		FileOutputStream fos=new FileOutputStream(path);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(c);
	}
}
