package Networking;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.InputStream;

public class LaunchServer {
	public static void main(String [] args) throws Exception {
		ServerSocket listener=new ServerSocket(4000);
		System.out.println("server is ready to accept request");
		
		InputStream is=ssoc.getInputStream();
		DataInputStream dis=new DataInputStream(os);
		String msg=dis.readUTF();
		System.out.println(msg);
		
		OutputStream os=csoc.getOutputStream();
		DataOutputStream dos=new DataOutputStream(is);
		Scanner scan=new Scanner(System.in);
		msg=scan.nextLine();
		dos.writeUTF(msg);
	}
}