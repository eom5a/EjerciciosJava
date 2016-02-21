package edu.upc.eetac.dsa.exercises.java;

/**
 * Created by enric on 21/02/2016.
 */
public class AppInheritance {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(null, 2.5);
        shapes[1] = new Rectangle(null, 3, 5);
        for (Shape shape : shapes)
            System.out.println("I'm a " + shape + " with area = " + shape.area());
    }
}
