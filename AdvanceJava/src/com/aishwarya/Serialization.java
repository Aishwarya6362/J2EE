package com.aishwarya;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

class Cricket implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    String name;
    int runs;
    float average;

    public Cricket(String name, int runs, float average) {
        this.name = name;
        this.runs = runs;
        this.average = average;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Runs: " + runs);
        System.out.println("Average: " + average);
    }
}

public class Serialization {
    public static void main(String[] args) {
        Cricket c = new Cricket("Sachin", 20000, 45.5f);
        c.display();

        String path = "c://ioprg//input.txt";

        // Serialize the object into the file
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(c);
            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
