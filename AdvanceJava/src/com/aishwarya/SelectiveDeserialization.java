package com.aishwarya;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


// Removed the public modifier
class CricketerDeserialization {

    static class Cricketer implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        transient int runs;       // Not serialized
        transient float average;  // Not serialized

        public Cricketer(String name, int runs, float average) {
            this.name = name;
            this.runs = runs;
            this.average = average;
        }
        

        void displayToFile(FileWriter writer) throws IOException {
            writer.write("Name: " + name + "\n");
            writer.write("Runs: " + runs + "\n");         // Will be 0 after deserialization
            writer.write("Average: " + average + "\n");   // Will be 0.0 after deserialization
        }
    }

    public static void main(String[] args) {
        String inputPath = "c://ioprg//input.txt";      // Path for input file
        String outputPath = "c://ioprg//output.txt";    // Path for output file

        // Step 1: Serialize the Cricketer object into the file
        Cricketer cricketer = new Cricketer("Sachin", 20000, 45.5f);
        try (FileOutputStream fos = new FileOutputStream(inputPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(cricketer);  // Writing the Cricketer object to the file
            System.out.println("Object Serialized to " + inputPath);

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            System.out.println();
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
