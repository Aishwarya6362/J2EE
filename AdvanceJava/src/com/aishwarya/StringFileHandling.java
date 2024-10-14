package com.aishwarya;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class StringFileHandling{
	public static void main(String[] args) {
		String path1="c://ioprg//input.txt";
		String path2="c://ioprg//output.txt";
		try {
			FileReader fr=new FileReader(path1);
			FileWriter fw=new FileWriter(path2);
			BufferedReader br=new BufferedReader(fr);
			BufferedWriter bw=new BufferedWriter(fw);
			String x;
			while((x=br.readLine())!=null) {
				bw.write(x);
			}
			bw.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}