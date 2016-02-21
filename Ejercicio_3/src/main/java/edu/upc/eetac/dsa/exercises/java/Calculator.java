package edu.upc.eetac.dsa.exercises.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by enric on 21/02/2016.
 */
public abstract class Calculator {
    public final static double average(String file) throws FileParsingException, BigNumberException {
        BufferedReader r = null;
        double counter = 0;
        double sum = 0;
        try {
            r = new BufferedReader(new FileReader(file));
            String line = null;

            while ((line = r.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    if (number > 1000)
                        throw new BigNumberException("Number greater than 1000 at line " + (int) (++counter));
                    sum += counter;
                    counter++;
                } catch (NumberFormatException e) {
                    throw new FileParsingException(e.getMessage());
                }
            }
        }catch (java.io.IOException e) {
            throw new FileParsingException(e.getMessage());
        } finally {
            try {
                r.close();
            } catch (IOException e) {
                System.err.println("Warning: cannot close the file.");
            }
        }
        return sum/counter;
    }
}
