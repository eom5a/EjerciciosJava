package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 21/02/2016.
 */
public class Circle extends AbstractShape{
    double radius;

    public Circle(String Type, double radius) {
        //super llama a un constructor sin argumentos o con los argumentos pasados por parametro
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2*Math.PI*radius;
    }
}
