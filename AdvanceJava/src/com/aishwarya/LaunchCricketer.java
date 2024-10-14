package com.aishwarya;

class Cricketer{
	String name;
	int runs;
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
public class LaunchCricketer {
	public static void main(String[] args) {
		Cricketer c=new Cricketer("Sachin",20000,45.6f);
		c.display();
	}
}