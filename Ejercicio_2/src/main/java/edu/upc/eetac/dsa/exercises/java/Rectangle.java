package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 21/02/2016.
 */
public class Rectangle extends AbstractShape{
    private double weight;
    private double height;

    public Rectangle(String Type, double weight, double height) {
        //super llama a un constructor sin argumentos o con los argumentos pasados por parametro
        super("Rectangle");
        this.weight = weight;
        this.height = height;
    }

    @Override
    public double area() {
        return weight*height;
    }
}
