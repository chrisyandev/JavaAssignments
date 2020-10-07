package ca.bcit.comp2522.labs.lab03;

public class Driver {
    public static void main(String[] args) {
        Quadrilateral trapezoid = new Trapezoid(2, 5, 7, 5, 10, 0, 0, 0);
        System.out.println(trapezoid);
        System.out.println(trapezoid.calculateArea());
    }
}
