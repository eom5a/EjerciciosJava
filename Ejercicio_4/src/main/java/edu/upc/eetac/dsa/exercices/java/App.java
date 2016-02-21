package edu.upc.eetac.dsa.exercices.java;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Binary testWrite = new Binary(5, 8.0, 'A');
        testWrite.saveToFile("TestIOBinary");

        Binary testRead = Binary.readFromFile("TestIOBinary");
        System.out.println();
        System.out.println();
        System.out.println();

        File file = new File("TestIOBinary");
        file.delete();
    }
}
