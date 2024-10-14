package com.aishwarya;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Deserialization {

    static class Cricketer implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int runs;
        float average;

        public Cricketer(String name, int runs, float average) {
            this.name = name;
            this.runs = runs;
            this.average = average;
        }

        void displayToFile(FileWriter writer) throws IOException {
            writer.write("Name: " + name + "\n");
            writer.write("Runs: " + runs + "\n");
            writer.write("Average: " + average + "\n");
        }
    }

    public static void main(String[] args) {
        String inputPath = "c://ioprg//input.txt";
        String outputPath = "c://ioprg//output.txt";

        // Step 1: Serialize the Cricketer object into the file
        Cricketer cricketer = new Cricketer("Sachin", 20000, 45.5f);
        try (FileOutputStream fos = new FileOutputStream(inputPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(cricketer);  // Writing the Cricketer object to the file
            System.out.println("Object Serialized to " + inputPath);

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }

        // Step 2: Deserialize the Cricketer object from the file
        try (FileInputStream fis = new FileInputStream(inputPath);
             ObjectInputStream ois = new ObjectInputStream(fis);
             FileWriter writer = new FileWriter(outputPath)) {

            Cricketer deserializedCricketer = (Cricketer) ois.readObject();
            System.out.println("Object Deserialized from " + inputPath);
            
            // Write the deserialized object data to output.txt
            deserializedCricketer.displayToFile(writer);
            System.out.println("Deserialized object data written to " + outputPath);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
//package com.aishwarya;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.Serializable;
//
//public class Deserialization {
//
//    static class Cricketer implements Serializable {
//        private static final long serialVersionUID = 1L;
//        String name;
//        int runs;
//        float average;
//
//        public Cricketer(String name, int runs, float average) {
//            this.name = name;
//            this.runs = runs;
//            this.average = average;
//        }
//
//        void display() {
//            System.out.println("Name: " + name);
//            System.out.println("Runs: " + runs);
//            System.out.println("Average: " + average);
//        }
//    }
//
//    public static void main(String[] args) {
//        String path = "c://ioprg//input.txt";
//
//        // Step 1: Serialize the Cricketer object into the file
//        Cricketer cricketer = new Cricketer("Sachin", 20000, 45.5f);
//        try (FileOutputStream fos = new FileOutputStream(path);
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
//            oos.writeObject(cricketer);  // Writing the Cricketer object to the file
//            System.out.println("Object Serialized to " + path);
//
//        } catch (IOException e) {
//            System.out.println("Error during serialization: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//        // Step 2: Check if file exists
//        File file = new File(path);
//        if (!file.exists()) {
//            System.out.println("File does not exist: " + path);
//            return;
//        }
//
//        // Step 3: Deserialize the Cricketer object from the file
//        try (FileInputStream fis = new FileInputStream(path);
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//
//            Cricketer deserializedCricketer = (Cricketer) ois.readObject();
//            System.out.println("Object Deserialized from " + path);
//            deserializedCricketer.display();
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error during deserialization: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
