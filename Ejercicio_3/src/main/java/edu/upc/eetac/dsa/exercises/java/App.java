package edu.upc.eetac.dsa.exercises.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            double average = Calculator.average(args[0]);
            System.out.println("Average = " + average);
        }
        catch (FileParsingException e) {
            e.printStackTrace();
        }
        catch (BigNumberException e) {
            e.printStackTrace();
        }
    }
}
