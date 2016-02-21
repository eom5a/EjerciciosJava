package edu.upc.eetac.dsa.exercises.java;

public class App 
{
    public static void main( String[] args )
    {
        Tree[] arboles = new Tree[4];
        arboles[0] = new Tree(4);
        arboles[1] = new Tree("Roble");
        arboles[2] = new Tree();
        arboles[3] = new Tree(5, "Pino");

        for (int i = 0; i < arboles.length; i++) {
            if (arboles[i].Ttipo == null) {
                if (arboles[i].Taltura == 0) System.out.println("Un árbol");
                else System.out.println("Un árbol de " + arboles[i].Taltura + " metros");
            }
            else {
                if (arboles[i].Taltura == 0) System.out.println("Un " + arboles[i].Ttipo);
                else System.out.println("Un " + arboles[i].Ttipo + " de " + arboles[i].Taltura + " metros");
            }
        }
    }
}
