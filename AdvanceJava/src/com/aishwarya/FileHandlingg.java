package com.aishwarya;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class FileHandlingg{
	public static void main(String[] args) {
		String path1="c://ioprg//input.txt";
		String path2="c://ioprg//output.txt";
		try {
			FileInputStream fis=new FileInputStream(path1);
			FileOutputStream fos=new FileOutputStream(path2);
			int x;
			while((x=fis.read())!=-1) {
				fos.write(x);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}