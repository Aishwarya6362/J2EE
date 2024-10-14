//Networking: Process of connecting
package Networking;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.InputStream;

public class LaunchClient {
	public static void main(String [] args) throws Exception {
		Socket csoc=new Socket("localhost",4000);
		OutputStream os=csoc.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		
		Scanner scan=new Scanner(System.in);
		String msg=scan.nextLine();
		dos.writeUTF(msg);
		
		InputStream is=csoc.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		msg=dis.readUTF();
		System.out.println(msg);
	}
}