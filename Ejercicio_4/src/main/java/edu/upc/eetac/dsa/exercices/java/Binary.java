package edu.upc.eetac.dsa.exercices.java;

import java.io.*;

/**
 * Created by enric on 21/02/2016.
 */
public class Binary {
    private int entero;
    private double decimal;
    private char caracter;

    public Binary(int entero, double decimal, char caracter) {
        this.entero = entero;
        this.decimal = decimal;
        this.caracter = caracter;
    }

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public void saveToFile(String filename) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
        dos.writeInt(entero);
        dos.writeDouble(decimal);
        dos.writeChar(caracter);
        dos.close();
    }

    public static final Binary readFromFile(String filename) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filename));
        int integer = dis.readInt();
        double decimal = dis.readDouble();
        char character = dis.readChar();

        return new Binary(integer, decimal, character);
    }
}
