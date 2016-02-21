package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 21/02/2016.
 */
public class Tree {
    int Taltura;
    String Ttipo;

    public Tree() {
    }

    public Tree(int altura) {
        Taltura = altura;
    }

    public Tree(String tipo) {
        Ttipo = tipo;
    }

    public Tree(int altura, String tipo) {
        Taltura = altura;
        Ttipo = tipo;
    }
}
