package com.aishwarya;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

// Renamed the class to avoid conflicts
class CricketerData implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    String name;
    transient int runs;  // Not serialized
    transient float average;  // Not serialized

    public CricketerData(String name, int runs, float average) {
        this.name = name;
        this.runs = runs;
        this.average = average;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Runs: " + runs);   // Will be 0 after deserialization
        System.out.println("Average: " + average);  // Will be 0.0 after deserialization
    }
}

public class SelectiveSerialization {
    public static void main(String[] args) {
        CricketerData c = new CricketerData("Sachin", 20000, 45.5f);
        System.out.println("Before Serialization:");
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

        // Deserialize the object from the file
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            CricketerData deserializedCricketer = (CricketerData) ois.readObject();
            System.out.println("After Deserialization:");
            deserializedCricketer.display();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//package com.aishwarya;
//
//import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.Serializable;
//
//class Cricket implements Serializable {
//    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
//    String name;
//    transient int runs;
//    transient float average;
//
//    public Cricket(String name, int runs, float average) {
//        this.name = name;
//        this.runs = runs;
//        this.average = average;
//    }
//
//    void display() {
//        System.out.println("Name: " + name);
//        System.out.println("Runs: " + runs);
//        System.out.println("Average: " + average);
//    }
//}
//
//public class SelectiveSerialization {
//    public static void main(String[] args) {
//        Cricket c = new Cricket("Sachin", 20000, 45.5f);
//        c.display();
//
//        String path = "c://ioprg//input.txt";
//
//        // Serialize the object into the file
//        try (FileOutputStream fos = new FileOutputStream(path);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//            oos.writeObject(c);
//            System.out.println("Object has been serialized");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
